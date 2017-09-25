import graphique.Fenetre;
import java.awt.Point;

public class Question3 {
	public static void main(String[] args)
	{
		Fenetre f = new Fenetre(1000, 1000, "Triangle");
		Point p1 = new Point(100,100);
		Point p2 = new Point(900,900);
		Point p3 = new Point(100,900);
		Thread[] th= new Thread[3];
		th[0] = new Thread(new DessineLigne(p1, p2, f));
		th[1] = new Thread(new DessineLigne(p3, p2, f));
		th[2] = new Thread(new DessineLigne(p1, p3, f));
		for(int i = 0; i < 3; i++)
		{
			th[i].start();
		}
	}
}
