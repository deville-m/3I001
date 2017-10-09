public class Client implements Runnable{
	private Salon s;
	
	public Client(Salon s){
		this.s = s;
	}
	
	public void run(){
		s.Entre(this);
	}
}
