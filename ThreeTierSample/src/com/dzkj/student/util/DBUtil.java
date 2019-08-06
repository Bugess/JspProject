package com.dzkj.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dzkj.student.entity.Student;

//通用数据库操作方法
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/student?characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "0404094";
	public static Connection connection = null;
	public static PreparedStatement preparedStatement = null;
	public static ResultSet resultSet = null;

	public static boolean executeUpdate(String sql, Object[] objects) {
		try {
			getConnection();
			createPreparedStatement(sql, objects);
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeAll(null, preparedStatement, connection);
		}
	}

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

	// 通用查

	public static ResultSet executeQuery(String sql, Object[] objects) {
		Student student = null;
		
		// 将学生放入集合
		List<Student> students = new ArrayList<>();

		try {
			getConnection();
			createPreparedStatement(sql, objects);
			resultSet = preparedStatement.executeQuery();
			return resultSet;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//查总数
	public static int getTotalCount(String sql) {
		int count = -1;
		try {
			preparedStatement = createPreparedStatement(sql, null);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(resultSet, preparedStatement, connection);
		}
		return count;
	}
	

}
