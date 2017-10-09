import java.util.*;

public class Barbier implements Runnable {
	private Salon s;
	
	public Barbier(Salon s){
		this.s = s;
	}
	
	public void run(){
	try {
		s.Rasage(this);
		Thread.sleep(400);}
		catch(InterruptedException e) {}
	}
}
