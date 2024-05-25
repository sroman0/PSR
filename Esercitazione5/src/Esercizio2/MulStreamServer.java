package Esercizio2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class MulStreamServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			ServerSocket welcomeSocket=new ServerSocket(1200);
			
			while(true) {
				Socket connectionSocket=welcomeSocket.accept();
				
				BufferedReader inFromClient= new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
				DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
				
				int num1=Integer.parseInt(inFromClient.readLine());
				int num2=Integer.parseInt(inFromClient.readLine());
				
				int result=num1*num2;
				
				outToClient.writeInt(result);
				
				connectionSocket.close();
				
			}
	}

}
