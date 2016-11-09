package eu.vicci.process.gesture;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Vector;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.xmlpull.mxp1.MXParser;
import org.xmlpull.v1.XmlPullParserException;

import eu.vicci.process.gesture.recognizer.ndollar.Multistroke;
import eu.vicci.process.gesture.recognizer.ndollar.NBestList;
import eu.vicci.process.gesture.recognizer.ndollar.NDollarRecognizer;

public class GestureRecognizer {

    private static String staticSamplesDir = "/samples/staticSamples";
    private static String samplesRecDir = "/samples/Records";

    // private static String continuousSamplesDir =
    // "/samples/continuousSamples";

    private int processingStep;
    private boolean saveGestures = false;

    static NDollarRecognizer staticRecognizer = new NDollarRecognizer(); // Recognizer
                                                                         // fuer
                                                                         // statische
                                                                         // Gesten
                                                                         // initialisieren

    // static NDollarRecognizer continousRecognizer = new NDollarRecognizer();

    public Result staticRecognize(BasicGesture basicGesture) {
        // Kopie die am Ende gespeichert wird damit es nicht so viel Zeit kostet
        // wird das erledigt wenn der Recognizer durch ist

        BasicGesture _basicGesture = new BasicGesture();
        _basicGesture = basicGesture;

        // System.out.println("basicGesture Recognition " +basicGesture.size()
        // +" "+basicGesture);
        // System.out.println("+ RECOGNITION +");
        /**
         * Listen in Vectoren umwandeln
         */
        Vector<Point> allPoints = new Vector<Point>();
        allPoints.addAll(basicGesture.getAllPoints());
        NBestList resultBestStaticMatch = new NBestList();

        Result result = new Result();
        boolean recognized = false;

        // Behandlung von Sonderfaellen. z.B. weil es zuwenig Punkte fuer den
        // Recognizer sind
        // Beispielhaft die Tap Geste

        if (allPoints.size() > 4) // Der Recognizer hat sich sonst mal
                                  // verschluckt
        {
            // Die Tap Geste wird nicht zuverlaessig vom NDollarRecognizer
            // erkannt und wird daher als Sonderfall behandelt (Punkte duerfen
            // nicht auf einem Haufen liegen)
            if (basicGesture.size() == 1 && basicGesture.getStroke(1).getSize() < 25) {
                basicGesture.getStroke(1).calculateMinMax();

                Interval tapRangeX = new Interval(0.0, 10);
                Interval tapRangeY = new Interval(0.0, 10);
                // System.out.println("min "+basicGesture.getStroke(1).getMinPoint().X+" max "+basicGesture.getStroke(1).getMaxPoint().X);
                Interval rangeX = new Interval(0.0, (basicGesture.getStroke(1).getMaxPoint().X - basicGesture
                        .getStroke(1).getMinPoint().X));
                Interval rangeY = new Interval(0.0, (basicGesture.getStroke(1).getMaxPoint().Y - basicGesture
                        .getStroke(1).getMinPoint().Y));

                // System.out.println("range x "+rangeX+ " y " + rangeY +
                // " tapRange x: "+tapRangeX + " y "+ tapRangeY);
                // System.out.println("" + (rangeX.subset(tapRangeX) &&
                // rangeY.subset(tapRangeY)));

                if (rangeX.subset(tapRangeX) && rangeY.subset(tapRangeY)) {

                    basicGesture.isFinished(true);
                    result.setGesture(basicGesture);

                    result.setName("tap");

                    // System.out.println();
                    // System.out.println("Name: "+result.getName() );
                    //
                    // System.out.println("First Point: x "
                    // +result.getFirstPoint().X + ", y "
                    // +result.getFirstPoint().Y +" LastPoint x:  "
                    // +result.getLastPoint().X +" y: "
                    // +result.getLastPoint().Y+" Centre x: "+
                    // +result.getCentreBox().X +" y: " +result.getCentreBox().Y
                    // );
                    //
                    // System.out.println();
                    // deleteStrokes(basicGesture);
                    // Editor.timertask.cancel();
                    recognized = true;
                }
            }
        } else {
            System.out.println("zu wenig Punkte");
        }

        /**
         * Wenn das Ergebnis mindestens zu MatchingScore uebereinstimmt wird es
         * ausgegeben
         */
        // durch die Tapgeste kommen Punkthaufen zustande, an denen sich der
        // REcognizer verschluckt, daher wird hier ein Interval definiert das
        // groesser sein muss wenn der Recognizer ausgeloest werden soll
        if (!recognized) {
            resultBestStaticMatch = staticRecognizer.Recognize(allPoints, basicGesture.getStrokes().size());
            result.setGesture(basicGesture);
            result.setRecognitionResult(resultBestStaticMatch);
        }
        /**
         * Optional koennen Gesten gespeichert werden um sie spaeter zu
         * analysieren
         */
        save(_basicGesture);
        return result;
    }

