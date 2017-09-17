package client;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Canvas;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.CompoundBorder;

import Listener.Listener;
import shape.Shape;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ClientManager {
	private static List<Shape> shapesArray = new ArrayList<Shape>();
	private static Graphics g;
	private static JFrame frmWhiteboard;
	private JTextField textField;
	private static JPanel panel = new JPanel();
	static Listener listener = new Listener();
	static int i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						ClientManager window = new ClientManager();
						window.frmWhiteboard.setVisible(true);
						listener.setG(panel.getGraphics());
						listener.setPanel(frmWhiteboard);
						shapesArray = listener.getShapesArray();
						System.out.println(shapesArray.size());
						

						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		ClientManager window = new ClientManager();
//		window.frmWhiteboard.setVisible(true);
//		shapesArray = listener.getShapesArray();
//		System.out.println(x);
//		
//		
//		//while(true)
//		//{
//			listener.setG(panel.getGraphics());
//			
//		//}
		
		
	
		
		
	}
	public class WhiteBoard extends JFrame
	{
		@Override
	    //override paint in JFrame
	    public void paint(Graphics g) {
	        //paint and draw
	        super.paint(g);
	        for (Shape l : shapesArray) {
	            l.draw();
	        }
	        System.out.println("repaintok");
	    }
	}
	
	/**
	 * Create the application.
	 */
	public ClientManager() {
		initialize();
	}
	
	public static void draw()
	{
		panel.getGraphics().drawLine(100, 200, 300, 400);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmWhiteboard = new WhiteBoard();
		frmWhiteboard.setTitle("Whiteboard");
		frmWhiteboard.setBounds(100, 100, 774, 563);
		frmWhiteboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWhiteboard.getContentPane().setLayout(null);
		frmWhiteboard.setResizable(false);
		
		JButton btnSend = new JButton("send");
		btnSend.setBounds(602, 450, 113, 27);
		frmWhiteboard.getContentPane().add(btnSend);
		//System.out.println(panel.getClass());
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 754, 26);
		frmWhiteboard.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("new");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("open");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("save");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("saveAs ");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("close");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_1 = new JMenu("Shapes");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("freehand");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.setShape("freehand");
			

			}
		});
		
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("line");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.setShape("line");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("circle");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.setShape("circle");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("rectangle");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.setShape("rectangle");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("oval");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.setShape("oval");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_2 = new JMenu("erase");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("small size");
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("medium size");
		mnNewMenu_2.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("large size");
		mnNewMenu_2.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_3 = new JMenu("color");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("choose color ");
		mnNewMenu_3.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_4 = new JMenu("text");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmTextInput = new JMenuItem("text input in canva");
		mnNewMenu_4.add(mntmTextInput);
		
		textField = new JTextField();
		textField.setBounds(14, 451, 574, 24);
		frmWhiteboard.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 13, 242, 427);
		textArea.setEditable(false);
		frmWhiteboard.getContentPane().add(textArea);
		
		//panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(270, 13, 484, 424);
		panel.addMouseListener(listener);
		panel.addMouseMotionListener(listener);
		
		
		frmWhiteboard.getContentPane().add(panel);
		panel.setLayout(null);
		listener.setColor(Color.BLACK);
		listener.setShape("freehand");
		
		
	}
	
	
}
