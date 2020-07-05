package jsu.cn.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class w_RankingList.
 *  向排行榜文件写数据
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class w_RankingList {
	
	/** The first F.  第一关排行榜文件*/
	private File firstF;
	
	/** The second F.  第二关排行榜文件*/
	private File secondF;
	
	/** The bw. 缓冲字符输出流*/
	private BufferedWriter bw;
	
	/**
	 * Instantiates a new w ranking list.
	 * 实例化对象
	 */
	public w_RankingList() {
		firstF = new File("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\排行榜\\第一关排行榜.txt");
		secondF = new File("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\排行榜\\第二关排行榜.txt");
	}
	
	/**
	 * W first.
	 *  向第一关排行榜重新写入数据
	 * @param all 写入的数据数组
	 * @param length 写入的长度
	 */
	public void wFirst(String all[],int length) {
		try {
			bw = new BufferedWriter(new FileWriter(firstF));
			if(length<10 && length>0) {
				for(int i=0;i<=length;i++) {
					bw.write(all[i]);
					bw.newLine();
					bw.flush();
				}
			}
			else if(length==10) {
				for(int i=0;i<10;i++) {
					bw.write(all[i]);
					bw.newLine();
					bw.flush();
				}
			}
			else {
				bw.write(all[0]);
				bw.newLine();
				bw.flush();
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bw!=null) {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	/**
	 * W second.
	 *向第二关排行榜重新写入数据
	 * @param all 写入的数据数组
	 * @param length 写入的长度
	 */
	public void wSecond(String all[],int length) {
		try {
			bw = new BufferedWriter(new FileWriter(secondF));
			if(length<10 && length>0) {
				for(int i=0;i<=length;i++) {
					bw.write(all[i]);
					bw.newLine();
					bw.flush();
				}
			}
			else if(length==10) {
				for(int i=0;i<10;i++) {
					bw.write(all[i]);
					bw.newLine();
					bw.flush();
				}
			}
			else {
				bw.write(all[0]);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bw!=null) {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
