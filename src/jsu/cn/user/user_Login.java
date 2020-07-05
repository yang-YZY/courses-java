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
import javax.swing.JOptionPane;

import jsu.cn.backGround.BackGround_JPanel;
import jsu.cn.dao.first_dao;
import jsu.cn.dao.second_dao;
import jsu.cn.dao.userNews_dao;
import jsu.cn.file.d_RankingList;
import jsu.cn.itf.window_itf;

// TODO: Auto-generated Javadoc
/**
 * The Class user_Login.
 *登录界面
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class user_Login implements window_itf {
	
	/** The ns. 昵称与性别*/
	private static String []ns;
	
	/** The uri. 背景图片路径*/
	private String uri;
	
	/** The login jf.登录窗口对象 */
	public static JFrame loginJf;
	
	/** The login jp.可以添加图片的容器 */
	private BackGround_JPanel loginJp;
	
	/** The play game jb. 玩游戏按钮*/
	private JButton playGameJb;
	
	/** The record jb. 游戏记录按钮*/
	private JButton recordJb;
	
	/** The ranking list jb.排行榜按钮 */
	private JButton rankingListJb;
	
	/** The cancel jb.注销按钮 */
	private JButton cancelJb;
	
	/** The sex jl. 性别标签*/
	private JLabel sexJl;
	
	/** The nick name jl.昵称标签 */
	private JLabel nickNameJl;
	
	/** The typeface. 字体*/
	private Font typeface;
	
	/**
	 * Instantiates a new user login.
	 * 实例化对象
	 */
	public user_Login() {
		voluation();
		location();
		setUp();
		addComponent();
		windowListener_Closing();
		actionListener_PlayGameJb();
		actionListener_RecordJb();
		actionListener_RankingListJb();
		actionListener_CancelJb();
		loginJf.setVisible(true);
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#voluation()
	    */
	    
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
	     cancelJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\按钮\\注销.png"));
	     typeface = new Font("宋体",Font.BOLD,20);
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#location()
	    */
	    
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
		cancelJb.setBounds(170, 360, 160, 40);
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#setUp()
	    */
	    
	public void setUp() {
		nickNameJl.setFont(typeface);
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#addComponent()
	    */
	    
	public void addComponent() {

		loginJp.add(playGameJb);
		loginJp.add(recordJb);
		loginJp.add(rankingListJb);
		loginJp.add(sexJl);
		loginJp.add(nickNameJl);
		loginJp.add(cancelJb);
		loginJf.add(loginJp);
	}
	
	/**
	 * Opening.
	 * 打开登录界面
	 */
	public static void opening() {
		loginJf.setVisible(true);
	}
	
	/**
	 * Sets the nn and sex.
	 *设置性别与昵称
	 * @param ns1 性别与昵称
	 */
	public static void setNnAndSex(String []ns1) {
		ns=ns1;
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#windowListener_Closing()
	    */
	    
	public void windowListener_Closing() {
		loginJf.addWindowListener(new WindowAdapter() {
	    	  @Override
	    	public void windowClosing(WindowEvent e) {
	    		// TODO Auto-generated method stub
	    		System.exit(0);
	    	}
		});
	}
	
	/**
	 * Action listener play game jb.
	 * 为玩游戏按钮添加动作监听器
	 */
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
	
	/**
	 * Action listener record jb.
	 * 为历史记录按钮添加动作监听器
	 */
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
	
	/**
	 * Action listener ranking list jb.
	 * 为排行榜按钮添加动作监听器
	 */
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
	
	/**
	 * Action listener cancel jb.
	 * 为注销按钮添加动作监听器
	 */
	private void actionListener_CancelJb() {
		cancelJb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new d_RankingList().delete(ns[0]);
				first_dao fd = new first_dao();
				fd.deleteFirst(ns[0]);
				fd.closing();
				second_dao sd = new second_dao();
				sd.deleteSecond(ns[0]);
				sd.closing();
				userNews_dao ud = new userNews_dao();
				ud.deleteUser(ns[0]);
				ud.closeAll();
				JOptionPane.showMessageDialog(loginJf, "注销成功");
				loginJf.setVisible(false);
				user.opening();
			}
		});
	}
}
