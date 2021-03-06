package easyfuzzy.gui;

/*import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicArrowButton;

import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicArrowButton;

import net.ericaro.surfaceplotter.JSurfacePanel;
import net.ericaro.surfaceplotter.Mapper;
import net.ericaro.surfaceplotter.surface.AbstractSurfaceModel;
import net.ericaro.surfaceplotter.surface.ArraySurfaceModel;
import net.ericaro.surfaceplotter.surface.SurfaceVertex;


//import com.googlecode.surfaceplotter.*; 



import javax.swing.JComponent;

public class Plane {
	private float[][] plot;
	private JPanel planeCard;
	private JPanel cards;
	private ItemListener gui;
	private JSurfacePanel jsp;
	private String title;
	private float xmax;
	private float xmin;
	private float ymax;
	private float ymin;
	private int xCount;
	private int yCount;
	
	    
	public Plane( JPanel cards, ItemListener gui){
		
		
		/*drawingComponent = new DrawingComponent();      
        box = new Rectangle(100, 100, 20, 30);
        graphObj = new Graph();
        xCoord = 0;

        yCoord_size = 400;
        xRate = 0.101;

        yCoord = new double[yCoord_size];*/
		this.gui = gui;
		this.cards = cards;
		planeCard = new JPanel();
		
        
        this.TestSomething();
		//this.DrawPanel();
        cards.add(planeCard, "3D Surface");
		
		
	}
	

	public void setPlot(float[][] input){
		xCount = input.length;
		yCount = input[0].length;
		plot = new float[xCount][yCount];
		for (int x = 0; x < xCount; x++){
			for (int y = 0; y < yCount; y++){
				plot[x][y] = input[x][y];
			}
		}
	}
	
	
	public void setTitle(String title){
		this.title = title;		
	}
		
	/*
	 * Sets the colour of a single point
	 */
	public void setPoint(int x, int y, int value){
		plot[x][y] = value;
	}
	
	/*
	 * Draws a line from two sets of integer points
	 */
	public void DrawLine(int x1, int y1, int x2, int y2, int degree){
		
		// Draw vertical Line
		if ((x1 == x2) && (y1 != y2)){
			int minY = (int)Math.min(y1, y2);
			int maxY = Math.max(y1, y2);
			for (int y = minY; y < maxY; y++){
				plot[x1][y] = degree;
			}
		}
		
		// Draw non vertical line of form y = mx + x
		else { 
			// swap in case x1 is larger than x2
			if (x1 > x2){
				int holder = x1;
				x1 = x2;
				x2 = holder;
				holder = y1;
				y1 = y2;
				y2 = holder;
			}
			// x1 is smaller than x2
			else {
				int dist = (x2 - x1);
				int m = Math.abs((y2 - y1)/(x2 - x1));
				int c = Math.abs((x2*y1 - y2*y1)/(x2 - x1));
						
				for (int i = 0; i < dist; i++){
					plot[x1][y1] = degree;
					x1++;
					y1 = m*x1 + c;
				}
			}
		}
	}
	
	
	/*
	 * Adds  data to the panel, to be called after all data is allocated
	 */
	
	public void DrawPanel(){
		jsp = new JSurfacePanel();
	    jsp.setTitleText("Yaz Mumma said hello");
	    jsp.setPreferredSize(new Dimension(700, 630));
	    
	    planeCard.add(jsp, BorderLayout.CENTER);
	    planeCard.setPreferredSize(new Dimension(730, 660));
	    
	    /*JFrame jf = new JFrame("LAMELRKGER;GHKJSR;TLKJT;HKURSTH");
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf.getContentPane().add(jsp, BorderLayout.CENTER);
	    jf.pack();
	    jf.setVisible(true);*/
	    	
	    Random rand = new Random();
	    int max = 10;
	    float[][] z1 = new float[max][max];
	    float[][] z2 = new float[max][max];
	    for (int i = 0; i < max; i++) {
	            for (int j = 0; j < max; j++) {
	                    z1[i][j] = rand.nextFloat() * 20 - 10f;
	                    z2[i][j] = rand.nextFloat() * 20 - 10f;
	            }
	    }
	    ArraySurfaceModel sm = new ArraySurfaceModel();
	    sm.setValues(0f,10f,0f,10f,max, plot, null);
	    jsp.setModel(sm);
	    // sm.doRotate();
	
	    // canvas.doPrint();
	    // sm.doCompute();
	}
	
	public void TestSomething() {
		jsp = new JSurfacePanel();
	    jsp.setTitleText("Yaz Mumma said hello");
	    jsp.setPreferredSize(new Dimension(700, 630));
	    
	    planeCard.add(jsp, BorderLayout.CENTER);
	    planeCard.setPreferredSize(new Dimension(730, 660));
	    
	    /*JFrame jf = new JFrame("LAMELRKGER;GHKJSR;TLKJT;HKURSTH");
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jf.getContentPane().add(jsp, BorderLayout.CENTER);
	    jf.pack();
	    jf.setVisible(true);*/
	    	
	    Random rand = new Random();
	    int max = 10;
	    float[][] z1 = new float[max][max];
	    float[][] z2 = new float[max][max];
	    for (int i = 0; i < max; i++) {
	            for (int j = 0; j < max; j++) {
	                    z1[i][j] = rand.nextFloat() * 20 - 10f;
	                    z2[i][j] = rand.nextFloat() * 20 - 10f;
	            }
	    }
	    ArraySurfaceModel sm = new ArraySurfaceModel();
	    sm.setValues(0f,10f,0f,10f,max, z1, null);
	    jsp.setModel(sm);
	    // sm.doRotate();
	
	    // canvas.doPrint();
	    // sm.doCompute();
	}
	
	/*public static float f1(float x, float y) {
	    // System.out.print('.');
	    return (float) (Math.sin(x * x + y * y) / (x * x + y * y));
	    // return (float)(10*x*x+5*y*y+8*x*y -5*x+3*y);
	}
	
	public static float f2(float x, float y) {
	    return (float) (Math.sin(x * x - y * y) / (x * x + y * y));
	    // return (float)(10*x*x+5*y*y+15*x*y-2*x-y);
	}*/
		

}
