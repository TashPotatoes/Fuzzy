package easyfuzzy.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import easyfuzzy.controller.BasicFuzzyController;
import easyfuzzy.rules.modifier.FzSet;
import easyfuzzy.variables.LinguisticVariable;
import easyfuzzy.variables.functions.TrapezoidalMembershipFunction;
import easyfuzzy.variables.functions.TriangularMembershipFunction;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
 
public class Gui implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    PinCard pinCard;
    BasicFuzzyController bfc;
    Plane plane;
    private FzSet targetclose;
    private FzSet targetmedium;
    private FzSet targetfar;
    private FzSet desirable;
    private FzSet undesirable;
    private FzSet verydesirable;
    private FzSet loads;
    private FzSet okay;
    private FzSet low;


    VariablesCard variablesCard;
    final static String PINPANEL = "Drop pin in field";
    final static String VARIABLESPANEL = "Membership Functions";
    final static String VIEWSETPANEL = "View Fuzzy Set";
    final static String OPSPANEL = "Fuzzy Operations";
    int hasclicked = 0;
    
    public enum displayOptions {
    	PINPANEL, FUZZYPANEL, VIEWSETPANEL, OPSPANEL
    }
   
//   String comboBoxItems[] = { pinCard.LABEL, variablesCard.getLabel(), VIEWSETPANEL, OPSPANEL, "3D Surface"};
   String comboBoxItems[] = { pinCard.LABEL, "Membership Functions", VIEWSETPANEL, OPSPANEL, "3D Surface"};
   
   
   
   

    
    private void makeCards(Container pane){
        
    	// order that it compiles determines which one is first.
    	cards = new JPanel(new CardLayout());
    	   	
    	//cards.setSize( 800, 630 );
    	pinCard = new PinCard(cards, this);
        variablesCard = new VariablesCard(cards, this);
        plane = new Plane(cards, this);
        plane.setPlot(variablesCard.getData());
        pane.add(cards, BorderLayout.CENTER);
        
    }
    
    
    private void makeLinguisticVars(){
    	/*LinguisticVariable lv = new LinguisticVariable("DISTANCE");
        targetclose = lv.addSet("targetclose", new TrapezoidalMembershipFunction(0, 0, 25, 50));
        targetmedium = lv.addSet("targetmedium", new TriangularMembershipFunction(25, 300, 150));
        targetfar = lv.addSet("targetfar", new TrapezoidalMembershipFunction(150, 300, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
        bfc.addVariable(lv);*/

    }
    
    
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        makeCards(pane);
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        
    }
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
        hasclicked++;
        System.out.println((String)evt.getItem() + "from main");
        
         
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        Gui demo = new Gui();
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        //frame.setSize( 800, 630 );
        frame.setVisible(true);
    }
     
    /*public static void main(String[] args) {
        // Use an appropriate Look and Feel
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        // Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }*/







	/*Panel p = new Panel();
		frame.add(p, BorderLayout.NORTH);
		p.add(new Label("Member Function"));
		final TextField memberFunctionInput = new TextField(15);//<-- no. of cols
		p.add(memberFunctionInput);

		p = new Panel();
		frm.add(p, BorderLayout.CENTER);
		p.add(new Label("Password"));
		final TextField ps = new TextField(15);
		ps.setEchoChar('*');//<-- don't show the actual password
		p.add(ps);

		p = new Panel();
		frm.add(p, BorderLayout.SOUTH);
		Button b = new Button("OK");
		p.add(b);*/

/*		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
		System.out.println("congrats you reached the end of making a gui");*/
    
    
    /*public void addMemberFunction(){
	    Panel inputFP = new Panel();
	    Panel inputFirstP = new Panel();
	    Panel inputConditionP = new Panel();
	    Panel inputSecondP = new Panel();
		
		frame.add(inputFP, BorderLayout.NORTH);
		frame.add(inputFirstP, BorderLayout.NORTH);
		frame.add(inputConditionP, BorderLayout.NORTH);
		frame.add(inputSecondP, BorderLayout.NORTH);
		inputFP.add(new Label("Member Function"));		
		final TextField memberFunctionInput = new TextField(15);//<-- no. of cols
		final TextField firstInput = new TextField(1);//<-- no. of cols
		final TextField conditionInput = new TextField(1);//<-- no. of cols
		final TextField secondInput = new TextField(1);//<-- no. of cols
		
		
		inputFP.add(memberFunctionInput);
		inputFirstP.add(firstInput);
		inputConditionP.add(conditionInput);
		inputSecondP.add(secondInput);
		System.out.println("end of adding");
    }*/
    
    /*public void actionPerformed(ActionEvent e) { 
        //...//code that reacts to the action... 
    }
    
    public void update() {
       // ...
    }

    public void render(Graphics2D g) {
        //...
    }

    public void keyPressed(int keyCode) {
      //  if(keyCode == KeyEvent.VK_ENTER)
        //    parent.setScreen(new Instructions());
    }
    
    public void keyReleased(int keyCode) {
        //...
    }*/
    /*public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    Rectangle2D r2d = new Rectangle2D.Float(10f, 10f, 130f, 130f);
    g2d.draw(r2d);
    r2d.addMouseListener(new MouseAdapter() {
        void mouseClicked(MouseEvent e) {
            System.out.println(e.getPoint());
        }
    });
    
  }*/

 
}