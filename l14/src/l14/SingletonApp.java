package l14;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;

public class SingletonApp {
	
	public static void main(String[] args) throws InterruptedException {
//		Thread t[]=new Thread[1000];
//		for (int i = 0; i < t.length; i++) {
//			t[i]=new Thread(new Run());
//			t[i].start();
//		}
//		for (int i = 0; i < t.length; i++) {
//			t[i].join();
//		}
//		System.out.println(Singleton.getInstance().count);
		
		Singleton BD=Singleton.getInstance();
		
		BD.addUser(BD.id, "SIMBA");
		BD.addUser(BD.id, "TIMON");
		BD.addUser(BD.id, "PUBMA");
		BD.addUser(BD.id, "SCAR");
		
		for (int i = 0; i < 4; i++) {
			System.out.println("User: "+BD.getProperty(i));
		}
		
		System.out.println(BD.id);
		
//		Singleton chat=Singleton.getInstance();
//		chat.sendMessage("Alice", "Hi there!");
//		chat.sendMessage("Bob", "Hello!");
//		chat.sendMessage("Alice", "How are you doing, Bob?");
//		chat.sendMessage("Bob", "I'm doing well, thanks for asking. How about you, Alice?");
	}
}
class Run implements Runnable{

	public void run() {
		Singleton.getInstance();
		
	}
	
}
class Singleton{
	static int id=0;
	private final int maxConnections = 4;
	private HashMap<Integer, String> BD;
	private static Singleton instance;
	private Singleton() {
		BD = new HashMap<>();
	}
	public static Singleton getInstance(){
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance == null)
					instance =new Singleton();
			}
		}
		return instance;
	}
	public void addUser(int key, String value) {
        if(id<maxConnections) {
        	id++;
        	BD.put(key, value);
        	
        }
        else
        	System.out.println("Limita de useri");
    }
	public void removeUser(int key) {
        BD.remove(key);
        id--;
    }
	public String getProperty(int key) {
        return BD.get(key);
    }
	
	 public void sendMessage(String user, String message) {
	        LocalDateTime timestamp = LocalDateTime.now();
	        System.out.println(timestamp + " [" + user + "]: " + message);
	 }
}