package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class first_dao. ��һ��ÿ���˵� ��߷ּ�¼��
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class first_dao {

	/** The driver name. JDBC���� */
	private String driverName;

	/** The uri. mqsql���� */
	private String uri;

	/** The sql.SQL��� */
	private String sql;

	/** The database connect. �����ݿ�������� */
	private Connection databaseConnect;

	/** The compile. Ԥ���������� */
	private PreparedStatement compile;

	/** The result. ����� */
	private ResultSet result;

	/**
	 * Instantiates a new first dao. ʵ��������
	 */
	public first_dao() {
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
	 * Yes or no. �ж��û���һ���Ƿ��м�¼
	 * 
	 * @param nickName �û��ǳ�
	 * @return ����ֵ
	 */
	public int yesOrNo(String nickName) {
		int flag = 0;
		sql = "select number from first where nickName=?";
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
	 * Insert first. ���һ�ز������û�����߼�¼
	 * 
	 * @param nickName �ǳ�
	 * @param number   ����
	 * @return ���ڲ���junit����
	 */
	public int insertFirst(String nickName, String number) {
		sql = "insert into first values(?,?)";
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
	 * Sets the first. �����û���һ�ص���߷���
	 * 
	 * @param number   ����
	 * @param nickName �û��ǳ�
	 * @return ���ڲ���junit����
	 */
	public int setFirst(String number, String nickName) {
		sql = "update first set number=? where nickName=?";
		int a = 0;
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, number);
			compile.setString(2, nickName);
			a = compile.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * Delete first. ɾ���û���һ�ص���߼�¼
	 * 
	 * @param nickName �û��ǳ�
	 */
	public void deleteFirst(String nickName) {
		sql = "delete from first where nickName=?";
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
