package jsu.cn.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jsu.cn.dao.userNews_dao;

// TODO: Auto-generated Javadoc
/**
 * The Class userNewsTest.
 *unit测试类userNews_dao
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class userNewsTest {
 
 /** The und. userNews_dao对象*/
 private userNews_dao und=new userNews_dao();
 
 /**
  * Test insert news.
  * 增加新用户
  */
 @Test
 public void testInsertNews() {
	 String s1="2014";
	 String s2="2014";
	 String s3="2014";
	 String s4="2014";
	 String s5="男";
	 assertEquals(1,und.insertNews(s1, s2, s3, s4, s5));
 }
}
