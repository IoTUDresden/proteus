package eu.vicci.process.gesture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.GestureEvent;
import org.eclipse.swt.events.GestureListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Touch;

import eu.vicci.process.gesture.recognizer.ndollar.Multistroke;

public class Editor extends DiagramEditor implements MouseMoveListener, MouseListener, GestureListener, TouchListener,
        PaintListener {

    static {
        DebugStream.activate();
    }

    /**
     * Instanz eines Editor mit Gestenerkennung
     *
     * @author daniel
     * @param mouseDown
     *            Gedrueckte Maustaste zur Steuerung des Timers
     * @param loadSample
     *            Ob die Samples eingelesen werden
     * @param staticRecognizer
     *            $N-Recognizer
     * @param strokes
     *            Liste der Strokes
     * @param currentMouseStroke
     *            Aktuell ausgefuehrter Mausstroke //Vorlaeufig wird zw. Touch
     *            u. Mouse unterschieden
     * @param smplesDir
     *            Pfad zum Ordern mit den Pattern fuer den Recognizer // Muss
     *            angepasst werden//
     * @param matchingScore
     *            Uebereinstimmung die eine Eingabe mit dem Pattern haben muss
     * @param currentTouchStroke
     *            Aktuell ausgefuehrter Touchstroke //Vorlaeufig wird zw. Touch
     *            u. Mouse unterschieden
     * @param timerOffset
     *            Timernachlauf bis Recognition ausgeloest wird
     * @param timerTime
     *            Aufruf des TimerTask in ms
     * @param timer
     *            Timer
     * @param timertask
     *            Timertask
     * @param coverage
     *            Prozentualer Anteil den ein Stroke innerhalb der durch
     *            strokeTolerance gesetzten Box um einen Stroke liegen muss
     * @param strokeTolerance
     */

    // Gedrueckte Maustaste zur Steuerung
    private boolean mouseDown = false;
    private boolean mouse = false;

    // MouseEvent zur steuerung, Maus und Touch sind momentan nicht gleichzeitig
    // moeglich
    private boolean touchDown = false;
    private boolean touch = false;
    private boolean gesture = false;

    // Var fuer den Recognizer
    private PreProcessor preProcessor = new PreProcessor();

    // Vektorarray mit Punkten aus points. Die Punkte werden fuer jeden Stroke
    // in einen separaten Vektor geschrieben
    private List<Stroke> strokes = new ArrayList<Stroke>();
    private GestureRecognizer recognizer = new GestureRecognizer();

    // Touch Variablen
    // fuer die Verarbeitung der einzelnen Touchevents
    private Stroke currentStroke = new Stroke();
    private Map<Long, Stroke> currentTouchStrokes = new HashMap<Long, Stroke>();
    private List<BasicGesture> findBasicGestures = new ArrayList<BasicGesture>();

    // Mouse Variablen
    // Die Verarbeitung der Events und insbeondere das Stroke aktualisieren
    // funktioniert sehr unterschiedlich, daher nicht der gleiche Stroke wie bei
    // Touch
    private Stroke currentMouseStroke;

    // Noetig um das updaten der MausStrokes zu kontrollieren
    private boolean newStroke;

    // Var fuer den Timer
    // fuer den Timernachlauf d * timerOffset = Zeit nach der letzten
    // Interaktion
    private int timerOffset;

    // Aufruf des Timers in ms
    private static final int timerTime = 55;

    // Timer zur Steuerung des Recognizers
    private Timer timer;
    public static TimerTask timertask;

    // Zeit bis eine Geste als fertig betrachtet wird
    private static final int finishOffset = 7;

    private List<GestureResultListener> gestureResultListeners = new LinkedList<GestureResultListener>();

    private static Semaphore recDelSemaphore = new Semaphore(1, true); // Semaphore
                                                                       // verhindert,
                                                                       // dass
                                                                       // keine
                                                                       // Strokes
                                                                       // geloescht
                                                                       // werden
                                                                       // waehred
                                                                       // Recognition

    public Editor() {

        super();
        // Schonmal die Samples in den Recognizer einlesen, da das u.U. Zeit
        // dauert
        GestureRecognizer.readSamples();
    }

    @Override
    protected void createGraphicalViewer(Composite parent) {

        super.createGraphicalViewer(parent);
        getGraphicalViewer().getControl().addGestureListener(this);
        getGraphicalViewer().getControl().setTouchEnabled(true);
        getGraphicalViewer().getControl().addTouchListener(this);
        getGraphicalViewer().getControl().addMouseListener(this);
        getGraphicalViewer().getControl().addMouseMoveListener(this);

        getGraphicalViewer().getControl().addPaintListener(this);
    }

    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // Touch Events
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    // ----------------------------------------------------------------
    /**
     * Gesture Event Gesture Event erkennt die Standardgesten Liefert das Dell
     * Touchdisplay nicht Surface lifert GestureEvent
     */
    @Override
    public void gesture(GestureEvent event) {

        gesture = true;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>GESTE<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        if (!touchDown && !mouseDown) {
            if (event.detail == 2) // Geste beginnt
                System.out.println("Gesture Start " + event.detail);

            if (event.detail == 4)// Geste endet
                System.out.println("Gesture End " + event.detail);
        }
    }

    /**
     * TouchEvent verarbeitung
     *
     * @param touches
     *            [] Alle Tocuhes
     * @param currentTouchStroke
     *            aktueller zu verarbeitender Stroke
     * @param currentTouchStrokes
     *            alle TouchStrokes // Das muss noch mit den Mousstrokes in
     *            Uebereinstimmung gebracht werden
     * @param mouseDown
     *            keine andere Eingabe // wie gedrueckte Maustaste
     * @param gesture
     *            // wenn Geste augefuehrt wird, keine andere Eingabe
     * @param timerOffset
     *            Zuruecksetzen solange ein Stroke ausgefuehrt wird
     *
     */
    public void touch(TouchEvent event) {

        // Das kommt noch vom Pixelsence bleibt auch erstmal, da es zunaechst
        // auch keine parallele Mauseingabe geben soll
        if (!mouse && !gesture) {
            touch = true;
            /*
             * Jedes Touchevent bekommt einen Eintrag in touches[] und es wird
             * immer durch die Schleife aktualisiert so lange das Event
             * ausgeloest wird abgerufen wird es durch die ID timerOffset wird
             * solange immer wieder auf 0 gesetzt
             */
            Touch touches[] = event.touches;
            for (int i = 0; i < touches.length; i++) {
                Touch currentTouch = touches[i];
                FigureCanvas canvas = (FigureCanvas) getGraphicalControl();
                org.eclipse.swt.graphics.Point canvasOrigin = canvas.toDisplay(0, 0);
                // Rectangle rect = currentTouch.source.getBounds();

                // Touch beginnt, Stroke anlegen Timer wird gestartet
                if (currentTouch.state == 1) {

                    this.currentStroke = new Stroke();
                    currentStroke.addPoint(new Point(currentTouch.x - canvasOrigin.x, currentTouch.y - canvasOrigin.y));
                    currentTouchStrokes.put(currentTouch.id, currentStroke);
                    strokes.add(currentStroke);
                    timerStart(timerTime);
                    touchDown = true;
                    timerOffset = 0;
                }
                // Touch wird ausgefuehrt
                else if (currentTouch.state == 2) {

                    currentStroke = currentTouchStrokes.get(currentTouch.id);
                    if (currentStroke != null) {
                        int temp = strokes.indexOf(currentStroke);
                        currentStroke.addPoint(new Point(currentTouch.x - canvasOrigin.x, currentTouch.y
                                - canvasOrigin.y));
                        strokes.remove(temp);
                        strokes.add(currentStroke);
                        touchDown = true;
                    }

                    Point min = currentStroke.getMinPoint();
                    Point max = currentStroke.getMaxPoint();
                    // System.out.println("min: " + min.X + ", " + min.Y +
                    // "; max: "
                    // + max.X + ", " + max.Y);
                    canvas.redraw((int) min.X, (int) min.Y, (int) (max.X - min.X), (int) (max.Y - min.Y), true);
                    canvas.update();
                }
                // Touch endet, dann die Strokeliste abschliessen
                else if (currentTouch.state == 4) {

                    currentStroke = currentTouchStrokes.get(currentTouch.id);
                    if (currentStroke != null) {
                        int temp = strokes.indexOf(currentStroke);
                        currentStroke.addPoint(new Point(currentTouch.x - canvasOrigin.x, currentTouch.y
                                - canvasOrigin.y));
                        strokes.remove(temp);
                        strokes.add(currentStroke);
                        currentStroke = null;
                        touchDown = false;
                        timerOffset = 0;
                    }
                }
            }
        }
    }

    /**
     * Mouse Down Event Wenn MouseDown wird der Timer gestartet und der erste
     * Punkt in currentMouseStroke geschrieben
     *
     * @param mouseDown
     * @param timerOffset
     *            Wird solange MouseDown immer wieder zurueckgesetzt
     * @param currentMouseStroke
     *            Aktuelle Stroke mit Punkten
     */
    @Override
    public void mouseDown(MouseEvent event) {

        // Erstmal nur eine Eingabemodalitaet
        // Damit wird erstmal abgefangen, dass das Surface events etwas
        // beliebig auswirft
        if (!touch && !gesture) {

            // Punkte werden nur gespeichert wenn linke Maustaste gedrueckt wird
            if (event.button == 1 && ((event.stateMask & SWT.MODIFIER_MASK) != 0)) {
                timerStart(timerTime);
                mouseDown = true;

                // Timernachlauf wird dann immer wieder zurueckgesetzt
                timerOffset = 0;
                this.currentMouseStroke = new Stroke();
                currentMouseStroke.addPoint(new Point(event.x, event.y));
            }
        }
    }

    /**
     * MouseUp Event Wenn MausUp dann wird der Aktuelle Stroke nach Strokes
     * geschrieben
     *
     * @param mouseDown
     *            false
     * @param strokes
     *            Strokes
     * @param currentMouseStroke
     * @param timerOffset
     *            wird letztes mal auf 0 gesetzt
     */
    @Override
    public void mouseUp(MouseEvent event) {

        // Erstmal nur eine Eingabemodalitaet
        if (!touch && !gesture) {
            // dieses Konstrukt ist noetig, damit das Wechselspiel mit dem Timer
            // funktioniert
            mouseDown = false;
            if (currentMouseStroke == null)
                return;

            if (strokes.isEmpty() || newStroke) {
                newStroke = true;
                strokes.add(currentMouseStroke);
                currentMouseStroke.clearStroke();
                currentMouseStroke = null;
                FigureCanvas canvas = (FigureCanvas) getGraphicalControl();
                canvas.redraw();
                canvas.update();
            } else {
                // letzten Stroke holen und Punkte anhaengen
                int indexOfLastStroke = strokes.size() - 1;
                strokes.get(indexOfLastStroke).addNewPartOfStroke(currentMouseStroke);
                newStroke = true;
                currentMouseStroke.clearStroke();
                currentMouseStroke = null;
                FigureCanvas canvas = (FigureCanvas) getGraphicalControl();
                canvas.redraw();
                canvas.update();
            }
            timerOffset = 0;
        }
    }

    /**
     * MouseMove Event Solange die Maus bewegt wird und die Maustaste gedrueckt
     * ist werden die Punktkoordinaten gesammelt
     *
     * @param mouseDown
     * @param currentMouseStroke
     *            aktelle Punkte des Strokes
     */
    @Override
    public void mouseMove(MouseEvent event) {
        if (!touch && !gesture) {

            // mouseDown ist noetig, da waehrend MouseMove event.button keine
            // Info liefert ob button 1 gedrueckt ist
            if (mouseDown) {
                currentMouseStroke.addPoint(new Point(event.x, event.y));

                Point min = currentMouseStroke.getMinPoint();
                Point max = currentMouseStroke.getMaxPoint();
                // System.out.println("min: " + min.X + ", " + min.Y + "; max: "
                // + max.X + ", " + max.Y);
                FigureCanvas canvas = (FigureCanvas) getGraphicalControl();

                if (canvas != null) {
                    canvas.redraw((int) min.X, (int) min.Y, (int) (max.X - min.X), (int) (max.Y - min.Y), true);
                    canvas.update();
                }
            }
        }
    }

    @Override
    public void mouseDoubleClick(MouseEvent event) {

    }

    /**
     * Loescht Strokes aus ArrayList strokes Die Strokes der erkannten Gesten
     * werden geloescht
     *
     * @param basicGesture
     */
    private void deleteStrokes(BasicGesture basicGesture) {
        Set<Stroke> delStrokes = new HashSet<Stroke>();
        delStrokes.addAll(basicGesture.getStrokes());
        Iterator<Stroke> iterator = delStrokes.iterator();
        while (iterator.hasNext()) {
            Stroke stroke = (Stroke) iterator.next();
            if (strokes.contains(stroke)) {
                strokes.remove(stroke);
                findBasicGestures.remove(basicGesture);
            }
        }
    }

    /**
     * Timer um Intervalweise die Eingabe zu pruefen Startet den Timertask im
     * Intervall
     *
     * @param intervall
     *            Intervall in ms
     * @param timer
     * @param timertask
     * @see timerAction()
     */
    private void timerStart(long intervall)// Intervall in ms
    {
        if (timer == null) {
            timer = new Timer();
            timertask = new TimerTask() {
                public void run() {
                    // verarbeitung der Eingaben
                    inputProcessing();
                }
            };
            timer.schedule(timertask, 0, intervall);
        }
    }

    /**
     * Stoppt den Timer Verarbeiten moeglicher noch nicht verarbeiter Eingaben,
     * und alles zuruecksetzen
     *
     * @param timer
     * @param strokes
     * @param findBasicGestures
     *            BasicGesture
     */
    public void inputStopp() {
        if (timer != null) {
            // Alle Gesten die noch in strokes enthalten sein koennten
            // abarbeiten
            if (strokes.size() > 0) {
                List<BasicGesture> finishedGestures = preProcessor.process(strokes);
                for (int i = 0; i < finishedGestures.size(); i++) {
                    BasicGesture finishedGesture = finishedGestures.get(i);
                    // unterscheiden zwischen kontinuierlicher Geste und
                    // statischer
                    // if (finishedGesture.isContinous()) {
                    // Result result =
                    // recognizer.continousRecognize(finishedGesture);
                    // doSomethingOther(result);
                    // }
                    // statisch
                    // else
                    // {
                    Result result = recognizer.staticRecognize(finishedGesture);
                    deleteStrokes(finishedGesture);
                    doSomething(result);
                    // }
                }
            }
            preProcessor.clear();
            recognizer.setProcessingStep(0);
            strokes.clear();
            timertask.cancel();
            timer.cancel();
            timertask = null;
            timer = null;
            touch = false;
            mouse = false;
            gesture = false;
            if (currentStroke != null)
                currentStroke.clearStroke();
            currentTouchStrokes.clear();
        }
    }

    /**
     * Aktionen waerend der Timer laeuft Recognition waehrend Gesten ausgefuehrt
     * werden
     *
     * @param timerOffset
     *            Timernachlauf
     * @param loadSmples
     *            Eingelesene Samples
     * @param mouseDown
     */
    public void inputProcessing() {

        timerOffset++;
        recognizer.setProcessingStep((recognizer.getProcessingStep()) + 1);
        /**
         * Wenn die Maustaste gedrueckt ist und der Timernachlauf > finishOffset
         * wird geprueft ob Geste fertig ist
         */
        if ((touchDown == true || mouseDown == true) && timerOffset >= finishOffset) {
            // System.out.println("> RECOGNIZE UND FUCHTELN <");
            /*
             * Nur fuer Mauseingabe Um die Aenderung zu pruefen muss der
             * aktuelle Stroke bei der kontinuierlichen Erkennung mitgeprueft
             * werden Damit es nicht immer ein neues Objekt ist wegen
             * PointsAtTime muss das so umstaendlich sein, d.h der Inhalt muss
             * geaendert werden damit die Referenz gleich bleibt
             */
            timerOffset = 0;
            if (strokes.isEmpty() || newStroke) {
                newStroke = false;
                if (mouseDown) {
                    strokes.add(currentMouseStroke);
                }
            } else {
                // letzten Stroke holen und Punkte anhaengen
                int indexOfLastStroke = strokes.size() - 1;
                if (mouseDown)
                    strokes.get(indexOfLastStroke).addNewPartOfStroke(currentMouseStroke);
            }
            try {
                recDelSemaphore.acquire();
                try {
                    preProcessor.setTimerOffset(timerOffset);
                    preProcessor.setFinishOffset(finishOffset);
                    BasicGesture basicGesture = preProcessor.preProcess(strokes);
                    // System.out.println("Rec unf fuchteln " +
                    // basicGesture.size()+" finished "
                    // +basicGesture.getFinished());
                    // unterscheiden zwischen statischer Geste und
                    if (basicGesture.getFinished() && !(basicGesture.isContinous())) {
                        Result result = recognizer.staticRecognize(basicGesture);
                        deleteStrokes(result.getGesture());
                        doSomething(result);
                    }
                    // kontinuierliche Geste
                    // wir nicht mehr ben�tigt
                    // if ((!(basicGesture.getFinished()) && touchDown) ||
                    // basicGesture.isContinous()) {
                    // Result result =
                    // recognizer.continousRecognize(basicGesture);
                    // doSomethingOther(result);
                    // }
                } finally {
                    recDelSemaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Thread.currentThread().interrupt();
                // break;
            }
        }
        // wenn keine Eingaben mehr kommen stoppen
        else if ((touchDown == false || mouseDown == false) && timerOffset >= finishOffset) {
            inputStopp();
        }
    }

    /**
     * Beispiel fuer die Ergebnisverarbeitung fuer die statischen Ergebnisse
     *
     * @param result
     */
    // Mach was mit dem statischen Ergebnis
    private void doSomething(Result result) {

        // Schaerfe des Recognizers, die Uebereinstimmung mit dem Pattern in %
        double matchingScore = 0.8;

        // Sonderfall Tap abfragen
        // wird nicht mehr gebraucht
        // if (result.getName().contains("tap")) {
        // System.out.println(result.getName());
        // System.out.println("x: " + result.getFirstPoint().X + " y: " +
        // result.getFirstPoint().Y);
        // }
        // Ansonsten das Recognizerergebnis verarbeiten
        // else {
        if (result.getRecognitionResult().getScore() == -1) {
            // nicht erkannte Gesten werden geloescht
            System.out.println(">>> Keine Geste erkannt <<<");
        }
        if (result.getRecognitionResult().getScore() > matchingScore) {
            System.out.println();
            System.out.println("Name: " + result.getName());
            System.out.println("    Score: " + result.getScore());
            System.out.println("    Distance: " + result.getDistance() + " Angle: " + result.getAngle());
            System.out.println("    First Point: x " + result.getFirstPoint().X + ", y " + result.getFirstPoint().Y
                    + " LastPoint x:  " + result.getLastPoint().X + " y: " + result.getLastPoint().Y + " Centre x: "
                    + +result.getCentreBox().X + " y: " + result.getCentreBox().Y);
            System.out.println();

            for (GestureResultListener listener : gestureResultListeners) {

                listener.gestureDetected(result);
            }

            /*
             * String[] resultNames =
             * result.getResultNamesInOrderOfRecognition(); for (int i = 0; i <
             * resultNames.length; i++) { System.out.println("Result Order "
             * +i+" Name " +resultNames[i]); }
             */
        } else {
            System.out.println("<< zu geringer MatchingScore >>");
        }
    }

    // }

    /**
     * Beispiel fuer die Ergebnisverarbeitung fuer die kontinuierlichen
     * Ergebnisse
     *
     * @param result
     */
    // Wird nicht mehr gebraucht
    // private void doSomethingOther(Result result) {
    // if (!(result.getName() == null)) {
    // if (result.getName().contains("drag")) {
    // System.out.println(" name: " + result.getName());
    // for (int i = 0; i < result.getGesture().getStroke(1).getPoints().size();
    // i++)
    // System.out.print("-");
    //
    // System.out.println("");
    // }
    // }
    // }

    public void addGestureResultListener(GestureResultListener g) {

        gestureResultListeners.add(g);
    }

    public void removeGestureResultListener(GestureResultListener g) {

        gestureResultListeners.remove(g);
    }

    @Override
    public void paintControl(PaintEvent e) {

        if (currentMouseStroke != null)
            for (Point p : currentMouseStroke.getPoints())
                e.gc.fillOval((int) p.X, (int) p.Y, 4, 4);

        if (currentStroke != null)
            for (Point p : currentStroke.getPoints())
                e.gc.fillOval((int) p.X, (int) p.Y, 4, 4);
    }

    public void addXMLGesture(String xmlGesture) {

        if (xmlGesture != null) {
            GestureRecognizer.addGesture(xmlGesture);
            //System.out.println(xmlGesture);
        }
    }

    public Hashtable<String, Multistroke> getGestures() {

        return recognizer.getGestures();
    }
}
