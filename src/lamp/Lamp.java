package lamp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Lamp extends java.rmi.server.UnicastRemoteObject implements ActionListener, buttonLampInterfaces.LampInterface  {
	
	boolean status = false;
	LampUI lUi;
	public Lamp() throws RemoteException, AlreadyBoundException, UnknownHostException {
		super();
		Registry registry = LocateRegistry.getRegistry(3000);
		
		// TODO: bind to lamp/hostname/uID, we use currentTime as uID for developing locally
		registry.bind("lamp" +"/"+InetAddress.getLocalHost().getHostName()+"/"+ System.currentTimeMillis(), this);
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
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException, UnknownHostException {
		new Lamp();
	}
}
