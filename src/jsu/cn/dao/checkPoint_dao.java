package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class checkPoint_dao. 取得关卡的权限以及相关关卡的最高分数
 * 
 * @date 2020-7-5
 * @author YZY
 * @version v1.0
 */
public class checkPoint_dao {

	/** The driver name. JDBC驱动 */
	private String driverName;

	/** The uri. mqsql驱动程序 */
	private String uri;

	/** The sql. SQL语句 */
	private String sql[];

	/** The database connect. 与数据库进行连接 */
	private Connection databaseConnect;

	/** The compile.预编译语句对象 */
	private PreparedStatement compile[];

	/** The result. 结果集 */
	private ResultSet result[];

	/**
	 * Instantiates a new check point dao. 实例化对象
	 */
	public checkPoint_dao() {
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
	 * Gets the index. 取得该用户选择关卡的权限
	 *
	 * @param nickName 昵称
	 * @return 可以选择的关卡数
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
	 * Gets the number. 得到最高分数
	 * 
	 * @param index 关卡值
	 * @return 取得关卡最高分数数组
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
	 * Closing. 关闭所有资源
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
