package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bizImpl.UserBizImpl;
import model.User;

import javax.swing.AbstractButton;
import javax.swing.JButton;

public class Main extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton=null;
	private JButton btnNewButton_1=null;
	private JButton btnNewButton_2=null;
	private JButton button=null;
	
	
	
		private void registerLinsener(){
		
		//给相应按钮增加监听器
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			//委托给方法执行
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new SickMainView();//进入挂号窗口
				dispose();
			}
			
		});
		
		
		button.addActionListener(new ActionListener(){

			@Override
			//委托给方法执行
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new ResultView();
				dispose();
			}
			
		});
		
		
		btnNewButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			new DocDo();//进入医生窗口
			dispose();
			}
		});
		
		
		btnNewButton_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			new LoginView();//进入后台窗口
			dispose();
			}
		});
		
		
		
		
	}
	public Main() {
		setTitle("\u6B22\u8FCE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);//设置窗体不可拖动大小
		this.setLocationRelativeTo(null);//居中显示
		this.setVisible(true);//窗体可见
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//病人挂号
		btnNewButton = new JButton("信息登记");
		btnNewButton.setBounds(24, 32, 113, 27);
		contentPane.add(btnNewButton);
		//医生就诊
		btnNewButton_1 = new JButton("教师审批");
		btnNewButton_1.setBounds(151, 32, 113, 27);
		contentPane.add(btnNewButton_1);
		//后台管理
		btnNewButton_2 = new JButton("后台管理");
		btnNewButton_2.setBounds(278, 32, 113, 27);
		contentPane.add(btnNewButton_2);
		
		button = new JButton("查看已经申请");
		button.setBounds(151, 100, 123, 27);
		contentPane.add(button);
		
		
		
		registerLinsener();
		
		
	}
		}
			
		
			
		
			
		






