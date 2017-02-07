package eu.vicci.process.gesture;

import java.util.ArrayList;
import java.util.List;

public class Stroke {

   public Stroke() {
      
      minPoint = new Point(Double.MAX_VALUE, Double.MAX_VALUE);
      maxPoint = new Point(-Double.MAX_VALUE, -Double.MAX_VALUE);
   }
   
	/**
	 * In Stroke sind Strokes definiert
	 *
	 * @author daniel
	 * @param points Punkteliste
	 * @param directNeighbours sind die Strokes mit einem unmittelbaren Nachbarn
	 * @param minPoint minimaler Punkt eines Strokes
	 * @param maxPoint maximaler Puntk eines Strokes
	 */
	private List <Point> points = new ArrayList<Point>();
	private List<Stroke> directNeighbours = new ArrayList<Stroke>(); //
	private boolean wasModified;
	private Point minPoint;
	private Point maxPoint;

	/**
	 * Direkten Nachbar hinzufuegen
	 *
	 * @param directNeighbour
	 */
	public void addDirectNeighbour(Stroke directNeighbour)
	{
		directNeighbours.add(directNeighbour);
	}

	/**
	 * Liefert Liste der direkten Nachbarn
	 *
	 * @return directNeighbours
	 */
	public List<Stroke> getDirectNeighbours() {
		return directNeighbours;
	}

	/**
	 * Berechnet miinimalen / maximalen Punkt des Strokes
	 *
	 * @param minPoint Minimum
	 * @param maxPoint Maximum
	 */
	public void calculateMinMax()
	{
		/**
		 * Min mit Max. und Max mit Min. initialisieren
		 */
		this.minPoint=new Point(Double.MAX_VALUE,Double.MAX_VALUE);
		this.maxPoint=new Point(0.0,0.0);
		if(points.size()>2)//das ist noetig wegen der basicGesture [] die als Platzhalter dient
		{
		    for (Point pointR : points)
		    {
				if (this.minPoint.X > pointR.X)//
				{
					minPoint.X = pointR.X; //Punkt mit Minimum X
				}
				if (this.maxPoint.X < pointR.X)
				{
					maxPoint.X = pointR.X;// Punkt mit Maximum X
				}
				if (this.minPoint.Y > pointR.Y)
				{
					minPoint.Y = pointR.Y; // Punkt mit Minimum Y
				}
				if (this.maxPoint.Y < pointR.Y)
				{
					maxPoint.Y = pointR.Y; // Punkt mit Maximum Y
				}
		    }
		}
		else
		{
			minPoint= new Point(0.0,0.0);
			maxPoint= new Point(0.0,0.0);
		}
	}

	/**
	 * Punkt an points anfuegen aber nur wenn sie innerhalb der erwarteten Box liegen, sonst werden sie verworfen
	 * @param point
	 */
	public void addPoint(Point point)
	{
		points.add(point);
		
		if (point.X > maxPoint.X)
		   maxPoint.X = point.X;
		
		if (point.X < minPoint.X)
		   minPoint.X = point.X;

		if (point.Y > maxPoint.Y)
		   maxPoint.Y = point.Y;
	      
		if (point.Y < minPoint.Y)
		   minPoint.Y = point.Y;
	}

	/**
	 * Einen Stroke an den Stroke anfuegen
	 * @param stroke
	 */
	public void addPointsOfStroke(Stroke stroke)
	{
		points.addAll(stroke.getPoints());
	}

	/**
	 * Neue Punkte eines Strokes die nicht im Stroke vorhanden sind anhaengen
	 * @param stroke
	 */
	public void addNewPartOfStroke(Stroke stroke)
	{
		for (int i = 0; i < stroke.getSize(); i++)
		{
			if (!points.contains(stroke.getPoint(i)))
			{
				points.add(stroke.getPoint(i));
			}
		}
	}

	/**
	 * Liefert true wenn Stroke leer ist
	 * @return
	 */
	public boolean isEmpty()
	{
		return points.isEmpty();
	}

	/**
	 * Liefert Punkt an Position i
	 * @param i
	 * @return
	 */
	public Point getPoint(int i)
	{
		return points.get(i);
	}

	/**
	 * Liefert Anzahl der Punkte des Strokes
	 * @return
	 */
	public Integer getSize ()
	{
		return points.size();
	}

	/**
	 * Liefert minimalen Punkt
	 * @return minPoint
	 */
	public Point getMinPoint() {
		return minPoint;
	}

	/**
	 * Liefert maximalen Punkt
	 * @return maxPoint
	 */
	public Point getMaxPoint() {
		return maxPoint;
	}

	/**
	 * Liefert Liste der Punkte
	 * @return
	 */
	public List<Point> getPoints() {
		return points;
	}

	/**
	 * Loescht Liste
	 * @return null
	 */
	public List <Point> clearStroke()
	{
		//Unschoen Testen
		//points.clear();
		//return points
		return null;
	}

	/**
	 * True setzen wenn sich stroke geaendert hat
	 * @param modified
	 */
	public void setModified(boolean modified)
	{
		this.wasModified = modified;
	}

	public boolean hasModified()
	{
		return wasModified;
	}

	/**
	 * Prueft ob ein neuer Punkt innerhalb einer Box um den letzten strokeTokerance Punkt liegt
	 * Erster Versuch einer Fehlerkorrektur fuer das Surface
	 *
	 * @param point
	 * @return
	 */
//	public boolean expectedPoint(PointR point)
//	{
//		/**
//		 * Wenn wenn schon ein Punkt in points ist wird gepr�ft ob der n�chste innerhalb der Box ist
//		 */
//		if (points.size() >0 )
//		{
//			int lastIndex = points.size()-1;
//
//			PointR lastPoint = points.get(lastIndex);
//			Interval pointX = new Interval (point.X , point.X);
//			Interval pointY = new Interval (point.Y , point.Y);
//			Interval miMaX = new Interval (lastPoint.X-Editor.strokeTolerance , lastPoint.X+Editor.strokeTolerance );
//			Interval miMaY = new Interval (lastPoint.Y-Editor.strokeTolerance , lastPoint.Y+Editor.strokeTolerance);
//			if(pointX.subset(miMaX)&&pointY.subset(miMaY))
//			{
//
//				return true;
//			}
//			else
//			{
//
//				return false;
//			}
//		}
//		else
//		{
//
//			return true;
//		}
//	}
}