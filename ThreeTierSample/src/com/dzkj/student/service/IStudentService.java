package com.dzkj.student.service;

import java.util.List;

import com.dzkj.student.entity.Student;

public interface IStudentService {
	public boolean addStudent(Student student) ;
	
	//ɾ
	public boolean delStudentByNo(int sno) ;
	
	//��
	public boolean updateStudentByNo(int sno,Student student);
	
	//��һ��
	public Student queryStudentByNo(int sno) ;
	
	//������
	public List<Student> queryAllStudents() ;
	
	//��ȡ����
	public int getTotalCount();
	
	//ÿҳ�����ݼ���
	public List<Student> queryStudentByPage(int currentPage, int PageSize);
}
