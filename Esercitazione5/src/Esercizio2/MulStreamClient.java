package Esercizio2;

import java.io.IOException;
import java.io.*;
import java.net.*;

public class MulStreamClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket clientSocket=new Socket("localhost", 1200);
		
		BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream outToServer=new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		System.out.println("Inserisci un numero:");
		int num1=Integer.parseInt(inFromUser.readLine());
		System.out.println("Inserisci un numero:");
		int num2=Integer.parseInt(inFromUser.readLine());
		
		outToServer.writeBytes(num1+"\n");
		outToServer.writeBytes(num2+"\n");
		
		int result=inFromServer.read();
		System.out.println("Il risultato della moltiplicazione è: " + result);
		
		clientSocket.close();
		
	}
}
