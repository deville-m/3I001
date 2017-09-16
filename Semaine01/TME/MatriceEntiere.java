import java.io.*;

public class MatriceEntiere
{
	private int[][] matrix;
	private int nbl, nbc;

	public MatriceEntiere(int lignes, int colonnes)
	{
		matrix = new int[lignes][colonnes];
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

	public MatriceEntiere transpose(MatriceEntiere A)
	{
		MatriceEntiere A_t = new MatriceEntiere(nbc, nbl);

		int i = 0;
		while (i < A.nbl)
		{
			int j = 0;
			while (j < A.nbc)
			{
				A_t.setElem(j, i, A.getElem(i, j));
				j++;
			}
			i++;
		}
		return (A_t);
	}

	public String toString()
	{
		String res = "";
		int i = 0;

		while (i < nbl)
		{
			int j = 0;
			while (j < nbl)
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
