public class TestSalon {
	public static void main(String []args){
		Salon salon = new Salon(7);
		Thread b = new Thread(new Barbier(salon));
		Thread[] tab = new Thread[12];
		
		b.start();
		for ( int i = 0; i < 12; i++){
			tab[i]= new Thread( new Client(salon));
			tab[i].start();
		}
		
		try{
			for ( int i = 0; i < 12; i++){
				tab[i].join();
			}
		} catch(InterruptedException e){}
			finally{
			b.interrupt();
		}			
	}
}
