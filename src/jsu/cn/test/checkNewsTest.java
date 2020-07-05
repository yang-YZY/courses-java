package jsu.cn.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jsu.cn.dao.checkNews_dao;

// TODO: Auto-generated Javadoc
/**
 * The Class checkNewsTest.
 *Junit测试类checkNews_dao
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class checkNewsTest {
  
  /** The cnd. checkNews_dao对象*/
  private checkNews_dao cnd = new checkNews_dao();
  
  /**
   * Test check id.
         * 账号
   */
  @Test
  public void testCheckId() {
	  String id="2018401225";
	  assertEquals(true,cnd.checkId(id));
  }
  
  /**
   * Test check nick name.
   * 检查是否存在该昵称
   */
  @Test
  public void testCheckNickName() {
	  String nickName="爱你";
	  assertEquals(true,cnd.checkNickName(nickName));
  }
  
  /**
   * Test check id and password.
   * 检查是否存在该账号
   */
  @Test
  public void testCheckIdAndPassword() {
	  String idPassword ="2018";
	  String id = "2018401225";
	  assertEquals(true,cnd.checkIdAndPassword(id, idPassword));
  }
	
}
