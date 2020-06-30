package Servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dom.UserDao;
import Dom.UserDaolmpl;
import Server.Socket;
public class UpdateServlet extends HttpServlet {
 
		
	      public void doGet(HttpServletRequest request,HttpServletResponse response)
	                    throws ServletException,IOException{
	    	  doPost(request,response);
	      }
	      public void doPost(HttpServletRequest request,HttpServletResponse response)
	                    throws ServletException,IOException{
	    	  String id=request.getParameter("id");
	    	  int userid=Integer.parseInt(id);
	    	  String name1=request.getParameter("name");
	    	  String sex=request.getParameter("sex");
	    	  String race=request.getParameter("race");
	    	  String birthday=request.getParameter("birthday");
	    	  String password=request.getParameter("password");
	    	  String type=request.getParameter("type");
	    	  String duty=request.getParameter("duty");
	    	  
	    	  UserDao ud=new UserDaolmpl();
	    	  Socket.getInstance().execute(new Runnable() {
				
				@Override
				public void run() {
					if(ud.update(userid,name1, sex, race, birthday, password, type, duty)) {
		            request.setAttribute("success", "更新成功");
		              HttpSession session=request.getSession();
		              String type1=(String) session.getAttribute("type");
	             	  if(type1.equals("admin")){
	                	try {
							request.getRequestDispatcher("/Searchall").forward(request, response);
						} catch (ServletException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		             }else {
		                 try {
							request.getRequestDispatcher("/Searchby").forward(request, response);
						} catch (ServletException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		               }
	          }else {
		        try {
					response.sendRedirect("error.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           }
				}
			});
	    	  
	    	  try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
	      
}
