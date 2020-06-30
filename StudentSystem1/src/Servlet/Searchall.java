package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dom.UserDao;
import Dom.UserDaolmpl;
import User.user;
@WebServlet("/Searchall")
public class Searchall extends HttpServlet{
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
       public  void doGet(HttpServletRequest request,HttpServletResponse response)
                    throws ServletException,IOException{
    	// TODO Auto-generated method stub
    	     doPost(request,response);
	              
}
       /**
   	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   	 */
       public void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException,IOException{
    	// TODO Auto-generated method stub
    	   
    	          UserDao ud=new UserDaolmpl();
    	       List<user> userAll=ud.getUserAll();
    	       //request.setAttribute("userAll", userAll);
    	       HttpSession session=request.getSession();
 	          session.setAttribute("userAll", userAll);
    	       request.getRequestDispatcher("/showall.jsp").forward(request, response);
       }
}
