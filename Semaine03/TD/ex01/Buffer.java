public class Buffer {
	private int[] tableau;
	private int nbElements;
	private int id;
	private int ir;

	public Buffer(int taille)
	{
		tableau = new int[taille];
		nbElements = 0;
		id = 0;
	}

	public int getTaille()
	{
		return tableau.length;
	}

	public void depot(int val) throws InterruptedException
	{
		while (nbElements == tableau.length)
		{
			Thread.sleep(10);
		}
		tableau[id] = val;
		id = (id + 1) % tableau.length;
		nbElements++;
		System.out.printf("Valeur\t%d\tdeposee dans la case %d\n", val, nbElements);
	}

	public int retrait() throws InterruptedException
	{
		while (nbElements == 0)
		{
			Thread.sleep(10);
		}
		int val = tableau[ir];
		ir = (ir + 1) % tableau.length;
		nbElements--;
		return val;
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
