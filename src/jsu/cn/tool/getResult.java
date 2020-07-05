package jsu.cn.tool;

// TODO: Auto-generated Javadoc
/**
 * The Class getResult.
 *    得到游戏为哪方赢的工具类
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class getResult {
 
 /** The flag. 输赢结果数组*/
 public static int flag[][]= {
		 {2,3,1},
		 {1,2,3},
		 {3,1,2}
 };
 
 /**
  * Gets the rl.
  * 得到标记值
  * @param a 左方
  * @param b 右方
  * @return 标记值
  */
 public static int getRL(int a,int b) {
	 return flag[a][b];
 }
}
