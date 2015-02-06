package easyfuzzy.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import easyfuzzy.controller.BasicFuzzyController;
import easyfuzzy.variables.IllegalSetException;
import easyfuzzy.variables.LinguisticVariable;
import easyfuzzy.variables.functions.FunctionException;
import easyfuzzy.variables.functions.TrapezoidalMembershipFunction;
import easyfuzzy.variables.functions.TriangularMembershipFunction;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
/*import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;*/
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;





public class VariablesCard {
	private JPanel card;
	private JPanel allCards;
	private ItemListener gui;
	private JButton addButton;
	private JButton saveButton;
	private int numFunctions = 1;
	Border loweredBevel = BorderFactory.createLoweredBevelBorder();
	private double [][] inputData = new double [4][5];

	String[]  functionLabels = {"Rectangular", "Trapezoidal", "Triangular"};
	final static String LABEL = "Membership Functions";
	private int INITIAL_TYPE_INDEX = 0;
	Queue<JPanel> functionPanels;
	Queue<JComboBox> functionCBs;
	
	
	public VariablesCard(JPanel cards, ItemListener gui){
		this.gui = gui;
		this.allCards = cards;
		functionPanels = new LinkedList<JPanel>();
		functionCBs = new LinkedList<JComboBox>();
		card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.PAGE_AXIS));
        card.add(Box.createRigidArea(new Dimension(0,5)));
        drawCard();
        allCards.add(card, LABEL);
	}
	
	/*
	 * Draws entire card, including 
	 */
	public void drawCard() {
		drawFunctions();
		drawVisual();
	}
	
	public void drawVisual(){
		processCard();
		JPanel chart = new ChartPanel(
				createChart(createDataSeries(inputData)));
		card.add(chart);
	}
	
	
	private void processCard(){
		//iterate over all panels, check if visible, find type, save data, create linquistic vars
		for (Component parentC : card.getComponents()){
			if (parentC instanceof JPanel && parentC.isVisible() == true){
				int i = 0;
				int textFields = 1;
				for (Component c : ((Container) parentC).getComponents()){
					if (c instanceof JComboBox){
						
						inputData[i][0] = ((JComboBox) c).getSelectedIndex();
						i++;
						
					} 
					// TODO: add data to adt so don't have to iterate and hope for the best
					else if (c instanceof JTextField){
						inputData[i][textFields] = Double.parseDouble(((JTextField) c).getText());
						
						System.out.println("new data is " + inputData[i][textFields]);
						textFields++;
					}
				}
			}
				
			
		}
		
		
	}
	
	public double[][] getData(){
		return inputData;
	}
	
	private XYSeriesCollection createDataSeries(double[][] data){
		
		XYSeriesCollection allFunctions = new XYSeriesCollection();
		
		for (int i = 0; i < data.length; i++){
			double a = data[i][1];
			double b = data[i][2];
			double c = data[i][3];
			double d = data[i][4];
			
			
			if (data[i][0] == 0) {
				// Rectangular membership goes (a,0) to (a, c) to (b,c) to (b,0)
				XYSeries function = new XYSeries(functionLabels[(int)data[i][0]] + " " + i);
				function.add(a, 0);
				function.add(a, c);
				function.add(b, c);
				function.add(b, 0);	
				allFunctions.addSeries(function);
			
			} else if (data[i][0] == 1) {
				// Trapezoidal membership goes (a,0) to (b,1) to (c,1) to (d,0)
				XYSeries function = new XYSeries(functionLabels[(int)data[i][0]] + " " + i);	
				function.add(a, 0);
				function.add(b, 1);
				function.add(c, 1);
				function.add(d, 0);								
				allFunctions.addSeries(function);
				
			} else if (data[i][0] == 2) {
				// Triangle membership goes (a,0) to (c,1) to (b,0)
				XYSeries function = new XYSeries(functionLabels[(int)data[i][0]] + " " + i);
				function.add(a, 0);
				function.add(c, 1);
				function.add(b, 0);
				allFunctions.addSeries(function);
				
			}
			
		}
		return allFunctions;
	}
	
	private JFreeChart createChart(final XYSeriesCollection dataset){
		JFreeChart XYLineChart = ChartFactory.createXYLineChart( "Function", "Input", "Membership Degree", dataset, PlotOrientation.VERTICAL, true, true, false);
		
		XYItemRenderer renderer = XYLineChart.getXYPlot().getRenderer();
		renderer.setSeriesPaint(0, Color.black);
		renderer.setSeriesPaint(1, Color.blue);
		renderer.setSeriesPaint(2, Color.cyan);
		renderer.setSeriesPaint(3, Color.gray);
		renderer.setSeriesPaint(4, Color.darkGray);
		renderer.setSeriesPaint(5, Color.yellow);
		renderer.setSeriesPaint(6, Color.green);
		renderer.setSeriesPaint(7, Color.red);

		XYPlot plot = XYLineChart.getXYPlot();

		ValueAxis domain = plot.getDomainAxis();
		domain.setAutoRange(true);
		ValueAxis range = plot.getRangeAxis();
		range.resizeRange(0, 1);
		
		NumberAxis xAxis = (NumberAxis) XYLineChart.getXYPlot().getRangeAxis();
		xAxis.setRange(0,1);
		NumberAxis yAxis = (NumberAxis) XYLineChart.getXYPlot().getDomainAxis();
		yAxis.setRange(0,1);
		

		XYLineChart.setBackgroundPaint(Color.lightGray);
		XYLineChart.getLegend().setBackgroundPaint(Color.white);
		return XYLineChart;
		
	}


	private void drawFunctions(){
		
	// draw four functions, set invisible. 		
		for (int i = 0; i < 4; i++){
			JPanel row = new JPanel();
			JComboBox cb = new JComboBox(functionLabels);
			row.add(cb);
			cb.addItemListener(gui);
			drawOneFunction(row);
			//row.setVisible(false);
			functionPanels.add(row);
			functionCBs.add(cb);
			row.setPreferredSize(new Dimension(10, 600));
			card.add(row);
			row.setBorder(loweredBevel);
		}
		
		functionPanels.peek().setVisible(true);
		
		addButton = new JButton("add");
		saveButton = new JButton("save");
		
		addButton.addItemListener(gui);
		saveButton.addItemListener(gui);
		
		card.add(addButton);
		card.add(saveButton);
	
	}
		
	private void drawOneFunction(JPanel panel){
			panel.add(new Label("point a"));
 	    	panel.add(new JTextField("0.5", 3));
 	    	panel.add(new Label("point b"));
 	    	panel.add(new JTextField("0.9", 3));
 	    	panel.add(new Label("point y"));
 	    	panel.add(new JTextField("0.4", 3));
 	    	panel.add(new Label("point d"));
 	    	panel.add(new JTextField("0.3", 3));
 	    	changeToTri(panel);
 	    	panel.setBorder(loweredBevel);
 	    	
 	    }
	
	
	private void changeToRect(JPanel panel){
		// First 6 components are always visible
		panel.getComponent(6).setVisible(true);
	    panel.getComponent(7).setVisible(true);	    	
	}
	
	private void changeToTrap(JPanel panel){
		panel.getComponent(6).setVisible(true);
	    panel.getComponent(7).setVisible(true);	    	
	}
	
	private void changeToTri(JPanel panel){
		panel.getComponent(6).setVisible(false);
	    panel.getComponent(7).setVisible(false);	    	
	}
	
	
 	 
		
	
	
	
	
	public void itemStateChanged(ItemEvent evt) {
        //CardLayout cl = (CardLayout)(variablesCard.getLayout());
        //cl.show(cards, (String)evt.getItem());

		System.out.println("trying state change from card");
        
		String evtName = (String)evt.getItem();
		int functionIndex = Arrays.asList(functionLabels).indexOf(evtName);
		System.out.println((String)evt.getItem() + functionIndex + "from card");
        //addMemberFunction(functionIndex);
         
    }
	
}

