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
		uri = new String("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\����\\���ܽ���.jpg");
	    loginJf = new JFrame("������Ϸ");
	    loginJp = new BackGround_JPanel(uri);
	    playGameJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\��ť\\��ʼ��Ϸ.png"));
	    recordJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\��ť\\��ʷ��¼.png"));
	    rankingListJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\��ť\\���а�.png"));
	     nickNameJl = new JLabel(ns[0]); 
	     if("1".equals(ns[1]))
	    	 sexJl = new JLabel(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\�Ա�\\��.png"));
	     else 
	    	 sexJl = new JLabel(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\�Ա�\\Ů.png")); 
	     typeface = new Font("����",Font.BOLD,20);
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
