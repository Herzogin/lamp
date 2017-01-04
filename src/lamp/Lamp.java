package lamp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import buttonLampInterfaces.LampInterface;

public class Lamp extends java.rmi.server.UnicastRemoteObject implements ActionListener, buttonLampInterfaces.LampInterface  {
	
	boolean status = false;
	LampUI lUi;
	public Lamp() throws RemoteException {
		super();
		lUi= new LampUI();
	}


	@Override
	public void changeStatus() throws RemoteException {
		if (status) {
			lUi.changeColor(status);
			status = false;
			
		}
		else {		
			lUi.changeColor(status);
			status = true;
		}
		System.out.println("Lamp is on: " + status);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
