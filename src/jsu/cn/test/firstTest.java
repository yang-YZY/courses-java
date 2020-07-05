package jsu.cn.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jsu.cn.dao.first_dao;

// TODO: Auto-generated Javadoc
/**
 * The Class firstTest.
 *Junit测试类first_dao
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class firstTest {
  
  /** The fd. first_dao对象*/
  private first_dao fd = new first_dao();
  
  /**
   * Test yes or no.
   * 判断用户第一关是否有记录
   */
  @Test
  public void testYesOrNo() {
	  String nickName = "爱你";
	  assertEquals(21,fd.yesOrNo(nickName));
  }
  
  /**
   * Test insert first.
   * 向第一关插入新用户的最高记录
   */
  public void testInsertFirst() {
	  String nickName="爱爱";
	  String number ="80";
	  assertEquals(1,fd.insertFirst(nickName, number));
  }
  
  /**
   * Test set first.
   * 更新用户第一关的最高分数
   */
  public void testSetFirst() {
	  String nickName="爱你";
	  String number ="80";
	  assertEquals(1,fd.setFirst(number, nickName));
  }
}
