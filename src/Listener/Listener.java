package Listener;

import shape.*;
import shape.Rectangle;
import shape.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Listener implements ActionListener, MouseListener,MouseMotionListener {
    
    private Graphics g;//drawer
    public List<Shape> getShapesArray() {
		return shapesArray;
	}

	public void setShapesArray(List<Shape> shapesArray) {
		this.shapesArray = shapesArray;
	}
	private List<Shape> shapesArray = new ArrayList<Shape>();
    private int x1,y1,x2,y2;//(x1,y1),(x2,y2) click and release mouse
    private String shape;
    private Color color = Color.BLACK;
    private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<ArrayList<Point>> actulpoints = new ArrayList<ArrayList<Point>>();
    private String text = "Text";
	private JFrame panel;
	private Shape dragShape;
 	public void setPanel(JFrame panel) {
		   	this.panel=panel;
		  }
	public void setActulpoints(ArrayList<ArrayList<Point>> actulpoints) {
		this.actulpoints = actulpoints;
	}

	public ArrayList<ArrayList<Point>> getActulpoints() {
		return actulpoints;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	//Draw
    public void setGraphics(Graphics g) {
        this.g = g;
 
    }
     
    public void setShape(String shape)
    {
    	this.shape = shape;
    }
    
    public String getShape()
    {
    	return shape;
    }
   
    @Override
    //drag mouse
    public void mouseDragged(MouseEvent e) {
		if(shapesArray.contains(dragShape)) {
			shapesArray.remove(dragShape);
			//System.out.println("removing old shape");
		}
		if(getShape()=="freehand") {
			points.add(e.getPoint());
			g.drawLine(x1, y1, e.getX(), e.getY());
			x1=e.getX();
			y1=e.getY();
		} else if(getShape()=="line") {
			dragShape = new ImplLine(g, x1,y1,e.getX(), e.getY(), color);
			shapesArray.add(dragShape);
			panel.repaint();
		} else if(getShape()=="circle") {
			dragShape = new Circle(x1,e.getX(),y1, e.getY(), color,g);
			shapesArray.add(dragShape);
			panel.repaint();
		} else if(getShape()=="rectangle") {
			dragShape = new Rectangle(x1,e.getX(),y1, e.getY(), color,g);
			shapesArray.add(dragShape);
			panel.repaint();
		} else if(getShape()=="oval") {
			dragShape = new Oval(x1,e.getX(), y1,e.getY(), color,g);
			shapesArray.add(dragShape);
			panel.repaint();
		}
	}



    @Override
  
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    //mouse click
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    //mouse press
    public void mousePressed(MouseEvent e) {
    	
        x1=e.getX();//get x
        y1=e.getY();//get y

        if(getShape()=="freehand") {
			points.clear();
        	points.add(e.getPoint());

        }
//        System.out.println(getShape());
//        System.out.println(getColor());
//        System.out.println(getG());
//        g.setColor(Color.BLUE);
//        getG().drawLine(10, 10, 100, 100);
        
    }

    @Override
    //mouse release
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        Shape shape;
        
        switch(getShape())
        {
        	case "line" :
        		shape=new ImplLine(g,x1,y1,x2,y2,color);
                shape.draw();
                shapesArray.add(shape);
        		 break;
        	case "circle" :
        		shape = new Circle(x1, x2, y1, y2, color, g);
        		shape.draw();
        		shapesArray.add(shape);
       		 	break;
        	case "rectangle" :
        		shape = new Rectangle(x1, x2, y1, y2, color, g);
        		shape.draw();
        		shapesArray.add(shape);		 
       		 	break;
        	case "oval" :
        		shape = new Oval(x1, x2, y1, y2, color, g);
        		shape.draw();
        		shapesArray.add(shape);	
       		 	break;
        	case "freehand":

				ArrayList<Point> midpoints = new ArrayList<Point>();
        		for (int i = 0; i < points.size() - 1 ; i ++)
				{
					midpoints.add(points.get(i).getLocation());
				}
				actulpoints.add(midpoints);
				shape = new Freehand(actulpoints, color, g);
				shape.draw();
				shapesArray.add(shape);
        		System.out.println(shapesArray.size());
        		break;
			case "text":
				String inputValue = JOptionPane.showInputDialog("Please input a value");
				text = inputValue;
				shape = new Text(x1, x2, y1, y2, color, g,text);
				shape.draw();
				shapesArray.add(shape);
				break;
		}
        //System.out.println(getG());
        //g.drawLine(x1, y1, x2, y2);
       
        
    }

    @Override
    //mouse in
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    //mouse excite
    public void mouseExited(MouseEvent e) {

    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	

   

}