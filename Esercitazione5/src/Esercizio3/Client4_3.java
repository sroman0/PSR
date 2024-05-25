package Esercizio3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client4_3 {

	public static final int YOU=0;
	public static final int PEER=1;
	public static final int EXIT=2;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		char status=YOU;
		int size;
		byte[] buffer=new byte[256];
		
		Scanner inFromUser=new Scanner(System.in);
		
		Socket clientSocket=new Socket("127.0.0.1", 1200);
		
		//DataOutputStream e DataInputStream sono dei decoratori, che implementano il pattern decorator
		DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
		DataInputStream inFromServer=new DataInputStream(clientSocket.getInputStream());
		
		while(status!=EXIT) {
			switch(status) {
			case YOU:
				do {
					System.out.println("YOU>");
					buffer=inFromUser.nextLine().getBytes();
					outToServer.write(buffer.length);
					outToServer.write(buffer);
					
				}while(status==YOU);
			}
		}
		
		
	}

}
