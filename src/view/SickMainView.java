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

	private JPanel main_panel=null;//�����
	private JPanel wel_panel=null;//��ӭ���
	private JPanel btu_panel=null;//��ť���
	private JDesktopPane funDesktop=null;//�������
	
	private JButton btn_guahao=null;//�ҺŰ�ť
	private JButton btn_query=null;//��ѯ��ť
	private JButton btn_back=null;//�˳���ť
	
	private JLabel deskLable=null;//��ʾ����
	private JLabel welcom=null;//��ӭ����
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton button=null;//�ύ��ť
	private JButton button_1=null;//���ذ�ť
	private JTextField textField=null;//ҽ������
	private JComboBox comboBox =null;//ҽ������

	private DocBizImpl docBiz=null;//��������
	private RecipeBizImpl recipeBiz=null;//�����Һŵ�
	private SickBizImpl sickBiz=null;//��������
	
	
private void registerLinsener(){
		
		//����Ӧ��ť���Ӽ�����
		button.addActionListener(new ActionListener(){

			@Override
			//ί�и�����ִ��
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
				String SName=textField_1.getText().trim();//��ȡ����
				String SSex=textField_2.getText().trim();//��ȡ�Ա�
				int SAge=Integer.parseInt(textField_3.getText().trim());//��ȡ����
				String SID=textField_4.getText().trim();//��ȡ֤����
				String DRoom=(String)comboBox.getSelectedItem();//��ȡ����
				String DName=textField.getText().trim();//��ȡҽ������
				
				
				
				docBiz=new DocBizImpl();
				
				if(SName.equals("")){
					JOptionPane.showMessageDialog(SickMainView.this, "��������Ϊ��");
					return;
				}else if(!(SSex.equals("��")||SSex.equals("Ů"))){
					JOptionPane.showMessageDialog(SickMainView.this, "��������д�л�Ů");
					return;
				}else if(SAge<0||SAge>140){
					JOptionPane.showMessageDialog(SickMainView.this, "���������Ƿ�����");
					return;
				}else if(SID.equals("")){
					JOptionPane.showMessageDialog(SickMainView.this, "֤���Ų���Ϊ��");
					return;
				}else if(!(docBiz.queryDocBySick(DRoom,DName))){
					JOptionPane.showMessageDialog(SickMainView.this, "�ÿ����޸�ҽ��");
					return;
				}
				
				Sick sick=new Sick(SName,SSex,SAge, SID);
				Recipe recipe=new Recipe(DName,SName);
				recipeBiz.saveRecipe(recipe);
				
				boolean a=sickBiz.addSick(sick);
				if(a==true){
					JOptionPane.showMessageDialog(SickMainView.this, "�Ǽǳɹ�");
				}else{
					JOptionPane.showMessageDialog(SickMainView.this, "�Ǽ�ʧ��");
				}
				
				
			
				
				
		
			}
			
		});
		
		
		
		
		//���ذ�ť������
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
		
		this.setLocationRelativeTo(null);//������ʾ
		this.setVisible(true);//����ɼ�
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
		//�ύ��ť
		button = new JButton("\u63D0\u4EA4");
		button.setBounds(14, 276, 90, 27);
		panel.add(button);
		//���ذ�ť
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
		
		
		registerLinsener();//���м���
		
		
		sickBiz=new SickBizImpl();
		recipeBiz=new RecipeBizImpl();
		
	
	}
}
