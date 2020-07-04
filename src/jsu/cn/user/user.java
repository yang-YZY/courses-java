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

public class user implements user_Itf,window_itf {
	private String uri;
	public static JFrame startJ;
	private BackGround_JPanel startJp;
	private JLabel welcomeJl;
	private JLabel passwordJl;
	private JLabel accountJl;
	private JPasswordField passwordJt;
	private JTextField accountJt;
	private JButton loginBt;
	private JButton registerBt;
	private Font typeface;
	
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
	@Override
	public void register() {
		startJ.setVisible(false);
		if(user_Register.registerJf!=null)
		user_Register.opening();
		else {
			user_Register user=new user_Register();
		}
	}
	@Override
	public void login() {
		int flag;
		String s1= accountJt.getText();
		String s2= new String(passwordJt.getPassword());
		flag= checkRegister.checkString(s1,s2);
		if(flag==0) {
			checkNews_dao cn=new checkNews_dao(2);
			if(cn.checkIdAndPassword(s1, s2)) {
				startJ.setVisible(false);
				String []ns=cn.getNnAndSex();
				user_Login.setNnAndSex(ns);
				user_Login ul=new user_Login();
				
			}
			else {
				JOptionPane.showMessageDialog(startJ, "账号或者密码错误!");
			}
		}
		else {
			JOptionPane.showMessageDialog(startJ, "请把信息输入完整，否则不能进行验证!");
		}
	}
	public void voluation() {
		uri= new String("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\背景\\初始背景.png");
		startJ = new JFrame("极难游戏");
		startJp = new BackGround_JPanel(uri);
		welcomeJl = new JLabel("欢迎进入极难游戏登录注册界面");	
		accountJl = new JLabel("账号:");
		accountJt = new JTextField("");
		passwordJl = new JLabel("密码:");
		passwordJt = new JPasswordField("");
		loginBt = new JButton("登录");
		registerBt = new JButton("注册");
		typeface = new Font("宋体",Font.BOLD,15);
	}
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
	public void setUp() {
		welcomeJl.setFont(typeface);
		accountJl.setFont(typeface);
		accountJt.setFont(typeface);
		passwordJl.setFont(typeface);
		passwordJt.setFont(typeface);
	}
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
	public static void opening() {
		startJ.setVisible(true);
	}
	public void windowListener_Closing() {
		 startJ.addWindowListener(new WindowAdapter() {
	    	  @Override
	    	public void windowClosing(WindowEvent e) {
	    		// TODO Auto-generated method stub
	    		System.exit(0);
	    	}
		});
	}
	private void actionListener_RegisterBt() {
		 registerBt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					register();
				}
			});
	}
	
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
