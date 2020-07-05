package jsu.cn.text;

import jsu.cn.tool.playMusic;
import jsu.cn.user.user;

// TODO: Auto-generated Javadoc
/**
 * The Class courseDesignDemo.
 * 程序入口类
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class courseDesignDemo {

	/**
	 * The main method.
	 *  进入游戏
	 * @param args the arguments
	 */
	public static void main(String[] args) {
           new user().startWindow();
           new playMusic("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\音乐\\音乐1.mp3").start();
	       
	}
}
