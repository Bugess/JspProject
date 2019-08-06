package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class jdbc {
	public static final String URL = "jdbc:mysql://localhost:3306/testdata?characterEncoding=UTF-8"; // �����ַ���
	public static final String USERNAME = "root";
	public static final String PWD = "0404094";

	public static void executeSQL() {
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		
		try {
			// 1.����������������
			Class.forName("com.mysql.jdbc.Driver");
			// 2.�����ݿ⽨������
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			// 3.����sql
			String sql = "insert into student values(?,?,?,?);";
			preparedStatement = connection.prepareStatement(sql);
			//statement = connection.createStatement();
			//String sql = "insert into student values(66, 'ë��', 66, 's6');";
			//int count = statement.executeUpdate(sql);
			
			preparedStatement.setInt(1,44);
			preparedStatement.setString(2,"hhhhhh");
			preparedStatement.setInt(3,44);
			preparedStatement.setString(4,"s7");
			
			int count = preparedStatement.executeUpdate();
			// 4.��������
			if (count > 0)
				System.out.println("�ɹ�����");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		//update();
		//String update = "insert into student values(66, 'ë', 1, 's1');";
		//executeSQL(update);
		
		//String del = "delete from student where gname='s5';";
		executeSQL();
	}
}



