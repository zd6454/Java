package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dom.UserDao;
import Dom.UserDaolmpl;
/**
 * Servlet implementation class DengluServlet
 */
//@WebServlet("/DengluServlet")
public class DengluServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);//����Ϣʹ��doPost����ִ��   ��Ӧjspҳ���е�form���е�method
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");//�õ�jspҳ�洫�����Ĳ���
		String password=request.getParameter("password");
		String type=request.getParameter("type");
		UserDao ud=new UserDaolmpl();
		if(ud.login(name, password)) {
			String type2=ud.requiretype(name, password);
		  if(type2.equals(type)) {
			if(type.equals("admin"))
			{
				HttpSession session=request.getSession();
				session.setAttribute("name", name);
				session.setAttribute("type", type2);
				request.setAttribute("zhu", "��ӭ�û�"+name);//��request���з�����Ϣ
		    	request.getRequestDispatcher("/success.jsp").forward(request, response);//ת�����ɹ�����
			}else if(type.equals("or"))
			{
				HttpSession session=request.getSession();
				session.setAttribute("type", type);
				request.setAttribute("zhu", "��ӭ�û�"+name);//��request���з�����Ϣ
		    	request.getRequestDispatcher("/zhuce.jsp").forward(request, response);
			}else {
				HttpSession session=request.getSession();
				session.setAttribute("name", name);
				session.setAttribute("type", type);
				session.setAttribute("password", password);
		    	request.getRequestDispatcher("/Searchby").forward(request, response);
			}
		  }else {
			  request.setAttribute("zhu", "�û�Ȩ�޴��󣡣���");//��request���з�����Ϣ
		    	request.getRequestDispatcher("/denglu.jsp").forward(request, response);
		  }
		}else {
			 request.setAttribute("zhu", "�˺Ż�������󣡣���");//��request���з�����Ϣ
		    	request.getRequestDispatcher("/denglu.jsp").forward(request, response);
		}
	}

}
