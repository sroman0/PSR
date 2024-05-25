package Esercizio2;

import java.io.*;
import java.net.*;



class FactorialServerHandler implements ProtocolHandler {
	
	public FactorialServerHandler(Socket soc) {
		socket = soc;
	}	
	
	public void handle() throws IOException {
	  try {	
		//System.out.println("Thread id " + Thread.currentThread().getId());  
		DataInputStream fromClient = new DataInputStream(socket.getInputStream());
		DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
		int n = 0; int f = 0;
		do {
			n = fromClient.readInt();  		// read the number for computing the factorial number
			f = fact(n);					// compute factorial
			toClient.writeInt(f);      		// send the factorial number to the client
		} while (n > 0);					// run until n > 0
	    
	  } catch (Exception e) {
	  } finally { if (socket == null) try { socket.close(); } catch (IOException e) {} 
	  }	
	}
	
	
	private int fact(int n) {            	// n must be >= 0
		if (n <=1 ) return 1;
		else return n*fact(n-1);
	}


	private Socket socket ; 

} 