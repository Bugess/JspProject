package com.dzkj.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.dzkj.student.service.IStudentService;
import com.dzkj.student.service.Impl.StudentServiceImpl;

/**
 * Servlet implementation class delStudentServlet
 */
public class delStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		
		IStudentService service = new StudentServiceImpl();
		boolean result = service.delStudentByNo(no);
	
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		/*if (result) {
			//response.getWriter().println("É¾³ý³É¹¦£¡£¡");
			response.sendRedirect("queryAllStudentServlet");
		} else {
			response.getWriter().println("É¾³ýÊ§°Ü£¡£¡");
		}*/
	
		if (!result) {
			request.setAttribute("dele", "dele");
		}else {
			request.setAttribute("dele", "noDele");
		}
		request.getRequestDispatcher("queryAllStudentServlet").forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
