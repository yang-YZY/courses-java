package jsu.cn.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jsu.cn.dao.checkPoint_dao;

// TODO: Auto-generated Javadoc
/**
 * The Class checkPointTest.
 *Junit������heckPoint_dao
 * @date 2020-7-5
 * @author YZY
 * @version  v1.0
 */
public class checkPointTest {
   
	/** The cpd. heckPoint_dao����*/
	private checkPoint_dao cpd = new checkPoint_dao();
	
	/**
	 * Test get index.
	 * ȡ�ùؿ���߷�������
	 */
	@Test
	public void testGetIndex() {
		String nickName="����";
		 assertEquals(2, cpd.getIndex(nickName));
	}
	
}
