package com.hxy.checkimgservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//为什么在验证码的问题上要将生成的验证码储存到session域对象中，因为session域对象的默认生命周期符合验证码的特性
		//session对象的默认生命周期是一次会话，每个人每次生成的验证码需要不同的
		
		//设置请求中乱码问题，也就是从客户端获取汉字时不会出现乱码的问题
		request.setCharacterEncoding("UTF-8");
		//获得session对象，
		HttpSession session = request.getSession();
		//由于生成的验证码是储存在session对象中的，所以用这个来获取验证码
		String checkImg1 = (String)session.getAttribute("checkcode_session");
		//这个是获取客户端输入的验证码
		String checkImg2 = request.getParameter("checkImg");
		
		if(!checkImg1.equals(checkImg2)) {
			request.setAttribute("loginInfo", "你的验证码不正确");
			//如果客户端输入的验证码不正确就在转发到注册页面，
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}else {
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}



















