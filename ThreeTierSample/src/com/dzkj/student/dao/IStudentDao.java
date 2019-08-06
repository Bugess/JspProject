package com.dzkj.student.dao;

import java.util.List;

import com.dzkj.student.entity.Student;

public interface IStudentDao {
	//��ѧ���Ƿ����
		public boolean isExist(int sno) ;

		//����ѧ��
		public boolean addStudent(Student student) ;
		
		//����ѧ��ɾ��ѧ��
		public boolean delStudentByNo(int sno) ;
		
		//����ѧ�Ÿ���ѧ����Ϣ
		public boolean updateStudentByNo(int sno, Student student) ;
		
		//����ѧ�Ų�ѧ��
		public Student queryStudentByNo(int sno) ;
		//��ѯ����ѧ��
		public List<Student> queryAllStudents() ;
		
		//��������
		public int getTotalCount();
		
		//��ÿҳ�����ݼ���

		List<Student> queryStudentByPage(int currentPage, int PageSize); 
}
