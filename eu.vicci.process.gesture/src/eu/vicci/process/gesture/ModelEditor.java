package eu.vicci.process.gesture;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.widgets.Touch;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import eu.vicci.process.gesture.recognizer.ndollar.NBestList;
import eu.vicci.process.gesture.recognizer.ndollar.NDollarParameters;
import eu.vicci.process.gesture.recognizer.ndollar.NDollarRecognizer;
import eu.vicci.process.gesture.recognizer.ndollar.Utils;
/**
 * Mit dem Modeleditor koennen Multistroke Modelle (Pattern/Gesten) als Referenzmuster erstellt werden auf die der $N-Recognizer prueft<p>
 * Hinterlegte Modelle (Pattern/Gesten) koennen geladen werden. Im momentanen Zustand muessen die zu ladenden Modelle (Pattern/Gesten) im $N-Recognizer-XML Format vorliegen (vergleiche XMl-files nach dem speichern)<p>
 * Diese Version des ModelEditor unterscheidet sich im Datenmodel von der des Recognizers der fuer die Eclipseinstanz erstellt wurde. Hier werden noch Vectoren verwendet.
 *
 * @author Daniel Schropp
 * @version  0.5, 08/02/13
 *
 */

public class ModelEditor extends Frame implements MouseMotionListener,
	MouseListener, ActionListener,MouseMoveListener {

    /**
     *
     */
    private static final long serialVersionUID = 6137493782116306484L;

    /**
     * Model Editor
     * 
     * @param recognizer
     *            Recognizer Instanz
     * @param samplesDir
     *            Verzeichnispfad in dem die Samples hinterlegt sind
     * @param points
     *            aktuelle Punkte
     * @param strokes
     *            nach Beendigung eines Strokes werden die points in einem
     *            strokes abgelegt
     * @param bufImage
     * @param bufG
     * @param infoLabel
     *            Label fuer die Rueckmeldungen des Editors fuer den Nutzer
     * @param save
     *            Speicherknopf
     * @param load
     *            Ladenknopf
     * @param recognize
     *            Recognizeknopf
     * @param saveName
     *            Texteingabefeld fuer den Name des zu speichernden Pattern
     * @param loadFilde
     *            Textfeld in dem der Name des geladenen Pattern erscheint
     * @param clear
     *            Canvas loeschen
     * 
     */
	private static NDollarRecognizer recognizer = null;
	private static String samplesDir = "samples" + File.separator + "staticSamples";

	private Vector<Point> points = new Vector<Point>();
	private Vector<Point> touchPoints = new Vector<Point>();
	private Vector<Vector<Point>> strokes = new Vector<Vector<Point>>();
	private Vector<Vector<Point>> touchStrokes = new Vector<Vector<Point>>();
//	Folgendes ist die Vorbereitung alles auf meine Datenstruktur umzubauen, wird wenn Zeit vorhanden ist gemacht
//	List<Stroke> gesture = new ArrayList<Stroke>();
//	Stroke currentStroke = new Stroke();
//	private boolean automaticRecognition=false;

	private Image bufImage;
	private Graphics bufG;

	private Label infoLabel;

	private Button save;
	private Button load;
	private Button recognize;
	private Button clear;
	private Button reloadModel;
	private TextField saveName;
	private TextField loadFile;

//	private JCheckBox checkBoxRec;

	/**
	 * Mainmethode
	 * @param args
	 *
	 */
	public static void main(String[] args) {
		recognizer = new NDollarRecognizer();
		readSamples();
		new ModelEditor();
	}

	public void touch(TouchEvent event) {

	    // die Mausevents muessen noch an Touch angepasst werden
		Touch touches[] = event.touches;

		// Idee ist zu jedem Touch ein Stroke zuweisen und mit dem Koordinaten befuellen
		//System.out.println(touches.toString());
		System.out.println("touches.length" + touches.length);
		for (int i = 0; i < touches.length; i++)
		{
			Touch currentTouch = touches[i];

			if (currentTouch.state == 1) // wenn Touch beginnt
			{
			    System.out.println("touch start");
			    touchPoints.add(new Point(currentTouch.x, currentTouch.y));

			    touchStrokes.add(touchPoints);
//
			}
			touchPoints = touchStrokes.elementAt(i);

			if (currentTouch.state == 2) // Wenn Touch  ausgefuehrt wird
			{
//			   		System.out.println("currentTouchStrokes.size()"+currentTouchStrokes.size());
			    System.out.println("touch wird ausgefuehrt");
			    touchPoints.add(new Point(currentTouch.x, currentTouch.y));
//				  	System.out.println("currentTouch x" +currentTouch.x+ ",y "+ currentTouch.y);
			    touchStrokes.set(i,touchPoints);
			}
			else if (currentTouch.state == 4) // wenn touch endet in die Strokeliste schreiben
			{
			    System.out.println("touch ende");
//					System.out.println("touch: " +  event.toString());
//					currentTouchStroke.addPoint(new PointR(currentTouch.x, currentTouch.y));
			    touchPoints.add(new Point(currentTouch.x, currentTouch.y));
			    touchStrokes.remove(i);
			    strokes.addAll(touchStrokes);
			}
		}
	}

	/**
	 * Standard Methode um im Editor Frame zu malen
	 * @param g
	 * @param strokes
	 * @param _points
	 * @param points
	 */
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.BLACK);
		Enumeration<Vector<Point>> en = strokes.elements();
		while (en.hasMoreElements()) {
			Vector<Point> _points = en.nextElement();
			for (int i = 0; i < (_points.size() - 1); ++i) {
				g2d.setColor(Color.BLACK);
				g2d.drawLine((int) _points.elementAt(i).X,
						(int) _points.elementAt(i).Y, (int) _points.elementAt(i + 1).X,
						(int) _points.elementAt(i + 1).Y);
			}
		}
		if (points.size() < 2)
			return;
		for (int i = 0; i < (points.size() - 1); ++i) {
			g2d.setColor(Color.BLACK);
			g2d.drawLine((int) points.get(i).X,
					(int) points.get(i).Y,
					(int) points.get(i + 1).X,
					(int) points.get(i + 1).Y);
		}
	}

	/**
	 * Methode fuer das Grafikupdate
	 * @param bufImage
	 * @param bufG
	 */
	public void update(Graphics g) {
		int w = this.getSize().width;
		int h = this.getSize().height;

		if (bufImage == null) {
			bufImage = this.createImage(w, h);
			bufG = bufImage.getGraphics();
		}

		bufG.setColor(this.getBackground());
		bufG.fillRect(0, 0, w, h);
		bufG.setColor(this.getForeground());

		paint(bufG);
		g.drawImage(bufImage, 0, 0, this);
	}

	/**
	 * Konstruktor<p>
	 * erstellt den Editor
	 *
	 * @param toolPanel Panel mit Buttons und Textfeldern
	 * @param load Button
	 * @param loadFile Button
	 * @param recognize Button
	 * @param clear Button
	 * @param save Button
	 * @param saveName Name des zu speichernden Pattern
	 * @param reloadModel Button
	 * @param infoLabel
	 *
	 */
	public ModelEditor()
	{
		setTitle("Model Editor");
		setBounds(0, 0, 2550, 1400);
		setBackground(new Color(221, 221, 000));
		setLayout(new BorderLayout());

		addMouseListener(this);
		addMouseMotionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		infoLabel = new Label("                                 Draw gesture in the green field.                                          Do some activities at toolpanel below. ");
		infoLabel.setBackground(new Color(255, 255, 255));
		infoLabel.setSize(600, 20);
		add(infoLabel, BorderLayout.NORTH);

		Panel toolPanel = new Panel();
		toolPanel.setBackground(new Color(100,100,100));
		toolPanel.setLayout(new FlowLayout());

		clear = new Button("clear");
		clear.addActionListener(this);

		recognize = new Button("recognize");
		recognize.addActionListener(this);

//      Folgendes ist die Vorbereitung alles auf meine Datenstrukutr umzubauen, wird wenn Zeit vorhanden ist gemacht
//		checkBoxRec = new JCheckBox("automatic recognition");
//		checkBoxRec.addActionListener(this);

		load = new Button ("Load model file");
		load.addActionListener(this);
		loadFile = new TextField("Loaded modelname");

		reloadModel = new Button ("Reload models");
		reloadModel.addActionListener(this);

		save = new Button("Save model");
		save.addActionListener(this);

		saveName = new TextField("Type modelname here...");
		saveName.setColumns(20);

//		recPanel.add(checkBoxRec);
		toolPanel.add(load);
		toolPanel.add(loadFile);
		toolPanel.add(recognize);
		toolPanel.add(clear);
		toolPanel.add(save);
		toolPanel.add(saveName);
		toolPanel.add(reloadModel);
		add(toolPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	/**
	 * Methode um den Auswahldialog zu oeffnen
	 *
	 * @param getBack Ausgewaehlter Dateipfad
	 * @param infoLabel setzt neuen Text ins infoLabel Feld
	 * @see loadNdollatModel loadNdollarModel wird aufgerufen
	 *
	 */
	private void openLoadDialog()
	{
		JFileChooser chooser = new JFileChooser(samplesDir);
		int getBack = chooser.showOpenDialog(null);


		if (getBack == JFileChooser.APPROVE_OPTION &&  checkFile(chooser.getSelectedFile().getAbsolutePath()))
		{
			chooser.getSelectedFile().getName();
			loadNdollarModel(chooser.getSelectedFile().getAbsolutePath());
			System.out.println("Die zu oeffnende Datei ist: " +chooser.getSelectedFile().getAbsolutePath());
			infoLabel.setText("Load File: " +chooser.getSelectedFile().getAbsolutePath());
		}
		else
		{
			 infoLabel.setText("Failure ");
			 System.out.println("Failure: can't read file ");
		}
	}

	/**
	 * Methode fuer Recognition
	 *
	 * @param strokes Alle zu erkennenden Strokes
	 * @param points werden nach Erkennung geloescht
	 * @param _points lokale der points aus strokes
	 * @param result Recognitionergebnis
	 * @param allPoints Alle Punkte der Strokes (ohne Unterteilung in Strokes)
	 * @param resultText Ergebnistext aus result mit Name Score Distance Angle ActualComparisons TotalComparisons
	 * @param infoLabel setzt neuen Text ins infoLabel Feld
	 *
	 */
	private void recognize()
	{
		if (strokes.size() > 0) {
			Vector<Point> allPoints = new Vector<Point>();
			/*
			 * Alle Punkte wieder aus strokes holen
			 */
			Enumeration<Vector<Point>> en = strokes.elements();
			while (en.hasMoreElements()) {
				Vector<Point> _points = en.nextElement();
				allPoints.addAll(_points);
			}
			NBestList result = recognizer.Recognize(allPoints, strokes.size());
			String resultText;
			/*
			 * Gibt resuktText aus wenn etwas erkannt wurde
			 */
			if (result.getScore() == -1) {
				resultText = MessageFormat.format(
						"No Match!\n[{0} out of {1} comparisons made]",
						result.getActualComparisons(),
						result.getTotalComparisons());
				infoLabel.setText("No Match!");
			} else {
				resultText = MessageFormat
						.format("{0}: {1} ({2}px, {3}{4})  [{5,number,integer} out of {6,number,integer} comparisons made]",
								result.getName(),
								Utils.round(result.getScore(), 2),
								Utils.round(result.getDistance(), 2),
								Utils.round(result.getAngle(), 2),
								(char) 176, result.getActualComparisons(),
								result.getTotalComparisons());
				infoLabel.setText("Result: " + result.getName() + " ("
						+ Utils.round(result.getScore(), 2) + ")");
			}
			System.out.println(resultText);
			points.clear();
		}
		repaint();
	}

	/**
	 * Speichern des gezeichneten Pattern
	 *
	 * @param strokes
	 * @param infoLabel setzt neuen Text ins infoLabel Feld
	 * @param name Name des Pattern
	 * @param numberPointsInStroke Anzahl der Punkte
	 * @param dateFormat Datumsformat
	 * @see SaveGesture
	 * @author Lisa
	 */
	public void save(String name) {
		/*
		 * Wenn keine Strokes nicht speichern
		 */
		if (strokes == null || strokes.size() == 0) {
			infoLabel.setText("Cannot save - no gesture!");
			return;
		}
		Vector<Integer> numberPointsInStroke = new Vector<Integer>();
		Enumeration<Vector<Point>> en = strokes.elements();
		while (en.hasMoreElements()) {
			Vector<Point> pts = en.nextElement();
			numberPointsInStroke.add(pts.size());
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		if (recognizer.SaveGesture(
				NDollarParameters.getInstance().SamplesDirectory +
						File.separator + name + "_" +
						dateFormat.format(GregorianCalendar.getInstance()
								.getTime()) + ".xml", strokes, numberPointsInStroke)) {
			infoLabel.setText("Gesture saved.");
		} else {
			infoLabel.setText("Gesture save failed.");
		}
	}

	/**
	 * Events auswerten
	 * @param event
	 * @see openDialog()
	 * @see recognize()
	 * @see readSamples()
	 */

	public void actionPerformed (ActionEvent event)
	{
		//leider lassen sich die die orginal Strokes nicht auslesen da diese fuer den algo auch nicht so relevant sind mit der ladefuntkion im recognizer nicht auslesen
		/**
		 * load Button oeffnet Auswahldialog
		 */
		if(event.getSource() == this.load){
           System.out.println("load Button");
           openLoadDialog();

		}
		/**
		 * save speichert Pattern
		 */
		else if(event.getSource() == this.save || event.getSource().equals(saveName))
		{
			saveName.selectAll();
			String name = saveName.getText();
			if (name != null && !name.equals(""))
			{
				save(name);
			}
			else
			{
				infoLabel.setText("Cannot save gesture - no name provided!");
			}
			System.out.println("save Button");
       }
		/**
		 * recognize loest Recognition aus
		 */
       else if (event.getSource() == this.recognize)
       {
       System.out.println("recognize Button");
          recognize();

       }
//       else if (event.getSource() == this.saveName)
//       {
//           System.out.println("saveName");
//       }
//       else if (event.getSource()==this.checkBoxRec)
//       {
//    	 folgendes ist die Vorbereitung alles auf meine Datenstrukutr umzubauen, wird wenn Zeit vorhanden ist gemacht
//    	   if (automaticRecognition == true)
//    	   {
//    		   automaticRecognition=false;
//    		   recLabel.setText("Automatic recognition disabled");
//    	   }
//    	   else
//    	   {
//    		   automaticRecognition=true;
//    		   recLabel.setText("Automatic recognition enabled");
//    	   }
//    	   System.out.println("Checkbox " + automaticRecognition);
//       }
		/**
		 * clear loescht alle points, strokes und setzt Canvas zurueck
		 */
       else if (event.getSource()==this.clear)
       {
    	   strokes.clear();
    	   points.clear();
    	   infoLabel.setText("Input cleared");
    	   System.out.println("clear Canvas");
    	   repaint();
       }
		/**
		 * reloadModel laedt die Liste der Patern neu ein
		 */
       else if (event.getSource()==this.reloadModel)
       {
    	   // Damit nicht immer die gleichen Modelle mehrmals im Recognizer sind wird er neu instanziiert (gibt sicher schoener varianten)
    	   recognizer = new NDollarRecognizer();
    	   readSamples();
       }
	}

	/**
	 * Abfragen ob Datei geladen werden kann
	 *
	 * @param file Pfad zur Datei
	 * @return boolean true wenn NDollar XML Datei
	 */
	public boolean checkFile(String file)
	{
		try
		{
			File nDollarFile = new File(file);
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(nDollarFile);
			if( doc.getDocumentElement().getAttribute("AppName") == "NDollarRecognizer-java");
			{
				return true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * XML Datei einlesen
	 *
	 * @param path Pfad zur Datei
	 * @param dBuilder
	 * @param doc geparstes Dokument
	 * @param gestureList Geste enaelt alle Kindknoten des Wurzelknotens
	 * @param strokeNode enthaelt alle Kindknoten von gestureList
	 * @param pointList Liste aller Kindknoten von strokeNode
	 * @param pointNode Punktknoten
	 * @param loadFilde gibt den Patternname aus
	 * @param points Punkte werden im Vector points gespeichert
	 * @param strokes Punkte eines Strokes werden im Vector stroke gespeichert
	 */
	public void loadNdollarModel(String path)
	{
		try
		{
			File nDollarFile = new File(path);
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(nDollarFile);
			NodeList gestureList = doc.getDocumentElement().getChildNodes();
			loadFile.setText(doc.getDocumentElement().getAttribute("Name"));
			for (int i = 0; i < gestureList.getLength(); i++)
			{
				Node strokeNode = gestureList.item(i);
				/*
				 * if damit die schliessenden Tags nicht beachtet werden
				 */
				if (strokeNode.getNodeName().equals("Stroke"))
				{

					NodeList pointList = strokeNode.getChildNodes();
					/*
					 * if damit die schliessenden Tags nicht beachtet werden
					 */
					for (int j = 0; j < pointList.getLength(); j++)
					{
						Node pointNode = pointList.item(j);
						/*
						 * if damit die schliessenden Tags nicht beachtet werden
						 * x,y Koordinaten werden in points gespeichert
						 */
						if (pointNode.getNodeName().equals("Point"))
						{
							//Folgendes ist die Vorbereitung alles auf meine Datenstrukutr umzubauen, wird wenn Zeit vorhanden ist gemacht
							//currentStroke.addPoint(new PointR(Double.parseDouble(pointNode.getAttributes().getNamedItem("X").getNodeValue()), Double.parseDouble(pointNode.getAttributes().getNamedItem("Y").getNodeValue())));
							points.add(new Point(Double.parseDouble(pointNode.getAttributes().getNamedItem("X").getNodeValue()), Double.parseDouble(pointNode.getAttributes().getNamedItem("Y").getNodeValue())));
						}
					}
					// folgendes ist die Vorbereitung alles auf meine Datenstrukutr umzubauen, wird wenn Zeit vorhanden ist gemacht
					//_gesture.add(currentStroke);
					//currentStroke.clearStroke();
					strokes.add(new Vector<Point>(points));
					points.clear();
					repaint();
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// folgendes ist die Vorbereitung alles auf meine Datenstrukutr umzubauen, wird wenn Zeit vorhanden ist gemacht
		//return _gesture;
	}

	/**
	 * Pattern Samples einlesen mit XML Filter
	 * @param currentDir Dateipfad
	 * @param allXMLFiles Alle im Dateifpad enthaltenen XML Files
	 *
	 */
	public static void readSamples() {
		// erstellt das Set der einzulesenden Files
		File currentDir = new File(samplesDir);
		File[] allXMLFiles = currentDir.listFiles(new FilenameFilter()
		{
			@Override
			public boolean accept(File dir, String name)
			{
				return name.toLowerCase().endsWith(".xml");
			}
		});
		// einlesen
		System.out.println("allXMLFiles.lenght" + allXMLFiles.length);
		for (int i = 0; i < allXMLFiles.length; ++i)
		{
			System.out.println(allXMLFiles.length);
			recognizer.LoadGesture(allXMLFiles[i]);
		}
	}

	@Override
	public void mouseMove(MouseEvent arg0) {
	

	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		

	}

	/**
	 * Event Mausloesen
	 * Punkte werden als Stroke zusammengefasst
	 *
	 * @param points Punkte die in
	 * @param strokes Punkte in Strokes zusammengefasst
	 * @param infoLabel Ausgabe
	 *
	 */
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {

		if (points.size() > 1) {
			strokes.add(new Vector<Point>(points));
			infoLabel.setText("Stroke #" + (strokes.size()) + " recorded.");
		}
		points.clear();
	}

	@Override
	/**
	 * Event Mausziehen
	 * Aufzeichnen der Mauskoordinaten waehrend Mausziehen
	 *
	 * @param point aktueller Punkt
	 * @param points Vector der Punkte des aktuellen Stroke
	 * @param infoLabel Ausgabe
	 */
	public void mouseDragged(java.awt.event.MouseEvent e) {

	    System.out.println("Mouse " +e.toString());
        points.add(new Point(e.getPoint().x, e.getPoint().y));
	    infoLabel.setText("Recording stroke #" + (strokes.size() + 1) + "...");
	    repaint();
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		
	}
}
