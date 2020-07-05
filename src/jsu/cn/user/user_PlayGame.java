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
import jsu.cn.dao.checkPoint_dao;
import jsu.cn.itf.window_itf;

// TODO: Auto-generated Javadoc
/**
 * The Class user_PlayGame.
 *  选择关卡界面
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class user_PlayGame implements window_itf {
	
	/** The ns. 昵称与性别*/
	private static String []ns;
	
	/** The fail.失败关卡图片 */
	private String fail[];
	
	/** The success.成功关卡图片 */
	private String success[];
	
	/** The uri. 背景图片路径*/
	private String uri;
	
	/** The max. 最大选择关卡数*/
	private int max;
	
	/** The play game jf. 关卡窗口对象*/
	private JFrame playGameJf;
	
	/** The play game jp.可以添加图片的容器 */
	private BackGround_JPanel playGameJp;
	
	/** The point. 关卡标签*/
	private JLabel point[];
   
	/**
	 * Instantiates a new user play game.
	 * 实例化对象
	 */
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
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#voluation()
	    */
	    
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

	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#location()
	    */
	    
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
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#addComponent()
	    */
	    
	@Override
	public void addComponent() {
		// TODO Auto-generated method stub
		int flag;
		checkPoint_dao cp = new checkPoint_dao();
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

	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#setUp()
	    */
	    
	@Override
	public void setUp() {
		// TODO Auto-generated method stub
       ;
	}

	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#windowListener_Closing()
	    */
	    
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
    
    /**
     * Sets the nn and sex.
     *设置昵称与姓名
     * @param ns1 昵称与姓名
     */
    public static void setNnAndSex(String []ns1) {
    	ns=ns1;
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
              * 自定义的鼠标监听器
     */
    class myMouseListener extends MouseAdapter{
    	
	    
	        /* (非 Javadoc)
	        * 
	        * 
	        * @param e
	        * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
	        */
	        
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
