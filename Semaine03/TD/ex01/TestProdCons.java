public class TestProdCons {
	public static void main(String[] args)
	{
		Buffer b = new Buffer(5);
		Thread tp = new Thread(new Producteur(b));
		Thread te = new Thread(new Consommateur(b));
		tp.start();
		te.start();
		try
		{
			tp.join();
			te.join();
			System.out.println("Done");
		}
		catch (Exception e)
		{
			System.out.println("WOW");
		}
	}
}
