public class HelloWorld implements Runnable {
	private String ville;
	private int id;
	private static int cpt = 1;

	public HelloWorld(String ville)
	{
		this.ville = ville;
		id = cpt++;
	}

	public void run()
	{
		System.out.println("thread " + id + " salue " + ville);
	}
}
