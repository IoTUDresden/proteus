package eu.vicci.process.gesture;

import java.util.ArrayList;
import java.util.List;

public class PreProcessor {

    /**
	 * Preprocessor uebernimmt die Vorverarbeitung der Strokes
	 * Er erkennt zusammenhaengende Strokes und fuegt sie zu einer Geste zusammen
	 * Er erkennt wann eine Geste beendet ist und markiert diese
	 */
	public static final double strokeTolerance = 80;//der Box die zusaetzlich um die Min/Max Werte des Strokes gelegt wird in Punkten wird dazu genutzt um 1. Strokes einen Nachbarn zuzuordnen und neue Punkte fuer einen Stroke muessen auch innerhalb dieser Toleranz liegen
	private static final int coverage = 1; // Prozentualer Anteil den der zweite Strokes innerhalb des ersten liegen muss um die Box zu erweitern
	private List<BasicGesture> gestures = new ArrayList<BasicGesture>();
	List<BasicGesture> findBasicGestures = new ArrayList<BasicGesture>();
	BasicGesture finishedBasicGesture = new BasicGesture();

	int timerOffset;
	int finishOffset;

	public PreProcessor()
	{

	}

	public BasicGesture preProcess(List<Stroke> strokes)
	{
//		List<BasicGesture> findBasicGestures = new ArrayList<BasicGesture>();
		BasicGesture finishedGesture = new BasicGesture();
		findDirectNeighbour(strokes);
		findBasicGestures = findBasicGestures(strokes);
		finishedGesture = gestureFinished(findBasicGestures);
//		finishedBasicGesture.clear();
		return finishedGesture;
	}
	/**
	 * process arbeitet die Strokes ab wenn nicht auf fertige gesten geprueft werden muss
	 * @param strokes
	 * @return
	 */
	public List<BasicGesture> process(List<Stroke> strokes)
	{
		List<BasicGesture> findBasicGestures = new ArrayList<BasicGesture>();
		findDirectNeighbour(strokes);
		findBasicGestures = findBasicGestures(strokes);
		return findBasicGestures;
	}


	/**
	 * Findet den direkten Nachbar eines Strokes. <P>
	 * Zwei Strokes sind direkter Nachbar wenn sich ein Stroke innerhablb der der durch strokeTolerance definierten Box um den Stroke befindet
	 * Es werden nur Intervalle nicht die Punkte ueberprueft
	 *
	 * @param strokes Liste mit Strokes die auf direkte Nachbarn untersucht wird
	 * @param firstStroke erster Vergleichsstroke
	 * @param secondStroke zweiter Vergleichsstroke
	 * @param startSecondStrokeIndex laeuft mit damit nicht die Strokes die schon geprueft wurden nochmal geprueft werden
	 */
	public void findDirectNeighbour(List<Stroke> strokes)
	{
//		System.out.println("== FIND DIRECT NEIGHBOUR ==");
		int startSecondStrokeIndex = 0;
		Stroke firstStroke = new Stroke();
		if (strokes.size() > 1) // Wenn mehr als ein Stroke
		{
			/**
			 * Schleife fuer das erste Intervall
			 */

			for (int x = 0; x < strokes.size() ; x++)
			{
				firstStroke = strokes.get(x);

				/**
				 * Min/Max fuer das erste Intervall berechnen
				 */
				firstStroke.calculateMinMax();
				/**
				 * Erstes Intervall + strokeTolerance einema fuer X einmal fuer Y
				 */
				Interval miMaX1 = new Interval(firstStroke.getMinPoint().X-strokeTolerance, firstStroke.getMaxPoint().X+strokeTolerance );
				Interval miMaY1 = new Interval(firstStroke.getMinPoint().Y-strokeTolerance, firstStroke.getMaxPoint().Y+strokeTolerance );
				/**
				 * Schleife fuer den zweiten Stroke
				 * Es muessen immer alle Beziehungen durchgegangen werden, damit spaeter zwei GEsten die eigentlich zusammengehoeren auch zusammengepackt werden, daher startSecondStrokeIndex = 0
				 * und Subgesten so ausgeschlossen werden
				 */
//				startSecondStrokeIndex++;
				for (int y = startSecondStrokeIndex; y < strokes.size(); y++) //Schleife fuer das zweite Interval
				{
					if (x == y)
					{

					}
					else
					{
					Stroke secondStroke = strokes.get(y);
					secondStroke.calculateMinMax();

					Interval miMaX2 = new Interval(secondStroke.getMinPoint().X, secondStroke.getMaxPoint().X);
					Interval miMaY2 = new Interval(secondStroke.getMinPoint().Y, secondStroke.getMaxPoint().Y);

					if ((miMaX2.percent(miMaX1)) > coverage && (miMaY2.percent(miMaY1)) > coverage) // X und Y beider Intervalle zu min h% Prozent innerhalb der Box
					{
						/**
						 * Zusammenfuehren der direkten Nchbarn
						 */
//						System.out.println("stroke " +x +" und stroke " +y +" sind nachbarn");
						firstStroke.addDirectNeighbour(secondStroke);
					}
				}}
			}
		}
	}

