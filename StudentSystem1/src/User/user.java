package User;

public class user {

	private int id;//id
	private String name;//����
	private String sex;//�Ա�
	private String race;//����
	private String birthday;//��������
	private String password;//����
	private String type;//Ȩ������
	private String duty;//ְ��
	
	public user()
	{
		
	}
	public user(String name, String sex,String race,String birthday,String password,String type,String duty)
	{
	
		this.name=name;
		this.sex=sex;
		this.race=race;
		this.birthday=birthday;
		this.password=password;
		this.type=type;
		this.duty=duty;
	}
	public String getName()
	{
		return this.name;
	}
	public void setNme(String name)
	{
		this.name=name;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getType()
	{
		return this.type;
	}
	public void setType(String type)
	{
		this.type=type;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
