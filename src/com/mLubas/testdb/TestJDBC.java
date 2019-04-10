package com.mLubas.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class TestJDBC {

	public static void main (String args[]) {
	
	String user = "hbstudent";
	String pass = "hbstudent";
	String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
	
	try { 

		System.out.println("Connecting to database: " + jdbcUrl);
	Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
	
	System.out.println( " Success!! :) ");
	} catch (Exception ex) {
		ex.printStackTrace();
		
	}
		}
}
