package com.dzkj.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/student?characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "0404094";
	public static Connection connection = null;
	public static PreparedStatement preparedStatement = null;
	public static ResultSet resultSet = null;

	// 获取链接
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		return connection = DriverManager.getConnection(URL, USER, PASSWORD);
	}

	// 获取PreparedStatement
		public static PreparedStatement createPreparedStatement(String sql, Object[] objects) throws SQLException {
			preparedStatement = connection.prepareStatement(sql);
			// 问号个数和数组个数一致,数组第零个对应一
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					preparedStatement.setObject(i + 1, objects[i]);
				}
			}

			return preparedStatement;
		}
		
		// 通用关闭
		public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
