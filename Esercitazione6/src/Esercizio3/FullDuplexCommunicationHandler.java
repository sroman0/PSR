package Esercizio3;

import java.io.IOException;
import java.net.Socket;

public class FullDuplexCommunicationHandler implements ProtocolHandler {

	public FullDuplexCommunicationHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void handle() {
		Writer writer = new Writer(this.socket);
		Thread reader = new Reader(this.socket);
		writer.start();
		reader.start();
	}
	
	Socket socket;
}
