import java.io.*;

public class TestMatriceEntiere
{
	public static void main(String args[])
	{
		try
		{
			MatriceEntiere test = new MatriceEntiere(new File("test.data"));
			test.print();
		}
		catch (IOException e)
		{
			System.err.println("Error: " + e);
		}
	}
}
