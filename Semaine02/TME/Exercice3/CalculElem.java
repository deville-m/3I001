public class CalculElem implements Runnable {
	private MatriceEntiere m;
	private MatriceEntiere m1;
	private MatriceEntiere m2;
	private int i, j;

	public CalculElem(MatriceEntiere m, MatriceEntiere m1, int i, MatriceEntiere m2, int j)
	{
		this.m = m;
		this.m1 = m1;
		this.m2 = m2;
		this.i = i;
		this.j = j;
	}

	public void run()
	{
		try
		{
			m.setElem(i, j, MatriceEntiere.produitLigneColonne(m1, i, m2, j));
		}
		catch (TaillesNonConcordantesException e)
		{
			System.err.println(e);
		}
	}
}
