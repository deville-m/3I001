import graphique.Fenetre;
import java.awt.Point;

public class Question1 {
	public static void main(String[] args)
	{
		Fenetre f = new Fenetre(1000, 1000, "Triangle");
		Point p1 = new Point(100,100);
		Point p2 = new Point(900,900);
		Point p3 = new Point(100,900);
		f.tracerLignePointAPoint(p1, p2);
		f.tracerLignePointAPoint(p1, p3);
		f.tracerLignePointAPoint(p2, p3);
	}
}
