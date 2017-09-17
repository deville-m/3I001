import java.io.*;

public class MatriceEntiere
{
	private int[][] matrix;
	private int nbl, nbc;

	public MatriceEntiere(int lignes, int colonnes)
	{
		matrix = new int[lignes][colonnes];
		nbl = lignes;
		nbc = colonnes;
	}
	
	public MatriceEntiere(File fichier) throws NumberFormatException, IOException
	{
		BufferedReader in = new BufferedReader(new FileReader(fichier));
		int i = 0;
		String line;
		String[] integers;

		nbl = Integer.parseInt(in.readLine());
		nbc = Integer.parseInt(in.readLine());
		matrix = new int[nbl][nbc];
		while ((line = in.readLine()) != null)
		{
			integers = line.split(" ");
			int j = 0;
			for(String temp : integers)
			{
				matrix[i][j] = Integer.parseInt(temp);
				j++;
			}
			i++;
		}
	}

	public int getElem(int i, int j) throws ArrayIndexOutOfBoundsException
	{
		return (matrix[i][j]);
	}

	public void setElem(int i, int j, int val) throws ArrayIndexOutOfBoundsException
	{
		matrix[i][j] = val;
	}

	public void fill(int scalar)
	{
		int i = 0;
		while (i < nbl)
		{
			int j = 0;
			while (j < nbc)
			{
				setElem(i, j, scalar);
				j++;
			}
			i++;
		}
	}

	public void nullify()
	{
		fill(0);
	}

	public MatriceEntiere transpose()
	{
		MatriceEntiere transposed = new MatriceEntiere(nbc, nbl);

		int i = 0;
		while (i < nbl)
		{
			int j = 0;
			while (j < nbc)
			{
				transposed.setElem(j, i, matrix[i][j]);
				j++;
			}
			i++;
		}
		return (transposed);
	}

	public MatriceEntiere scalarMult(int scalar)
	{
		MatriceEntiere mult = new MatriceEntiere(nbl, nbc);

		int i = 0;
		while (i < nbl)
		{
			int j = 0;
			while (j < nbc)
			{
				mult.matrix[i][j] = matrix[i][j] * scalar;
				j++;
			}
			i++;
		}
		return (mult);
	}

	public static MatriceEntiere sum(MatriceEntiere A, MatriceEntiere B) throws TailleNonConcordantesException
	{
		if (A.nbl != B.nbl || A.nbc != B.nbc)
			throw new TailleNonConcordantesException("A et B doivent etre de meme dimensions.");
		MatriceEntiere res = new MatriceEntiere(A.nbl, B.nbc);
		int i = 0;
		while (i < res.nbl)
		{
			int j = 0;
			while (j < res.nbc)
			{
				res.matrix[i][j] = A.matrix[i][j] + B.matrix[i][j];
				j++;
			}
			i++;
		}
		return (res);
	}

	public String toString()
	{
		String res = "";
		int i = 0;

		while (i < nbl)
		{
			int j = 0;
			while (j < nbc)
			{
				res += matrix[i][j] + " ";
				j++;
			}
			res += "\n";
			i++;
		}
		return (res);
	}

	public void print()
	{
		System.out.printf(this.toString());
	}
}
