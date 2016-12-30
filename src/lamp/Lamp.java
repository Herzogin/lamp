package lamp;

import java.rmi.RemoteException;

import buttonLampInterfaces.LampInterface;

public class Lamp extends java.rmi.server.UnicastRemoteObject implements buttonLampInterfaces.LampInterface  {
	
	boolean status = false;
	
	public Lamp() throws RemoteException {
		super();
	}


	@Override
	public void changeStatus() throws RemoteException {
		if (status) {
			status = false;
		}
		else {
			status = true;
		}
		System.out.println("Lamp is on: " + status);
	}

}
