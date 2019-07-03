package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import action.impl.BaseDao;
import model.Doctor;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultView extends JFrame {

	private JPanel contentPane;
	private JButton button=null;
	private JButton button_1=null;

	public ResultView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("\u9000\u51FA\u8BE5\u9875\u9762");
		button.setBounds(308, 176, 103, 23);
		contentPane.add(button);

		JLabel label = new JLabel("");
		label.setBounds(49, 27, 54, 15);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 402, 100);
		contentPane.add(scrollPane);
		
		
		String[] biaoge= {"编号","学院","姓名"};
		DefaultTableModel tablePatient=new DefaultTableModel(null,biaoge);
		JTable table=new JTable(tablePatient);
		
		scrollPane.setViewportView(table);
		
		Connection conn=null;
		try {
			BaseDao a=new BaseDao();
			
			conn=a.getConnection();
			PreparedStatement ps=conn.prepareStatement("select DId,Room,DName from doctor ");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()&&rs.getRow()>0) {
				String did=rs.getString("DId");
				String room=rs.getString("Room");
				String dname=rs.getString("DName");
				String[] c= {did,room,dname};
				tablePatient.addRow(c);

			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(ResultView.this, "获取信息失败");
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		success4();
		
	}
	
	private void success4() {
		 button.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
				
					dispose();
					new Main();
				}
	        });
	}
}