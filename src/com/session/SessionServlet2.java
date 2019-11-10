package com.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session2")
public class SessionServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//由于Sessionservlet中在session中存放了数据，所以在该类中也可以通过session.getAttribute(key)来取出value
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		response.getWriter().write(name+"");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}