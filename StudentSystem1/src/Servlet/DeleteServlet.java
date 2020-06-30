package Servlet;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dom.UserDao;
import Dom.UserDaolmpl;
public class DeleteServlet extends HttpServlet {
     public void doGet(HttpServletRequest request, HttpServletResponse response)
                   throws ServletException,IOException{
    	 doPost(request,response);
     }
     public  void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException,IOException{
    	 String id = request.getParameter("id");
 		int userId = Integer.parseInt(id);
    	  UserDao ud=new UserDaolmpl();
    	  if(ud.delete(userId)) {
    		  request.setAttribute("success", "É¾³ý³É¹¦");
    		  request.getRequestDispatcher("/Searchall").forward(request, response);
    	  }else {
    		  response.sendRedirect("error.jsp");
    	  }
     }
}
