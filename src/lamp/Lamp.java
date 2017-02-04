package lamp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.htw.fiw.vs.IBinder;

public class Lamp extends java.rmi.server.UnicastRemoteObject implements ActionListener, org.htw.fiw.vs.team1.LampInterface  {
	
	boolean status = false;
	LampUI lUi;
	public Lamp() throws RemoteException, AlreadyBoundException, UnknownHostException, MalformedURLException, NotBoundException {
		super();
		IBinder registry = (IBinder) Naming.lookup("rmi://141.45.251.149/binder");
		
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
	public void turnOff() throws RemoteException {
		//true because there is a bug in UI, sorry af
		this.status = true;
		lUi.changeColor(this.status);
		System.out.println("Lamp turned off");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException, UnknownHostException, MalformedURLException, NotBoundException {
		new Lamp();
	}
}
