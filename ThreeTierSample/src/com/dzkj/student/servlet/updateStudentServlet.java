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
 * Servlet implementation class updateStudentServlet
 */
public class updateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		Student student = new Student(name,age,address);
		
		IStudentService service = new StudentServiceImpl();
		boolean result = service.updateStudentByNo(no, student);
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		/*if (result) {
			//response.getWriter().println("修改成功！");
			request.getRequestDispatcher("queryAllStudentServlet").forward(request, response);
		} else {
			response.getWriter().println("修改失败！");
		}*/
		
		if (!result) {
			request.setAttribute("update", "update");
		}else {
			request.setAttribute("update", "noUpdate");
		}
		request.getRequestDispatcher("queryAllStudentServlet").forward(request, response);	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
