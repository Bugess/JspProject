package com.dzkj.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dzkj.student.entity.Student;
import com.dzkj.student.service.IStudentService;
import com.dzkj.student.service.Impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryStudentByPage
 */
public class QueryStudentByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStudentByPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService iStudentService = new StudentServiceImpl();
		//总数据数
		int count = iStudentService.getTotalCount();
		int currentPage = 2;
		int PageSize = 3;
		//当前页数据集合
		List<Student> students = iStudentService.queryStudentByPage(currentPage , PageSize);
		System.out.println(count);
		System.out.println(students);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
