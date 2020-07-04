package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userNews_dao {
private String driverName;
private String uri;
private String sql;
private Connection databaseConnect;
private PreparedStatement compile;

public userNews_dao() {
	loadDriver();
	databaseConnect=getConnection();
	compile=getPreparedStatement();
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
private PreparedStatement getPreparedStatement() {
	 PreparedStatement linShi = null;
	 sql="insert into user values(?,?,?,?,?)";
	 try {
		linShi =  databaseConnect.prepareStatement(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return linShi;
}
public void insertNews(String id,String idPassword,String userName,String nickName,String sex ) {
	try {
		compile.setString(1, id);
		compile.setString(2, idPassword);
		compile.setString(3, userName);
		compile.setString(4, nickName);
			if("ÄÐ".equals(sex))
				compile.setString(5, "1");
			else 
				compile.setString(5, "0");
		compile.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
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
