package jsu.cn.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class w_RankingList {
	private File firstF;
	private File secondF;
	private BufferedWriter bw;
	
	public w_RankingList() {
		firstF = new File("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\排行榜\\第一关排行榜.txt");
		secondF = new File("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\排行榜\\第二关排行榜.txt");
	}
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
