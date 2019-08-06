package com.dzkj.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dzkj.student.entity.Student;
import com.dzkj.student.service.IStudentService;
import com.dzkj.student.service.Impl.StudentServiceImpl;

/**
 * Servlet implementation class AddStudentServlet
 */
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求编码
		request.setCharacterEncoding("utf-8");

		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		Student student = new Student(no, name, age, address);

		IStudentService service = new StudentServiceImpl();

		boolean result = service.addStudent(student);

		// 设置响应编码
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");

		/*
		 * if (result) {
		 * 
		 * response.getWriter().println("增加成功！");
		 * response.sendRedirect("queryAllStudentServlet"); } else {
		 * response.getWriter().println("增加失败！"); }
		 */
		
			if (!result) {// 增加失败,request有值
				request.setAttribute("error", "addError");
			} else {
				// 成功：1request有值
				request.setAttribute("error", "noAddError");
			} // 2没有值不显示
			request.getRequestDispatcher("queryAllStudentServlet").forward(request, response);
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
