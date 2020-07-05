package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class second_dao. �ڶ���ÿ���˵� ��߷ּ�¼��
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class second_dao {

	/** The driver name. JDBC���� */
	private String driverName;

	/** The uri. mqsql���� */
	private String uri;

	/** The sql. SQL��� */
	private String sql;

	/** The database connect.�����ݿ�������� */
	private Connection databaseConnect;

	/** The compile. Ԥ���������� */
	private PreparedStatement compile;

	/** The result. ����� */
	private ResultSet result;

	/**
	 * Instantiates a new second dao. ʵ��������
	 */
	public second_dao() {
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
	 * Yes or no. �ж��û��ڶ����Ƿ��м�¼
	 * 
	 * @param nickName �û��ǳ�
	 * @return ����ֵ
	 */
	public int yesOrNo(String nickName) {
		int flag = 0;
		sql = "select number from second where nickName=?";
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, nickName);
			result = compile.executeQuery();
			if (result.next()) {
				flag = Integer.parseInt(result.getString(1)) + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Insert second. ��ڶ��ز������û�����߼�¼
	 * 
	 * @param nickName �ǳ�
	 * @param number   ����
	 * @return ���ڲ���junit����
	 */
	public int insertSecond(String nickName, String number) {
		sql = "insert into second values(?,?)";
		int a = 0;
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, nickName);
			compile.setString(2, number);
			a = compile.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * Sets the second. �����û��ڶ��ص���߷���
	 * 
	 * @param number   ����
	 * @param nickName �û��ǳ�
	 * @return ���ڲ���junit����
	 */
	public int setSecond(String number, String nickName) {
		sql = "update second set number=? where nickName=?";
		int a = 0;
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, number);
			compile.setString(2, nickName);
			compile.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * Delete second. ɾ���û��ڶ��ص���߼�¼
	 * 
	 * @param nickName the nick name
	 */
	public void deleteSecond(String nickName) {
		sql = "delete from second where nickName=?";
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, nickName);
			compile.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Closing. �ر�������Դ
	 */
	public void closing() {
		try {
			if (result != null)
				result.close();
			if (compile != null)
				compile.close();
			databaseConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
