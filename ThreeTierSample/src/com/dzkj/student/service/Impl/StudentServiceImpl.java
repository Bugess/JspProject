package com.dzkj.student.service.Impl;

import java.util.List;

import com.dzkj.student.dao.Impl.StudentDaoImpl;
import com.dzkj.student.entity.Student;
import com.dzkj.student.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
	StudentDaoImpl studentDao = new StudentDaoImpl();
	
	//增加
	public boolean addStudent(Student student) {
		if (!studentDao.isExist(student.getSno())) {//不存在
			return studentDao.addStudent(student);
		} else {
			System.out.println("此人已存在！！");
			return false;
		}
	}
	
	//删
	public boolean delStudentByNo(int sno) {
		if (studentDao.isExist(sno)) {//如果存在
			return studentDao.delStudentByNo(sno);
		}
		return false;
	}
	
	//改
	public boolean updateStudentByNo(int sno,Student student) {
		if (studentDao.isExist(sno)) {//如果存在
			return studentDao.updateStudentByNo(sno, student);
		}
		return false;
	}
	
	//查一个
	public Student queryStudentByNo(int sno) {
			return studentDao.queryStudentByNo(sno);
	}
	
	//查所有
	public List<Student> queryAllStudents() {
		return studentDao.queryAllStudents();
}
	
	//总条数
	@Override
	public int getTotalCount() {
		return studentDao.getTotalCount();
	}
	
	//当前页数据集合
	@Override
	public List<Student> queryStudentByPage(int currentPage, int PageSize) {
		return studentDao.queryStudentByPage(currentPage, PageSize);
	}
}	
