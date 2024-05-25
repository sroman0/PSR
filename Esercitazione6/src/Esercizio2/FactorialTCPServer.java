package Esercizio2;


import java.io.IOException;
import java.net.*;

public class FactorialTCPServer {
	
	public static void main(String argv[]) throws Exception { 
		try { 
		  FactorialTCPServer fs = new FactorialTCPServer(6789);
		  fs.go();	
		} catch (IOException e) {
			System.out.println(e);
		}	
	}
	
	public FactorialTCPServer (int port) throws IOException {
		welcomeSocket = new ServerSocket(port);
	}	
	
	public void go() throws IOException {

	  while(true) {
		Socket connectionSocket = welcomeSocket.accept();
		ProtocolHandler ph = new FactorialServerHandler(connectionSocket);
		ph.handle();

	  }

	}
	
	private ServerSocket welcomeSocket; 

} 