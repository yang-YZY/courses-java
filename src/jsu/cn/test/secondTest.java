package jsu.cn.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jsu.cn.dao.second_dao;

// TODO: Auto-generated Javadoc
/**
 * The Class secondTest.
 *Junit������second_dao
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class secondTest {
	
	/** The sd. second_dao����*/
	private second_dao sd = new second_dao();
	  
  	/**
  	 * Test yes or no.
  	 * �ж��û��ڶ����Ƿ��м�¼
  	 */
  	@Test
	  public void testYesOrNo() {
		  String nickName = "����";
		  assertEquals(427,sd.yesOrNo(nickName));
	  }
	  
  	/**
  	 * Test insert first.
  	 * ��ڶ��ز������û�����߼�¼
  	 */
  	public void testInsertSecond() {
		  String nickName="����";
		  String number ="80";
		  assertEquals(1,sd.insertSecond(nickName, number));
	  }
	  
  	/**
  	 * Test set first.
  	 * �����û��ڶ��ص���߷���
  	 */
  	public void testSetSecond() {
		  String nickName="����";
		  String number ="80";
		  assertEquals(1,sd.setSecond(number, nickName));
	  }
}
