package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dom.UserDao;
import Dom.UserDaolmpl;
import User.user;

public class ZhuceServlet extends HttpServlet {
        public void doGet(HttpServletRequest request,HttpServletResponse response)
                        throws ServletException,IOException{
        	doPost(request,response);
        }
        public void doPost(HttpServletRequest request,HttpServletResponse response)
                         throws ServletException,IOException{
        	         String name =request.getParameter("name");//获取jsp页面传过来的参数
        	         String sex=request.getParameter("sex");
        	         String race=request.getParameter("race");
        	         String birthday=request.getParameter("birthday");
        	         String password=request.getParameter("password");
        	         String type="reject";
        	         String duty=request.getParameter("duty");
        	    if(name.equals("")||sex.equals("")||race.equals("")||birthday.equals("")||password.equals("")||duty.equals("")) {
        	    	 request.setAttribute("zhu", "添加失败，请输入正确格式");//向request域中放置参数
        	    	 request.getRequestDispatcher("/zhuce.jsp").forward(request, response);
        	    }else {
        	         user user1=new user();//实例化一个对象，组装属性

        	         user1.setNme(name);
        	         user1.setSex(sex);
        	         user1.setRace(race);
        	         user1.setBirthday(birthday);
        	         user1.setPassword(password);
        	         user1.setType(type);
        	         user1.setDuty(duty);
        	     UserDao ud=new UserDaolmpl();
        	     if(ud.register(user1)) { 
        	    	 request.setAttribute("zhu", "添加"+name+"成功");//向request域中放置参数
        	    	 HttpSession session=request.getSession();
     				   String type0=(String) session.getAttribute("type");
        	    	 if(type0.equals("or"))
        	    	 request.getRequestDispatcher("/zhuce.jsp").forward(request, response);	
        	    	 if(type0.equals("admin"))
        	    		 request.getRequestDispatcher("/success.jsp").forward(request, response);
        	    }else {
        	    		 response.sendRedirect("error.jsp");//报错
        	     }
        	   }
        }
}
