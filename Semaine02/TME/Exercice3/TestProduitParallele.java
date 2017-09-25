import java.io.*;

public class TestProduitParallele
{
	public static void main(String args[])
	{
		if (args.length != 2)
		{
			System.err.println("Syntax : exec first_matrix second_matrix");
			return ;
		}
		try
		{
			MatriceEntiere matrix1 = new MatriceEntiere(new File(args[0]));
			MatriceEntiere matrix2 = new MatriceEntiere(new File(args[1]));
			int nbl = matrix1.getNbLignes();
			int nbc = matrix2.getNbColonnes();
			MatriceEntiere res = new MatriceEntiere(nbl, nbc);
			Thread[][] th = new Thread[nbl][nbc];
			System.out.println(args[0] + " * " + args[1]);
			for(int i = 0; i < nbl; i++)
			{
				for(int j = 0; j < nbc; j++)
				{
					th[i][j] = new Thread(new CalculElem(res, matrix1, i, matrix2, j));
				}
			}
			res.print();
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e);
		}
	}
}
