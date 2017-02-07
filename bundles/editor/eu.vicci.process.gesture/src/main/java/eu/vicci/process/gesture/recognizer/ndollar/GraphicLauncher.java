package eu.vicci.process.gesture.recognizer.ndollar;

/*
 *  The $N Multistroke Recognizer (Java version)
 *
 *      Jan Sonnenberg, Ph.D.
 *      TU Braunschweig
 *      Institut fuer Nachrichtentechnik
 *      Schleinitzstr. 22
 *      38106 Braunschweig
 *      sonnenberg@ifn.ing.tu-bs.de
 *
 * Based on the $N Multistroke Recognizer (C# version)
 *
 *	    Lisa Anthony, Ph.D.
 *		UMBC
 *		Information Systems Department
 * 		1000 Hilltop Circle
 *		Baltimore, MD 21250
 * 		lanthony@umbc.edu
 *
 *      Jacob O. Wobbrock, Ph.D.
 * 		The Information School
 *		University of Washington
 *		Mary Gates Hall, Box 352840
 *		Seattle, WA 98195-2840
 *		wobbrock@u.washington.edu
 *
 * The Protractor enhancement was published by Yang Li and programmed
 * here by Lisa Anthony and Jacob O. Wobbrock.
 *
 *	Li, Y. (2010). Protractor: A fast and accurate gesture
 *	  recognizer. Proceedings of the ACM Conference on Human
 *	  Factors in Computing Systems (CHI '10). Atlanta, Georgia
 *	  (April 10-15, 2010). New York: ACM Press, pp. 2169-2172.
 *
 * This software is distributed under the "New BSD License" agreement:
 *
 * Copyright (c) 2007-2011, Lisa Anthony and Jacob O. Wobbrock
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *    * Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *    * Neither the name of the University of Washington nor UMBC,
 *      nor the names of its contributors may be used to endorse or promote
 *      products derived from this software without specific prior written
 *      permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL Jacob O. Wobbrock OR Lisa Anthony
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import eu.vicci.process.gesture.Point;

public class GraphicLauncher extends Frame implements MouseMotionListener, MouseListener, ActionListener {
    private static final long serialVersionUID = 1L;

    static NDollarRecognizer _rec = null;

    Vector<Point> points = new Vector<Point>();
    Vector<Vector<Point>> strokes = new Vector<Vector<Point>>();

    Image bufImage;
    Graphics bufG;

    Label recLabel;
    Button save;
    TextField input;

    public static void main(String[] args) {
        String samplesDir = NDollarParameters.getInstance().SamplesDirectory;

        _rec = new NDollarRecognizer();

        // create the set of filenames to read in
        File currentDir = new File(samplesDir);
        File[] allXMLFiles = currentDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".xml");
            }
        });

        // read them
        for (int i = 0; i < allXMLFiles.length; ++i) {
            _rec.LoadGesture(allXMLFiles[i]);
        }

        new GraphicLauncher();
    }

    public GraphicLauncher() {
        setTitle("$N Multistroke Recognizer in Java");
        setBounds(400, 300, 400, 400);
        setBackground(new Color(221, 221, 221));
        setLayout(new BorderLayout());
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        recLabel = new Label("   left-click: draw    middle-click: clear canvas    right-click: recognize    ");
        recLabel.setBackground(new Color(255, 255, 136));
        recLabel.setSize(400, 20);
        add(recLabel, BorderLayout.NORTH);
        Panel savePanel = new Panel();
        savePanel.setBackground(new Color(236, 233, 216));
        savePanel.setLayout(new FlowLayout());
        save = new Button("save");
        save.addActionListener(this);
        input = new TextField("Type name here...");
        input.addActionListener(this);
        input.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                input.selectAll();
            }
        });
        input.setColumns(20);
        savePanel.add(save);
        savePanel.add(input);
        add(savePanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.RED);
        Enumeration<Vector<Point>> en = strokes.elements();
        while (en.hasMoreElements()) {
            Vector<Point> pts = en.nextElement();
            for (int i = 0; i < (pts.size() - 1); ++i) {
                g2d.setColor(Color.RED);
                g2d.drawLine((int) pts.elementAt(i).X, (int) pts.elementAt(i).Y, (int) pts.elementAt(i + 1).X, (int) pts
                        .elementAt(i + 1).Y);
            }
        }
        if (points.size() < 2)
            return;
        for (int i = 0; i < (points.size() - 1); ++i) {
            g2d.setColor(Color.RED);
            g2d.drawLine((int) points.elementAt(i).X, (int) points.elementAt(i).Y, (int) points.elementAt(i + 1).X, (int) points
                    .elementAt(i + 1).Y);
        }

    }

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

    @Override
    public void mouseDragged(MouseEvent e) {

        points.add(new Point(e.getPoint().x, e.getPoint().y));
        recLabel.setText("Recording stroke #" + (strokes.size() + 1) + "...");
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (points.size() > 1) {
                strokes.add(new Vector<Point>(points));
                recLabel.setText("Stroke #" + (strokes.size()) + " recorded.");
            }
            points.clear();
        } else if (e.getButton() == MouseEvent.BUTTON2) {
            strokes.clear();
            points.clear();
            recLabel.setText("Canvas cleared.");
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            if (strokes.size() > 0) {
                Vector<Point> allPoints = new Vector<Point>();
                Enumeration<Vector<Point>> en = strokes.elements();
                while (en.hasMoreElements()) {
                    Vector<Point> pts = en.nextElement();
                    allPoints.addAll(pts);
                }
                NBestList result = _rec.Recognize(allPoints, strokes.size());
                String resultTxt;
                if (result.getScore() == -1) {
                    resultTxt = MessageFormat.format("No Match!\n[{0} out of {1} comparisons made]", result
                            .getActualComparisons(), result.getTotalComparisons());
                    recLabel.setText("No Match!");
                } else {
                    resultTxt = MessageFormat
                            .format("{0}: {1} ({2}px, {3}{4})  [{5,number,integer} out of {6,number,integer} comparisons made]", result
                                    .getName(), Utils.round(result.getScore(), 2), Utils.round(result.getDistance(), 2), Utils
                                    .round(result.getAngle(), 2), (char) 176, result.getActualComparisons(), result
                                    .getTotalComparisons());
                    recLabel.setText("Result: " + result.getName() + " (" + Utils.round(result.getScore(), 2) + ")");
                }
                System.out.println(resultTxt);
                points.clear();
            }

        }
        repaint();
    }

    public void save(String name) {
        if (strokes == null || strokes.size() == 0) {
            recLabel.setText("Cannot save - no gesture!");
            return;
        }
        Vector<Integer> numPtsInStroke = new Vector<Integer>();
        Enumeration<Vector<Point>> en = strokes.elements();
        while (en.hasMoreElements()) {
            Vector<Point> pts = en.nextElement();
            numPtsInStroke.add(pts.size());
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        if (_rec.SaveGesture(NDollarParameters.getInstance().SamplesDirectory + "\\" + name + "_"
                + dateFormat.format(GregorianCalendar.getInstance().getTime()) + ".xml", strokes, numPtsInStroke)) {
            recLabel.setText("Gesture saved.");
        } else {
            recLabel.setText("Gesture save failed.");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource().equals(save) || evt.getSource().equals(input)) {
            String name = input.getText();
            if (name != null && !name.equals("")) {
                save(name);
            } else {
                recLabel.setText("Cannot save gesture - no name provided!");
            }
        }
    }
}