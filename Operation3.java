package com.myfirstjava.program;
import java.net.*;
import java.io.*;
import java.util.*;


// Omer Mohammed Abbas om17102
//om17102@auis.edu.krd

public class Operation3 { // Server 2
	public static String txt;
	public static void main(String[] args) {
		int port = 2131;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			Socket conn = serverSocket.accept();
			InputStream in = conn.getInputStream();
			OutputStream out = conn.getOutputStream();
			DataInputStream din = new DataInputStream(in);
			DataOutputStream dout = new DataOutputStream(out);
			BufferedOutputStream bout = new BufferedOutputStream(dout);
			do {
			 txt=din.readUTF();
			 System.out.println(txt);	
			 txt = txt.toLowerCase();
			 char[] chars = txt.toCharArray();	
			 int count = 0;
			 for (int i = 0; i <txt.length(); i++) {
				 if (txt.charAt(i) == 'e') {
						count++;
				 }
			 }
			 
			 System.out.println("Total Number of vowels (e): " + count);
			 dout.writeInt(count); 
			 int counter = 0;
				char ch[] = new char [txt.length()];
				for (int i =0; i < txt.length(); i++) {
					ch[i]= txt.charAt(i);  
					 if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) ) { 
		                 counter++;  
					 }
				}
				System.out.println("number of words: " + counter);
				dout.writeInt(count);
				dout.flush();
				
				dout.writeInt(counter);
				dout.flush();
				
			}while(true);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
