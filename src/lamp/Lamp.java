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
	IBinder registry;
	String name;
	
	public Lamp() throws RemoteException, AlreadyBoundException, UnknownHostException, MalformedURLException, NotBoundException {
		super();
		this.registry = (IBinder) Naming.lookup("rmi://localhost/binder");
		this.name = "lamp" +"-"+InetAddress.getLocalHost().getHostName()+"-"+ System.currentTimeMillis();
		this.registry.bind(name, this);
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
		Lamp l = new Lamp();
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					l.registry.unbind(l.name);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
