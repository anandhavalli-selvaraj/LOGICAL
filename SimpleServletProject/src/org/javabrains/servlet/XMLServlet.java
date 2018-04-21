package org.javabrains.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XMLServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/HTML");
		System.out.println("Hello from GET Method from XMLServlet");
		PrintWriter writer=response.getWriter();
		String userName=request.getParameter("userName");
		String fullName=request.getParameter("fullName");
		HttpSession session=request.getSession();
		ServletContext context=request.getServletContext();
		if(userName!=null&&userName!="")
		{
			session.setAttribute("userName", userName);
			context.setAttribute("userName", userName);
			
		}
		writer.println(" Hello From Get Method!!!  "+userName+" we know your full Name "+fullName);
		writer.println("Session UserName "+session.getAttribute("userName"));
		writer.println("Context UserName "+context.getAttribute("userName"));

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/HTML");
		PrintWriter writer=response.getWriter();
		String userName=request.getParameter("userName");
		String fullName=request.getParameter("fullName");
		String prof=request.getParameter("prof");
		// when multiple values are selected these getParameter method can't able to catch the parameterString optionvalue=request.getParameter("location");
		 String[] location=request.getParameterValues("location");
		writer.println(" Hello From POST Method!!!  "+userName+" we know your full Name "+fullName);
		writer.println("you are  a "+prof +" you are in "+location+" and length "+location.length);
		
}

}
