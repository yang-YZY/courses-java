package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class first {
	private String driverName;
	private String uri;
	private String sql;
	private Connection databaseConnect;
	private PreparedStatement compile;
	private ResultSet result;
	
	public first() {
		loadDriver();
		databaseConnect=getConnection();
	}
	private void loadDriver() {
		driverName="com.mysql.jdbc.Driver";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Connection getConnection() {
		uri="jdbc:mysql://localhost:3306/javacx?user=root&password=yangzhiye0527&useUnicode=true&characterEncoding=UTF-8&useSSL=true";
		Connection linShi = null;
		try {
			linShi = DriverManager.getConnection(uri);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return linShi;
	}
	public int yesOrNo(String nickName) {
		int flag=0;
		sql ="select number from first where nickName=?";
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, nickName);
			result = compile.executeQuery();
			if(result.next()) {
				flag =Integer.parseInt(result.getString(1))+1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public void insertFirst(String nickName,String number) {
		sql = "insert into first values(?,?)";
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, nickName);
			compile.setString(2, number);
			compile.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setFirst(String number,String nickName) {
		sql = "update first set number=? where nickName=?";
		try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, number);
			compile.setString(2, nickName);
			compile.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closing() {
		try {
			if(result!=null)
				result.close();
			if(compile!=null)
				compile.close();
			databaseConnect.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
