package view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import biz.UserBiz;
import bizImpl.UserBizImpl;
import model.User;

import java.awt.BorderLayout;
public class LoginView extends JFrame {

	private JPanel panel_main=null;//�����
	private JPanel panel_left=null;//������
	private JPanel panel_right=null;//�Ҳ����
	
	private JLabel lb_uname=null;//�û���ǩ
	private JLabel lb_upass=null;//�����ǩ
	private JLabel lb_type=null;//��¼���ͱ�ǩ
	
	private JTextField tf_uname=null;//�û��ı���
	private JPasswordField pf_pass=null;//�����ı���
	
	private JLabel lb_img=null;//��ʾͼƬ��ǩ
	
	private JButton btn_login=null;//��¼��ť
	private JButton btn_register=null;//ע�ᰴť
	//private JComboBox<String> cb_type=null;//��¼���������б��
	
	
	private UserBiz userBiz=null;
	//��ʼ���ؼ��ķ���
	private void init(){
		this.setSize(320,220);//���ô����С
		this.setResizable(false);//���ô��岻���϶���С
		this.setLocationRelativeTo(null);//������ʾ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
		this.setTitle("��У����ϵͳ��¼����");//����

		//��ʼ�����
		panel_main=new JPanel(new GridLayout(1,2));
		panel_left=new JPanel();
		panel_right=new JPanel(new GridLayout(4,2,0,10));
		//��ʼ���ؼ�
		tf_uname=new JTextField(8);
		pf_pass=new JPasswordField(8);
		lb_uname=new JLabel("�� ��",JLabel.CENTER);
		lb_upass=new JLabel("�� ��",JLabel.CENTER);
		lb_img=new JLabel(new ImageIcon(ClassLoader.getSystemResource("image/login.jpg")));
		//����Ӧ�ؼ��������
		panel_left.add(lb_img);
		panel_right.add(lb_uname);
		panel_right.add(tf_uname);
		panel_right.add(lb_upass);
		panel_right.add(pf_pass);
		
		//������з������������
		panel_main.add(panel_left);
		panel_main.add(panel_right);
		
	
		//panel_right.add(comboBox);
		btn_register=new JButton("ע��");
		panel_right.add(btn_register);
		
		
		btn_login=new JButton("��¼");
		//panel_right.add(cb_type);
		panel_right.add(btn_login);
		
		//�ٰ������ŵ�������
		this.getContentPane().add(panel_main);
		this.pack();
		
		this.setVisible(true);//����ɼ�
		
		}
	
	//��������
	private void registerLinsener(){
		//����Ӧ��ť���Ӽ�����
		btn_register.addActionListener(new ActionListener(){

			@Override
			//ί�и�����ִ��
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UserRegisterView();//����ע�ᴰ��
			}
			
		});
		
		
		btn_login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//��ȡ�û���������
				String uname=tf_uname.getText().trim();
				String upass=new String(pf_pass.getPassword());
				if(uname.equals("")){
					JOptionPane.showMessageDialog(LoginView.this, "�û�������Ϊ��");
					return;
				}else if(upass.equals("")){
					JOptionPane.showMessageDialog(LoginView.this, "���벻��Ϊ��");
					return;
				}
				User user=new User(uname,upass);
				user=userBiz.login(user);		
				if(user!=null){
					
					//new UserDo();//�������Ա���
					new Main();
					LoginView.this.dispose();
					
				}else{
					JOptionPane.showMessageDialog(LoginView.this, "�û��������������");
				}
				
			}
			
		});
	}
		
		
	
	
	public LoginView() {
		userBiz=new UserBizImpl();
		init();
		registerLinsener();
		
		
	}

}
