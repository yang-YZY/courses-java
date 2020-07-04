package jsu.cn.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import jsu.cn.backGround.BackGround_JPanel;
import jsu.cn.dao.first;
import jsu.cn.file.r_RankingList;
import jsu.cn.file.w_RankingList;
import jsu.cn.itf.window_itf;
import jsu.cn.tool.getResult;

public class user_firstPoint implements window_itf,ActionListener {
	private int nb;
	private int fc;
	private int js;
	private int flag;
	private String uri;
    private static String []ns;
    private String []left;
    private String []right;
    private JFrame firstPointJf;
    private BackGround_JPanel firstPointJp;
    private JLabel number;
    private JLabel numberTxt;
    private JLabel fraction;
    private JLabel fractionTxt;
    private JLabel jishi;
    private JLabel jishiTxt;
    private JButton redJb;
    private JButton blueJb;
	private JButton violetJb;
	private JLabel leftJl;
	private JLabel rightJl;
	private JLabel add;
	private Font typeface;
	private Timer firstPointT;
	private Random firstPointR;
	
	public user_firstPoint() {
		voluation();
		location();
		setUp();
		addComponent();
		windowListener_Closing();
		myMouseListener my =new myMouseListener();
		redJb.addMouseListener(my);
		blueJb.addMouseListener(my);
		violetJb.addMouseListener(my);
		firstPointJf.setVisible(true);
		firstPointT.start();
	}
	
	@Override
	public void voluation() {

		// TODO Auto-generated method stub
	nb=0;
	fc=0;
	js=30;
    uri = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\背景\\游戏背景.png";
    left = new String[3];
    right = new String[3];
    left[0] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\布\\左布.png";
    right[0] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\布\\右布.png";
    left[1] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\剪刀\\左剪刀.png";
    right[1] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\剪刀\\右剪刀.png";
    left[2] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\石头\\左石头.png";
    right[2] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\石头\\右石头.png";
    firstPointJf = new JFrame("第一关");
    firstPointJp = new BackGround_JPanel(uri);
    number = new JLabel("0",SwingConstants.CENTER);
    numberTxt = new JLabel("答对数",SwingConstants.CENTER);
    fraction = new JLabel("0",SwingConstants.CENTER);
    fractionTxt = new JLabel("分数",SwingConstants.CENTER);
    jishi = new JLabel("30",SwingConstants.CENTER);
    jishiTxt = new JLabel("游戏时间",SwingConstants.CENTER);
    redJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\按钮\\红色按钮.png"));
    blueJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\按钮\\蓝色按钮.png"));
    violetJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\按钮\\紫色按钮.png"));
    leftJl = new JLabel(new ImageIcon(left[0]));
    rightJl = new JLabel(new ImageIcon(right[0]));
    add = new JLabel("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\按钮\\加一.jpg");
    typeface = new Font("宋体",Font.BOLD,28);
    firstPointT = new Timer(1000,this);
    firstPointR = new Random();
	}

	@Override
	public void location() {

		// TODO Auto-generated method stub
		firstPointJf.setLayout(null);
		firstPointJp.setLayout(null);
		firstPointJf.setBounds(700, 300, 600, 512);
		firstPointJp.setBounds(0, 0, 600, 512);
		number.setBounds(520, 20, 60, 40);
		numberTxt.setBounds(400, 20, 120, 40);
		fraction.setBounds(520, 80, 60, 40);
		fractionTxt.setBounds(400, 80, 120, 40);
		jishi.setBounds(520, 140, 60, 40);
		jishiTxt.setBounds(400, 140, 120, 40);
		redJb.setBounds(100, 400, 100, 48);
		violetJb.setBounds(220, 400, 100, 48);
		blueJb.setBounds(340, 400, 100, 48);
		leftJl.setBounds(160, 200, 56, 55);
		rightJl.setBounds(320, 200, 56,55);
		add.setBounds(260, 270, 123, 123);
		add.setVisible(false);
	}

	@Override
	public void addComponent() {

		// TODO Auto-generated method stub
		firstPointJp.add(number);
		firstPointJp.add(numberTxt);
		firstPointJp.add(fraction);
		firstPointJp.add(fractionTxt);
		firstPointJp.add(jishi);
		firstPointJp.add(jishiTxt);
		firstPointJp.add(redJb);
		firstPointJp.add(blueJb);
		firstPointJp.add(violetJb);
		firstPointJp.add(rightJl);
		firstPointJp.add(leftJl);
		firstPointJf.add(firstPointJp);
	}

