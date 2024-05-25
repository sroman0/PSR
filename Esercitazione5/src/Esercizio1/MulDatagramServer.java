package Esercizio1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class MulDatagramServer {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner inFromUser=new Scanner(System.in);
		byte []sendData;
		byte []receiveData=new byte[1024];
		DatagramSocket serverSocket=new DatagramSocket(1200);
		
		while(true) {
			DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
			serverSocket.receive(receivePacket);
			
			ByteBuffer buf=ByteBuffer.wrap(receivePacket.getData());
			int a=buf.getInt();
			int b=buf.getInt();
			long result=a*(long) b;
			buf=ByteBuffer.allocate(8);
			buf.putLong(result);
			sendData=buf.array();
			InetAddress IP=receivePacket.getAddress();
			int port=receivePacket.getPort();
			DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length, IP, port);
			serverSocket.send(sendPacket);
		}
	}

}
