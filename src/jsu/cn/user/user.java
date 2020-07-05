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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import jsu.cn.backGround.BackGround_JPanel;
import jsu.cn.dao.checkNews_dao;
import jsu.cn.itf.user_Itf;
import jsu.cn.itf.window_itf;
import jsu.cn.tool.checkRegister;

// TODO: Auto-generated Javadoc
/**
 * The Class user.
   *     �û���ʼ����
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class user implements user_Itf,window_itf {
	
	/** The uri. ����ͼƬ·��  */
	private String uri;
	
	/** The start J. ��ʼ����*/
	public static JFrame startJ;
	
	/** The start jp. �������ͼƬ������ */
	private BackGround_JPanel startJp;
	
	/** The welcome jl.  ��ӭ��Ϣ*/
	private JLabel welcomeJl;
	
	/** The password jl. �����ǩ*/
	private JLabel passwordJl;
	
	/** The account jl.  �˺ű�ǩ*/
	private JLabel accountJl;
	
	/** The password jt. ����*/
	private JPasswordField passwordJt;
	
	/** The account jt. �˺�*/
	private JTextField accountJt;
	
	/** The login bt. ��¼��ť*/
	private JButton loginBt;
	
	/** The register bt. ע�ᰴť*/
	private JButton registerBt;
	
	/** The typeface. ����*/
	private Font typeface;
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.user_Itf#startWindow()
	    */
	    
	@Override
	public void startWindow() {
		voluation();
		location();
		setUp();
		addComponent();
		actionListener_RegisterBt();
		actionListener_LoginBt();
	    windowListener_Closing();
		startJ.setVisible(true);
	}
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.user_Itf#register()
	    */
	    
	@Override
	public void register() {
		startJ.setVisible(false);
		if(user_Register.registerJf!=null)
		user_Register.opening();
		else {
			user_Register user=new user_Register();
		}
	}
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.user_Itf#login()
	    */
	    
	@Override
	public void login() {
		int flag;
		String s1= accountJt.getText();
		String s2= new String(passwordJt.getPassword());
		flag= checkRegister.checkString(s1,s2);
		if(flag==0) {
			checkNews_dao cn=new checkNews_dao();
			if(cn.checkIdAndPassword(s1, s2)) {
				accountJt.setText("");
				passwordJt.setText("");
				startJ.setVisible(false);
				String []ns=cn.getNnAndSex();
				user_Login.setNnAndSex(ns);
				user_Login ul=new user_Login();
				
			}
			else {
				JOptionPane.showMessageDialog(startJ, "�˺Ż����������!");
			}
		}
		else {
			JOptionPane.showMessageDialog(startJ, "�����Ϣ���������������ܽ�����֤!");
		}
	}
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#voluation()
	    */
	    
	public void voluation() {
		uri= new String("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\����\\��ʼ����.png");
		startJ = new JFrame("������Ϸ");
		startJp = new BackGround_JPanel(uri);
		welcomeJl = new JLabel("��ӭ���뼫����Ϸ��¼ע�����");	
		accountJl = new JLabel("�˺�:");
		accountJt = new JTextField("");
		passwordJl = new JLabel("����:");
		passwordJt = new JPasswordField("");
		loginBt = new JButton("��¼");
		registerBt = new JButton("ע��");
		typeface = new Font("����",Font.BOLD,15);
	}
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#location()
	    */
	    
	public void location() {
		startJ.setLayout(null);
		startJp.setLayout(null);
		startJ.setBounds(700, 300, 400, 400);
		startJp.setBounds(0, 0,400, 400);
		welcomeJl.setBounds(90, 20, 240, 40);
		accountJl.setBounds(80, 80, 60, 20);
		accountJt.setBounds(200, 75, 120, 30);
		passwordJl.setBounds(80, 200, 60, 20);
		passwordJt.setBounds(200, 195, 120, 30);
		loginBt.setBounds(100, 280, 60,30);
		registerBt.setBounds(220, 280, 60, 30);
	}
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#setUp()
	    */
	    
	public void setUp() {
		welcomeJl.setFont(typeface);
		accountJl.setFont(typeface);
		accountJt.setFont(typeface);
		passwordJl.setFont(typeface);
		passwordJt.setFont(typeface);
	}
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#addComponent()
	    */
	    
	public void addComponent() {
		startJp.add(welcomeJl);
		startJp.add(accountJl);
		startJp.add(accountJt);
		startJp.add(passwordJl);
		startJp.add(passwordJt);
	    startJp.add(loginBt);
	    startJp.add(registerBt);
	    startJ.add(startJp);
	}
	
	/**
	 * Opening. 
	 *     �򿪳�ʼ����
	 */
	public static void opening() {
		startJ.setVisible(true);
	}
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#windowListener_Closing()
	    */
	    
	public void windowListener_Closing() {
		 startJ.addWindowListener(new WindowAdapter() {
	    	  @Override
	    	public void windowClosing(WindowEvent e) {
	    		// TODO Auto-generated method stub
	    		System.exit(0);
	    	}
		});
	}
	
	/**
	 * Action listener register bt.
	 * Ϊע�ᰴť��Ӷ���������
	 */
	private void actionListener_RegisterBt() {
		 registerBt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					register();
				}
			});
	}
	
	/**
	 * Action listener login bt.
	 * Ϊ��¼��ť��Ӷ���������
	 */
	private void actionListener_LoginBt() {
		loginBt.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				login();
			}
		});
	}
}
