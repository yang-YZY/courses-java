package jsu.cn.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jsu.cn.backGround.BackGround_JPanel;
import jsu.cn.dao.checkNews_dao;
import jsu.cn.dao.userNews_dao;
import jsu.cn.itf.window_itf;
import jsu.cn.tool.checkRegister;

// TODO: Auto-generated Javadoc
/**
 * The Class user_Register.
 *注册界面
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class user_Register implements window_itf{
	
	/** The uri. 背景图片路径*/
	private String uri;
	
	/** The s 1. 账号*/
	private String s1;
	
	/** The s 2.密码 */
	private String s2;
	
	/** The s 3. 姓名*/
	private String s3;
	
	/** The s 4. 昵称*/
	private String s4;
	
	/** The s 5. 性别*/
	private String s5;
	
	/** The register jf. 注册窗口对象*/
	public static JFrame registerJf;
	
	/** The register jp. 可以添加图片的容器 */
	private BackGround_JPanel registerJp;
	
	/** The welcome jl. 欢迎标签*/
	private JLabel welcomeJl;
	
	/** The id jl. 账号标签*/
	private JLabel idJl;
	
	/** The id password jl. 密码标签*/
	private JLabel idPasswordJl;
	
	/** The user name jl. 姓名标签*/
	private JLabel userNameJl;
	
	/** The sex jl. 性别标签*/
	private JLabel sexJl;
	
	/** The nick name jl. 昵称标签*/
	private JLabel nickNameJl;
	
	/** The id jt. 账号框*/
	private JTextField idJt;
	
	/** The id password jp. 密码框*/
	private JPasswordField idPasswordJp;
	
	/** The user name jt. 姓名框*/
	private JTextField userNameJt;
	
	/** The nick name jt. 昵称框*/
	private JTextField nickNameJt;
	
	/** The cancel jb. 取消框*/
	private JButton cancelJb;
	
	/** The ok jb. 确认框*/
	private JButton okJb;
	
	/** The sex M. 性别男按钮*/
	private JRadioButton sexM;
	
	/** The sex W. 性别女按钮*/
	private JRadioButton sexW;
	
	/** The sex bg. 作用域*/
	private ButtonGroup sexBg;
	
	/** The typeface.字体 */
	private Font typeface;
	
	/** The sex I. 自定义的 选择监听器*/
	private myItemListener sexI;
	
	/**
	 * Instantiates a new user register.
	 * 实例化对象
	 */
	public user_Register() {
		voluation();
		
		location();
		setUp();
		addComponent();
		sexM.addItemListener(sexI);
		sexW.addItemListener(sexI);
		acctionListener_ActionPerformed_okJb();
		acctionListener_ActionPerformed_cancelJb();
		windowListener_Closing();
		registerJf.setVisible(true);
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#voluation()
	    */
	    
	public void voluation() {
    	uri=new String("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\背景\\注册背景.png");
    	s1 = new String();
    	s2 = new String();
    	s3 = new String();
    	s4 = new String();
    	s5 = new String();
    	registerJf =new JFrame("注册");
		registerJp = new BackGround_JPanel(uri);
		welcomeJl =new JLabel("欢迎进入信息注册界面");
		idJl =new JLabel("用户名账号",SwingConstants.CENTER);
		idPasswordJl =new JLabel("密码",SwingConstants.CENTER);
		userNameJl =new JLabel("姓名",SwingConstants.CENTER);
		sexJl =new JLabel("性别",SwingConstants.CENTER);
		nickNameJl =new JLabel("昵称",SwingConstants.CENTER);
		idJt =new JTextField();
		idPasswordJp =new JPasswordField();
		userNameJt =new JTextField();
		nickNameJt =new JTextField();
		cancelJb =new JButton("取消");
		okJb =new JButton("确认");
		sexM = new JRadioButton("男");
		sexW = new JRadioButton("女");
		sexBg = new ButtonGroup();
		typeface = new Font("宋体 ",Font.BOLD,17);
		sexI = new myItemListener();
    }
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#location()
	    */
	    
	public void location() {
    	registerJf.setBounds(700, 300, 500, 600);
		registerJp.setBounds(0, 0, 500, 600);
		registerJf.setLayout(null);
		registerJp.setLayout(null);
		welcomeJl.setBounds(160, 10, 200, 80);
		idJl.setBounds(80, 100, 120, 40);
		idJt.setBounds(300, 105, 100, 30);
		idPasswordJl.setBounds(100,160, 80, 40);
		idPasswordJp.setBounds(300, 165, 100, 30);
		userNameJl.setBounds(100, 220, 80, 40);
		userNameJt.setBounds(300, 225, 100, 30);
		nickNameJl.setBounds(100, 280, 80, 40);
		nickNameJt.setBounds(300, 285, 100, 30);
	    sexJl.setBounds(100, 340, 80, 40);
	    sexM.setBounds(300, 345, 50, 30);
	    sexW.setBounds(350,345,50,30);
		okJb.setBounds(100, 480, 80, 40);
		cancelJb.setBounds(300, 480, 80, 40);
    }
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#setUp()
	    */
	    
	public void setUp() {
    	welcomeJl.setFont(typeface);
    	idJl.setFont(typeface);
    	idJl.setForeground(Color.RED);
    	idPasswordJl.setFont(typeface);
    	idPasswordJl.setForeground(Color.RED);
    	idPasswordJp.setFont(typeface);
    	userNameJl.setFont(typeface);
    	userNameJl.setForeground(Color.RED);
    	userNameJt.setFont(typeface);
    	nickNameJl.setFont(typeface);
    	nickNameJl.setForeground(Color.RED);
    	nickNameJt.setFont(typeface);
    	sexJl.setFont(typeface);
    	sexJl.setForeground(Color.RED);
    }
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#addComponent()
	    */
	    
	public void addComponent() {
		registerJp.add(welcomeJl);
		registerJp.add(idJl);
		registerJp.add(idJt);
		registerJp.add(sexM);
		registerJp.add(sexW);
		sexBg.add(sexM);
		sexBg.add(sexW);
		registerJp.add(idPasswordJl);
		registerJp.add(idPasswordJp);
		registerJp.add(userNameJl);
		registerJp.add(userNameJt);
		registerJp.add(sexJl);
		registerJp.add(nickNameJl);
		registerJp.add(nickNameJt);
		registerJp.add(cancelJb);
		registerJp.add(okJb);
		registerJf.add(registerJp);
	}
	 
 	/**
 	 * The listener interface for receiving myItem events.
 	 * The class that is interested in processing a myItem
 	 * event implements this interface, and the object created
 	 * with that class is registered with a component using the
 	 * component's <code>addmyItemListener<code> method. When
 	 * the myItem event occurs, that object's appropriate
 	 * method is invoked.
 	 *
 	 * @see myItemEvent
 	 * 自定义的选择监听器
 	 */
 	class myItemListener implements ItemListener{
		 
 		
 		    /* (非 Javadoc)
 		    * 
 		    * 
 		    * @param e
 		    * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
 		    */
 		    
 		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getItem()==sexM)
				s5=sexM.getText();
			else 
				s5=sexW.getText();
		}
	 }
	
	/**
	 * Opening.
	 * 打开注册界面
	 */
	public static void opening() {
		registerJf.setVisible(true);
	}
	
	
	    /* (非 Javadoc)
	    * 
	    * 
	    * @see jsu.cn.itf.window_itf#windowListener_Closing()
	    */
	    
	public void windowListener_Closing() {
		registerJf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				user.opening();
				empty();
			}
		});
	}
	
	/**
	 * Acction listener action performed cancel jb.
	 * 为取消按钮添加动作监听器
	 */
	public void acctionListener_ActionPerformed_cancelJb() {
		 cancelJb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					registerJf.setVisible(false);
					user.opening();
					empty();
				}
			});
	}
	
	/**
	 * Acction listener action performed ok jb.
	 * 为确认按钮添加动作监听器
	 */
	public void acctionListener_ActionPerformed_okJb() {
		okJb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int a;
				 s1= idJt.getText();
				 s2= new String(idPasswordJp.getPassword());
				 s3= userNameJt.getText();
				 s4= nickNameJt.getText();
				 a=checkRegister.checkString(s1,s2,s3,s4,s5);
				if(a==0) {
					checkNews_dao cn = new checkNews_dao();
					if(cn.checkId(s1)) {
						JOptionPane.showMessageDialog(registerJf, "账号已存在");
						idJt.setText("");
						cn.closeAll();
					}
					else if(cn.checkNickName(s4)) {
						JOptionPane.showMessageDialog(registerJf, "昵称已存在");
						nickNameJt.setText("");
						cn.closeAll();
					} else {
						userNews_dao un=new userNews_dao();
						un.insertNews(s1, s2, s3, s4, s5);
						un.closeAll();
						empty();
						JOptionPane.showMessageDialog(registerJf, "注册成功");
					}
				}
				else {
					JOptionPane.showMessageDialog(registerJf, "请把信息输入完整!");
				}
			}
		});
	}
	
	/**
	 * Empty.
	 * 置空
	 */
	private void empty() {
		idJt.setText("");
		idPasswordJp.setText("");
		userNameJt.setText("");
		nickNameJt.setText("");
		sexBg.clearSelection();
	}
}
