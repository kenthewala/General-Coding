package sockets.chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) {
		startServer();

	}
	
	public static void startServer(){
		try (ServerSocket ServerSocket = new ServerSocket(8888, 10);){
			Socket incomingSocket = null;
			
			
			while(true){
				incomingSocket = ServerSocket.accept();
				System.out.println("incoming socket request received"+incomingSocket.getInetAddress().toString());
				
				
			}
				
			/*BufferedReader br = new BufferedReader(new InputStreamReader(incomingSocket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(incomingSocket.getOutputStream()));
			
			while(br.readLine()!=null){
				pw.println();
			}*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
