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

import jsu.cn.backGround.BackGround_JPanel;
import jsu.cn.itf.window_itf;

public class user_Login implements window_itf {
	private static String []ns;
	private String uri;
	public static JFrame loginJf;
	private BackGround_JPanel loginJp;
	private JButton playGameJb;
	private JButton recordJb;
	private JButton rankingListJb;
	private JLabel sexJl;
	private JLabel nickNameJl;
	private Font typeface;
	
	public user_Login() {
		voluation();
		location();
		setUp();
		addComponent();
		windowListener_Closing();
		actionListener_PlayGameJb();
		actionListener_RecordJb();
		actionListener_RankingListJb();
		loginJf.setVisible(true);
	}
	public void voluation() {
		uri = new String("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\背景\\功能界面.jpg");
	    loginJf = new JFrame("极难游戏");
	    loginJp = new BackGround_JPanel(uri);
	    playGameJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\按钮\\开始游戏.png"));
	    recordJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\按钮\\历史记录.png"));
	    rankingListJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\按钮\\排行榜.png"));
	     nickNameJl = new JLabel(ns[0]); 
	     if("1".equals(ns[1]))
	    	 sexJl = new JLabel(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\性别\\男.png"));
	     else 
	    	 sexJl = new JLabel(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\性别\\女.png")); 
	     typeface = new Font("宋体",Font.BOLD,20);
	}
	public void location() {

		loginJf.setLayout(null);
		loginJp.setLayout(null);
		loginJf.setBounds(700, 300, 600, 455);
		loginJp.setBounds(0, 0, 600, 455);
		playGameJb.setBounds(200, 120, 100, 40);
		recordJb.setBounds(200, 200, 100, 40);
		rankingListJb.setBounds(150, 280, 200, 40);
		sexJl.setBounds(450, 200, 24, 24);
		nickNameJl.setBounds(490, 160, 100, 100);
	}
	public void setUp() {
		nickNameJl.setFont(typeface);
	}
	public void addComponent() {

		loginJp.add(playGameJb);
		loginJp.add(recordJb);
		loginJp.add(rankingListJb);
		loginJp.add(sexJl);
		loginJp.add(nickNameJl);
		loginJf.add(loginJp);
	}
	public static void opening() {
		loginJf.setVisible(true);
	}
	public static void setNnAndSex(String []ns1) {
		ns=ns1;
	}
	public void windowListener_Closing() {
		loginJf.addWindowListener(new WindowAdapter() {
	    	  @Override
	    	public void windowClosing(WindowEvent e) {
	    		// TODO Auto-generated method stub
	    		System.exit(0);
	    	}
		});
	}
	private void actionListener_PlayGameJb() {
		playGameJb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					loginJf.setVisible(false);
					 user_PlayGame.setNnAndSex(ns);
					 new user_PlayGame();
				}
			});
	}
	private void actionListener_RecordJb() {
		recordJb.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loginJf.setVisible(false);
				user_Record.setNnAndSex(ns);
				new user_Record();
			}
		});
	}
	private void actionListener_RankingListJb() {
		rankingListJb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loginJf.setVisible(false);
				new user_RankingList();
			}
		});
	}
}
