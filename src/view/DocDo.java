package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import biz.RecipeBiz;
import biz.UserBiz;
import bizImpl.RecipeBizImpl;
import model.Recipe;
import model.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class DocDo extends JFrame {

	private JPanel contentPane;
	private JTextField textField=null;//挂号单
	private JTextField textField_1=null;//处方
	private JButton button=null;//挂号单号按钮
	private JButton button_1=null;//处方按钮
	private RecipeBiz recipeBiz=null;
	
	
	private void registerLinsener(){
		//给相应按钮增加监听器
		//提交监听器
		button.addActionListener(new ActionListener(){

			@Override
			//委托给方法执行
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int RId=Integer.parseInt(textField.getText().trim());
				String Re=textField_1.getText().trim();
				recipeBiz=new RecipeBizImpl();
				recipeBiz.updateRecipe(Re,RId);
				if(recipeBiz!=null){
					JOptionPane.showMessageDialog(DocDo.this, "处理成功");
					
					
				}else{
					JOptionPane.showMessageDialog(DocDo.this, "处理失败");
				}
				
			}
			
		});
		
		//取消监听器
		button_1.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//获取用户名和密码
				dispose();
				new Main();
				
			}
			
		});
	}
		
		
	

	public DocDo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);//设置窗体不可拖动大小
		this.setLocationRelativeTo(null);//居中显示

		setBounds(100, 100, 314, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(133, 87, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 138, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\u7533\u8BF7\u5E8F\u5217\u53F7");
		label.setBounds(30, 90, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u662F\u5426\u540C\u610F");
		label_1.setBounds(30, 141, 72, 18);
		contentPane.add(label_1);
		
		button = new JButton("\u786E\u5B9A");
		button.setBounds(82, 224, 113, 27);
		contentPane.add(button);
		
		button_1 = new JButton("\u9000\u51FA");
		button_1.setBounds(82, 264, 113, 27);
		contentPane.add(button_1);
		
		
		this.setVisible(true);//窗体可见
		registerLinsener();
	}
}
