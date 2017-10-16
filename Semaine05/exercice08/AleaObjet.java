public class AleaObjet {
	private int poids;

	public AleaObjet(int min, int max)
	{
		poids = (int)(Math.random() * (max - min)) + min;
	}

	public int getPoids()
	{
		return (poids);
	}
}
