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
@WebServlet("/Searchby")
public class Searchby extends HttpServlet{
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
    	   String getone=request.getParameter("getone");
    	   String num=request.getParameter("num");
    	          UserDao ud=new UserDaolmpl();
    	          List<user> userAll=ud.getUserby(getone, num);
    	      if(userAll == null) {
    	    	  request.setAttribute("zhu2", "没有该信息");
       	          request.getRequestDispatcher("/queryby.jsp").forward(request, response);
    	      }else {
    	    	  HttpSession session=request.getSession();
  				  session.setAttribute("userAll",userAll);
    	          request.setAttribute("userAll", userAll);
    	          request.getRequestDispatcher("/queryby.jsp").forward(request, response);
    	      }
       }
}
