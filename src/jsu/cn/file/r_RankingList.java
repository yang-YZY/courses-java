package jsu.cn.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class r_RankingList. �����а��ļ��ж�������
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class r_RankingList {

	/** The first F. ��һ�����а��ļ� */
	private File firstF;

	/** The second F. �ڶ������а��ļ� */
	private File secondF;

	/** The br. �����ַ������� */
	private BufferedReader br;

	/** The al first.�������� */
	private ArrayList<String> alFirst;

	/** The al second. �������� */
	private ArrayList<String> alSecond;

	/**
	 * Instantiates a new r ranking list. ʵ��������
	 */
	public r_RankingList() {
		firstF = new File("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\���а�\\��һ�����а�.txt");
		secondF = new File("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\���а�\\�ڶ������а�.txt");
	}

	/**
	 * First is empty. �жϵ�һ�����а��ļ��Ƿ�Ϊ��
	 * 
	 * @return �����
	 */
	public boolean firstIsEmpty() {
		boolean flag = true;
		if (firstF.length() != 0)
			flag = false;
		return flag;
	}

	/**
	 * Second is empty. �жϵڶ������а��ļ��Ƿ�Ϊ��
	 * 
	 * @return �����
	 */
	public boolean secondIsEmpty() {
		boolean flag = true;
		if (secondF.length() != 0)
			flag = false;
		return flag;
	}

	/**
	 * First. ��һ�����а�����
	 * 
	 * @return ��������
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
	 * Second. �ڶ������а�����
	 * 
	 * @return ��������
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