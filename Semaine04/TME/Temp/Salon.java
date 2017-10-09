public class Salon {
	
	private int capacite;
	private int placeOccupe;
	private Client[] client;
	
	public Salon(int n){
		capacite = n;
		placeOccupe = 0;
		client = new Client[n];
	}
	
	public synchronized void Entre(Client c){
		if(placeOccupe < capacite-1){
			client[placeOccupe] = c;
			placeOccupe++;
			notifyAll();
		}
		else{
			System.out.println("Salon plein, le client est parti");
			return;
		}	
			
	}
	
	public synchronized void Rasage(Barbier b){
		while(true){
			try{
				while(placeOccupe == 0){
					wait();			
				}
				if ( placeOccupe > 0 ){
				try {
					client[placeOccupe] = null;
					placeOccupe--;
					System.out.println("Client pris en charge");	
				}catch(ArrayIndexOutOfBoundsException a)
				{System.out.println(placeOccupe);	}
				}
			}
			catch(InterruptedException e){break;}
		}
	}
}
