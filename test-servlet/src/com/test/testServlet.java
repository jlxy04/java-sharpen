package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet
 */
public class testServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public testServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("进servlet来了....................");
		String content = request.getParameter("content");
		String ss = new String(content.getBytes("ISO8859-1"), "UTF-8");
		System.out.println(ss);
		response.getWriter().write("servlet执行完成！！！！！！！！！！！！！");
		System.out.println("出servlet来了..................");
		System.out.println("新增功能");
		System.out.println("新增功能2");
		System.out.println("新增功能3");
		System.out.println("新增功能4");
		System.out.println("新增功能5");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
