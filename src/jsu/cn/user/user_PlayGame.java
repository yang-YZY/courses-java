package jsu.cn.user;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import jsu.cn.backGround.BackGround_JPanel;
import jsu.cn.dao.checkPoint;
import jsu.cn.itf.window_itf;

public class user_PlayGame implements window_itf {
	private static String []ns;
	private String fail[];
	private String success[];
	private String uri;
	private int max;
	private JFrame playGameJf;
	private BackGround_JPanel playGameJp;
	private JLabel point[];
   
	public user_PlayGame() {
		 voluation();
		 location();
		 setUp();
		 addComponent();
		 myMouseListener my= new myMouseListener();
		 for(int i=0;i<point.length;i++) {
			 point[i].addMouseListener(my);
		 }
		 windowListener_Closing();
		 playGameJf.setVisible(true);
	 }
	@Override
	public void voluation() {
	uri = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\背景\\关卡背景.jpg";
	playGameJf = new JFrame("关卡");
	playGameJp = new BackGround_JPanel(uri);
	fail =new String[4];
	success = new String[4];
	fail[0] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\关卡\\关卡1.png";
	fail[1] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\关卡\\关卡2.png";
	fail[2] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\关卡\\关卡3.png";
	fail[3] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\关卡\\关卡4.png";
	success[0] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\关卡\\1.png";
	success[1] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\关卡\\2.png";
	success[2] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\关卡\\3.png";
	success[3] = "C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\关卡\\4.png";
	point = new JLabel[4];
	for(int i=0;i<4;i++)
		point[i] = new JLabel();
	}

	@Override
	public void location() {
		playGameJf.setLayout(null);
		playGameJp.setLayout(null);
		playGameJf.setBounds(700, 300, 800, 400);
		playGameJp.setBounds(0, 0, 800, 400);
		for(int i=0;i<4;i++) {
			point[i].setBounds(60+i*170, 120, 150, 170);
		}
	}
	@Override
	public void addComponent() {
		// TODO Auto-generated method stub
		int flag;
		checkPoint cp = new checkPoint();
		flag = cp.getIndex(ns[0]);
		for(int i=0;i<flag;i++) {
		    point[i].setIcon(new ImageIcon(success[i]));
		    playGameJp.add(point[i]);
		}
		for(int i= flag;i<4;i++) {
			point[i].setIcon(new ImageIcon(fail[i]));
			playGameJp.add(point[i]);
		}
		playGameJf.add(playGameJp);
		cp.closing();
	    max=flag;
	}

	@Override
	public void setUp() {
		// TODO Auto-generated method stub
       ;
	}

	@Override
	public void windowListener_Closing() {
		// TODO Auto-generated method stub
		playGameJf.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			playGameJf.setVisible(false);
			user_Login.opening();
		}
		});
	}
    public static void setNnAndSex(String []ns1) {
    	ns=ns1;
    }
    class myMouseListener extends MouseAdapter{
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		// TODO Auto-generated method stub
    		if(e.getComponent()==point[0]) {
    			playGameJf.setVisible(false);
    			user_firstPoint.setNnAndSex(ns);
    			  new user_firstPoint();
    		}
    		else if(e.getComponent()==point[1]) {
    			if(max>=1) {
    				playGameJf.setVisible(false);
    				user_secondPoint.setNnAndSex(ns);
    				new user_secondPoint();
    			}
    			else
    				JOptionPane.showMessageDialog(playGameJf,"请先玩过第一关");
    		}
    		else if(e.getComponent()==point[2]) {
    			if(max>=2) {
    				;
    			}
    			else
    				JOptionPane.showMessageDialog(playGameJf,"请先玩过第二关");
    		}
    		else if(e.getComponent()==point[3]) {
    			if(max>=3) {
    				;
    			}
    			else
    				JOptionPane.showMessageDialog(playGameJf,"请先玩过第三关");
    		}
    	}
    }
}
