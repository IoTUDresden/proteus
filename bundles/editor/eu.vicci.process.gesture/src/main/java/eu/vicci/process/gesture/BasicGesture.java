package eu.vicci.process.gesture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/**
 * BasicGesture stellt eine Geste mit allen Strokes die dazu geh�ren dar.
 * 
 * @author daniel
 * @param strokes Strokes der Geste um Dupletten bereinigt
 * @param pointsAtTime Anzahl der Punkte der Geste
 * @param continous staitsche Geste false, continuierliche Geste true
 * @param finished Geste beendet true 
 * 
 */
public class BasicGesture {
	private Set<Stroke> strokes = new LinkedHashSet<Stroke>(); 
	private int pointsAtTime; 
	private boolean finished = false;
	private boolean continous = false;



	/**
	 * Liefert alle Strokes der Geste
	 * 
	 * @return strokes
	 */
	public Set<Stroke> getStrokes() {
		
		return strokes;
	}

	/**
	 * Die Strokes austauschen damit die Geste geupdatet werden kann
	 * @param gesture
	 * @return strokes
	 */
	public Set<Stroke> reSetAll(BasicGesture gesture)
	{
		strokes.removeAll(strokes);
		strokes.addAll(gesture.getStrokes());
//		calculateAttributes();
		return strokes;
	}
	/**
	 * Liefert Stroke i der Geste
	 * 
	 * @param i
	 * @return
	 */
	public Stroke getStroke(int i )
	{
		int it = 0;
		Stroke stroke = new Stroke();
		Iterator<Stroke> iterator = strokes.iterator();
		while(iterator.hasNext())
		{
			stroke = (Stroke) iterator.next();
			it++;
			if (it == i)
			{
				break;
				
			}
		}
		return stroke;
	}
	/**
	 * F�gt ganze Strokes zu strokes hinzu
	 * 
	 * @param strokes
	 */
	public void addStrokes(List<Stroke> strokes)
	{
		strokes.addAll(strokes);
//		calculateAttributes();
	}
	/**
	 * F�gt einen Stroke zu strokes hinzu
	 * @param stroke
	 */
	public void addStroke(Stroke stroke)
	{
		strokes.add(stroke);
//		calculateAttributes();
	}
	/**
	 * Liefert alle Punte aus strokes
	 * 
	 * @return points
	 */
	public List<Point> getAllPoints()
	{
		List<Point> points = new ArrayList<Point>();
		Iterator<Stroke> iterator = strokes.iterator();
		while (iterator.hasNext()) {
			Stroke stroke = (Stroke) iterator.next();
			 points.addAll(stroke.getPoints());
		}
		return points;
	}
	/**
	 * Liefert die Anzahl der Stroke der Geste
	 * @return
	 */
	public Integer size()
	{
		return strokes.size();
	}
	/**
	 * Anzahl der Punkte der Geste setzen
	 * 
	 * @param pointsAtTime
	 */
	public void setPointsAtTime(int pointsAtTime) {
		this.pointsAtTime = pointsAtTime;
	}
	/**
	 * Liefert die Anzahl der Punkte der Geste
	 * @return
	 */
	public Integer getPointsAtTime ()
	{
		return pointsAtTime;
	}
	/**
	 * �berpr�ft, ob sich die Anzahl der Punkte ge�ndert hat
	 *  
	 * @return boolean
	 */
	public boolean hasModified()
	{
		
		return pointsAtTime != getAllPoints().size();
	}
	/**
	 * Strokes der Geste L�schen 
	 * @return
	 */
	public Set<Stroke> clear()
	{
		strokes.clear();
		return strokes;
	}
	/**
	 * Liefert true wenn Geste kontinuierliche Geste ist
	 * @return
	 */
	public boolean isContinous() {
		return continous;
	}
	/**
	 * Markieren einer kontinuierlichen Geste
	 * @param continous
	 */
	public void setContinous(boolean continous) {
		this.continous = continous;
	}
	/**
	 * Liefert true wenn Geste beendet ist
	 * @return
	 */
	public boolean getFinished ()
	{
		return finished;
	}
	/**
	 * Markieren eine beendeten Geste
	 * @param isFinished
	 */
	public void isFinished (boolean isFinished)
	{
		finished = isFinished;
	}
}