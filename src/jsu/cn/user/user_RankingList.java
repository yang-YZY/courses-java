package jsu.cn.user;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import jsu.cn.backGround.BackGround_JPanel;
import jsu.cn.file.r_RankingList;
import jsu.cn.itf.window_itf;

// TODO: Auto-generated Javadoc
/**
 * The Class user_RankingList.
 *  ���а����
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class user_RankingList implements window_itf{
	
	/** The uri. ����ͼƬ·��*/
	private String uri;
	
	/** The ranking list jf.���а񴰿ڶ��� */
	private JFrame rankingListJf;
	
	/** The point.ѡ����� */
	private JTabbedPane point;
	
	/** The first. ��һ�ؿ������ͼƬ������*/
	private BackGround_JPanel first;
	
	/** The second. �ڶ��ؿ������ͼƬ������*/
	private BackGround_JPanel second;
	
	/** The third. �����ؿ������ͼƬ������*/
	private BackGround_JPanel third;
	
	/** The fourth. ���Ĺؿ������ͼƬ������*/
	private BackGround_JPanel fourth;
	
	/** The first number.��һ��ǰ10����ǩ */
	private JLabel firstNumber[];
	
	/** The first ranking. ��һ��ǰ10���ݱ�ǩ*/
	private JLabel firstRanking[];
	
	/** The second number.�ڶ���ǰ10����ǩ */
	private JLabel secondNumber[];
	
	/** The second ranking. �ڶ���ǰ10�����ݱ�ǩ*/
	private JLabel secondRanking[];
	
	/** The third number. ������ǰ10����ǩ*/
	private JLabel thirdNumber[];
	
	/** The third ranking. ������ǰ10�����ݱ�ǩ*/
	private JLabel thirdRanking[];
	
	/** The fourth number. ���Ĺ�ǰ10����ǩ*/
	private JLabel fourthNumber[];
	
	/** The fourth ranking. ���Ĺ�ǰ10�����ݱ�ǩ*/
	private JLabel fourthRanking[];
	
	/** The typeface.���� */
	private Font typeface;

/**
 * Instantiates a new user ranking list.
 * ʵ��������
 */
public user_RankingList() {
	voluation();
	location();
	setUp();
	show();
	addComponent();
	windowListener_Closing();
	rankingListJf.setVisible(true);
}


    /* (�� Javadoc)
    * 
    * 
    * @see jsu.cn.itf.window_itf#voluation()
    */
    
public void voluation() {
	uri = "C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\����\\���а�.png";
	rankingListJf = new JFrame("���а�");
	point = new JTabbedPane(JTabbedPane.TOP);
	first = new BackGround_JPanel(uri);
	second = new BackGround_JPanel(uri);
	third = new BackGround_JPanel(uri);
	fourth = new BackGround_JPanel(uri);
	firstNumber = new JLabel[10];
	firstRanking = new JLabel[10];
	secondNumber = new JLabel[10];
	secondRanking = new JLabel[10];
	thirdNumber = new JLabel[10];
	thirdRanking =  new JLabel[10];
	fourthNumber = new JLabel[10];
	fourthRanking = new JLabel[10];
	for(int i=0;i<=9;i++) {
		String s="��"+(i+1)+"��";
		firstRanking[i] = new JLabel(s,SwingConstants.CENTER);
		secondRanking[i] = new JLabel(s,SwingConstants.CENTER);
		thirdRanking[i] = new JLabel(s,SwingConstants.CENTER);
		fourthRanking[i] = new JLabel(s,SwingConstants.CENTER);
		firstNumber[i] = new JLabel("���޼�¼",SwingConstants.CENTER);
		secondNumber[i] = new JLabel("���޼�¼",SwingConstants.CENTER);
		thirdNumber[i] = new JLabel("���޼�¼",SwingConstants.CENTER);
		fourthNumber[i] = new JLabel("���޼�¼",SwingConstants.CENTER);
	}
	typeface = new Font("����",Font.BOLD,16);
}


    /* (�� Javadoc)
    * 
    * 
    * @see jsu.cn.itf.window_itf#location()
    */
    
public void location() {
	rankingListJf.setLayout(null);
	first.setLayout(null);
	second.setLayout(null);
	third.setLayout(null);
	fourth.setLayout(null);
	rankingListJf.setBounds(700, 300, 512, 512);
	point.setBounds(0, 0, 512, 512);
	first.setBounds(0, 0, 512, 512);
	second.setBounds(0, 0, 512, 512);
	third.setBounds(0, 0, 512, 512);
	fourth.setBounds(0, 0, 512, 512);
	for(int i=0;i<=9;i++) {
		firstRanking[i].setBounds(100, i*40+10, 80, 30);
		secondRanking[i].setBounds(100, i*40+10,80, 30);
		thirdRanking[i].setBounds(100, i*40+10,80, 30);
		fourthRanking[i].setBounds(100, i*40+10,80, 30);
		firstNumber[i].setBounds(320, i*40+10, 80, 30);
		secondNumber[i].setBounds(320, i*40+10, 80, 30);
		thirdNumber[i].setBounds(320, i*40+10, 80, 30);
		fourthNumber[i].setBounds(320, i*40+10, 80, 30);
	}
}


    /* (�� Javadoc)
    * 
    * 
    * @see jsu.cn.itf.window_itf#setUp()
    */
    
public void setUp() {
	for(int i=0;i<=9;i++) {
		firstRanking[i].setFont(typeface);
		secondRanking[i].setFont(typeface);
		thirdRanking[i].setFont(typeface);
		fourthRanking[i].setFont(typeface);
		firstNumber[i].setFont(typeface);
		secondNumber[i].setFont(typeface);
		thirdNumber[i].setFont(typeface);
		fourthNumber[i].setFont(typeface);
	}
}

/**
 * Show.
 * ���ø����ε�����
 */
private void show() {
	r_RankingList rwRL= new r_RankingList();
	String flag[] = new String[10] ;
	String flag1[] = new String[10];
	if(!rwRL.firstIsEmpty()) {
		flag=rwRL.first();
		for(int i=0;i<flag.length;i++) {
			firstNumber[i].setText(flag[i]);
		}
	}
	if(!rwRL.secondIsEmpty()) {
		flag1=rwRL.second();
		for(int i=0;i<flag1.length;i++)
			secondNumber[i].setText(flag1[i]);
	}
}


    /* (�� Javadoc)
    * 
    * 
    * @see jsu.cn.itf.window_itf#addComponent()
    */
    
public void addComponent() {
	for(int i=0;i<=9;i++) {
		first.add(firstRanking[i]);
		first.add(firstNumber[i]);
		second.add(secondRanking[i]);
		second.add(secondNumber[i]);
		third.add(thirdRanking[i]);
		third.add(thirdNumber[i]);
		fourth.add(fourthRanking[i]);
		fourth.add(fourthNumber[i]);
	}
	point.addTab("��һ��", first);
	point.addTab("�ڶ���", second);
	point.addTab("������", third);
	point.addTab("���Ĺ�", fourth);
	rankingListJf.add(point);
}


    /* (�� Javadoc)
    * 
    * 
    * @see jsu.cn.itf.window_itf#windowListener_Closing()
    */
    
public void windowListener_Closing() {
	rankingListJf.addWindowListener(new WindowAdapter() {
    	  @Override
    	public void windowClosing(WindowEvent e) {
    		// TODO Auto-generated method stub
    		  rankingListJf.setVisible(false);
    		  user_Login.opening();
    	}
	});
}
}
