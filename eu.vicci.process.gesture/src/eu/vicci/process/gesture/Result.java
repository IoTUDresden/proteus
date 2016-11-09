package eu.vicci.process.gesture;

import java.util.Iterator;
import java.util.Set;

import eu.vicci.process.gesture.recognizer.ndollar.NBestList;

public class Result {

	BasicGesture gesture = new BasicGesture();
	NBestList recognitionResult = new NBestList();
	private Point centreBox;
	private Point startBox;
	private Point endBox;
	private int dimensionX;
	private int dimensionY;
	private Point firstPoint;
	private Point lastPoint;
	private String name;
	private double distance;
	private double angle;
	private double score;
	private String[] resultNamesInOrderOfRecognition;

	public void setGesture(BasicGesture basicGesture)
	{
		gesture = basicGesture;
		calculateAttributes();
	}

	public void setRecognitionResult(NBestList result)
	{
		recognitionResult = result;
		setName(recognitionResult.getName());
		score = result.getScore();
		distance = result.getDistance();
		angle=  result.getAngle();
		resultNamesInOrderOfRecognition =  result.getNames();
	}

	public void setName(String newName)
	{
		name = newName;
	}

	public void calculateAttributes()
	{
		Set<Stroke> strokes = gesture.getStrokes();
		int it = 0;
		Point minX = new Point(Double.MAX_VALUE,Double.MAX_VALUE);
		Point maxX = new Point(0.0,0.0);
		Point minY = new Point(Double.MAX_VALUE,Double.MAX_VALUE);
		Point maxY = new Point(0.0,0.0);
		Stroke stroke = new Stroke();
		Iterator<Stroke> iterator = strokes.iterator();
		while(iterator.hasNext())
		{
			stroke = (Stroke) iterator.next();
			stroke.calculateMinMax();

			if (it == 0)
			{
				firstPoint = new Point(stroke.getPoint(0).X,stroke.getPoint(0).Y);
			}
			if (minX.X > stroke.getMinPoint().X)
			{
				minX = stroke.getMinPoint();
			}
			if (maxX.X< stroke.getMaxPoint().X)
			{
				maxX= stroke.getMaxPoint();
			}
			if (minY.Y > stroke.getMinPoint().Y)
			{
				minY = stroke.getMinPoint();
			}
			if (maxY.Y< stroke.getMaxPoint().Y)
			{
				maxY= stroke.getMaxPoint();
			}
			if(!iterator.hasNext())
			{
				int size = stroke.getSize()-1;
				lastPoint = new Point(stroke.getPoint(size).X,stroke.getPoint(size).Y);
			}
			it++;
		}
		dimensionX = (int) (maxX.X-minX.X);
		dimensionY = (int) (maxY.Y-minY.Y);
		startBox = new Point(minX.X, minY.Y);
		endBox = new Point(maxX.X, maxY.Y);
		centreBox = new Point(((maxX.X-minX.X)/2),((maxY.Y-minY.Y)/2));
	}

	public BasicGesture getGesture() {
		return gesture;
	}

	public NBestList getRecognitionResult() {
		return recognitionResult;
	}

	public Point getCentreBox() {
		return centreBox;
	}

	public Point getStartBox() {
		return startBox;
	}

	public Point getEndBox() {
		return endBox;
	}

	public int getDimensionX() {
		return dimensionX;
	}

	public int getDimensionY() {
		return dimensionY;
	}

	public Point getFirstPoint() {
		return firstPoint;
	}

	public Point getLastPoint() {
		return lastPoint;
	}

	public String getName() {
		return name;
	}

	public double getDistance() {
		return distance;
	}

	public double getAngle() {
		return angle;
	}

	public double getScore() {
		return score;
	}

	public String[] getResultNamesInOrderOfRecognition() {
		return resultNamesInOrderOfRecognition;
	}
}
