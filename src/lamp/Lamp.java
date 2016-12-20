package lamp;

import java.rmi.RemoteException;

import lampButtonServer.LampInterface;

public class Lamp implements LampInterface  {
	
	boolean status = false;

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
