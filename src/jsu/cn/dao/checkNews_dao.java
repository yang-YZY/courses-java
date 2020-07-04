package jsu.cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkNews_dao {
	private String driverName;
	private String uri;
	private String sql;
	private Connection databaseConnect;
	private PreparedStatement compile;
    private ResultSet result;
    
    public checkNews_dao(int a) {
    	loadDriver();
    	databaseConnect= getConnection();
    	if(a==1)
    		compile= getPreparedStatement();
    	else if(a==2) 
    		compile= getPreparedStatement1();
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
    	 sql="select * from user where id=?";
    	 try {
    		linShi =  databaseConnect.prepareStatement(sql);
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	 return linShi;
    }
    private PreparedStatement getPreparedStatement1() {
    	 PreparedStatement linShi = null;
    	 sql="select id,idPassword,nickName,sex from user where id=? and idPassword=?";
    	 try {
     		linShi =  databaseConnect.prepareStatement(sql);
     	} catch (SQLException e) {
     		// TODO Auto-generated catch block
     		e.printStackTrace();
     	}
     	 return linShi;
    }
    public boolean checkId(String id) {
    	boolean flag = false;
    	try {
			compile.setString(1, id);
			result=compile.executeQuery();
			if(result.next())
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return flag;
    }
    public boolean checkNickName(String nickName) {
    	boolean flag = false;
    	String sql = "select * from user where nickName=?";
    	try {
			compile = databaseConnect.prepareStatement(sql);
			compile.setString(1, nickName);
			result = compile.executeQuery();
			if(result.next())
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return flag;
    }
    public boolean checkIdAndPassword(String id,String idPassword) {
    	boolean flag=false;
    	try {
			compile.setString(1, id);
			compile.setString(2, idPassword);
			result = compile.executeQuery();
			if(result.next())
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return flag;
    }
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
    public void closeAll() {
    		try {
    			if(result!=null)
				result.close();
    			databaseConnect.close();
    			compile.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}
