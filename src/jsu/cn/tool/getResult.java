package jsu.cn.tool;

// TODO: Auto-generated Javadoc
/**
 * The Class getResult.
 *    �õ���ϷΪ�ķ�Ӯ�Ĺ�����
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class getResult {
 
 /** The flag. ��Ӯ�������*/
 public static int flag[][]= {
		 {2,3,1},
		 {1,2,3},
		 {3,1,2}
 };
 
 /**
  * Gets the rl.
  * �õ����ֵ
  * @param a ��
  * @param b �ҷ�
  * @return ���ֵ
  */
 public static int getRL(int a,int b) {
	 return flag[a][b];
 }
}
