package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class second_dao. 第二关每个人的 最高分记录类
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class second_dao {

	/** The driver name. JDBC驱动 */
	private String driverName;

	/** The uri. mqsql驱动 */
	private String uri;

	/** The sql. SQL语句 */
	private String sql;

	/** The database connect.与数据库进行连接 */
	private Connection databaseConnect;

	/** The compile. 预编译语句对象 */
	private PreparedStatement compile;

	/** The result. 结果集 */
	private ResultSet result;

	/**
	 * Instantiates a new second dao. 实例化对象
	 */
	public second_dao() {
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
	 * Yes or no. 判断用户第二关是否有记录
	 * 
	 * @param nickName 用户昵称
	 * @return 区分值
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
	 * Insert second. 向第二关插入新用户的最高记录
	 * 
	 * @param nickName 昵称
	 * @param number   分数
	 * @return 用于测试junit测试
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
	 * Sets the second. 更新用户第二关的最高分数
	 * 
	 * @param number   分数
	 * @param nickName 用户昵称
	 * @return 用于测试junit测试
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
	 * Delete second. 删除用户第二关的最高记录
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
	 * Closing. 关闭所有资源
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
