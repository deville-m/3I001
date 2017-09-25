import java.io.*;

public class TestMatriceEntiere
{
	public static void main(String args[])
	{
		if (args.length != 2 && args.length != 1)
		{
			System.out.println("Syntax : exec first_matrix [second_matrix]");
			return ;
		}
		try
		{
			if (args.length == 1)
			{
				MatriceEntiere test = new MatriceEntiere(new File(args[0]));
				System.out.println("Original:");
				test.print();

				System.out.println("Transposed:");
				MatriceEntiere test_transposed = test.transpose();
				test_transposed.print();

				System.out.println("Original Scaled by 2:");
				MatriceEntiere test_scalar_multiplied = test.scalarMult(2);
				test_scalar_multiplied.print();
			}
			else
			{
				MatriceEntiere matrix1 = new MatriceEntiere(new File(args[0]));
				MatriceEntiere matrix2 = new MatriceEntiere(new File(args[1]));

				System.out.println(args[0] + " * " + args[1]);
				MatriceEntiere matrix_multiply = matrix1.multiply(matrix2);
				matrix_multiply.print();

				System.out.println(args[0] + " + " + args[1]);
				MatriceEntiere matrix_sum = matrix1.sum(matrix2);
				matrix_sum.print();
			}
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e);
		}
	}
}
