package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import User.user;
import Poexcel.writetoExcel;

@WebServlet("/Downfile")
public class Dwonfile extends  HttpServlet{
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
    	   HttpSession session=request.getSession();
    	   String type=(String) session.getAttribute("type");
    	   List<user> userAll=new ArrayList<>();
	         userAll=(List<user>) session.getAttribute("userAll");
	         writetoExcel t= new writetoExcel();
	         String filePath=t.toExcel(userAll);
	         if(t.downloadfile(filePath, "档案文件", response))
	        	 if(type.equals("admin"))
	         request.getRequestDispatcher("/showall.jsp").forward(request, response);
	        	 else {
	        		 request.getRequestDispatcher("/queryby.jsp").forward(request, response);
	        	 }
	         else {
	        	 response.sendRedirect("error.jsp");//报错
	         }
       }
       
}
