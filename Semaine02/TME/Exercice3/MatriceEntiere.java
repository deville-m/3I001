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

	public int getNbLignes()
	{
		return (nbl);
	}

	public int getNbColonnes()
	{
		return (nbc);
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

	public MatriceEntiere sum(MatriceEntiere B) throws TaillesNonConcordantesException
	{
		if (nbl != B.nbl || nbc != B.nbc)
			throw new TaillesNonConcordantesException("A et B doivent etre de meme dimensions.");

		MatriceEntiere res = new MatriceEntiere(nbl, B.nbc);
		int i = 0;
		while (i < res.nbl)
		{
			int j = 0;
			while (j < res.nbc)
			{
				res.matrix[i][j] = matrix[i][j] + B.matrix[i][j];
				j++;
			}
			i++;
		}
		return (res);
	}

	public MatriceEntiere multiply(MatriceEntiere B) throws TaillesNonConcordantesException
	{
		if (nbc != B.nbl)
			throw new TaillesNonConcordantesException("A doit avoir le meme nombre de colonnes que le nombre de lignes de B");

		MatriceEntiere res = new MatriceEntiere(nbl, B.nbc);
		res.nullify();
		int i = 0;
		while (i < res.nbl)
		{
			int j = 0;
			while (j < res.nbc)
			{
				int k = 0;
				while (k < nbc)
				{
					res.matrix[i][j] += matrix[i][k] * B.matrix[k][j];
					k++;
				}
				j++;
			}
			i++;
		}
		return (res);
	}

	public static int produitLigneColonne(MatriceEntiere m1, int i, MatriceEntiere m2, int j) throws TaillesNonConcordantesException
	{
		if (m1.nbc != m2.nbl)
			throw new TaillesNonConcordantesException("A doit avoir le meme nombre de colonnes que le nombre de lignes de B");
		int k = 0, somme = 0;
		while (k < m1.nbc)
		{
			somme += m1.matrix[i][k] * m2.matrix[j][k];
			k++;
		}
		return somme;
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
