import graphique.Fenetre;
import java.awt.Point;

public class DessineLigne extends Thread{
	private Point p1;
	private Point p2;
	private Fenetre f;

	public DessineLigne(Point p1, Point p2, Fenetre f)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.f = f;
	}

	public void run()
	{
		f.tracerLignePointAPoint(p1, p2);
	}
}
