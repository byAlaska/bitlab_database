package bitlab.askar.lesson6;

import java.util.*;
import java.net.*;
import java.io.*;
public class Main{
	public static  MainFrame frame;
	public static Socket socket;
	public static ObjectOutputStream outStream;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		frame = new MainFrame();
		frame.setVisible(true);
	}

	public static boolean connectToServer(String ip, int port){
		boolean check = false;
		try{
			socket = new Socket(ip,port);
			outStream = new ObjectOutputStream(socket.getOutputStream());
			check = true;
		}catch(Exception e){
			e.printStackTrace();
			check = false;
		}
		return check;
	}

	public static void sendMessage(String message){
		try{
			outStream.writeObject(message);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}