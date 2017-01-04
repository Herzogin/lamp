package lamp;

import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LampUI implements ActionListener{
	JPanel p;
	Boolean onOff = false;
	
	public LampUI(){
		
	    JFrame f = new JFrame( "Lampe" );
	    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    //f.add( new JLabel( String.format( "%tT", new Date() ) ) );
	     p = new JPanel();
	    p.setBackground(Color.BLACK);
	    f.add(p);
	    f.setVisible( true );
	}
	

	public void changeColor(){
		 if (onOff) {
			p.setBackground(Color.black);
			onOff = false;
		}else {
			p.setBackground(Color.yellow);
			onOff = true; 
		}
	}
	
	
	/*public static void main( String[] args )
	  {
		new LampUI();
	  }*/


	@Override
	public void actionPerformed(ActionEvent e) {
		this.changeColor();
		
	}




}
