package easyfuzzy.gui;

import java.awt.*;
import java.awt.event.*;


public class Gui extends Frame{
    //private Game parent;
    
	public Frame frame;
	private int memberFunctionsCount = 1;
	
    public Gui(){ 
    	System.out.println("Press Ctrl + c here, to exit ...");
		frame = new Frame("Parent Frame");
		addMemberFunction();
		
		for (int i = 0; i < memberFunctionsCount; i++){
			System.out.println("inside loop " + i);
		}
		Button addButton = new Button("add member functions");
		/*addButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            memberFunctionsCount++;
	            addMemberFunction();
	            
	         }
	      });
		*/
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

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
		System.out.println("congrats you reached the end of making a gui");
    }
    
    public void addMemberFunction(){
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
    }
    
    public void actionPerformed(ActionEvent e) { 
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
    }
}