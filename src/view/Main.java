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
		
		//����Ӧ��ť���Ӽ�����
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			//ί�и�����ִ��
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new SickMainView();//����ҺŴ���
				dispose();
			}
			
		});
		
		
		button.addActionListener(new ActionListener(){

			@Override
			//ί�и�����ִ��
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new ResultView();
				dispose();
			}
			
		});
		
		
		btnNewButton_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			new DocDo();//����ҽ������
			dispose();
			}
		});
		
		
		btnNewButton_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			new LoginView();//�����̨����
			dispose();
			}
		});
		
		
		
		
	}
	public Main() {
		setTitle("\u6B22\u8FCE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);//���ô��岻���϶���С
		this.setLocationRelativeTo(null);//������ʾ
		this.setVisible(true);//����ɼ�
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//���˹Һ�
		btnNewButton = new JButton("��Ϣ�Ǽ�");
		btnNewButton.setBounds(24, 32, 113, 27);
		contentPane.add(btnNewButton);
		//ҽ������
		btnNewButton_1 = new JButton("��ʦ����");
		btnNewButton_1.setBounds(151, 32, 113, 27);
		contentPane.add(btnNewButton_1);
		//��̨����
		btnNewButton_2 = new JButton("��̨����");
		btnNewButton_2.setBounds(278, 32, 113, 27);
		contentPane.add(btnNewButton_2);
		
		button = new JButton("�鿴�Ѿ�����");
		button.setBounds(151, 100, 123, 27);
		contentPane.add(button);
		
		
		
		registerLinsener();
		
		
	}
		}
			
		
			
		
			
		






