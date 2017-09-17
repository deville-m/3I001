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

			System.out.println("Scalar Multiplied by 2:");
			MatriceEntiere test_scalar_multiplied = test.scalarMult(2);
			test_scalar_multiplied.print();

			System.out.println("Original + Transposed:");
			MatriceEntiere test_sum = MatriceEntiere.sum(test, test_transposed);
			test_sum.print();

			System.out.println("Original * Transposed:");
			MatriceEntiere test_multiply = MatriceEntiere.multiply(test, test_transposed);
			test_multiply.print();
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e);
		}
	}
}
