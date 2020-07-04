package jsu.cn.backGround;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackGround_JPanel extends JPanel {
 private Image backGround;
 public BackGround_JPanel(String uri){
	 ImageIcon i= new ImageIcon(uri);
	 backGround = i.getImage();
 }
 @Override
	protected void paintComponent(Graphics g) {
		g.drawImage(backGround, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
