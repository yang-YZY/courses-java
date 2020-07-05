package jsu.cn.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import jsu.cn.backGround.BackGround_JPanel;
import jsu.cn.dao.second_dao;
import jsu.cn.file.r_RankingList;
import jsu.cn.file.w_RankingList;
import jsu.cn.itf.window_itf;

// TODO: Auto-generated Javadoc
/**
 * The Class user_secondPoint.
 *第二关界面
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class user_secondPoint implements ActionListener,window_itf {
	
	/** The nb. 数量*/
	private int nb;
	
	/** The fc. 分数*/
	private int fc;
	
	/** The js. 时间*/
	private int js;
	
	/** The flag. 计分标记值*/
	private int flag;
	
	/** The uri. 背景图片路径*/
	private String uri;
    
    /** The ns.昵称与性别 */
    private static String []ns;
    
    /** The second point jf. 第二关窗口对象 */
    private JFrame secondPointJf;
    
    /** The second point jp.可以添加图片的容器 */
    private BackGround_JPanel secondPointJp;
    
    /** The number. 数量*/
    private JLabel number;
    
    /** The number txt.数量标签 */
    private JLabel numberTxt;
    
    /** The fraction. 分数*/
    private JLabel fraction;
    
    /** The fraction txt.分数标签 */
    private JLabel fractionTxt;
    
    /** The jishi. 时间*/
    private JLabel jishi;
    
    /** The jishi txt. 时间标签*/
    private JLabel jishiTxt;
    
    /** The finish jb. 结束游戏按钮*/
    private JButton finishJb;
    
    /** The face. 耳光按钮*/
    private JButton face;
    
    /** The typeface.字体 */
    private Font typeface;
    
    /** The second point T.计时器 */
    private Timer secondPointT;
    
    /**
     * Instantiates a new user second point.
     * 实例化 对象
     */
    public user_secondPoint() {
    	voluation();
		location();
		setUp();
		addComponent();
		windowListener_Closing();
		mouseListener_Face();
		actionListener_FinishJb();
		secondPointJf.setVisible(true);
		secondPointT.start();
    	
    }
    
    
        /* (非 Javadoc)
        * 
        * 
        * @see jsu.cn.itf.window_itf#voluation()
        */
        
    @Override
    public void voluation() {
    	// TODO Auto-generated method stub
    	nb=0;
    	fc=0;
    	js=0;
    	flag=1;
    	uri="C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\背景\\游戏背景.png";
    	secondPointJf = new JFrame("第二关");
    	secondPointJp = new BackGround_JPanel(uri);
    	number = new JLabel("0",SwingConstants.CENTER);
    	numberTxt = new JLabel("次数",SwingConstants.CENTER);
    	fraction = new JLabel("0",SwingConstants.CENTER);
        fractionTxt = new JLabel("分数",SwingConstants.CENTER);
    	jishi = new JLabel("0",SwingConstants.CENTER);
    	jishiTxt = new JLabel("游戏时间",SwingConstants.CENTER);
    	 typeface = new Font("宋体",Font.BOLD,28);
    	 face = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\按钮\\耳光.png"));
    	 finishJb = new JButton(new ImageIcon("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\按钮\\结束游戏.png"));
    	 secondPointT = new Timer(1000,this);
    	 
    }
    
    
        /* (非 Javadoc)
        * 
        * 
        * @see jsu.cn.itf.window_itf#location()
        */
        
    @Override
    public void location() {
    	// TODO Auto-generated method stub
    	secondPointJf.setLayout(null);
    	secondPointJp.setLayout(null);
    	secondPointJf.setBounds(700, 300, 600, 512);
    	secondPointJp.setBounds(0, 0, 600, 512);
		number.setBounds(510, 20, 60, 40);
		numberTxt.setBounds(370, 20, 140, 40);
		fraction.setBounds(510, 80, 60, 40);
		fractionTxt.setBounds(370, 80, 140, 40);
		jishi.setBounds(510, 140, 60, 40);
		jishiTxt.setBounds(370, 140, 140, 40);
		face.setBounds(270, 260, 65, 65);
		finishJb.setBounds(260,340 , 100,48 );
    }
    
    
        /* (非 Javadoc)
        * 
        * 
        * @see jsu.cn.itf.window_itf#addComponent()
        */
        
    @Override
    public void addComponent() {
    	// TODO Auto-generated method stub
    	secondPointJp.add(number);
    	secondPointJp.add(numberTxt);
    	secondPointJp.add(fraction);
    	secondPointJp.add(fractionTxt);
    	secondPointJp.add(jishi);
    	secondPointJp.add(jishiTxt);
    	secondPointJp.add(face);
    	secondPointJp.add(finishJb);
    	secondPointJf.add(secondPointJp);
    }
    
    
        /* (非 Javadoc)
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
    
    
        /* (非 Javadoc)
        * 
        * 
        * @see jsu.cn.itf.window_itf#windowListener_Closing()
        */
        
    @Override
    public void windowListener_Closing() {
    	// TODO Auto-generated method stub
    	secondPointJf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				int linshi;
				String linshi1[] =null;
				String linshi2[] = new String[11];
				String linshi3[] ;
				String middle=null;
				int middle1;
				int linshi4[]=new int[11];
				second_dao f= new second_dao();
				linshi = f.yesOrNo(ns[0]);
				if(linshi==0)
					f.insertSecond(ns[0],fraction.getText());
				else {
					if((linshi-1) < Integer.parseInt(fraction.getText()))
							f.setSecond(fraction.getText(), ns[0]);
				}
				r_RankingList rr = new  r_RankingList();
				w_RankingList wr = new w_RankingList();
				if(rr.secondIsEmpty()) {
					String one[]=new String[1];
					one[0]=ns[0]+"-"+fraction.getText();
					System.out.println(one[0]);
					wr.wSecond(one,0);
				}
				else {
					linshi1 = rr.second();
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
							 wr.wSecond(linshi2,linshi1.length);
						 else 
							 wr.wSecond(linshi2, 10);
				}
				secondPointT.stop();
				secondPointJf.setVisible(false);
				user_Login.opening();
			}
		});
    }
    
    /**
     * Mouse listener face.
     * 为耳光添加鼠标监听器
     */
    public void mouseListener_Face() {
    	face.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			// TODO Auto-generated method stub
    			if(flag==1) {
    				nb++;	
    				fc=fc+5+10-js;
    				fraction.setText(String.valueOf(fc));
    				number.setText(String.valueOf(nb));
    			}
    		}
		});
    }
    
    /**
     * Action listener finish jb.
     *      为结束游戏按钮添加动作事件
     */
    public void actionListener_FinishJb(){
    	finishJb.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(flag==1) {
					flag=0;
				if(nb!=37) {
					fraction.setText("0");
					fc=0;
					JOptionPane.showMessageDialog(secondPointJf,"由于你的手速过快导致次数不足或者过多，因此分数清零");
				}
				secondPointT.stop();
				}
				
			}
		});
    }
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @param e
	    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	    */
	    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		js++;
		if(js==10) {
			flag=0;
			fc=0;
			fraction.setText("0");
			jishi.setText(String.valueOf(js));
			JOptionPane.showMessageDialog(secondPointJf,"由于你的手速过慢导致次数不足，因此分数清零");
			secondPointT.stop();
		}
		else {
			jishi.setText(String.valueOf(js));
		}
	}
	
	/**
	 * Sets the nn and sex.
	 *设置昵称与性别
	 * @param ns1 昵称与性别
	 */
	public static void setNnAndSex(String []ns1) {
		ns=ns1;
	}
}