	/**
	 * Findet alle Strokes die zu einer Geste gehoehren, fasst sie zu einer BasicGesture zusammen
	 *
	 * @param strokes Liste der auf BasicGestures zu untersucheden Strokes
	 * @param basicGestures Alle zusammengehoerigen Gesten
	 * @param stroke Aktuell zu beabreitender Stroke
	 * @param basicgesture BasicGesture Geste
	 */
	public List<BasicGesture> findBasicGestures(List<Stroke> strokes) // hier muss doch eigentlich directNeigbour rein
	{

		for (int i = 0; i<strokes.size(); i++)
		{
			boolean contains = false;
			for (int j = 0; j < gestures.size(); j++)
			{
				//Stroke ist schon in der Geste, pr�fen ob der Stroke nachbarn hat dann GEste erweitern
				if (gestures.get(j).getStrokes().contains(strokes.get(i)))
				{

					if(strokes.get(i).getDirectNeighbours().size()>0)
					{
						findRelatedStrokes(strokes.get(i), gestures.get(j));
					}
					contains = true;
					break;
				}
			}
			// wenn nicht in der geste wird neue geste angelegt.
			if (! contains)
			{
				BasicGesture newGesture = new BasicGesture();
				findRelatedStrokes(strokes.get(i), newGesture);
				gestures.add(newGesture);
			}
			//doppelte gesten werden automatisch, (hashSet) geloescht, es koennen aber subgesten entstehen eventuell schon entstandene subgesten wieder loeschen
			// sehr unschoen geloest
			for (int j = 0; j < gestures.size(); j++)
			{
				for (int j2 = 0; j2 < gestures.size(); j2++)
				{
					for (int j3 = 0; j3 < strokes.size(); j3++)
					{

						// Wenn Stroke in Geste j und Geste j2, und Geste j ungeleich Geste j2, dann loesche die kleinere Geste Subgeste
						if(gestures.get(j).getStrokes().contains(strokes.get(j3)) && gestures.get(j2).getStrokes().contains(strokes.get(j3)) && j!=j2 )
						{
							System.out.println("Delete Subgesture");
							if (gestures.get(j).getStrokes().size()> gestures.get(j2).getStrokes().size())
							{
								gestures.remove(gestures.get(j2));
								break;
							}
							if (gestures.get(j).getStrokes().size()< gestures.get(j2).getStrokes().size())
							{
								gestures.remove(gestures.get(j));
								break;
							}
						}
					}
				}
			}
		}
		return gestures;
	}

	/**
	 * Findet alle zusammengehoerigen Strokes<p>
	 * Druchlaeuft rekursiv alle Strokes die direkte Nachbarn sind<p>
	 * Es wird die transitive Huelle aller Strokes gesucht
	 *
	 * @param stroke
	 * @param gesture
	 * @param directNeighbours Liste der Strokes die direkte Nachbarn sind
	 * @see findBasicGesture()
	 * @see findRelatedStrokes()
	 */
	private void findRelatedStrokes(Stroke stroke, BasicGesture gesture){  // Suche den Nachbarn eines Strokes, wenn er einen Nachbarn hat, dann suche dessen Nachbarn
//		System.out.println("~~ FIND RELATED STROKES ~~");

		gesture.addStroke(stroke);
		List<Stroke> directNeighbours = stroke.getDirectNeighbours();
		for (int i = 0; i < directNeighbours.size(); i++)
		{
			Stroke neighbour= directNeighbours.get(i);
			if(!(gesture.getStrokes().contains(neighbour)))
					{
			findRelatedStrokes(neighbour, gesture);
					}
		}
	}

	/**
	 * Prueft ob eine Geste beendet ist<P>
	 * Wenn sich die Anzahl der Punkte einer Geste nach finishOffset Timeraufrufen nicht mehr aendert ist sie fertig
	 *
	 * @param gestures Liste der BasicGestures
	 * @param allPoints Recognizer erwartet alle Punkte am Stueck
	 * @param result Recognizer Ergebnis
	 */
	private BasicGesture gestureFinished(List<BasicGesture> gestures)
	{
//		System.out.println("** GESTURE FINISHED **");
//		System.out.println(gestures);
		for (int i = 0; i < gestures.size(); i++)
		{
			finishedBasicGesture = gestures.get(i);
			if(! finishedBasicGesture.getFinished())
			{
				/**
				 * Wenn sich die Geste geaendert hat und der TimerOffset kleiner finishOffset ist wird die Anzahl der Punkte neu gesetzt und die Recognition nicht ausgeloest
				 *
				 */
//				System.out.println("finishedBasicGesture "+finishedBasicGesture+ " modified "+finishedBasicGesture.hasModified());
				if (finishedBasicGesture.hasModified() &&  timerOffset < finishOffset)
				{
					finishedBasicGesture.setPointsAtTime(finishedBasicGesture.getAllPoints().size());
				}
				/**
				 * Punkte werden fuer den Recognizer vorbereitet und zum Recognizer geschickt
				 */
				else
				{
					finishedBasicGesture.isFinished(true);
					System.out.println(" PreProcessor gestureFinished " + finishedBasicGesture.getFinished());
					gestures.remove(finishedBasicGesture);
					break;
				}
			}
		}
		return (finishedBasicGesture);
	}

	/**
	 * Timer aus inputProcessing um zu testen wann eine Geste beendet ist
	 * @param tOffset
	 */
	public void setTimerOffset( int tOffset)
	{
		timerOffset = tOffset;
	}

	/**
	 * TimerNachlauf aus inputProcessing setzen
	 * @param fOffset
	 */
	public void setFinishOffset(int fOffset)
	{
		finishOffset = fOffset;
	}

	/**
	 * Loescht den PreProcessor
	 */
	public void clear()
	{
		finishedBasicGesture.clear();
		gestures.clear();
		findBasicGestures.clear();
		finishOffset=0;
		timerOffset=0;
	}
}
