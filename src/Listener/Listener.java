package Listener;

import shape.ImplLine;
import shape.Shape;

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
        
        switch(getShape())
        {
        	case "line" :
        		 //g.drawLine(x1, y1, x2, y2);
        		Shape shape=new ImplLine(g,x1,y1,x2,y2,color);
                //CALL DARW
                shape.draw();
                //SAVE THE LIST FOR REPAINT
                shapesArray.add(shape);
                System.out.println("addok");
        		 break;
        	case "circle" :
        		g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(x1 - x2));
       		 	break;
        	case "rectangle" :
        		 g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
       		 	break;
        	case "oval" :
       		 	g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
       		 	break;
        	case "freehand":
        		g.drawLine(x1, y1, x2, y2);
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