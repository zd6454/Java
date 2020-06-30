package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Poexcel.writetoExcel;
import User.user;
import Dom.UserDao;
import Dom.UserDaolmpl;

/**
 * Servlet implementation class Downone
 */
@WebServlet("/Downone")
public class Downone extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int id2=Integer.parseInt(id);
		UserDao ud=new UserDaolmpl();
		List<user> user1=ud.getUserbyid(id2,"id");
		  writetoExcel t= new writetoExcel();
	         String filePath=t.toExcel(user1);
	         if(t.downloadfile(filePath, "档案文件", response))
	         request.getRequestDispatcher("/queryby.jsp").forward(request, response);
	         else {
	        	 response.sendRedirect("error.jsp");//报错
	         }
	}

}
