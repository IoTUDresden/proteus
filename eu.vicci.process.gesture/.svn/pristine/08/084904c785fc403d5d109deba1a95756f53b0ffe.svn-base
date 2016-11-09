package eu.vicci.process.gesture;

import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.graphiti.platform.IDiagramContainer;
import org.eclipse.graphiti.ui.editor.DefaultPaletteBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;

import eu.vicci.process.gesture.recognizer.ndollar.Gesture;
import eu.vicci.process.gesture.recognizer.ndollar.Multistroke;

public class GesturePaletteBehavior extends DefaultPaletteBehavior {

    private class PaletteEntry extends ToolEntry {

        public PaletteEntry(String label, String shortDesc, ImageDescriptor iconSmall, ImageDescriptor iconLarge) {

            super(label, shortDesc, iconSmall, iconLarge);
        }

    }

    public GesturePaletteBehavior(DiagramBehavior diagramBehavior) {

        super(diagramBehavior);
    }


    private void bresenham(int x0, int y0, int x1, int y1, ImageData image, int color) {

        double dx = Math.abs(x1 - x0);
        double dy = Math.abs(y1 - y0);
        int sx = (x0 < x1) ? 1: -1;
        int sy = (y0 < y1) ? 1: -1;

        double err = dx - dy;

        for (;;) {

            image.setPixel(x0, y0, color);
            if (x0 == x1 && y0 == y1)
                return;

            double e2 = 2 * err;
            if (e2 > -dy) {
                err = err - dy;
                x0 = x0 + sx;
            }

            if (x0 == x1 && y0 == y1) {
                image.setPixel(x0, y0, color);
                return;
            }

            if (e2 < dx) {
                err = err + dx;
                y0 = y0 + sy;
            }
        }
    }

    protected PaletteRoot createPaletteRoot() {

        final int imageWidth = 24;
        final int imageHeight = 24;

        PaletteRoot root = super.createPaletteRoot();
        PaletteDrawer drawer = new PaletteDrawer("Gestures");

        IDiagramContainer container = diagramBehavior.getDiagramContainer();
        if (container instanceof Editor) {

            Hashtable<String, Multistroke> gestures = ((Editor) container).getGestures();
            List<String> keys = Collections.list(gestures.keys());
            Collections.sort(keys);

            for (String name : keys) {

                ImageData data = new ImageData(imageWidth, imageHeight, 8, new PaletteData(0xFF, 0xFF, 0xFF));
                for (int y = 0; y < imageWidth; y++)
                    for (int x = 0; x < imageHeight; x++)
                        data.setPixel(x, y, 0xFF);

                Point min = new Point(Double.MAX_VALUE, Double.MAX_VALUE);
                Point max = new Point(-Double.MAX_VALUE, -Double.MAX_VALUE);

                Gesture g = gestures.get(name).OriginalGesture;

                // find bounding box of points that make up the gesture
                for (Point p : g.Points) {
                    if (p.X < min.X)
                        min.X = p.X;
                    if (p.Y < min.Y)
                        min.Y = p.Y;
                    if (p.X > max.X)
                        max.X = p.X;
                    if (p.Y > max.Y)
                        max.Y = p.Y;
                }

                // draw lines between neighboring points
                Point last = null;
                for (Point p : g.Points) {
                    int x = Math.min((int) ((p.X - min.X) / (max.X - min.X) * (imageWidth - 1)), imageWidth - 1);
                    int y = Math.min((int) ((p.Y - min.Y) / (max.Y - min.Y) * (imageHeight - 1)), imageHeight - 1);
                    if (last != null)
                        bresenham((int) last.X, (int) last.Y, x, y, data, 0x000000);
                    last = new Point(x, y);
                }

                ImageDescriptor image = ImageDescriptor.createFromImageData(data);

                PaletteEntry entry = new PaletteEntry(name, null, image, image);
                drawer.add(entry);
            }
        }
        root.add(drawer);
        return root;
    }
}
