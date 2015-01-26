package easyfuzzy.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class VariablesCard {
	JPanel variablesCard;
	final static String LABEL = "Membership Functions";
	
	public VariablesCard(JPanel cards){
		
		JPanel variablesCard = new JPanel();
        variablesCard.setLayout(new BoxLayout(variablesCard, BoxLayout.PAGE_AXIS));
        variablesCard.add(Box.createRigidArea(new Dimension(0,5)));
        addMemberFunction(variablesCard);
        cards.add(variablesCard, LABEL);
        
	}
	
	public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
         
    }

	private void addMemberFunction(JPanel panel){
    	JPanel thisFunctionPanel = new JPanel();
    	
    	String[] functionTypesArray = {"Rectangular", "Trapezoidal", "Triangular"};
    	JComboBox functionType= new JComboBox(functionTypesArray);
 	    thisFunctionPanel.add(functionType);
 	    thisFunctionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
 	    functionType.addItemListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getPoint());
            }
        });
    	
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
		panel.add(thisFunctionPanel);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
	       
    }
	

	public JPanel get(){
		return variablesCard;
	}
}

