package com.myfirstjava.program;

import java.net.*;
import java.io.*;

//Omer Mohammed Abbas-om17102
//om17102@auis.edu.krd
public class Operation5 { //server 4
	public static String txt;
	public static void main(String[] args) {
		int portNumber = 4141;
		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket conn = serverSocket.accept();
			InputStream in = conn.getInputStream();
			OutputStream out = conn.getOutputStream();
			DataInputStream din = new DataInputStream(in);
			DataOutputStream dout = new DataOutputStream(out);
			BufferedOutputStream bout = new BufferedOutputStream(dout);
			do {
				txt = din.readUTF();
				System.out.println(txt);	
				txt = txt.toLowerCase();
				char[] chars = txt.toCharArray();
				int count = 0;
				for (int i = 0; i <txt.length(); i++) {
					if (txt.charAt(i) == 'o') {
						count++;
					}
				}
				System.out.println("Total no of vowels (o) in string are: " + count);
				
				int counter = 0;
				char ch[] = new char [txt.length()];
				for (int i =0; i < txt.length(); i++) {
					ch[i]= txt.charAt(i);  
					if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) ) { 
						counter++;  
					}
				}
				System.out.println("number of words: " + counter);
				
				// Send both values in a single message
				int[] values = {count, counter};
				dout.writeInt(values.length);
				for (int i = 0; i < values.length; i++) {
					dout.writeInt(values[i]);
				}
				dout.flush();
				
			} while (true);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

