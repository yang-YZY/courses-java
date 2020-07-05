package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class userNews_dao. �û���Ϣ��
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class userNews_dao {

	/** The driver name. JDBC���� */
	private String driverName;

	/** The uri. mqsql���� */
	private String uri;

	/** The sql. SQL��� */
	private String sql;

	/** The database connect. �����ݿ�������� */
	private Connection databaseConnect;

	/** The compile.Ԥ���������� */
	private PreparedStatement compile;

	/**
	 * Instantiates a new user news dao. ʵ��������
	 */
	public userNews_dao() {
		loadDriver();
		databaseConnect = getConnection();
		compile = getPreparedStatement();
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
	 * Gets the prepared statement. ȡ��Ԥ����������
	 * 
	 * @return ����Ԥ����������
	 */
	private PreparedStatement getPreparedStatement() {
		PreparedStatement linShi = null;
		sql = "insert into user values(?,?,?,?,?)";
		try {
			linShi = databaseConnect.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linShi;
	}

	/**
	 * Insert news. �����û�
	 * 
	 * @param id         �˺�
	 * @param idPassword ����
	 * @param userName   ����
	 * @param nickName   �ǳ�
	 * @param sex        �Ա�
	 * @return ���ڲ���junit����
	 */
	public int insertNews(String id, String idPassword, String userName, String nickName, String sex) {
		int a = 0;
		try {
			compile.setString(1, id);
			compile.setString(2, idPassword);
			compile.setString(3, userName);
			compile.setString(4, nickName);
			if ("��".equals(sex))
				compile.setString(5, "1");
			else
				compile.setString(5, "0");
			a = compile.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * Delete user. ɾ���û�
	 * 
	 * @param nickName �Բ�
	 */
	public void deleteUser(String nickName) {
		sql = "delete from user where nickName=?";
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, nickName);
			compile.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Close all. �ر�������Դ
	 */
	public void closeAll() {
		try {
			databaseConnect.close();
			compile.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
