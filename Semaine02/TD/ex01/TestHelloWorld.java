public class TestHelloWorld {
	public static void main(String[] args) {
		Thread[] th = new Thread[3];
		th[0] = new Thread(new HelloWorld("Londres"));
		th[1] = new Thread(new HelloWorld("Tokyo"));
		th[2] = new Thread(new HelloWorld("Paris"));
		th[0].start();
		th[1].start();
		th[2].start();
	}
}
