package com.hxy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//cookie缓存机制，将浏览记录缓存到客户端，好处是减轻服务器端的压力，不足：存在安全问题
		//1.先创建一个cookie对象,cookie对象的键值对不支持中文
		Cookie cookie = new Cookie("name", "zhangsan");
		//2.cookie的API
		//cookie默认是一次会话记录，也就是保存的时间是从第一次打开浏览器访问一个网站到关闭浏览器，cookie保存的记录就会消失
		//若果想让cookie保存的时间自己设置，就要调用它的方法cookie.setMaxAge(秒);
		cookie.setMaxAge(10*60);//这样就讲cookie对象的缓存时间设置为10分钟
		//指定cookie对象保存路径
		cookie.setPath(" ");
		//如果将cookie对象发送到客户端，需要使用方法response.addCookie(cookie);这样设置的cookie就会生效
		response.addCookie(cookie);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}