package jsu.cn.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jsu.cn.dao.first_dao;

// TODO: Auto-generated Javadoc
/**
 * The Class firstTest.
 *Junit������first_dao
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class firstTest {
  
  /** The fd. first_dao����*/
  private first_dao fd = new first_dao();
  
  /**
   * Test yes or no.
   * �ж��û���һ���Ƿ��м�¼
   */
  @Test
  public void testYesOrNo() {
	  String nickName = "����";
	  assertEquals(21,fd.yesOrNo(nickName));
  }
  
  /**
   * Test insert first.
   * ���һ�ز������û�����߼�¼
   */
  public void testInsertFirst() {
	  String nickName="����";
	  String number ="80";
	  assertEquals(1,fd.insertFirst(nickName, number));
  }
  
  /**
   * Test set first.
   * �����û���һ�ص���߷���
   */
  public void testSetFirst() {
	  String nickName="����";
	  String number ="80";
	  assertEquals(1,fd.setFirst(number, nickName));
  }
}
