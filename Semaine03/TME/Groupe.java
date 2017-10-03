import java.util.ArrayList;

public class Groupe implements Runnable {
	private int id;
	private static int cpt = 0;
	private int nb;
	private Salle s;
	private ArrayList<Integer[]> listPos;

	public Groupe(int nb, Salle s)
	{
		this.nb = nb;
		this.id = cpt++;
		this.s = s;
		listPos = new ArrayList<Integer[]>();
	}

	public void addPos(int rang, int place)
	{
		Integer[] tmp = {rang, place};
		listPos.add(tmp);
	}

	public void cancelAll()
	{
		while (!listPos.isEmpty())
		{
			this.cancelOne();
		}
	}

	public void cancelOne()
	{
		if (!listPos.isEmpty())
		{
			Integer[] tmp = listPos.get(0);
			listPos.remove(0);
			s.cancel(tmp[0], tmp[1]);
		}
	}

	public void run()
	{
		s.reserver(this.nb);
	}
}
