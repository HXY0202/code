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
		//cookie������ƣ��������¼���浽�ͻ��ˣ��ô��Ǽ���������˵�ѹ�������㣺���ڰ�ȫ����
		//1.�ȴ���һ��cookie����,cookie����ļ�ֵ�Բ�֧������
		Cookie cookie = new Cookie("name", "zhangsan");
		//2.cookie��API
		//cookieĬ����һ�λỰ��¼��Ҳ���Ǳ����ʱ���Ǵӵ�һ�δ����������һ����վ���ر��������cookie����ļ�¼�ͻ���ʧ
		//��������cookie�����ʱ���Լ����ã���Ҫ�������ķ���cookie.setMaxAge(��);
		cookie.setMaxAge(10*60);//�����ͽ�cookie����Ļ���ʱ������Ϊ10����
		//ָ��cookie���󱣴�·��
		cookie.setPath(" ");
		//�����cookie�����͵��ͻ��ˣ���Ҫʹ�÷���response.addCookie(cookie);�������õ�cookie�ͻ���Ч
		response.addCookie(cookie);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}