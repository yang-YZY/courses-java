package jsu.cn.user;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jsu.cn.backGround.BackGround_JPanel;
import jsu.cn.dao.checkNews_dao;
import jsu.cn.dao.userNews_dao;
import jsu.cn.itf.window_itf;
import jsu.cn.tool.checkRegister;

public class user_Register implements window_itf{
	private String uri;
	public static JFrame registerJf;
	private BackGround_JPanel registerJp;
	private JLabel welcomeJl;
	
	private JLabel idJl;
	private JLabel idPasswordJl;
	private JLabel userNameJl;
	private JLabel sexJl;
	private JLabel nickNameJl;
	
	private JTextField idJt;
	private JTextField idPasswordJt;
	private JTextField userNameJt;
	private JTextField sexJt;
	private JTextField nickNameJt;
	
	private JButton cancelJb;
	private JButton okJb;
	private Font typeface;
	
	public user_Register() {
		voluation();
		
		location();
		setUp();
		addComponent();
		
		acctionListener_ActionPerformed_okJb();
		acctionListener_ActionPerformed_cancelJb();
		windowListener_Closing();
		registerJf.setVisible(true);
	}
	public void voluation() {
    	uri=new String("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\����\\ע�ᱳ��.png");
    	registerJf =new JFrame("ע��");
		registerJp = new BackGround_JPanel(uri);
		welcomeJl =new JLabel("��ӭ������Ϣע�����");
		idJl =new JLabel("�û����˺�",SwingConstants.CENTER);
		idPasswordJl =new JLabel("����",SwingConstants.CENTER);
		userNameJl =new JLabel("����",SwingConstants.CENTER);
		sexJl =new JLabel("�Ա�",SwingConstants.CENTER);
		nickNameJl =new JLabel("�ǳ�",SwingConstants.CENTER);
		idJt =new JTextField();
		idPasswordJt =new JTextField();
		userNameJt =new JTextField();
		sexJt =new JTextField();
		nickNameJt =new JTextField();
		cancelJb =new JButton("ȡ��");
		okJb =new JButton("ȷ��");
		typeface = new Font("���� ",Font.BOLD,15);
    }
	public void location() {
    	registerJf.setBounds(700, 300, 500, 600);
		registerJp.setBounds(0, 0, 500, 600);
		registerJf.setLayout(null);
		registerJp.setLayout(null);
		welcomeJl.setBounds(160, 10, 200, 80);
		idJl.setBounds(100, 100, 80, 40);
		idJt.setBounds(300, 105, 100, 30);
		idPasswordJl.setBounds(100,160, 80, 40);
		idPasswordJt.setBounds(300, 165, 100, 30);
		userNameJl.setBounds(100, 220, 80, 40);
		userNameJt.setBounds(300, 225, 100, 30);
		nickNameJl.setBounds(100, 280, 80, 40);
		nickNameJt.setBounds(300, 285, 100, 30);
	    sexJl.setBounds(100, 340, 80, 40);
		sexJt.setBounds(300, 345, 100, 30);
		okJb.setBounds(100, 480, 80, 40);
		cancelJb.setBounds(300, 480, 80, 40);
    }
	public void setUp() {
    	welcomeJl.setFont(typeface);
    	idJl.setFont(typeface);
    	idJt.setFont(typeface);
    	idPasswordJl.setFont(typeface);
    	idPasswordJt.setFont(typeface);
    	userNameJl.setFont(typeface);
    	userNameJt.setFont(typeface);
    	nickNameJl.setFont(typeface);
    	nickNameJt.setFont(typeface);
    	sexJl.setFont(typeface);
    	sexJt.setFont(typeface);
    	//okJb.setFont(typeface);
    	//cancelJb.setFont(typeface);
    }
	public void addComponent() {
		registerJp.add(welcomeJl);
		registerJp.add(idJl);
		registerJp.add(idJt);
		registerJp.add(idPasswordJl);
		registerJp.add(idPasswordJt);
		registerJp.add(userNameJl);
		registerJp.add(userNameJt);
		registerJp.add(sexJl);
		registerJp.add(sexJt);
		registerJp.add(nickNameJl);
		registerJp.add(nickNameJt);
		registerJp.add(cancelJb);
		registerJp.add(okJb);
		registerJf.add(registerJp);
	}
	public static void opening() {
		registerJf.setVisible(true);
	}
	public void windowListener_Closing() {
		registerJf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				user.opening();
				empty();
			}
		});
	}
	public void acctionListener_ActionPerformed_cancelJb() {
		 cancelJb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					registerJf.setVisible(false);
					user.opening();
					empty();
				}
			});
	}
	public void acctionListener_ActionPerformed_okJb() {
		okJb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int a;
				String s1= idJt.getText();
				String s2= idPasswordJt.getText();
				String s3= userNameJt.getText();
				String s4= nickNameJt.getText();
				String s5= sexJt.getText();
				a=checkRegister.checkString(s1,s2,s3,s4,s5);
				if(a==0) {
					checkNews_dao cn = new checkNews_dao(1);
					if(cn.checkId(s1)) {
						JOptionPane.showMessageDialog(registerJf, "�˺��Ѵ���");
						idJt.setText("");
						cn.closeAll();
					}
					else if(cn.checkNickName(s4)) {
						JOptionPane.showMessageDialog(registerJf, "�ǳ��Ѵ���");
						nickNameJt.setText("");
						cn.closeAll();
					} else {
						userNews_dao un=new userNews_dao();
						un.insertNews(s1, s2, s3, s4, s5);
						un.closeAll();
						empty();
					}
				}
				else {
					JOptionPane.showMessageDialog(registerJf, "�����Ϣ��������!");
				}
			}
		});
	}
	private void empty() {
		idJt.setText("");
		idPasswordJt.setText("");
		userNameJt.setText("");
		sexJt.setText("");
		nickNameJt.setText("");
	}
}
