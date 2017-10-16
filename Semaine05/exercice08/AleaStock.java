public class AleaStock {
	private AleaObjet[] stock;
	private int poidsMax;

	public AleaStock(int taille)
	{
		stock = new AleaObjet[taille];
		for (int i = 0; i < taille; i++)
		{
			stock[i] = new AleaObjet(0, 100);
		}
	}

	public synchronized AleaObjet getStockObjet(int index)
	{
		return (stock[index]);
	}

	public synchronized int getTaille()
	{
		return (stock.length);
	}

	public boolean estVide()
	{
		return (getTaille() == 0);
	}
}
