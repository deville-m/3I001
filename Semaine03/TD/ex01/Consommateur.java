public class Consommateur implements Runnable {
	int nbRetraits;
	Buffer stock;

	public Consommateur(Buffer b)
	{
		stock = b;
		nbRetraits = b.getTaille();
	}
	public void run() {
		for (int i = 0; i < nbRetraits; i++)
		{
			try
			{
				int val = stock.retrait();
				System.out.println("Valeur " + val + " retiree.");
			}
			catch (InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
