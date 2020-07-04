package jsu.cn.tool;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class playMusic extends Thread{
    Player player;
    String music;
    public playMusic(String file) {
        this.music = file;
    }
     public void run() {
    	 while(true) { 
            play();
                }
     }
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
