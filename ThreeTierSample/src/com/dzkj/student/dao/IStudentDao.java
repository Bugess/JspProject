package com.dzkj.student.dao;

import java.util.List;

import com.dzkj.student.entity.Student;

public interface IStudentDao {
	//查学生是否存在
		public boolean isExist(int sno) ;

		//增加学生
		public boolean addStudent(Student student) ;
		
		//根据学号删除学生
		public boolean delStudentByNo(int sno) ;
		
		//根据学号更改学生信息
		public boolean updateStudentByNo(int sno, Student student) ;
		
		//根据学号查学生
		public Student queryStudentByNo(int sno) ;
		//查询所有学生
		public List<Student> queryAllStudents() ;
		
		//查总数据
		public int getTotalCount();
		
		//查每页的数据集合

		List<Student> queryStudentByPage(int currentPage, int PageSize); 
}
