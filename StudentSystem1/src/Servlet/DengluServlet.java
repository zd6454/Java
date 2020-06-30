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
		doPost(request,response);//将信息使用doPost方法执行   对应jsp页面中的form表单中的method
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");//得到jsp页面传过来的参数
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
				request.setAttribute("zhu", "欢迎用户"+name);//向request域中放置信息
		    	request.getRequestDispatcher("/success.jsp").forward(request, response);//转发到成功界面
			}else if(type.equals("or"))
			{
				HttpSession session=request.getSession();
				session.setAttribute("type", type);
				request.setAttribute("zhu", "欢迎用户"+name);//向request域中放置信息
		    	request.getRequestDispatcher("/zhuce.jsp").forward(request, response);
			}else {
				HttpSession session=request.getSession();
				session.setAttribute("name", name);
				session.setAttribute("type", type);
				session.setAttribute("password", password);
		    	request.getRequestDispatcher("/Searchby").forward(request, response);
			}
		  }else {
			  request.setAttribute("zhu", "用户权限错误！！！");//向request域中放置信息
		    	request.getRequestDispatcher("/denglu.jsp").forward(request, response);
		  }
		}else {
			 request.setAttribute("zhu", "账号或密码错误！！！");//向request域中放置信息
		    	request.getRequestDispatcher("/denglu.jsp").forward(request, response);
		}
	}

}
