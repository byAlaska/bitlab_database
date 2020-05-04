package bitlab.askar.lesson6;

import java.util.*;
import java.io.*;
import java.net.*;
public class ClientHandler extends Thread{
	private Socket socket;

	public ClientHandler(Socket socket){
		this.socket = socket;
	}


	public void run(){
		try{
	
			ObjectInputStream inStream = 
				new ObjectInputStream(socket.getInputStream());
			String message = null;

			while((message = (String)inStream.readObject())!=null){
				
					System.out.println(message);
				
			}
			System.out.println("Client disconnected!!!");
			inStream.close();
			socket.close();
			

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}