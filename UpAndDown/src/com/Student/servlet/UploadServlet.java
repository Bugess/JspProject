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
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String fileName = null;
try {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// 判断前台是否有multipart/form-data属性
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// ServletFileUpload方法需要一个FileItemFactory类型的对象
			ServletFileUpload upload = new ServletFileUpload(factory);

			
				// 将parseRequest解析的方法中的所有请求字段保存到集合中
				List<FileItem> items = upload.parseRequest(request);
				// 遍历
				Iterator<FileItem> iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = iterator.next();
					String sname = null;
					//判断是普通表单字段还是文件字段
					if (item.isFormField()) {

						if (item.getFieldName().equals("sname")) {//getFileName:普通字段
							sname = item.getString("UTF-8");
						} else {
							System.out.println("其他.....");
						}
					} else {//是文件字段
						//上传
						fileName = item.getName();			//getName:文件名
						//获取文件内容并上传,文件内容item
						//上传路径：服务器路径
						//String path = request.getSession().getServletContext().getRealPath("upload");
						String path = "D:\\1\\student\\upload";
						File file = new File(path, fileName);	//
						
						
						item.write(file);		//文件内容item
						System.out.println(fileName+"上传成功");
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
