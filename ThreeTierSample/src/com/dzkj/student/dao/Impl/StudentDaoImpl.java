package com.dzkj.student.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dzkj.student.dao.IStudentDao;
import com.dzkj.student.entity.Student;
import com.dzkj.student.util.DBUtil;

public class StudentDaoImpl implements IStudentDao {

	private static final String URL = "jdbc:mysql://localhost:3306/student?characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASSWORD = "0404094";
	Student student = null;
	ResultSet resultSet = null;
	// 将学生放入集合
	List<Student> students = new ArrayList<>();
	
	// 查学生是否存在
	public boolean isExist(int sno) {// ==null表不存在
		return queryStudentByNo(sno) == null ? false : true;
	}

	// 增加学生
	public boolean addStudent(Student student) {
		String sql = "insert into student values(?,?,?,?)";
		Object[] objects = { student.getSno(), student.getSname(), student.getSage(), student.getSaddress() };
		return DBUtil.executeUpdate(sql, objects);
	}

	// 根据学号删除学生
	public boolean delStudentByNo(int sno) {
		String sql = "delete from student where sno=?";
		Object[] objects = { sno };
		return DBUtil.executeUpdate(sql, objects);
	}

	// 根据学号更改学生信息
	public boolean updateStudentByNo(int sno, Student student) {
		String sql = "update student set sname=?,sage=?,saddress=? where sno=?";
		Object[] objects = { student.getSname(), student.getSage(), student.getSaddress(), sno };
		return DBUtil.executeUpdate(sql, objects);
	}

	// 根据学号查学生
	public Student queryStudentByNo(int sno) {
		Student student = null;
		PreparedStatement preparedStatement = null;
		try {

			String sql = "select * from student where sno=?";
			Object[] objects = { sno };
			resultSet = DBUtil.executeQuery(sql, objects);

			//resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int no = resultSet.getInt("sno");
				String name = resultSet.getString("sname");
				int age = resultSet.getInt("sage");
				String address = resultSet.getString("saddress");
				student = new Student(no, name, age, address);
			}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(resultSet, preparedStatement, DBUtil.connection);
		}
	}

	// 查询所有学生
	public List<Student> queryAllStudents() {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			String sql = "select * from student";
			resultSet = DBUtil.executeQuery(sql, null);
			while (resultSet.next()) {
				int no = resultSet.getInt("sno");
				String name = resultSet.getString("sname");
				int age = resultSet.getInt("sage");
				String address = resultSet.getString("saddress");
				student = new Student(no, name, age, address);
				// 每查一个学生就添加进集合
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(resultSet, preparedStatement, DBUtil.connection);
		}
	}

	//获取总数
	@Override
	public int getTotalCount() {
		
		String sql = "select * from student";
		return DBUtil.getTotalCount(sql);
	}

	//每页的数据集合
	@Override
	public List<Student> queryStudentByPage(int currentPage, int PageSize) {
		
		String sql = "select * from student LIMIT ?,? ";
		Object[] objects = {currentPage*PageSize, (currentPage-1)*PageSize+1};
		ResultSet resultSet = DBUtil.executeQuery(sql, objects);
		try {
			while (resultSet.next()) {
				student = new Student(resultSet.getInt("sno"), 
									resultSet.getString("sname"), 
									resultSet.getInt("sage"), 
									resultSet.getString("saddress"));
				// 每查一个学生就添加进集合
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	// 根据姓名查
	// 根据年龄查
}
