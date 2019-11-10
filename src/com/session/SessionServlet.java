package com.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//默认在一次会话中，也就是说在，一次会话中任何资源公用一个session对象
		//Session技术：存到服务器端 借助cookie存储JSESSIONID
		
		//sesion对象其实也是一个域对象，他是依赖于cookie对象而存在的，与cookie不同的是，cookie将数据存放到客服端，而session将数据存放到服务器端
		//客户端依赖与cookie的JSESSIONID能够找到session
		//通过request.getsession()能够过得一个session对象，当执行到这行代码时，如果该客户端存在JSESESSIONID就返回这个session对象
		//如果客户端不存在JSESESSIONID就会自动创建一个session对象，所以当执行了getsession代码时客户端就一定会存在session对象
		HttpSession session = request.getSession();
		System.out.println(session.getId());//可以拿到session对象的ID
		
		//向session域中存放数据，session，setAttribute(key,value);
		session.setAttribute("name", "zhangsan");
		
		//---------------------------------------------------------------
		//设置JSESSION持久化，如果不设置持久化，当访问完一次页面时，把客户端关闭，由于cookie默认是一次请求，所以在cookie的JSESSION就会消失，由于JSESSION消失
		//就不能找到session对象了，也就是之前存放在session域中的数据就会找不到，知道它自动消失
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setPath("/WEB06/"); //加不加都可以
		cookie.setMaxAge(60*10);
		System.out.println(request.getContextPath());
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}