	@Override
	public void setUp() {

		// TODO Auto-generated method stub
    number.setFont(typeface);
    number.setForeground(Color.RED);
    numberTxt.setFont(typeface);
    numberTxt.setForeground(Color.RED);
    fraction.setFont(typeface);
    fraction.setForeground(Color.RED);
    fractionTxt.setFont(typeface);
    fractionTxt.setForeground(Color.RED);
    jishi.setFont(typeface);
    jishi.setForeground(Color.RED);
    jishiTxt.setFont(typeface);
    jishiTxt.setForeground(Color.RED);
	}
;
	@Override
	public void windowListener_Closing() {
		// TODO Auto-generated method stub
		firstPointJf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				firstPointJf.setVisible(false);
				user_Login.opening();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int a=0;
		int b=0;
		js--;
		if(js==0) {
			flag=0;
			jishi.setText(String.valueOf(js));
			firstPointT.stop();
			int linshi;
			String linshi1[] =null;
			String linshi2[] = new String[11];
			String linshi3[] ;
			String middle=null;
			int middle1;
			int linshi4[]=new int[11];
			first f= new first();
			linshi = f.yesOrNo(ns[0]);
			if(linshi==0)
				f.insertFirst(ns[0],fraction.getText());
			else {
				if((linshi-1) < Integer.parseInt(fraction.getText()))
						f.setFirst(fraction.getText(), ns[0]);
			}
			r_RankingList rr = new  r_RankingList();
			w_RankingList wr = new w_RankingList();
			if(rr.firstIsEmpty()) {
				String one[]=new String[1];
				one[0]=ns[0]+"-"+fraction.getText();
				System.out.println(one[0]);
				wr.wFirst(one,0);
			}
			else {
				linshi1 = rr.first();
					for(int i=0;i<linshi1.length;i++) {
						linshi2[i]=linshi1[i];
						linshi3 = linshi1[i].split("-");
						linshi4[i] = Integer.parseInt(linshi3[1]);
					}
					linshi2[linshi1.length] =ns[0]+"-"+fraction.getText();
					linshi4[linshi1.length] =fc;
					for(int i=linshi1.length;i>0;i--) {
						if(linshi4[i]>linshi4[i-1]) {
							middle1 =linshi4[i-1];
							middle = linshi2[i-1];
							linshi4[i-1]=linshi4[i];
							linshi2[i-1]=linshi2[i];
							linshi4[i]=middle1;
							linshi2[i]=middle;
						}
						else break;
					}
					 if(linshi1.length<10)
						 wr.wFirst(linshi2,linshi1.length);
					 else 
						 wr.wFirst(linshi2, 10);
			}
		}
		else {
			a=firstPointR.nextInt(3);
			b=firstPointR.nextInt(3);
			flag=getResult.getRL(a, b);
			leftJl.setIcon(new ImageIcon(left[a]));
			rightJl.setIcon(new ImageIcon(right[b]));
			jishi.setText(String.valueOf(js));
		}
}
	class myMouseListener extends MouseAdapter {
	         @Override
	        public void mouseClicked(MouseEvent e) {
	        	// TODO Auto-generated method stub
	        	if(e.getComponent()==redJb) {
	        		if(flag==1) {
	        			nb++;
	        			fc=fc+10;
	        			number.setText(String.valueOf(nb));
	        			fraction.setText(String.valueOf(fc));
	        			flag=0;
	        		}
	        	}
	        	else if(e.getComponent()==violetJb) {
	        		if(flag==2) {
	        			nb++;
	        			fc=fc+10;
	        			number.setText(String.valueOf(nb));
	        			fraction.setText(String.valueOf(fc));
	        			flag=0;
	        		}
	        	}
	        	else if(e.getComponent()==blueJb) {
	        		if(flag==3) {
	        			nb++;
	        			fc=fc+10;
	        			number.setText(String.valueOf(nb));
	        			fraction.setText(String.valueOf(fc));
	        			flag=0;
	        		}
	        	}
	        }
	}
	public static void setNnAndSex(String []ns1) {
		ns=ns1;
	}

}
