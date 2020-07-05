package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class userNews_dao. 用户信息类
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class userNews_dao {

	/** The driver name. JDBC驱动 */
	private String driverName;

	/** The uri. mqsql驱动 */
	private String uri;

	/** The sql. SQL语句 */
	private String sql;

	/** The database connect. 与数据库进行连接 */
	private Connection databaseConnect;

	/** The compile.预编译语句对象 */
	private PreparedStatement compile;

	/**
	 * Instantiates a new user news dao. 实例化对象
	 */
	public userNews_dao() {
		loadDriver();
		databaseConnect = getConnection();
		compile = getPreparedStatement();
	}

	/**
	 * Load driver. 加载驱动
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
	 * Gets the connection. 取得连接
	 * 
	 * @return 返回连接对象
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
	 * Gets the prepared statement. 取得预编译语句对象
	 * 
	 * @return 返回预编译语句对象
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
	 * Insert news. 增加用户
	 * 
	 * @param id         账号
	 * @param idPassword 密码
	 * @param userName   姓名
	 * @param nickName   昵称
	 * @param sex        性别
	 * @return 用于测试junit测试
	 */
	public int insertNews(String id, String idPassword, String userName, String nickName, String sex) {
		int a = 0;
		try {
			compile.setString(1, id);
			compile.setString(2, idPassword);
			compile.setString(3, userName);
			compile.setString(4, nickName);
			if ("男".equals(sex))
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
	 * Delete user. 删除用户
	 * 
	 * @param nickName 脑残
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
	 * Close all. 关闭所有资源
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
