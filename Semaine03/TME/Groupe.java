public class Groupe {
	private int id;
	private int nb;
	private static int cpt = 0;

	public Groupe(int nb)
	{
		this.nb = nb;
		this.id = cpt++;
	}

	public Groupe demande()
	{
		return (this);
	}
}
