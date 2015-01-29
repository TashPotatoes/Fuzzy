package easyfuzzy.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PinCard {
	private ItemListener gui;
	
	final static String LABEL = "Drop pin in field";
	private JPanel pinCard;
	private JPanel pinField;
	private int x;
	private int y;
	
	
	public PinCard(JPanel cards, ItemListener gui){
		this.gui = gui;
		
		//Drop pin card
        pinCard = new JPanel(); 
        pinField = new JPanel();
        pinField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println((e.getPoint()).getClass());
                x = e.getPoint().x;
                y = e.getPoint().y;
                
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
	
	public int getX(){
		return x;
	}
	 
	public int getY(){
		return y;
	}

}
