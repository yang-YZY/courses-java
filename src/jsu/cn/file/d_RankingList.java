package jsu.cn.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class d_RankingList. 删除用户全部排行榜记录
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class d_RankingList {

	/** The first F. 第一关排行榜文件 */
	private File firstF;

	/** The second F.第二关排行榜文件 */
	private File secondF;

	/** The br. 缓冲字符输入流 */
	private BufferedReader br;

	/** The bw. 缓冲字符输出流 */
	private BufferedWriter bw;

	/** The al first. 辅助集合 */
	private ArrayList<String> alFirst;

	/** The al second. 辅助集合 */
	private ArrayList<String> alSecond;

	/**
	 * Instantiates a new d ranking list. 实例化对象
	 */
	public d_RankingList() {
		firstF = new File("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\排行榜\\第一关排行榜.txt");
		secondF = new File("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\排行榜\\第二关排行榜.txt");
	}

	/**
	 * Delete. 删除用户所有游戏排行榜记录
	 * 
	 * @param nickName 昵称
	 */
	public void delete(String nickName) {
		String flag;
		String spilt[];
		alFirst = new ArrayList<>();
		alSecond = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(firstF));
			while ((flag = br.readLine()) != null) {
				alFirst.add(flag);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < alFirst.size(); i++) {
			flag = alFirst.get(i);
			spilt = flag.split("-");
			if (spilt[0].equals(nickName)) {
				alFirst.remove(i);
				i--;
			}
		}
		try {
			bw = new BufferedWriter(new FileWriter(firstF));
			for (String s : alFirst) {
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closing();
		try {
			br = new BufferedReader(new FileReader(secondF));
			while ((flag = br.readLine()) != null) {
				alSecond.add(flag);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < alSecond.size(); i++) {
			flag = alSecond.get(i);
			spilt = flag.split("-");
			if (spilt[0].equals(nickName)) {
				alSecond.remove(i);
				i--;
			}
		}
		try {
			bw = new BufferedWriter(new FileWriter(secondF));
			for (String s : alSecond) {
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closing();
	}

	/**
	 * Closing. 关闭所有资源
	 */
	private void closing() {
		if (bw != null) {
			try {
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (br != null) {
			try {
				br.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
