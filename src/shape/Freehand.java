package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Freehand implements Shape {
	
	private ArrayList<Point> points;
	private Color c;
	private Graphics g;
	
	public Freehand(ArrayList<Point> points, Color c, Graphics g) {
		this.points=points;
		this.c=c;
		this.g=g;
	}

	@Override
	public void draw() {
		int x1,x2,y1,y2;
		for(int i=0; i<points.size()-1; i++) {
			x1 = (int)points.get(i).getX();
			y1 = (int)points.get(i).getY();
			x2 = (int)points.get(i+1).getX();
			y2 = (int)points.get(i+1).getY();
			g.drawLine(x1, y1, x2, y2);
		}
		
	}

}
