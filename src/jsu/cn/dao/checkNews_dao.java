package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class checkNews_dao. 查看信息有无
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class checkNews_dao {

	/** The driver name. JDBC驱动 */
	private String driverName;

	/** The uri. mqsql驱动 */
	private String uri;

	/** The sql. SQL语句 */
	private String sql;

	/** The database connect. 与数据库进行连接 */
	private Connection databaseConnect;

	/** The compile. 预编译语句对象 */
	private PreparedStatement compile;

	/** The result. 结果集 */
	private ResultSet result;

	/**
	 * Instantiates a new check news dao. 实例化对象
	 */
	public checkNews_dao() {
		loadDriver();
		databaseConnect = getConnection();
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
	 * Check id. 检查ID是否存在
	 *
	 * @param id 用户账号
	 * @return 返回有无
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
	 * Check nick name. 检查昵称是否存在
	 *
	 * @param nickName 用户昵称
	 * @return 返回有无
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
	 * Check id and password. 检查该账号是否存在
	 * 
	 * @param id         用户账号
	 * @param idPassword 用户密码
	 * @return 返回有无
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
	 * Gets the nn and sex. 得到昵称和性别
	 * 
	 * @return 返回昵称与性别的数组
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
	 * Close all. 关闭所有资源
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
