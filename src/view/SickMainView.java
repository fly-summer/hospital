package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import action.impl.RecipeDaoImpl;
import bizImpl.DocBizImpl;
import bizImpl.RecipeBizImpl;
import bizImpl.SickBizImpl;
import bizImpl.UserBizImpl;
import model.Doctor;
import model.Recipe;
import model.Sick;
import model.User;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SickMainView extends JFrame {

	private JPanel main_panel=null;//主面板
	private JPanel wel_panel=null;//欢迎面板
	private JPanel btu_panel=null;//按钮面板
	private JDesktopPane funDesktop=null;//桌面面板
	
	private JButton btn_guahao=null;//挂号按钮
	private JButton btn_query=null;//查询按钮
	private JButton btn_back=null;//退出按钮
	
	private JLabel deskLable=null;//显示界面
	private JLabel welcom=null;//欢迎界面
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton button=null;//提交按钮
	private JButton button_1=null;//返回按钮
	private JTextField textField=null;//医生姓名
	private JComboBox comboBox =null;//医生科室

	private DocBizImpl docBiz=null;//创建对象
	private RecipeBizImpl recipeBiz=null;//创建挂号单
	private SickBizImpl sickBiz=null;//创建对象
	
	
private void registerLinsener(){
		
		//给相应按钮增加监听器
		button.addActionListener(new ActionListener(){

			@Override
			//委托给方法执行
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				String SName=textField_1.getText().trim();//获取姓名
				String SSex=textField_2.getText().trim();//获取性别
				int SAge=Integer.parseInt(textField_3.getText().trim());//获取年龄
				String SID=textField_4.getText().trim();//获取证件号
				String DRoom=(String)comboBox.getSelectedItem();//获取科室
				String DName=textField.getText().trim();//获取医生姓名
				
				
				
				docBiz=new DocBizImpl();
				
				if(SName.equals("")){
					JOptionPane.showMessageDialog(SickMainView.this, "姓名不能为空");
					return;
				}else if(!(SSex.equals("男")||SSex.equals("女"))){
					JOptionPane.showMessageDialog(SickMainView.this, "姓名请填写男或女");
					return;
				}else if(SAge<0||SAge>140){
					JOptionPane.showMessageDialog(SickMainView.this, "请检查年龄是否有误");
					return;
				}else if(SID.equals("")){
					JOptionPane.showMessageDialog(SickMainView.this, "证件号不能为空");
					return;
				}else if(!(docBiz.queryDocBySick(DRoom,DName))){
					JOptionPane.showMessageDialog(SickMainView.this, "该科室无该医生");
					return;
				}
				
				Sick sick=new Sick(SName,SSex,SAge, SID);
				Recipe recipe=new Recipe(DName,SName);
				recipeBiz.saveRecipe(recipe);
				
				boolean a=sickBiz.addSick(sick);
				if(a==true){
					JOptionPane.showMessageDialog(SickMainView.this, "登记成功");
				}else{
					JOptionPane.showMessageDialog(SickMainView.this, "登记失败");
				}
				
				
			
				
				
		
			}
			
		});
		
		
		
		
		//返回按钮监听器
		button_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main();
			}
		});
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public SickMainView() {
		
		setTitle("\u767B\u8BB0\u7A97\u53E3");
		getContentPane().setLayout(null);
		
		this.setLocationRelativeTo(null);//居中显示
		this.setVisible(true);//窗体可见
		this.setSize(400,400);
		JPanel panel = new JPanel();
		panel.setBounds(83, 13, 226, 316);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("\u59D3   \u540D");
		label_1.setBounds(25, 39, 71, 18);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 39, 86, 24);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(90, 70, 86, 24);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(90, 107, 86, 24);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(90, 146, 86, 24);
		panel.add(textField_4);
		
		JLabel label_2 = new JLabel("\u6027   \u522B");
		label_2.setBounds(25, 73, 60, 18);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5E74   \u9F84");
		label_3.setBounds(25, 110, 60, 18);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u8BC1\u4EF6\u53F7\u7801");
		label_4.setBounds(25, 149, 60, 18);
		panel.add(label_4);
		//提交按钮
		button = new JButton("\u63D0\u4EA4");
		button.setBounds(14, 276, 90, 27);
		panel.add(button);
		//返回按钮
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.setBounds(122, 276, 90, 27);
		panel.add(button_1);
		
		JLabel label_5 = new JLabel("\u5BFC\u5458");
		label_5.setBounds(25, 230, 60, 18);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("\u5B66\u9662");
		label_6.setBounds(25, 193, 60, 18);
		panel.add(label_6);
		
		textField = new JTextField();
		textField.setBounds(90, 227, 86, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u8F6F\u4EF6", "\u571F\u6728", "\u673A\u68B0", "\u4FE1\u5DE5", "\u6C34\u5229"}));
		comboBox.setBounds(90, 190, 86, 24);
		panel.add(comboBox);
		
		
		registerLinsener();//进行监听
		
		
		sickBiz=new SickBizImpl();
		recipeBiz=new RecipeBizImpl();
		
	
	}
}
