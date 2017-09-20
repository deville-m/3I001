public class Buffer {
	private int[] tableau;
	private int nbElements;

	public Buffer(int taille)
	{
		tableau = new int[taille];
		nbElements = 0;
	}

	public int getTaille()
	{
		return tableau.length;
	}

	public void depot(int val)
	{
		if (nbElements < tableau.length)
		{
			tableau[nbElements] = val;
			System.out.printf("Valeur\t%d\tdeposee dans la case %d\n", val, nbElements++);
		}
		else
		{
			System.out.println("Buffer plein.");
		}
	}

	public String toString()
	{
		String res = "Le tableau contient " + nbElements + " elements;\n";
		for (int i = 0; i < nbElements; i++)
		{
			res = res + "\t valeur " + tableau[i] + " dans la case " + i + "\n";
		}
		return res;
	}
}
