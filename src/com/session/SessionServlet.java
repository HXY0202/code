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
		
		//Ĭ����һ�λỰ�У�Ҳ����˵�ڣ�һ�λỰ���κ���Դ����һ��session����
		//Session�������浽�������� ����cookie�洢JSESSIONID
		
		//sesion������ʵҲ��һ�����������������cookie��������ڵģ���cookie��ͬ���ǣ�cookie�����ݴ�ŵ��ͷ��ˣ���session�����ݴ�ŵ���������
		//�ͻ���������cookie��JSESSIONID�ܹ��ҵ�session
		//ͨ��request.getsession()�ܹ�����һ��session���󣬵�ִ�е����д���ʱ������ÿͻ��˴���JSESESSIONID�ͷ������session����
		//����ͻ��˲�����JSESESSIONID�ͻ��Զ�����һ��session�������Ե�ִ����getsession����ʱ�ͻ��˾�һ�������session����
		HttpSession session = request.getSession();
		System.out.println(session.getId());//�����õ�session�����ID
		
		//��session���д�����ݣ�session��setAttribute(key,value);
		session.setAttribute("name", "zhangsan");
		
		//---------------------------------------------------------------
		//����JSESSION�־û�����������ó־û�����������һ��ҳ��ʱ���ѿͻ��˹رգ�����cookieĬ����һ������������cookie��JSESSION�ͻ���ʧ������JSESSION��ʧ
		//�Ͳ����ҵ�session�����ˣ�Ҳ����֮ǰ�����session���е����ݾͻ��Ҳ�����֪�����Զ���ʧ
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setPath("/WEB06/"); //�Ӳ��Ӷ�����
		cookie.setMaxAge(60*10);
		System.out.println(request.getContextPath());
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}












