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
	private JTextField textField=null;//�Һŵ�
	private JTextField textField_1=null;//����
	private JButton button=null;//�Һŵ��Ű�ť
	private JButton button_1=null;//������ť
	private RecipeBiz recipeBiz=null;
	
	
	private void registerLinsener(){
		//����Ӧ��ť���Ӽ�����
		//�ύ������
		button.addActionListener(new ActionListener(){

			@Override
			//ί�и�����ִ��
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int RId=Integer.parseInt(textField.getText().trim());
				String Re=textField_1.getText().trim();
				recipeBiz=new RecipeBizImpl();
				recipeBiz.updateRecipe(Re,RId);
				if(recipeBiz!=null){
					JOptionPane.showMessageDialog(DocDo.this, "����ɹ�");
					
					
				}else{
					JOptionPane.showMessageDialog(DocDo.this, "����ʧ��");
				}
				
			}
			
		});
		
		//ȡ��������
		button_1.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//��ȡ�û���������
				dispose();
				new Main();
				
			}
			
		});
	}
		
		
	

	public DocDo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);//���ô��岻���϶���С
		this.setLocationRelativeTo(null);//������ʾ

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
		
		
		this.setVisible(true);//����ɼ�
		registerLinsener();
	}
}
