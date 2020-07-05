package jsu.cn.tool;

// TODO: Auto-generated Javadoc
/**
 * The Class checkRegister.
 *     得到多少个信息为空的工具类
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class checkRegister {
  
  /**
   * Check string.
        *检测信息填入是否完整
   * @param arry 信息数组
   * @return 缺少数据的个数
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
