package jsu.cn.tool;

// TODO: Auto-generated Javadoc
/**
 * The Class checkRegister.
 *     �õ����ٸ���ϢΪ�յĹ�����
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class checkRegister {
  
  /**
   * Check string.
        *�����Ϣ�����Ƿ�����
   * @param arry ��Ϣ����
   * @return ȱ�����ݵĸ���
   */
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
