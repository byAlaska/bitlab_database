package bitlab.askar.lesson6;

import java.net.*;
import java.io.*;
import java.util.*;
public class Server{
	public static void main(String[] args) {
		try{
			ServerSocket server = new ServerSocket(1998);
			System.out.println("Waiting for client...");
			while(true){
				Socket socket = server.accept();
				System.out.println("Client connected");
				ClientHandler ch = new ClientHandler(socket);
				ch.start();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}