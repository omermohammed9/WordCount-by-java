package com.myfirstjava.program;

import java.net.*;
import java.io.*;

public class Operation1 { //Server 1
	public static String txt;
	public static void main(String[] args) {
		int portNumber= 4321;
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
			int c = 0;
			for (int i = 0; i <txt.length(); i++) {
				if (txt.charAt(i) == 'a') {
					count++;
				}
			}
			System.out.println("Total no of vowels (a) in string are: " + count);
			
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
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}

	}
}		

/*https://stackoverflow.com/questions/63468593/how-can-i-split-paragraphs-into-proper-sentences-in-java-using-split
https://www.educba.com/split-function-in-java/
https://www.geeksforgeeks.org/split-string-java-examples/
https://www.geeksforgeeks.org/java-program-to-count-the-number-of-lines-words-characters-and-paragraphs-in-a-text-file/
https://www.geeksforgeeks.org/java-program-to-count-number-of-vowels-in-a-string/
https://www.javatpoint.com/java-program-to-count-the-number-of-words-in-a-string
https://dumbitdude.com/socket-programming-in-java/ 
https://gist.github.com/chatton/8955d2f96f58f6082bde14e7c33f69a6
https://www.programiz.com/java-programming/examples/iterate-each-string-characters */