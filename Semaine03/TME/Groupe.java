public class Groupe implements Runnable {
	private int id;
	private static int cpt = 0;
	private int nb;
	private Salle s;

	public Groupe(int nb, Salle s)
	{
		this.nb = nb;
		this.id = cpt++;
		this.s = s;
	}

	public void run()
	{
		s.reserver(this.nb);
	}
}
