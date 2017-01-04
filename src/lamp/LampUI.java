package lamp;

import java.awt.Color;
import java.awt.Event;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LampUI {
	
	//Methode zum ändern der Farbe
	public void press(Event e){
		
	}
	
	
	public static void main( String[] args )
	  {
	    JFrame f = new JFrame( "Lampe" );
	    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    //f.add( new JLabel( String.format( "%tT", new Date() ) ) );
	    JPanel p = new JPanel();
	    p.setBackground(Color.BLACK);
	    f.add(p);
	    f.setVisible( true );
	  }


}
