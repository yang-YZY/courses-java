package jsu.cn.backGround;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class BackGround_JPanel. ����ͼƬ��
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class BackGround_JPanel extends JPanel {

	/** The back ground. ͼƬ���� */
	private Image backGround;

	/**
	 * Instantiates a new back ground J panel. ʵ��������
	 *
	 * @param uri ����ͼƬ·��
	 */
	public BackGround_JPanel(String uri) {
		ImageIcon i = new ImageIcon(uri);
		backGround = i.getImage();
	}

	/*
	 * (�� Javadoc)
	 * 
	 * 
	 * @param g
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(backGround, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
