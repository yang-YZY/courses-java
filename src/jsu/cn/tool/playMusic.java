package jsu.cn.tool;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class playMusic.
 *����������
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class playMusic extends Thread{
    
    /** The player.������ */
    Player player;
    
    /** The music. �����ļ�·��*/
    String music;
    
    /**
     * Instantiates a new play music.
             *ʵ��������
     * @param  file �����ļ�·�� 
     */
    public playMusic(String file) {
        this.music = file;
    }
     
     
         /* (�� Javadoc)
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
               * ��������
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
