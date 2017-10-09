public class Salon {
	private int capacite;
	private int nbclients;
	private Client[] clients;

	public Salon(int n)
	{
		capacite = n - 1;
		clients = new Client[n];
		nbclients = 0;
	}

	public synchronized void nvClient(Client c)
	{
		if (nbclients < capacite)
		{
			clients[nbclients++] = c;
			notifyAll();
		}
		else
		{
			System.out.println("Salon plein, client parti");
		}
	}

	public synchronized int getNbClients()
	{
		return nbclients;
	}

	public synchronized int getCapacite()
	{
		return capacite;
	}

	public void rasage()
	{
		
	}
}
