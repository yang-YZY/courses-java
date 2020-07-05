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
 * The Class d_RankingList. ɾ���û�ȫ�����а��¼
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class d_RankingList {

	/** The first F. ��һ�����а��ļ� */
	private File firstF;

	/** The second F.�ڶ������а��ļ� */
	private File secondF;

	/** The br. �����ַ������� */
	private BufferedReader br;

	/** The bw. �����ַ������ */
	private BufferedWriter bw;

	/** The al first. �������� */
	private ArrayList<String> alFirst;

	/** The al second. �������� */
	private ArrayList<String> alSecond;

	/**
	 * Instantiates a new d ranking list. ʵ��������
	 */
	public d_RankingList() {
		firstF = new File("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\���а�\\��һ�����а�.txt");
		secondF = new File("C:\\Users\\ASUS\\Desktop\\java�γ����\\java�γ�����ز�\\���а�\\�ڶ������а�.txt");
	}

	/**
	 * Delete. ɾ���û�������Ϸ���а��¼
	 * 
	 * @param nickName �ǳ�
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
	 * Closing. �ر�������Դ
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
