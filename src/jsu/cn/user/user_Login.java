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
 *��¼����
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class user_Login implements window_itf {
	
	/** The ns. �ǳ����Ա�*/
	private static String []ns;
	
	/** The uri. ����ͼƬ·��*/
	private String uri;
	
	/** The login jf.��¼���ڶ��� */
	public static JFrame loginJf;
	
	/** The login jp.�������ͼƬ������ */
	private BackGround_JPanel loginJp;
	
	/** The play game jb. ����Ϸ��ť*/
	private JButton playGameJb;
	
	/** The record jb. ��Ϸ��¼��ť*/
	private JButton recordJb;
	
	/** The ranking list jb.���а�ť */
	private JButton rankingListJb;
	
	/** The cancel jb.ע����ť */
	private JButton cancelJb;
	
	/** The sex jl. �Ա��ǩ*/
	private JLabel sexJl;
	
	/** The nick name jl.�ǳƱ�ǩ */
	private JLabel nickNameJl;
	
	/** The typeface. ����*/
	private Font typeface;
	
	/**
	 * Instantiates a new user login.
	 * ʵ��������
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
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#voluation()
	    */
	    
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
	     cancelJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\��ť\\ע��.png"));
	     typeface = new Font("����",Font.BOLD,20);
	}
	
	
	    /* (�� Javadoc)
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
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#setUp()
	    */
	    
	public void setUp() {
		nickNameJl.setFont(typeface);
	}
	
	
	    /* (�� Javadoc)
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
	 * �򿪵�¼����
	 */
	public static void opening() {
		loginJf.setVisible(true);
	}
	
	/**
	 * Sets the nn and sex.
	 *�����Ա����ǳ�
	 * @param ns1 �Ա����ǳ�
	 */
	public static void setNnAndSex(String []ns1) {
		ns=ns1;
	}
	
	
	    /* (�� Javadoc)
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
	 * Ϊ����Ϸ��ť��Ӷ���������
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
	 * Ϊ��ʷ��¼��ť��Ӷ���������
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
	 * Ϊ���а�ť��Ӷ���������
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
	 * Ϊע����ť��Ӷ���������
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
				JOptionPane.showMessageDialog(loginJf, "ע���ɹ�");
				loginJf.setVisible(false);
				user.opening();
			}
		});
	}
}
