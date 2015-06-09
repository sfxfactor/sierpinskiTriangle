import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.Random;
import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TriangleFracComponent2 extends JComponent {

    private Point2D current;
    private final Point2D p1 = new Point(500,0);
    private final Point2D p2 = new Point(0,866);
    private final Point2D p3 = new Point(1000,866);
    private final Dimension d = new Dimension(1,1);
    private Random r;
    private int iterations;

    public TriangleFracComponent2(int i) {
	current = p1;
	r = new Random();
	iterations = i;
    }

    public void paintComponent (Graphics g) {
	Graphics2D g2 = (Graphics2D) g;

	class BasicListener implements ActionListener {
	    public void actionPerformed(ActionEvent event) {
		Point2D p;
		int n = r.nextInt(3) + 1;
	    
		if (n == 1)
		    p = p1;
		else if (n == 2)
		    p = p2;
		else
		    p = p3;
		
		current = midpoint(current, p);
		g2.draw(new Rectangle((Point) current,d));
	    }
	}

	    BasicListener be = new BasicListener();
	    Timer t = new Timer (1,be);
	    for (int n = 0; n < iterations; n++) {
		t.start();
		System.out.println(n);
	    }
	    t.stop();
    }

    public static Point2D midpoint(Point2D p1, Point2D p2) {
	int p1x = (int) p1.getX();
	int p1y = (int) p1.getY();
	int p2x = (int) p2.getX();
	int p2y = (int) p2.getY();

	Point2D midpoint = new Point((p2x-p1x)/2 + p1x, (p2y-p1y)/2 + p1y);
	return midpoint;
    }
}