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
		
		//Ϊʲô����֤���������Ҫ�����ɵ���֤�봢�浽session������У���Ϊsession������Ĭ���������ڷ�����֤�������
		//session�����Ĭ������������һ�λỰ��ÿ����ÿ�����ɵ���֤����Ҫ��ͬ��
		
		//�����������������⣬Ҳ���Ǵӿͻ��˻�ȡ����ʱ����������������
		request.setCharacterEncoding("UTF-8");
		//���session����
		HttpSession session = request.getSession();
		//�������ɵ���֤���Ǵ�����session�����еģ��������������ȡ��֤��
		String checkImg1 = (String)session.getAttribute("checkcode_session");
		//����ǻ�ȡ�ͻ����������֤��
		String checkImg2 = request.getParameter("checkImg");
		
		if(!checkImg1.equals(checkImg2)) {
			request.setAttribute("loginInfo", "�����֤�벻��ȷ");
			//����ͻ����������֤�벻��ȷ����ת����ע��ҳ�棬
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}else {
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}



















