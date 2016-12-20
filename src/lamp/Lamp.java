package lamp;

import java.rmi.RemoteException;

import lampButtonServer.LampInterface;

public class Lamp extends java.rmi.server.UnicastRemoteObject implements LampInterface  {
	
	boolean status = false;
	
	protected Lamp() throws RemoteException {
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
