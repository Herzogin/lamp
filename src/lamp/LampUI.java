package lamp;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LampUI {
	JPanel p;
	
	
	public LampUI(){
		
	    JFrame f = new JFrame( "Lampe" );
	    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    //f.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    //f.add( new JLabel( String.format( "%tT", new Date() ) ) );
	    p = new JPanel();
	    p.setBackground(Color.BLACK);
	    f.setSize(600, 600);
	    f.add(p);
	    f.setVisible( true );
	}
	

	public void changeColor(Boolean status){
		 if (status) {
			p.setBackground(Color.black);
		}else {
			p.setBackground(Color.yellow);
		}
	}
	
	
	/*public static void main( String[] args )
	  {
		new LampUI();
	  }*/


	




}
