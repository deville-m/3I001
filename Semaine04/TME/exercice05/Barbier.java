public class Barbier implements Runnable {
	private Salon s;

	public Barbier(Salon s)
	{
		this.s = s;
	}

	public void run()
	{
		try
		{
			while (s.getNbClients() == 0)
			{
				wait();
			}
			s.rasage();
		}
		catch (InterrupedException e)
		{
			System.err.println("Le Barbier n'a pas pu attendre");
		}
	}
}
