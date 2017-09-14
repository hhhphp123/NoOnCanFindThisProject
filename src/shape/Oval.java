package shape;

import java.awt.Color;
import java.awt.Graphics;

public class Oval implements Shape {
	
	private Graphics g;
	private int x1, x2,y1,y2;
	private Color c;
	
	public Oval(int x1, int x2, int y1, int y2, Color c, Graphics g) {
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.c=c;
		this.g=g;
	}

	@Override
	public void draw() {
		g.setColor(c);
		g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
	}

}
