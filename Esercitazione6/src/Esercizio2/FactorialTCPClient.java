package Esercizio2;


import java.io.IOException;
import java.net.*;

public class FactorialTCPClient { 
	
	public static void main(String argv[]) { 
		try {
		  FactorialTCPClient fc = new FactorialTCPClient("127.0.0.1", 6789);
		  fc.go();
		} catch (IOException e) {
			System.out.println(e); 
		}	
	}
	
	public FactorialTCPClient(String h, int port) throws IOException {
		clientSocket = new Socket(h, port);
	}	

	public void go() throws IOException {		
		ProtocolHandler ph = new FactorialClientHandler(clientSocket);
		ph.handle();
		
	}
    private Socket clientSocket;
} 