package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class checkNews_dao. �鿴��Ϣ����
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class checkNews_dao {

	/** The driver name. JDBC���� */
	private String driverName;

	/** The uri. mqsql���� */
	private String uri;

	/** The sql. SQL��� */
	private String sql;

	/** The database connect. �����ݿ�������� */
	private Connection databaseConnect;

	/** The compile. Ԥ���������� */
	private PreparedStatement compile;

	/** The result. ����� */
	private ResultSet result;

	/**
	 * Instantiates a new check news dao. ʵ��������
	 */
	public checkNews_dao() {
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
	 * Check id. ���ID�Ƿ����
	 *
	 * @param id �û��˺�
	 * @return ��������
	 */
	public boolean checkId(String id) {
		boolean flag = false;
		sql = "select * from user where id=?";
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, id);
			result = compile.executeQuery();
			if (result.next())
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Check nick name. ����ǳ��Ƿ����
	 *
	 * @param nickName �û��ǳ�
	 * @return ��������
	 */
	public boolean checkNickName(String nickName) {
		boolean flag = false;
		String sql = "select * from user where nickName=?";
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, nickName);
			result = compile.executeQuery();
			if (result.next())
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Check id and password. �����˺��Ƿ����
	 * 
	 * @param id         �û��˺�
	 * @param idPassword �û�����
	 * @return ��������
	 */
	public boolean checkIdAndPassword(String id, String idPassword) {
		boolean flag = false;
		sql = "select id,idPassword,nickName,sex from user where id=? and idPassword=?";
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, id);
			compile.setString(2, idPassword);
			result = compile.executeQuery();
			if (result.next())
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Gets the nn and sex. �õ��ǳƺ��Ա�
	 * 
	 * @return �����ǳ����Ա������
	 */
	public String[] getNnAndSex() {
		String[] flag = new String[2];
		try {
			flag[0] = result.getString(3);
			flag[1] = result.getString(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Close all. �ر�������Դ
	 */
	public void closeAll() {
		try {
			if (result != null)
				result.close();
			if (compile != null)
				compile.close();
			databaseConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
