package action.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class BaseDao {
	private static final String URL="jdbc:mysql://123.206.22.162:3306/hospital?characterEncoding=utf8&useSSL=false";
	private static final String USER="hospital";
	private static final String PASSWORD="root";
	//�������ݿ⣬�������ݿ����Ӷ���
	public static Connection getConnection(){
		Connection conn=null;
		try {
			//1.������������
			Class.forName("com.mysql.jdbc.Driver");
			//2.������ݿ������
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	//�ͷ���Ӧ��Դ rs,pstmt,conn
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection conn){
		try {
			if(rs!=null){
			rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	//�˷������������ɾ�����в���������true or flase
	public boolean operUpdate(String sql,List<Object> params){
		int res=0;//Ӱ�������
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=getConnection();//�������ݿ�����
		try {
			pstmt=conn.prepareStatement(sql);//װ��sql���
			if(params!=null){
				//�����У�����ִ��֮ǰ�ѣ�ռλ���滻��
				for(int i=0;i<params.size();i++){
					pstmt.setObject(i+1, params.get(i));
				}
				
			}
			res=pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			closeAll(rs,pstmt,conn);
		}
		
		return res>0? true:false;
		
	}
	
	//ʹ�÷��ͷ����ͷ�����ƽ��з�װ
	public  <T> List<T> operQuery(String sql,List<Object> params,Class<T> cls) throws Exception, Exception{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<T> data=new ArrayList<T>();
		
		
		
		try {
			conn=getConnection();//�������ݿ�����
			pstmt=conn.prepareStatement(sql);//װ��sql���
			if(params!=null){
				//�����У�����ִ��֮ǰ�ѣ�ռλ���滻��
				for(int i=0;i<params.size();i++){
					pstmt.setObject(i+1, params.get(i));
				}
				
			}
			rs=pstmt.executeQuery();
			//�Ѳ�ѯ�����Ľ����װ�ɶ�Ӧ��ʵ�������
			ResultSetMetaData rsd=rs.getMetaData();//�õ���¼��Ԫ���ݶ���
			//ͨ���˶�����Եõ���Ľ�����������������еĸ������е���������
			while(rs.next()){
				T m=cls.newInstance();
				for(int i=0;i<rsd.getColumnCount();i++){
				String col_name=rsd.getColumnName(i+1);	//�������
				Object value=rs.getObject(col_name);//���������Ӧ������
				java.lang.reflect.Field field=cls.getDeclaredField(col_name);
				field.setAccessible(true);//��˽���������ÿɷ�����
				field.set(m,value);//������˽�����Ը�ֵ
					
				}
				data.add(m);
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally{
			closeAll(rs,pstmt,conn);
		}
		
		return data;
		
	}

}
