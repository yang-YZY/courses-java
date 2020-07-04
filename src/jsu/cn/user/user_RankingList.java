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

public class user_RankingList implements window_itf{
	private String uri;
	private JFrame rankingListJf;
	private JTabbedPane point;
	private BackGround_JPanel first;
	private BackGround_JPanel second;
	private BackGround_JPanel third;
	private BackGround_JPanel fourth;
	private JLabel firstNumber[];
	private JLabel firstRanking[];
	private JLabel secondNumber[];
	private JLabel secondRanking[];
	private JLabel thirdNumber[];
	private JLabel thirdRanking[];
	private JLabel fourthNumber[];
	private JLabel fourthRanking[];
	private Font typeface;

public user_RankingList() {
	voluation();
	location();
	setUp();
	show();
	addComponent();
	windowListener_Closing();
	rankingListJf.setVisible(true);
}
public void voluation() {
	uri = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\背景\\排行榜.png";
	rankingListJf = new JFrame("排行榜");
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
		String s="第"+(i+1)+"名";
		firstRanking[i] = new JLabel(s,SwingConstants.CENTER);
		secondRanking[i] = new JLabel(s,SwingConstants.CENTER);
		thirdRanking[i] = new JLabel(s,SwingConstants.CENTER);
		fourthRanking[i] = new JLabel(s,SwingConstants.CENTER);
		firstNumber[i] = new JLabel("暂无记录",SwingConstants.CENTER);
		secondNumber[i] = new JLabel("暂无记录",SwingConstants.CENTER);
		thirdNumber[i] = new JLabel("暂无记录",SwingConstants.CENTER);
		fourthNumber[i] = new JLabel("暂无记录",SwingConstants.CENTER);
	}
	typeface = new Font("宋体",Font.BOLD,16);
}
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
	point.addTab("第一关", first);
	point.addTab("第二关", second);
	point.addTab("第三关", third);
	point.addTab("第四关", fourth);
	rankingListJf.add(point);
}
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
