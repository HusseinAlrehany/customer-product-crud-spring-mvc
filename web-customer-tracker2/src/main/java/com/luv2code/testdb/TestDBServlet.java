package com.luv2code.testdb;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDBServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException {
		
		String user="springstudent";
		
		String pass="springstudent";
		
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		
		
		String driver="com.mysql.cj.jdbc.Driver";
		
		
		try {
			
			
			PrintWriter writer=response.getWriter();
			
			writer.println("Connecting to data base " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection connection=DriverManager.getConnection(jdbcUrl,user,pass);
			
			writer.println("SUCCESSS!");
			
			connection.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
			throw new ServletException(ex);
			
		}
		
		
	}

}
