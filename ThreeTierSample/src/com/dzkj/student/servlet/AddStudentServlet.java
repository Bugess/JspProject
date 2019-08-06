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
		// �����������
		request.setCharacterEncoding("utf-8");

		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		Student student = new Student(no, name, age, address);

		IStudentService service = new StudentServiceImpl();

		boolean result = service.addStudent(student);

		// ������Ӧ����
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");

		/*
		 * if (result) {
		 * 
		 * response.getWriter().println("���ӳɹ���");
		 * response.sendRedirect("queryAllStudentServlet"); } else {
		 * response.getWriter().println("����ʧ�ܣ�"); }
		 */
		
			if (!result) {// ����ʧ��,request��ֵ
				request.setAttribute("error", "addError");
			} else {
				// �ɹ���1request��ֵ
				request.setAttribute("error", "noAddError");
			} // 2û��ֵ����ʾ
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
