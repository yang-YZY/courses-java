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
import jsu.cn.dao.first_dao;
import jsu.cn.file.r_RankingList;
import jsu.cn.file.w_RankingList;
import jsu.cn.itf.window_itf;
import jsu.cn.tool.getResult;

// TODO: Auto-generated Javadoc
/**
 * The Class user_firstPoint.
 *��һ�ؽ���
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class user_firstPoint implements window_itf,ActionListener {
	
	/** The nb. ����*/
	private int nb;
	
	/** The fc.���� */
	private int fc;
	
	/** The js. ʱ��*/
	private int js;
	
	/** The flag. ��Ӯ���ֵ*/
	private int flag;
	
	/** The uri. ����ͼƬ·��*/
	private String uri;
    
    /** The ns. �ǳ����Ա�*/
    private static String []ns;
    
    /** The left.��ͼƬ */
    private String []left;
    
    /** The right. �ҷ�ͼƬ*/
    private String []right;
    
    /** The first point jf. ��һ�ش��ڶ��� */
    private JFrame firstPointJf;
    
    /** The first point jp. �������ͼƬ������ */
    private BackGround_JPanel firstPointJp;
    
    /** The number. ����*/
    private JLabel number;
    
    /** The number txt. ������ǩ*/
    private JLabel numberTxt;
    
    /** The fraction. ����*/
    private JLabel fraction;
    
    /** The fraction txt.������ǩ */
    private JLabel fractionTxt;
    
    /** The jishi. ʱ��*/
    private JLabel jishi;
    
    /** The jishi txt.ʱ���ǩ */
    private JLabel jishiTxt;
    
    /** The red jb.��ɫ��ť */
    private JButton redJb;
    
    /** The blue jb. ��ɫ��ť*/
    private JButton blueJb;
	
	/** The violet jb.��ɫ��ť */
	private JButton violetJb;
	
	/** The left jl. ��ͼƬ*/
	private JLabel leftJl;
	
	/** The right jl. ��ͼƬ*/
	private JLabel rightJl;
	
	/** The typeface. ����*/
	private Font typeface;
	
	/** The first point T. ��ʱ�� */
	private Timer firstPointT;
	
	/** The first point R. ������� */
	private Random firstPointR;
	
	/**
	 * Instantiates a new user first point.
	 * ʵ��������
	 */
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
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#voluation()
	    */
	    
	@Override
	public void voluation() {

		// TODO Auto-generated method stub
	nb=0;
	fc=0;
	js=30;
    uri = "C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\����\\��Ϸ����.png";
    left = new String[3];
    right = new String[3];
    left[0] = "C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\��\\��.png";
    right[0] = "C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\��\\�Ҳ�.png";
    left[1] = "C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\����\\�����.png";
    right[1] = "C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\����\\�Ҽ���.png";
    left[2] = "C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\ʯͷ\\��ʯͷ.png";
    right[2] = "C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\ʯͷ\\��ʯͷ.png";
    firstPointJf = new JFrame("��һ��");
    firstPointJp = new BackGround_JPanel(uri);
    number = new JLabel("0",SwingConstants.CENTER);
    numberTxt = new JLabel("�����",SwingConstants.CENTER);
    fraction = new JLabel("0",SwingConstants.CENTER);
    fractionTxt = new JLabel("����",SwingConstants.CENTER);
    jishi = new JLabel("30",SwingConstants.CENTER);
    jishiTxt = new JLabel("��Ϸʱ��",SwingConstants.CENTER);
    redJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\��ť\\��ɫ��ť.png"));
    blueJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\��ť\\��ɫ��ť.png"));
    violetJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\��ť\\��ɫ��ť.png"));
    leftJl = new JLabel(new ImageIcon(left[0]));
    rightJl = new JLabel(new ImageIcon(right[0]));
    typeface = new Font("����",Font.BOLD,28);
    firstPointT = new Timer(1000,this);
    firstPointR = new Random();
	}

	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#location()
	    */
	    
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
	}

	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#addComponent()
	    */
	    
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

	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#setUp()
	    */
	    
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
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#windowListener_Closing()
	    */
	    
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
	
	
	    /* (�� Javadoc)
	    * 
	    * 
	    * @param e
	    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	    */
	    
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
			first_dao f= new first_dao();
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
	
	/**
	 * The listener interface for receiving myMouse events.
	 * The class that is interested in processing a myMouse
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addmyMouseListener<code> method. When
	 * the myMouse event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see myMouseEvent
	 *       �Զ������������
	 */
	class myMouseListener extends MouseAdapter {
	         
         	
         	    /* (�� Javadoc)
         	    * 
         	    * 
         	    * @param e
         	    * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
         	    */
         	    
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
	
	/**
	 * Sets the nn and sex.
	 *�����ǳ����Ա�
	 * @param ns1 �ǳ����Ա�
	 */
	public static void setNnAndSex(String []ns1) {
		ns=ns1;
	}

}
