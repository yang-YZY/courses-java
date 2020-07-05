package jsu.cn.user;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import jsu.cn.backGround.BackGround_JPanel;
import jsu.cn.dao.checkPoint_dao;
import jsu.cn.itf.window_itf;

// TODO: Auto-generated Javadoc
/**
 * The Class user_Record.
 *历史记录界面
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class user_Record implements window_itf {
		
		/** The uri.背景图片路径 */
		private String uri;
		
		/** The ns. 性别与 昵称*/
		private static String []ns;
		
		/** The record jf. 历史记录窗口对象*/
		private JFrame recordJf;
		
		/** The record jp. 可以添加图片的容器*/
		private BackGround_JPanel recordJp;
		
		/** The point. 关卡标签*/
		private JLabel point[];
		
		/** The number. 分数标签*/
		private JLabel number[];
		
		/** The nick name jl. 昵称标签*/
		private JLabel nickNameJl;
		
		/** The sex jl. 性别标签*/
		private JLabel sexJl;
		
		/** The back. 返回按钮*/
		private JButton back; 
		
		/** The typeface. 字体*/
		private Font typeface;

	/**
	 * Instantiates a new user record.
	 * 实例化对象
	 */
	public user_Record() {
		voluation();
		location();
		show();
		setUp();
		addComponent();
		windowListener_Closing();
		actionListener_Back();
		recordJf.setVisible(true);
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#voluation()
	    */
	    
	public void voluation() {
	uri = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\背景\\记录.png";
	recordJf = new JFrame("历史记录");
	recordJp = new BackGround_JPanel(uri);
	point = new JLabel[4];
	number = new JLabel[4];
	for(int i=0;i<point.length;i++) {
		String s="第"+(i+1)+"关";
		point[i]= new JLabel(s,SwingConstants.CENTER);
		number[i]= new JLabel("暂无记录",SwingConstants.CENTER);
	}
	nickNameJl = new JLabel(ns[0]);
	if("1".equals(ns[1]))
		sexJl = new JLabel(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\性别\\男.png"));
	else 
		sexJl = new JLabel(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\性别\\女.png"));
	back = new JButton("返回");
	typeface = new Font("宋体",Font.BOLD,16);
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#location()
	    */
	    
	public void location() {
		recordJf.setLayout(null);
		recordJp.setLayout(null);
		recordJf.setBounds(700, 300, 640, 528);
		recordJp.setBounds(0, 0, 640, 528);
		point[0].setBounds(120, 200, 80, 80);
		number[0].setBounds(120, 350, 80, 80);
		point[1].setBounds(220, 200, 80, 80);
		number[1].setBounds(220, 350, 80, 80);
		point[2].setBounds(360, 200, 80, 80);
		number[2].setBounds(360, 350, 80, 80);
		point[3].setBounds(460, 200, 80, 80);
		number[3].setBounds(460, 350, 80, 80);
		sexJl.setBounds(300, 120,24, 24);
		nickNameJl.setBounds(330, 120, 60, 20);
		back.setBounds(300, 440, 60, 30);
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#addComponent()
	    */
	    
	public void addComponent() {
		for(int i=0;i<point.length;i++) {
			recordJp.add(point[i]);
			recordJp.add(number[i]);
		}
		recordJp.add(sexJl);
		recordJp.add(nickNameJl);
		recordJp.add(back);
		recordJf.add(recordJp);
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#setUp()
	    */
	    
	public void setUp() {
		for(int i=0;i<point.length;i++) {
			point[i].setFont(typeface);
			number[i].setFont(typeface);
		}
		nickNameJl.setFont(typeface);
	}
	
	/**
	 * Sets the nn and sex.
	 *设置昵称与性别
	 * @param ns1 昵称与性别
	 */
	public static void setNnAndSex(String []ns1) {
		ns=ns1;
	}
	
	/**
	 * Show.
	 * 设置内容
	 */
	private void show() {
		int flag;
		String flag1[] =new String[4];
		checkPoint_dao cp =new checkPoint_dao();
		flag=cp.getIndex(ns[0]);
		if(flag!=0) {
			flag1 = cp.getNumber(flag);
			for(int i=0;i<flag1.length;i++) {
				number[i].setText(flag1[i]);
			}
		}
		cp.closing();
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#windowListener_Closing()
	    */
	    
	public void windowListener_Closing() {
		recordJf.addWindowListener(new WindowAdapter() {
	    	  @Override
	    	public void windowClosing(WindowEvent e) {
	    		// TODO Auto-generated method stub
	    		  user_Login.opening();
	    	}
		});
	}
	
	/**
	 * Action listener back.
	 * 为返回按钮添加动作监听器
	 */
	private void actionListener_Back(){
		back.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					recordJf.setVisible(false);
					user_Login.opening();
				}
			});
	}
}
