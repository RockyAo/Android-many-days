package com.itcast.wh;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public static String username = "18651607742";
	// MD5¼ÓÃÜ×Ö·û´®(ÃÜÂëÊÇ123456)
	public static String password = "e10adc3949ba59abbe56e057f20f883e";

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		// response.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html");
		// response.setHeader("content-type","text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		OutputStream out = response.getOutputStream();
		if (username.equals(this.username) && password.equals(this.password)) {
			// µÇÂ¼³É¹¦£º·µ»ØµÇÂ¼ÐÅÏ¢
			String path = getServletContext().getRealPath("/")
					+ "file/login.json";
			File file = new File(path);
			FileInputStream stream = new FileInputStream(file);
			int count = -1;
			byte[] buffer = new byte[1024];
			while ((count = stream.read(buffer)) != -1) {
				out.write(buffer, 0, count);
				out.flush();
			}
			stream.close();
			out.close();
		} else {
			// µÇÂ¼Ê§°Ü
			String jsonError = "{\"success\":false}";
			out.write(jsonError.getBytes());
			out.flush();
			out.close();
		}
	}

}
