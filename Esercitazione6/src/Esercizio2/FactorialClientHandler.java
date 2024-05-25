package Esercizio2;

import java.io.IOException;

import java.util.*;
import java.io.*;
import java.net.*;

public class FactorialClientHandler implements ProtocolHandler {
	
	public FactorialClientHandler(Socket soc) {
		socket = soc;
	}	
	
	public void handle() throws IOException {
	  Scanner fromUser = null;
	  try {	
		fromUser = new Scanner(System.in);
        PrintStream toUser = new PrintStream(System.out);
		DataInputStream fromServer = new DataInputStream(socket.getInputStream());
		DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
		int n = 0;
		do {
			toUser.print("Enter an integer number: "); 
			n = fromUser.nextInt(); 									// read a number from stdin
			toServer.writeInt(n);										// write the number to the server
			int f = fromServer.readInt();								// read the factorial number from the server
			if (n >= 0) toUser.println("The factorial of " + n + " is "+ f);  		// write the factorial to the stdout
		} while(n >= 0);													// run until n > 0
	    toUser.println("Terminated");
	  } catch (Exception e) {
	  } finally { 
		  if (socket != null) try { socket.close(); } catch (IOException e) {} 
		  if (fromUser != null) fromUser.close();
	  }
	}
	
	private Socket socket ; 

} 