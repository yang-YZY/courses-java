package jsu.cn.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class w_RankingList.
 *  �����а��ļ�д����
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class w_RankingList {
	
	/** The first F.  ��һ�����а��ļ�*/
	private File firstF;
	
	/** The second F.  �ڶ������а��ļ�*/
	private File secondF;
	
	/** The bw. �����ַ������*/
	private BufferedWriter bw;
	
	/**
	 * Instantiates a new w ranking list.
	 * ʵ��������
	 */
	public w_RankingList() {
		firstF = new File("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\���а�\\��һ�����а�.txt");
		secondF = new File("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\���а�\\�ڶ������а�.txt");
	}
	
	/**
	 * W first.
	 *  ���һ�����а�����д������
	 * @param all д�����������
	 * @param length д��ĳ���
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
	 *��ڶ������а�����д������
	 * @param all д�����������
	 * @param length д��ĳ���
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
