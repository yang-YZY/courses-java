package jsu.cn.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jsu.cn.dao.second_dao;

// TODO: Auto-generated Javadoc
/**
 * The Class secondTest.
 *Junit测试类second_dao
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class secondTest {
	
	/** The sd. second_dao对象*/
	private second_dao sd = new second_dao();
	  
  	/**
  	 * Test yes or no.
  	 * 判断用户第二关是否有记录
  	 */
  	@Test
	  public void testYesOrNo() {
		  String nickName = "爱你";
		  assertEquals(427,sd.yesOrNo(nickName));
	  }
	  
  	/**
  	 * Test insert first.
  	 * 向第二关插入新用户的最高记录
  	 */
  	public void testInsertSecond() {
		  String nickName="爱爱";
		  String number ="80";
		  assertEquals(1,sd.insertSecond(nickName, number));
	  }
	  
  	/**
  	 * Test set first.
  	 * 更新用户第二关的最高分数
  	 */
  	public void testSetSecond() {
		  String nickName="爱你";
		  String number ="80";
		  assertEquals(1,sd.setSecond(number, nickName));
	  }
}
