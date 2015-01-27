package easyfuzzy.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;


import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class VariablesCard {
	private JPanel variablesCard;
	private JPanel cards;
	private ItemListener gui;
	String[]  functionTypes = {"Rectangular", "Trapezoidal", "Triangular"};
	final static String LABEL = "Membership Functions";
	private int INITIAL_TYPE_INDEX = 0;
	
	public VariablesCard(JPanel cards, ItemListener gui){
		this.gui = gui;
		this.cards = cards;
		JPanel variablesCard = new JPanel();
        variablesCard.setLayout(new BoxLayout(variablesCard, BoxLayout.PAGE_AXIS));
        variablesCard.add(Box.createRigidArea(new Dimension(0,5)));
        addMemberFunction(INITIAL_TYPE_INDEX);
        cards.add(variablesCard, LABEL);
        
	}
	
	public void itemStateChanged(ItemEvent evt) {
        //CardLayout cl = (CardLayout)(variablesCard.getLayout());
        //cl.show(cards, (String)evt.getItem());

		String evtName = (String)evt.getItem();
		int functionIndex = Arrays.asList(functionTypes).indexOf(evtName);
		System.out.println((String)evt.getItem());
        addMemberFunction(functionIndex);
         
    }

	private void addMemberFunction(int index){
    	JPanel thisFunctionPanel = new JPanel();
    	//BoxLayout layout = (BoxLayout)(variablesCard.getLayout());
        
    	
    	
    	JComboBox functionType= new JComboBox(functionTypes);
 	    thisFunctionPanel.add(functionType);
 	    thisFunctionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
 	    functionType.addItemListener(gui);
    	
 	    //Rectangle
 	    if (functionType.getSelectedIndex() == 0){
 	    	thisFunctionPanel.add(new Label("point a"));
 	    	thisFunctionPanel.add(new TextField("0.5", 3));
 	    	thisFunctionPanel.add(new Label("point b"));
 	    	thisFunctionPanel.add(new TextField("0.9", 3));
 	    	thisFunctionPanel.add(new Label("point y"));
 	    	thisFunctionPanel.add(new TextField("0.4", 3));
 	    }
 	    
 	    //Trapezoid
 	    else if (functionType.getSelectedIndex() == 1){
 	    	thisFunctionPanel.add(new Label("point a"));
 	    	thisFunctionPanel.add(new TextField("0.5", 3));
 	    	thisFunctionPanel.add(new Label("point b"));
 	    	thisFunctionPanel.add(new TextField("0.9", 3));
 	    	thisFunctionPanel.add(new Label("point c"));
 	    	thisFunctionPanel.add(new TextField("0.4", 3));
 	    	thisFunctionPanel.add(new Label("point d"));
 	    	thisFunctionPanel.add(new TextField("0.3", 3));
 	    }
 	    //Triangle
 	    else if (functionType.getSelectedIndex() == 2){
 	    	thisFunctionPanel.add(new Label("point a"));
 	    	thisFunctionPanel.add(new TextField("0.5", 3));
 	    	thisFunctionPanel.add(new Label("point b"));
 	    	thisFunctionPanel.add(new TextField("0.9", 3));
 	    	thisFunctionPanel.add(new Label("point c"));
 	    	thisFunctionPanel.add(new TextField("0.4", 3));
 	    }
 	    
 	    	
 	    		//Arrays.asList(yourArray).contains(yourChar)
   
 	    
		
    	
    	
    	//thisFunctionPanel.setPreferredSize(new Dimension( 500, 10 ));
    	/*thisFunctionPanel.add(new Label("Member Function"));
		final TextField memberFunctionInput = new TextField("x^2", 15);//<-- no. of cols
		final TextField lessInput = new TextField("0", 3);//<-- no. of cols
		final TextField greaterInput = new TextField("10", 3);
		JComboBox inequality1= new JComboBox(new String[]{"<", "<=", " "});
		JComboBox variable = new JComboBox(new String[]{"x", "y"});
		JComboBox inequality2 = new JComboBox(new String[]{"<", "<=", " "});
		thisFunctionPanel.add(memberFunctionInput);
		thisFunctionPanel.add(lessInput);
		thisFunctionPanel.add(inequality1);
		thisFunctionPanel.add(variable);
		thisFunctionPanel.add(inequality2);
		thisFunctionPanel.add(greaterInput);*/
		thisFunctionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		variablesCard.add(thisFunctionPanel);
	
		
		((Component) gui).validate();
		variablesCard.setAlignmentX(Component.CENTER_ALIGNMENT);
	       
    }
	

	public JPanel get(){
		return variablesCard;
	}
}

