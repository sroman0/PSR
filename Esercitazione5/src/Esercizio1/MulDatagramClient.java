package Esercizio1;

import java.net.*;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class MulDatagramClient {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner inFromUser=new Scanner(System.in);
		
		DatagramSocket clientSocket=new DatagramSocket();
		
		InetAddress IpAddress=InetAddress.getByName("127.0.0.1");
		
		byte[] sendData;
		byte[] receiveData=new byte[1024];
		
		System.out.println("Insert numbers");
		
		int a=inFromUser.nextInt();
		int b=inFromUser.nextInt();
		
		ByteBuffer buf=ByteBuffer.allocate(8);
		buf.putInt(a);
		buf.putInt(b);
		
		sendData=buf.array();
		
		DatagramPacket packet=new DatagramPacket(sendData,sendData.length, IpAddress, 1200);
		
		clientSocket.send(packet);
		
		DatagramPacket receivePacket=new DatagramPacket(receiveData, receiveData.length);
		
		clientSocket.receive(receivePacket);
		
		buf=ByteBuffer.wrap(receivePacket.getData());
		
		long result=buf.getLong();
		
		System.out.println("Result from server: " + result);
		
		clientSocket.close();
	}
}
