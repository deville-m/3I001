public class Salle {
	private int nbPlacesParRang;
	private int nbRangs;
	private boolean[][] tableau;
	private int capacite;

	public Salle(int nbRangs, int nbPlacesParRang)
	{
		this.nbRangs = nbRangs;
		this.nbPlacesParRang = nbPlacesParRang;
		capacite = nbRangs * nbPlacesParRang;
		tableau = new boolean[nbRangs][nbPlacesParRang];

		for (int i = 0; i < nbRangs; i++)
		{
			for (int j = 0; j < nbPlacesParRang; j++)
			{
				tableau[i][j] = true;
			}
		}
	}

	public boolean CapaciteOK(int n)
	{
		return ((capacite < n) ? false : true);
	}

	public int nContiguesAuRangI(int n, int i)
	{
		int cpt = 0;
		int deb = -1;

		for(int j = 0; cpt < n && j < nbPlacesParRang; j++)
		{
			if (tableau[i][j])
			{
				cpt = 0;
				deb = -1;
			}
			else
			{
				cpt++;
				if (deb == -1)
					deb = j;
			}
		}
		return (deb);
	}

	public boolean reserverContigue(int n)
	{
		int deb = -1, i;

		for(i = 0; i < nbRangs && deb != -1; i++)
		{
			deb = nContiguesAuRangI(n, i);
		}
		i--;

		if (deb != -1)
		{
			capacite -= n;
			while (n > 0)
			{
				tableau[i][deb] = true;
				deb++;
				n--;
			}
			return (true);
		}
		else
			return (false);
	}

	public synchronized boolean reserver(int n)
	{
		if (!CapaciteOK(n))
		{
			return (false);
		}

		if (!reserverContigue(n))
		{
			for(int i = 0; i < nbRangs && n > 0; i++)
			{
				for(int j = 0; j < nbPlacesParRang && n > 0; j++)
				{
					if (!tableau[i][j])
					{
						tableau[i][j] = true;
						n--;
					}
				}
			}
		}
		return (true);
	}

	public String toString()
	{
		String res = "";

		for(int i = 0; i < nbRangs; i++)
		{
			for(int j = 0; j < nbPlacesParRang; j++)
			{
				res += (tableau[i][j]) ? "1 " : "0 ";
			}
			res += "\n";
		}
		return (res);
	}
}
