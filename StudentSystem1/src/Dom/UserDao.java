package Dom;

import java.util.List;
import User.user;
public interface UserDao {
  public boolean login(String name,String passwork);//登录
  public boolean register(user user1);//注册
  public List<user> getUserAll();//返回用户信息
  public boolean delete(int id);//删除
  public List<user> getUserby(String getone,String num);
  public boolean update(int id,String name, String sex,String race,String birthday,String password,String type,String duty);//更新
  public String requiretype(String name, String password);
List<user> getUserbyid(int getone, String num);
}
