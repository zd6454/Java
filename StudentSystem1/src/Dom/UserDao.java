package Dom;

import java.util.List;
import User.user;
public interface UserDao {
  public boolean login(String name,String passwork);//��¼
  public boolean register(user user1);//ע��
  public List<user> getUserAll();//�����û���Ϣ
  public boolean delete(int id);//ɾ��
  public List<user> getUserby(String getone,String num);
  public boolean update(int id,String name, String sex,String race,String birthday,String password,String type,String duty);//����
  public String requiretype(String name, String password);
List<user> getUserbyid(int getone, String num);
}
