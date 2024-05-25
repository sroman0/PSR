package Esercizio3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FullDuplexServer {

	public FullDuplexServer(int port) throws IOException{
		this.serverSocket = new ServerSocket(port);
	}

	public void start() throws IOException{
		ProtocolHandler ph = new FullDuplexCommunicationHandler(this.communicationSocket);
		ph.handle();
	}
	public static void main(String[] args) {
		try {
			FullDuplexServer fds = new FullDuplexServer(8080);
			fds.communicationSocket = fds.serverSocket.accept();
			fds.start();
		} catch (IOException e) {}
			
	}
	

	ServerSocket serverSocket;
	Socket communicationSocket;
}
