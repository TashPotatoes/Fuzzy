package easyfuzzy.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PinCard {
	final static String LABEL = "Drop pin in field";
	JPanel pinCard;
	JPanel pinField;
	
	
	public PinCard(JPanel cards){
		//Drop pin card
        pinCard = new JPanel(); 
        pinField = new JPanel();
        pinField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getPoint());
            }
        });
        pinField.setBorder(BorderFactory.createLineBorder(Color.black));
        pinField.setPreferredSize(new Dimension(200, 200));
        pinCard.add(pinField);
        cards.add(pinCard, LABEL);
	}
	
	public JPanel get(){
		return pinCard;
	}
	
	 

}
