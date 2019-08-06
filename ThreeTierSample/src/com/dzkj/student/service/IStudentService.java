package com.dzkj.student.service;

import java.util.List;

import com.dzkj.student.entity.Student;

public interface IStudentService {
	public boolean addStudent(Student student) ;
	
	//删
	public boolean delStudentByNo(int sno) ;
	
	//改
	public boolean updateStudentByNo(int sno,Student student);
	
	//查一个
	public Student queryStudentByNo(int sno) ;
	
	//查所有
	public List<Student> queryAllStudents() ;
	
	//获取总数
	public int getTotalCount();
	
	//每页的数据集合
	public List<Student> queryStudentByPage(int currentPage, int PageSize);
}
