package jsu.cn.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class r_RankingList. 从排行榜文件中读出数据
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class r_RankingList {

	/** The first F. 第一关排行榜文件 */
	private File firstF;

	/** The second F. 第二关排行榜文件 */
	private File secondF;

	/** The br. 缓冲字符输入流 */
	private BufferedReader br;

	/** The al first.辅助集合 */
	private ArrayList<String> alFirst;

	/** The al second. 辅助集合 */
	private ArrayList<String> alSecond;

	/**
	 * Instantiates a new r ranking list. 实例化对象
	 */
	public r_RankingList() {
		firstF = new File("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\排行榜\\第一关排行榜.txt");
		secondF = new File("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\排行榜\\第二关排行榜.txt");
	}

	/**
	 * First is empty. 判断第一关排行榜文件是否为空
	 * 
	 * @return 是与否
	 */
	public boolean firstIsEmpty() {
		boolean flag = true;
		if (firstF.length() != 0)
			flag = false;
		return flag;
	}

	/**
	 * Second is empty. 判断第二关排行榜文件是否为空
	 * 
	 * @return 是与否
	 */
	public boolean secondIsEmpty() {
		boolean flag = true;
		if (secondF.length() != 0)
			flag = false;
		return flag;
	}

	/**
	 * First. 第一关排行榜数据
	 * 
	 * @return 数据数组
	 */
	public String[] first() {
		alFirst = new ArrayList<>();
		String flag;
		try {
			br = new BufferedReader(new FileReader(firstF));
			while ((flag = br.readLine()) != null) {
				alFirst.add(flag);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		String flag1[] = new String[alFirst.size()];
		return alFirst.toArray(flag1);
	}

	/**
	 * Second. 第二关排行榜数据
	 * 
	 * @return 数据数组
	 */
	public String[] second() {
		alSecond = new ArrayList<>();
		String flag;
		try {
			br = new BufferedReader(new FileReader(secondF));
			while ((flag = br.readLine()) != null) {
				alSecond.add(flag);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		String flag1[] = new String[alSecond.size()];
		return alSecond.toArray(flag1);
	}

}