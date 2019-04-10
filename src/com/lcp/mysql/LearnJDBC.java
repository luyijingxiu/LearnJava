package com.lcp.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class LearnJDBC {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("数据库驱动后加载成功");
			Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.20.112:3306/robot?characterEncoding=UTF-8","root","123456");
			Statement statement=(Statement) connection.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
