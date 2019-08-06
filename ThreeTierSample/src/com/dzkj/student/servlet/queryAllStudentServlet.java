package com.dzkj.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dzkj.student.entity.Student;
import com.dzkj.student.service.IStudentService;
import com.dzkj.student.service.Impl.StudentServiceImpl;

import java.util.List;

/**
 * Servlet implementation class queryAllStudentServlet
 */
public class queryAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryAllStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IStudentService service = new StudentServiceImpl();
		List<Student> students = service.queryAllStudents();
		
		System.out.println(students);
		//将学生数据放入request域中
		request.setAttribute("students", students);
		//跳转回index
		request.getRequestDispatcher("wel.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
