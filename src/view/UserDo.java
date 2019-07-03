package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bizImpl.DocBizImpl;
import bizImpl.SickBizImpl;
import bizImpl.UserBizImpl;
import model.Doctor;
import model.Recipe;
import model.Sick;
import model.User;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserDo extends JFrame {

	private JPanel contentPane;
	private DocBizImpl docBiz=null;//创建对象
	private JButton button_1=null;//增加医生
	private JButton button_2=null;//增加病人
	private JButton button_3=null;//删除医生
	private JButton button_4=null;//删除病人
	private JButton btnNewButton=null;//查询所有医生
	private JButton btnNewButton_1=null;//查询所有病人
	private JButton btnNewButton_2=null;//修改病人
	private JButton button=null;//修改医生
	private JButton button_5=null;//编号查询
	private JButton button_6=null;//姓名查询
	private JTextField textField=null;//医生编号
	private JTextField textField_2=null;//医生姓名
	private JComboBox comboBox = null;//科室
	private Doctor doctor=null;//建立医生对象
	private SickBizImpl sickBiz=null;//创建对象
	

	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JButton button_7=null;


	private void registerLinsener() {
		// TODO Auto-generated method stub
		
		//增加医生
		button_1.addActionListener(new ActionListener(){
			
			
			public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	//获取用户名和密码
	int DId=Integer.parseInt(textField.getText());
	String dname=textField_2.getText().trim();
	String room=(String)comboBox.getSelectedItem();//获取科室
		System.out.println(room);
	if(dname.equals("")){
		JOptionPane.showMessageDialog(UserDo.this, "姓名不能为空");
		return;
	}
	doctor=new Doctor(DId,room,dname);
	docBiz.saveDoc(doctor);
	
	
}
});
		
		
		
		//删除医生通过编号
		button_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int DId=Integer.parseInt(textField.getText());
				
				docBiz.delDoc(DId);
			}
			
		});
		
		//查询所有医生
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				docBiz.queryDocs();
			}
			
		});
		
		
		//修改医生信息根据DId
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				int DId=Integer.parseInt(textField.getText());
				String dname=textField_2.getText().trim();
				String room=(String) comboBox.getSelectedItem();//获取科室
					//System.out.println(room);
				doctor=new Doctor(DId,room,dname);
				docBiz.updateDoc(doctor);
			}
			
		});
		
		//根据DId医生编号查询医生
		button_5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int DId=Integer.parseInt(textField.getText());
				docBiz.queryDocByDId(DId);
			}
			
		});
		
		
	
		//根据DName医生姓名查询医生
		
		button_6.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String dname=textField_2.getText().trim();
				docBiz.queryDocByDName(dname);
			}
			
		});
		
		
		//增加病人
		button_2.addActionListener(new ActionListener(){

					@Override
					//委托给方法执行
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
			
						String SName=textField_7.getText().trim();//获取姓名
						String SSex=textField_8.getText().trim();//获取性别
						int SAge=Integer.parseInt(textField_9.getText().trim());//获取年龄
						String SID=textField_10.getText().trim();//获取证件号
						
						if(SName.equals("")){
							JOptionPane.showMessageDialog(UserDo.this, "姓名不能为空");
							return;
						}else if(!(SSex.equals("男")||SSex.equals("女"))){
							JOptionPane.showMessageDialog(UserDo.this, "姓名请填写男或女");
							return;
						}else if(SAge<0||SAge>140){
							JOptionPane.showMessageDialog(UserDo.this, "请检查年龄是否有误");
							return;
						}else if(SID.equals("")){
							JOptionPane.showMessageDialog(UserDo.this, "证件号不能为空");
							return;
						}
						
						Sick sick=new Sick(SName,SSex,SAge, SID);
						
						boolean a=sickBiz.addSick(sick);
						if(a==true){
							JOptionPane.showMessageDialog(UserDo.this, "增加成功");
						}else{
							JOptionPane.showMessageDialog(UserDo.this, "增加失败");
						}

					}
					
				});
		
		//通过ID删除病人
		
		button_4.addActionListener(new ActionListener(){

			@Override
			//委托给方法执行
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				int SId=Integer.parseInt(textField_6.getText().trim());//获取编号
				Sick sick=new Sick();
				sickBiz.delSick(SId);
			}
			
		});
		
		
		button_7.addActionListener(new ActionListener(){

			@Override
			//委托给方法执行
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				dispose();
				new LoginView();
				
			}
			
		});
		
		
		
		
		
		
}

	public UserDo() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);//设置窗体不可拖动大小
		this.setLocationRelativeTo(null);//居中显示
	
		setBounds(100, 100, 446, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("\u67E5\u8BE2\u6240\u6709\u533B\u751F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(14, 334, 140, 27);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u67E5\u8BE2\u6240\u6709\u75C5\u4EBA");
		btnNewButton_1.setBounds(233, 359, 140, 27);
		contentPane.add(btnNewButton_1);
		
		button = new JButton("\u4FEE\u6539\u533B\u751F\u4FE1\u606F");
		button.setBounds(14, 399, 140, 27);
		contentPane.add(button);
		
		btnNewButton_2 = new JButton("\u4FEE\u6539\u75C5\u4EBA\u4FE1\u606F");
		btnNewButton_2.setBounds(233, 399, 140, 27);
		contentPane.add(btnNewButton_2);
		
		button_1 = new JButton("\u589E\u52A0\u533B\u751F");
		button_1.setBounds(14, 216, 113, 27);
		contentPane.add(button_1);
		
		button_2 = new JButton("\u589E\u52A0\u75C5\u4EBA");
		button_2.setBounds(233, 254, 113, 27);
		contentPane.add(button_2);
		
		button_3 = new JButton("\u5220\u9664\u533B\u751F");
		button_3.setBounds(14, 273, 113, 27);
		contentPane.add(button_3);
		
		button_4 = new JButton("\u5220\u9664\u75C5\u4EBA");
		button_4.setBounds(233, 319, 113, 27);
		contentPane.add(button_4);
		
		textField = new JTextField();
		textField.setBounds(61, 50, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(61, 128, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("\u7F16\u53F7");
		label.setBounds(14, 53, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u79D1\u5BA4");
		label_1.setBounds(14, 87, 72, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u59D3\u540D");
		label_2.setBounds(14, 131, 72, 18);
		contentPane.add(label_2);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5185\u79D1", "\u5916\u79D1", "\u9AA8\u79D1", "\u7259\u79D1"}));
		comboBox.setBounds(61, 87, 83, 24);
		contentPane.add(comboBox);
		
		button_5 = new JButton("\u7F16\u53F7\u67E5\u8BE2\u533B\u751F");
		button_5.setBounds(14, 453, 140, 27);
		contentPane.add(button_5);
		
		button_6 = new JButton("\u59D3\u540D\u67E5\u8BE2\u533B\u751F");
		button_6.setBounds(14, 505, 140, 27);
		contentPane.add(button_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(233, 47, 86, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(233, 87, 86, 24);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(233, 128, 86, 24);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(233, 179, 86, 24);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(233, 217, 86, 24);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7F16\u53F7");
		label_3.setBounds(159, 53, 72, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u59D3\u540D");
		label_4.setBounds(158, 87, 72, 18);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u6027\u522B");
		label_5.setBounds(161, 131, 72, 18);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u5E74\u9F84");
		label_6.setBounds(159, 182, 72, 18);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u8BC1\u4EF6\u53F7");
		label_7.setBounds(159, 220, 72, 18);
		contentPane.add(label_7);
		
		textField_10 = new JTextField();
		textField_10.setBounds(233, 217, 86, 24);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		button_7 = new JButton("\u9000\u51FA");
		button_7.setBounds(313, 561, 113, 27);
		contentPane.add(button_7);
		
		this.setVisible(true);//窗体可见
		docBiz=new DocBizImpl();
		
		registerLinsener();
	}
}
