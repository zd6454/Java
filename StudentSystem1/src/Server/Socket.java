package Server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Dom.UserDao;
import Dom.UserDaolmpl;

public class Socket {
	
	private Socket() {
		
	}
	private static ExecutorService theadPool = Executors.newFixedThreadPool(10);
	private static Object lock = new Object();
	public static ExecutorService getInstance() {
		return theadPool;
	}
		public void destory() {
			if(theadPool!=null) {
				theadPool.shutdown();
			}
		}
	/*
	 * public void gthread(int id,String name, String sex,String race,String
	 * birthday,String password,String type,String duty) { for (int i=0;i<100;i++) {
	 * final int j = i; //theadpool.execute(new Runnable(){public void run(){}})
	 * theadPool.execute(()->{ System.out.println("11 "); try { boolean t=Update(id,
	 * name, sex, race,birthday , password, type, duty); Thread.sleep(1000); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }); } } public synchronized boolean Update(int
	 * id,String name, String sex,String race,String birthday,String password,String
	 * type,String duty) { UserDao ud=new UserDaolmpl(); if(ud.update(id, name, sex,
	 * race, birthday, password, type, duty)) { return true; }else return false;
	 * 
	 * }
	 */
}