    /**
     * Pattern Samples einlesen mit XML Filter
     *
     * @param currentDir
     *            Dateipfad
     * @param allXMLFiles
     *            Alle im Dateifpad enthaltenen XML File
     */
    public static void readSamples() {
        URL url = FileLocator.find(Platform.getBundle("eu.vicci.process.gesture"), new Path(staticSamplesDir), null);
        try {
            File directory = new File(FileLocator.resolve(url).toURI());
            File[] allStaticXMLFiles = directory.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".xml");
                }
            });

            for (int i = 0; i < allStaticXMLFiles.length; ++i)
                staticRecognizer.LoadGesture(allStaticXMLFiles[i]);

        } catch (URISyntaxException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static boolean addGesture(String gestureXML) {

        MXParser parser = new MXParser();
        try {
            parser.setInput(new ByteArrayInputStream(gestureXML.getBytes("UTF-8")), "UTF-8");
            staticRecognizer.AddGestureFromXML(parser);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void save(BasicGesture gesture) {
        /**
         * Speichert die erkannten Gesten automatisch um ggf. spaeter
         * auszuwerten Alles was mit dem NDollar im Original spielt laeuft ueber
         * Vectoren daher wird das hier mein Datenmodel umgewandelt
         */
        BasicGesture _basicGesture = gesture;
        Vector<Vector<Point>> _strokes = new Vector<Vector<Point>>();
        for (int i = 0; i < _basicGesture.size(); i++) {
            Vector<Point> _points = new Vector<Point>();
            Stroke stroke = _basicGesture.getStroke(i);
            for (int j = 0; j < stroke.getSize(); j++) {
                _points.add(stroke.getPoint(j));
            }
            _strokes.add(_points);
        }
        if (_strokes == null || _strokes.size() == 0) {
            return;
        }
        Vector<Integer> numberPointsInStroke = new Vector<Integer>();
        Enumeration<Vector<Point>> en = _strokes.elements();

        while (en.hasMoreElements()) {
            Vector<Point> pts = en.nextElement();
            numberPointsInStroke.add(pts.size());
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String gestureName = "Touch-Record_" + dateFormat.format(GregorianCalendar.getInstance().getTime());

        /*
         * hier wurde getrickst um die Save Methode aus dem NDollarRecognizer zu
         * nutzen aber nicht die gespeicherte Geste dem Recognizer hizuzufuegen
         * wurde ein dummy gesetzt. Das kann hier geaendert werden indem mann
         * dummy durch den Recognizer _rec ersetzt
         */
        // TODO: saving disabled
        if (saveGestures) {
            NDollarRecognizer dummy = new NDollarRecognizer();

            URL url = FileLocator.find(Platform.getBundle("eu.vicci.process.gesture"), new Path(samplesRecDir), null);
            try {
                URI uri = FileLocator.resolve(url).toURI();
                dummy.SaveGesture(uri.getRawPath() + gestureName + ".xml", _strokes, numberPointsInStroke);

            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Result continousRecognize(BasicGesture basicGesture) {
        Result continousResult = new Result();

        // Die kontinuierliche Erkennung funktioniert nochmal bisschen anders.
        // Der NDollarREcognizer ist dazu nur bedingt faehig.
        if (basicGesture.size() == 2) {
            // Punkte muessen beieinander liegen
            int size1 = (basicGesture.getStroke(1).getSize()) - 1;
            int size2 = (basicGesture.getStroke(2).getSize()) - 1;
            // System.out.println(basicGesture.getStroke(1).getSize());
            // int size3 = basicGesture.getStroke(3).getSize();
            Point point1 = new Point(basicGesture.getStroke(1).getPoint(size1).X, basicGesture.getStroke(1)
                    .getPoint(size1).Y);
            Point point2 = new Point(basicGesture.getStroke(2).getPoint(size2).X, basicGesture.getStroke(1)
                    .getPoint(size2).Y);
            // PointR point3 = new
            // PointR(basicGesture.getStroke(3).getPoint(size3).X,basicGesture.getStroke(1).getPoint(size3).Y);

            Interval s1X = new Interval(point1.X - 35, point1.X + 35.0);
            Interval s1Y = new Interval(point1.Y - 35, point1.Y + 35.0);

            Interval s2X = new Interval(point2.X - 35, point2.X + 35.0);
            Interval s2Y = new Interval(point2.Y - 35, point2.Y + 35.0);

            // System.out.println(" s1x " +s1X+ " s2x " + s2X+" s1y " + s1Y +
            // " s2y " +s2Y);
            // System.out.println(" s1X.intersects(s2X) " + s1X.intersects(s2X)+
            // "  s1Y.intersects(s2Y) " +s1Y.intersects(s2Y));

            if (s1X.intersects(s2X) && s1Y.intersects(s2Y)) {
                continousResult.setGesture(basicGesture);
                continousResult.getGesture().setContinous(true);
                continousResult.setName("drag");
            }
        }

        return continousResult;
    }

    public int getProcessingStep() {

        return processingStep;
    }

    public void setProcessingStep(int prosessingStep) {

        this.processingStep = prosessingStep;
    }

    public Hashtable<String, Multistroke> getGestures() {

        return staticRecognizer.getGestures();
    }
}
