package com.Student.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1����ȡ�ļ���
		String fileName = request.getParameter("fileName1");
		//2��������Ϣͷ
		response.addHeader("content-Type", "application/octet-stream");
		response.addHeader("content-Disposition", "attachement;fileName=" + fileName);
		//3��ת��Ϊ������������servlet��
		InputStream in = getServletContext().getResourceAsStream("/images/abc.png");
		//3��ת��Ϊ�����������û�
		ServletOutputStream out = response.getOutputStream();
		
		byte[] bs = new byte[10];
		int len = -1;
		while((len = (in.read(bs))) != -1) {
			out.write(bs, 0, len);
		}
		out.close();
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
