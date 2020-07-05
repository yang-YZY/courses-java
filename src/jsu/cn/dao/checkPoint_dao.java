package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class checkPoint_dao. ȡ�ùؿ���Ȩ���Լ���عؿ�����߷���
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class checkPoint_dao {

	/** The driver name. JDBC���� */
	private String driverName;

	/** The uri. mqsql�������� */
	private String uri;

	/** The sql. SQL��� */
	private String sql[];

	/** The database connect. �����ݿ�������� */
	private Connection databaseConnect;

	/** The compile.Ԥ���������� */
	private PreparedStatement compile[];

	/** The result. ����� */
	private ResultSet result[];

	/**
	 * Instantiates a new check point dao. ʵ��������
	 */
	public checkPoint_dao() {
		loadDriver();
		databaseConnect = getConnection();
	}

	/**
	 * Load driver. ��������
	 */
	private void loadDriver() {
		driverName = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets the connection. ȡ������
	 * 
	 * @return �������Ӷ���
	 */
	private Connection getConnection() {
		uri = "jdbc:mysql://localhost:3306/javacx?user=root&password=yangzhiye0527&useUnicode=true&characterEncoding=UTF-8&useSSL=true";
		Connection linShi = null;
		try {
			linShi = DriverManager.getConnection(uri);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linShi;
	}

	/**
	 * Gets the index. ȡ�ø��û�ѡ��ؿ���Ȩ��
	 *
	 * @param nickName �ǳ�
	 * @return ����ѡ��Ĺؿ���
	 */
	public int getIndex(String nickName) {
		int flag = 0;
		sql = new String[2];
		compile = new PreparedStatement[2];
		result = new ResultSet[2];
		sql[0] = "select number from first where nickName=?";
		sql[1] = "select number from second where nickName=?";
		for (int i = 0; i < sql.length; i++) {
			try {
				compile[i] = databaseConnect.prepareStatement(sql[i]);
				compile[i].setString(1, nickName);
				result[i] = compile[i].executeQuery();
				if (!result[i].next()) {
					flag = i;
					break;
				}
				if (i == 1) {
					flag = 2;
					break;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * Gets the number. �õ���߷���
	 * 
	 * @param index �ؿ�ֵ
	 * @return ȡ�ùؿ���߷�������
	 */
	public String[] getNumber(int index) {
		String[] flag = new String[index];
		for (int i = 0; i < index; i++) {
			try {
				flag[i] = result[i].getString(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * Closing. �ر�������Դ
	 */
	public void closing() {
		for (int i = 0; i < result.length; i++) {
			if (result[i] != null) {
				try {
					result[i].close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (compile[i] != null) {
				try {
					compile[i].close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			databaseConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
