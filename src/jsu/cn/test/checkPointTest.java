package jsu.cn.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jsu.cn.dao.checkPoint_dao;

// TODO: Auto-generated Javadoc
/**
 * The Class checkPointTest.
 *Junit测试类heckPoint_dao
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class checkPointTest {
   
	/** The cpd. heckPoint_dao对象*/
	private checkPoint_dao cpd = new checkPoint_dao();
	
	/**
	 * Test get index.
	 * 取得关卡最高分数数组
	 */
	@Test
	public void testGetIndex() {
		String nickName="爱你";
		 assertEquals(2, cpd.getIndex(nickName));
	}
	
}
