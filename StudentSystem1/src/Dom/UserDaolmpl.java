package Dom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import User.user;
import util.DBconn;
public class UserDaolmpl implements UserDao {

	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try {
			DBconn.init();
			ResultSet rs=DBconn.selectSql("select * from user1 where name='"+name+"'and password='"+password+"'");
			while(rs.next()) {
				if(rs.getString("name").equals(name)&&rs.getString("password").equals(password)) {
					flag=true;
				}
			}
			DBconn.closeConn();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	
	@Override
	public boolean register(user user1) {
		// TODO Auto-generated method stub
		boolean flag=false;
		DBconn.init();
		int i=DBconn.addUpdDel("insert into user1(name,sex,race,birthday,password,type,duty)"
				+"value('"+user1.getName()+"','"+user1.getSex()+"','"+user1.getRace()+"','"+user1.getBirthday()+"','"+
				user1.getPassword()+"','"+user1.getType()+"','"+user1.getDuty()+"')");
		if(i>0) {
			flag=true;
		}
		DBconn.closeConn();
		return flag;
	}

	@Override
	public List<user> getUserAll() {
		// TODO Auto-generated method stub
		   List<user> list =new ArrayList<user>();
		try {
			DBconn.init();
			ResultSet rs=DBconn.selectSql("select * from user1");
			while(rs.next()) {
				user user2=new user();
				user2.setId(rs.getInt("id"));
				user2.setNme(rs.getString("name"));
				user2.setSex(rs.getString("sex"));
				user2.setRace(rs.getString("race"));
				user2.setBirthday(rs.getString("birthday"));
				user2.setPassword(rs.getString("password"));
				user2.setType(rs.getString("type"));
				user2.setDuty(rs.getString("duty"));
				list.add(user2);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		DBconn.init();
		String sql="delete from user1 where id="+id;
		int i=DBconn.addUpdDel(sql);
		if(i>0) {
			flag=true;
		}
		DBconn.closeConn();
		return flag;
	}
	@Override
	public synchronized boolean update(int id,String name, String sex, String race, String birthday, String password, String type,
			String duty) {
		// TODO Auto-generated method stub
		boolean flag=false;
		DBconn.init();
		String sql="update user1 set name ='"+name
				+"',sex ='"+sex
				+"',race ='"+race
				+"',birthday='"+birthday
				+"',password='"+password
				+"',type='"+type
				+"',duty='"+duty+"'where id="+id;
		int i=DBconn.addUpdDel(sql);
		if(i>0) {
			flag=true;
		}
		DBconn.closeConn();
		return flag;
	}
	@Override
	public List<user> getUserby(String getone,String num)
	{
		 List<user> list =new ArrayList<user>();
		try {
		    DBconn.init();
	    	ResultSet rs=DBconn.selectSql("SELECT * FROM user1 WHERE " + num + " LIKE '"+ getone +"'");
			while(rs.next()) {
				user user2=new user();
				user2.setId(rs.getInt("id"));
				user2.setNme(rs.getString("name"));
				user2.setSex(rs.getString("sex"));
				user2.setRace(rs.getString("race"));
				user2.setBirthday(rs.getString("birthday"));
				user2.setPassword(rs.getString("password"));
				user2.setType(rs.getString("type"));
				user2.setDuty(rs.getString("duty"));
				list.add(user2);
			  }
			DBconn.closeConn();
			return list;
		  
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return null;
		
	}
	@Override
	public List<user> getUserbyid(int getone,String num)
	{
		 List<user> list =new ArrayList<user>();
		try {
		    DBconn.init();
	    	ResultSet rs=DBconn.selectSql("SELECT * FROM user1 WHERE " + num + " LIKE '"+ getone +"'");
			while(rs.next()) {
				user user2=new user();
				user2.setId(rs.getInt("id"));
				user2.setNme(rs.getString("name"));
				user2.setSex(rs.getString("sex"));
				user2.setRace(rs.getString("race"));
				user2.setBirthday(rs.getString("birthday"));
				user2.setPassword(rs.getString("password"));
				user2.setType(rs.getString("type"));
				user2.setDuty(rs.getString("duty"));
				list.add(user2);
			  }
			DBconn.closeConn();
			return list;
		  
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return null;
		
	}
	@Override
	public String requiretype(String name,String password)
	{
		String type=null;
		try {
		DBconn.init();
		ResultSet rs=DBconn.selectSql("select * from user1 where name='"+name+"'and password='"+password+"'");
		while(rs.next()) {
			if(rs.getString("name").equals(name)&&rs.getString("password").equals(password)) {
				type=rs.getString("type");
			}
		}
		DBconn.closeConn();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return type;
		
	}
}
