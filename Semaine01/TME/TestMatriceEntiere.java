import java.io.*;

public class TestMatriceEntiere
{
	public static void main(String args[])
	{
		try
		{
			MatriceEntiere test = new MatriceEntiere(new File("test.data"));
			System.out.println("Original:");
			test.print();
			System.out.println("Transposed:");
			MatriceEntiere test_transposed = test.transpose();
			test_transposed.print();
		}
		catch (IOException e)
		{
			System.err.println("Error: " + e);
		}
	}
}
