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
import jsu.cn.dao.checkPoint;
import jsu.cn.itf.window_itf;

public class user_Record implements window_itf {
		private String uri;
		private static String []ns;
		private JFrame recordJf;
		private BackGround_JPanel recordJp;
		private JLabel point[];
		private JLabel number[];
		private JLabel nickNameJl;
		private JLabel sexJl;
		private JButton back; 
		private Font typeface;

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
	public void voluation() {
	uri = "C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\����\\��¼.png";
	recordJf = new JFrame("��ʷ��¼");
	recordJp = new BackGround_JPanel(uri);
	point = new JLabel[4];
	number = new JLabel[4];
	for(int i=0;i<point.length;i++) {
		String s="��"+(i+1)+"��";
		point[i]= new JLabel(s,SwingConstants.CENTER);
		number[i]= new JLabel("���޼�¼",SwingConstants.CENTER);
	}
	nickNameJl = new JLabel(ns[0]);
	if("1".equals(ns[1]))
		sexJl = new JLabel(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\�Ա�\\��.png"));
	else 
		sexJl = new JLabel(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\�Ա�\\Ů.png"));
	back = new JButton("����");
	typeface = new Font("����",Font.BOLD,16);
	}
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
	public void setUp() {
		for(int i=0;i<point.length;i++) {
			point[i].setFont(typeface);
			number[i].setFont(typeface);
		}
		nickNameJl.setFont(typeface);
	}
	public static void setNnAndSex(String []ns1) {
		ns=ns1;
	}
	private void show() {
		int flag;
		String flag1[] =new String[4];
		checkPoint cp =new checkPoint();
		flag=cp.getIndex(ns[0]);
		if(flag!=0) {
			flag1 = cp.getNumber(flag);
			for(int i=0;i<flag1.length;i++) {
				number[i].setText(flag1[i]);
			}
		}
		cp.closing();
	}
	public void windowListener_Closing() {
		recordJf.addWindowListener(new WindowAdapter() {
	    	  @Override
	    	public void windowClosing(WindowEvent e) {
	    		// TODO Auto-generated method stub
	    		  user_Login.opening();
	    	}
		});
	}
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
