package com.Student.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String fileName = null;
try {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// �ж�ǰ̨�Ƿ���multipart/form-data����
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// ServletFileUpload������Ҫһ��FileItemFactory���͵Ķ���
			ServletFileUpload upload = new ServletFileUpload(factory);

			
				// ��parseRequest�����ķ����е����������ֶα��浽������
				List<FileItem> items = upload.parseRequest(request);
				// ����
				Iterator<FileItem> iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = iterator.next();
					String sname = null;
					//�ж�����ͨ���ֶλ����ļ��ֶ�
					if (item.isFormField()) {

						if (item.getFieldName().equals("sname")) {//getFileName:��ͨ�ֶ�
							sname = item.getString("UTF-8");
						} else {
							System.out.println("����.....");
						}
					} else {//���ļ��ֶ�
						//�ϴ�
						fileName = item.getName();			//getName:�ļ���
						//��ȡ�ļ����ݲ��ϴ�,�ļ�����item
						//�ϴ�·����������·��
						//String path = request.getSession().getServletContext().getRealPath("upload");
						String path = "D:\\1\\student\\upload";
						File file = new File(path, fileName);	//
						
						
						item.write(file);		//�ļ�����item
						System.out.println(fileName+"�ϴ��ɹ�");
						return;
					}
				}
			}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

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
