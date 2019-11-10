package com.hxy;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lastcookie")
public class GetCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * //创建当前时间 Date date = new Date(); //格式化当前时间 SimpleDateFormat format = new
		 * SimpleDateFormat("yyyy-MM-dd"); String current = format.format(date);
		 * System.out.println(current); //创建一个cookie对象 Cookie cookie = new
		 * Cookie("lastaccessTime", current); cookie.setMaxAge(60*24*2); //将cookie对象发送
		 * response.addCookie(cookie);
		 * 
		 * String lasttime = null;
		 * 
		 * Cookie[] cookies = request.getCookies(); if(cookies!=null) { for(Cookie coo :
		 * cookies) { if(coo.getName().equals("lastaccessTime")) { lasttime =
		 * coo.getValue(); } }
		 * 
		 * response.setContentType("text/html;charset=UTF-8"); if(lasttime!=null) {
		 * response.getWriter().write("你上次访问该网站的时间是"+lasttime); }else {
		 * response.getWriter().write("你是第一次访问改网站"); }
		 * 
		 * }
		 */
		Date date = new Date();
		request.setCharacterEncoding("UTF-8");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
		String lastTime = format.format(date);

		Cookie cookie = new Cookie("lastAccessTime", lastTime);
		cookie.setMaxAge(60*10);
		response.addCookie(cookie);

		String lastAccessTime = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie coo : cookies) {
				if ("lastAccessTime".equals(coo.getName())) {
					lastAccessTime = coo.getValue();
				}
			}
		}
		if (lastAccessTime != null) {
			System.out.println("你上次访问的时间是" + lastAccessTime);
		} else {
			System.out.println("你是第一次访问该网站");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
