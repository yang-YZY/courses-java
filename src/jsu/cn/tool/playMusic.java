package jsu.cn.tool;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class playMusic.
 *播放音乐类
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class playMusic extends Thread{
    
    /** The player.播放器 */
    Player player;
    
    /** The music. 音乐文件路径*/
    String music;
    
    /**
     * Instantiates a new play music.
             *实例化对象
     * @param  file 音乐文件路径 
     */
    public playMusic(String file) {
        this.music = file;
    }
     
     
         /* (非 Javadoc)
         * 
         * 
         * @see java.lang.Thread#run()
         */
         
     public void run() {
    	 while(true) { 
            play();
                }
     }
    
    /**
      * Play.
               * 播放音乐
     */
    public void play()  { 
    	try{
    		BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music)); 
    		 player = new Player(buffer); 
    	        player.play();
    	}catch ( FileNotFoundException e){
    		e.printStackTrace();
    	}catch ( JavaLayerException e) {
    		e.printStackTrace();
    	}
   } 
}
