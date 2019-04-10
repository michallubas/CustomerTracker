package com.mLubas.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDbServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// setup connection variables
		String user = "hbstudent";
		String pass = "hbstudent";
		
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		// load driver
		String driver="com.mysql.jdbc.Driver";
		
		// get connection
		
		try {
			PrintWriter out = response.getWriter();
			out.println("Connection to data base: "+ jdbcUrl);
			
			// load db driver
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println();
			out.println("SUCCESS");
			myConn.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			// and throw on browser exceptions
			throw new ServletException(ex);
			
		}
		
		
		
	}

}
