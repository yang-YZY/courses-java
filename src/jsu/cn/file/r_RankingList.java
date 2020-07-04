package jsu.cn.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class r_RankingList {
private File firstF;
private File secondF;
private BufferedReader br;
private ArrayList<String> alFirst;
private ArrayList<String> alSecond;

public r_RankingList() {
	firstF = new File("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\排行榜\\第一关排行榜.txt");
	secondF = new File("C:\\Users\\ASUS\\Desktop\\java课程设计\\java课程设计素材\\排行榜\\第二关排行榜.txt");
}
public boolean firstIsEmpty() {
	boolean flag = true;
	if(firstF.length()!=0)
		flag = false;
	return flag;
}
public boolean secondIsEmpty() {
	boolean flag = true;
	if(secondF.length()!=0)
		flag = false;
	return flag;
}
public String [] first() {
	alFirst = new ArrayList<>();
	String flag;
	try {
		br = new BufferedReader(new FileReader(firstF));
		while((flag=br.readLine())!=null) {
			alFirst.add(flag);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	finally {
		if(br!=null) {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	String flag1[]=new String[alFirst.size()];
	return alFirst.toArray(flag1);
}
public String[] second() {
	alSecond = new ArrayList<>();
	String flag;
	try {
		br = new BufferedReader(new FileReader(secondF));
		while((flag=br.readLine())!=null) {
			alSecond.add(flag);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	finally {
		if(br!=null) {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	String flag1[]=new String[alSecond.size()];
	return alSecond.toArray(flag1);
}

}