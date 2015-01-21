package easyfuzzy.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
 
public class Gui implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    final static String PINPANEL = "Drop pin in field";
    final static String FUZZYPANEL = "Membership Functions";
    final static String VIEWSETPANEL = "View Fuzzy Set";
    final static String OPSPANEL = "Fuzzy Operations";

    
     
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { PINPANEL, FUZZYPANEL, VIEWSETPANEL, OPSPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
         
        //Create the "cards".
        //Drop pin card
        JPanel pinCard = new JPanel(new GridBagLayout()); 
        
        JPanel pinField = new JPanel();
        pinField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getPoint());
            }
        });
        
        pinCard.add(new JButton("Button 1"));
        pinCard.add(new JButton("Button 2"));
        pinCard.add(new JButton("Button 3"));
        pinCard.add(pinField);
        
        //Fuzzy card
        JPanel fuzzyCard = new JPanel();
        fuzzyCard.add(new JTextField("TextField", 20));
         
        
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(pinCard, PINPANEL);
        cards.add(fuzzyCard, FUZZYPANEL);
         
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    
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
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
     
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        Gui demo = new Gui();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
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
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }







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
}