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
	// ��ѧ�����뼯��
	List<Student> students = new ArrayList<>();
	
	// ��ѧ���Ƿ����
	public boolean isExist(int sno) {// ==null������
		return queryStudentByNo(sno) == null ? false : true;
	}

	// ����ѧ��
	public boolean addStudent(Student student) {
		String sql = "insert into student values(?,?,?,?)";
		Object[] objects = { student.getSno(), student.getSname(), student.getSage(), student.getSaddress() };
		return DBUtil.executeUpdate(sql, objects);
	}

	// ����ѧ��ɾ��ѧ��
	public boolean delStudentByNo(int sno) {
		String sql = "delete from student where sno=?";
		Object[] objects = { sno };
		return DBUtil.executeUpdate(sql, objects);
	}

	// ����ѧ�Ÿ���ѧ����Ϣ
	public boolean updateStudentByNo(int sno, Student student) {
		String sql = "update student set sname=?,sage=?,saddress=? where sno=?";
		Object[] objects = { student.getSname(), student.getSage(), student.getSaddress(), sno };
		return DBUtil.executeUpdate(sql, objects);
	}

	// ����ѧ�Ų�ѧ��
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

	// ��ѯ����ѧ��
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
				// ÿ��һ��ѧ������ӽ�����
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

	//��ȡ����
	@Override
	public int getTotalCount() {
		
		String sql = "select * from student";
		return DBUtil.getTotalCount(sql);
	}

	//ÿҳ�����ݼ���
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
				// ÿ��һ��ѧ������ӽ�����
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	// ����������
	// ���������
}
