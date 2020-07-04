package jsu.cn.tool;

import javax.swing.JOptionPane;

import jsu.cn.user.user_Register;

public class checkRegister {
  public static int checkString(String ...arry) {
	  int a=0;
	  for(int i=0;i<arry.length;i++) {
		  if("".equals(arry[i])) {
			 a++;
		  }
	  }
	  return a;
  }
}
