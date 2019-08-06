package com.dzkj.student.service.Impl;

import java.util.List;

import com.dzkj.student.dao.Impl.StudentDaoImpl;
import com.dzkj.student.entity.Student;
import com.dzkj.student.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
	StudentDaoImpl studentDao = new StudentDaoImpl();
	
	//����
	public boolean addStudent(Student student) {
		if (!studentDao.isExist(student.getSno())) {//������
			return studentDao.addStudent(student);
		} else {
			System.out.println("�����Ѵ��ڣ���");
			return false;
		}
	}
	
	//ɾ
	public boolean delStudentByNo(int sno) {
		if (studentDao.isExist(sno)) {//�������
			return studentDao.delStudentByNo(sno);
		}
		return false;
	}
	
	//��
	public boolean updateStudentByNo(int sno,Student student) {
		if (studentDao.isExist(sno)) {//�������
			return studentDao.updateStudentByNo(sno, student);
		}
		return false;
	}
	
	//��һ��
	public Student queryStudentByNo(int sno) {
			return studentDao.queryStudentByNo(sno);
	}
	
	//������
	public List<Student> queryAllStudents() {
		return studentDao.queryAllStudents();
}
	
	//������
	@Override
	public int getTotalCount() {
		return studentDao.getTotalCount();
	}
	
	//��ǰҳ���ݼ���
	@Override
	public List<Student> queryStudentByPage(int currentPage, int PageSize) {
		return studentDao.queryStudentByPage(currentPage, PageSize);
	}
}	
