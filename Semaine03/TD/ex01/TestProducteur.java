public class TestProducteur {

public static void main(String[] args)
	{
		Buffer b = new Buffer(5);
		Thread t = new Thread(new Producteur(b));
		t.start();
		try {
			t.join();
			System.out.println(b.toString());
		}
		catch (InterruptedException e)
		{
			System.out.println(e);
		}
	}
}
