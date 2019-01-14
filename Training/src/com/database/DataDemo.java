package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataDemo {
public static void main(String []cp) {
	String DB_CONN_STRING = "jdbc:oracle:thin:@localhost:1521:ORCL2";
	//Provided by your driver documentation. In this case, a MySql driver is used : 
	String DRIVER_CLASS_NAME = "oracle.jdbc.OracleDriver";
	String USER_NAME = "java_train";
	String PASSWORD =  "java_train";
	Connection conn = null;
	PreparedStatement stmt = null;
	StringBuilder sql = new StringBuilder();
	
	sql.append("insert into ").append("country")
		.append("(").append("state_id")
		.append(", ").append("state_name")
		.append(", ").append("capital");
	sql.append(") ");
	sql.append("values (?, ?, ?)");
	
	
	
	try {
		Class.forName(DRIVER_CLASS_NAME).newInstance();
		conn = DriverManager.getConnection(DB_CONN_STRING, USER_NAME, PASSWORD);
		stmt = conn.prepareStatement(sql.toString());
		conn.setAutoCommit(false);
		stmt.clearBatch();
		stmt.clearParameters();
		int count = 0;
		int limit = 7;
		for(long i=0;i<20;i++) {
		count++;
		stmt.setLong(1, i);
		stmt.setString(2, i+" AA");
		stmt.setString(3, i+" BB");
		stmt.addBatch();
		if(count ==limit ) {
			System.out.println("Commiting in batch");
			stmt.executeBatch();
			conn.commit();
			count = 0;
			stmt.clearBatch();
			stmt.clearParameters();

		}
		}
		if(count < limit) {
			System.out.println("Remaining cleared");
			stmt.executeBatch();
			conn.commit();
			stmt.clearBatch();
			stmt.clearParameters();
		}
		conn.close();
	}
	catch (SQLException e){
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

}
