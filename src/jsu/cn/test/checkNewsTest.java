package jsu.cn.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jsu.cn.dao.checkNews_dao;

// TODO: Auto-generated Javadoc
/**
 * The Class checkNewsTest.
 *Junit������checkNews_dao
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class checkNewsTest {
  
  /** The cnd. checkNews_dao����*/
  private checkNews_dao cnd = new checkNews_dao();
  
  /**
   * Test check id.
         * �˺�
   */
  @Test
  public void testCheckId() {
	  String id="2018401225";
	  assertEquals(true,cnd.checkId(id));
  }
  
  /**
   * Test check nick name.
   * ����Ƿ���ڸ��ǳ�
   */
  @Test
  public void testCheckNickName() {
	  String nickName="����";
	  assertEquals(true,cnd.checkNickName(nickName));
  }
  
  /**
   * Test check id and password.
   * ����Ƿ���ڸ��˺�
   */
  @Test
  public void testCheckIdAndPassword() {
	  String idPassword ="2018";
	  String id = "2018401225";
	  assertEquals(true,cnd.checkIdAndPassword(id, idPassword));
  }
	
}
