package com.myfirstjava.program;

import java.net.*;
import java.io.*;
import java.util.*;
//Omer Mohammed Abbas om17102
//om17102@auis.edu.krd
public class Operation2 { //client

	public static void main(String[] args) {
		try {
			Socket client = new Socket("127.0.0.1", 5151);
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			DataInputStream din = new DataInputStream(in);
			DataOutputStream dout = new DataOutputStream(out);	
			do {
			Scanner sc = new Scanner(System.in);
			String txt;
			System.out.println("Enter text: ");
			txt = sc.nextLine();
			dout.writeUTF(txt);
			
			int count1,count2,count3,count4,count5;
			count1=din.readInt();
			System.out.println("Total no of vowels (a): " + count1);
			count2= din.readInt();
			System.out.println("Total no of vowels (e): " + count2);
			count3= din.readInt();
			System.out.println("Total no of vowels (i): " + count3);
			count4 = din.readInt();
			System.out.println("Total no of vowels (o): " + count4);
			count5=din.readInt();
			System.out.println("Total no of vowels (u): " + count5);
			
			int numberofwords1,numberofwords2,numberofwords3,numberofwords4,numberofwords5;
			numberofwords1= din.readInt();
			System.out.println("number of words s1: " + numberofwords1);
			numberofwords2 = din.readInt();
			System.out.println("number of words s2: " + numberofwords2);
			numberofwords3 = din.readInt();
			System.out.println("number of words s3: " + numberofwords3);
			numberofwords4 = din.readInt();
			System.out.println("number of words s4: " + numberofwords4);
			numberofwords5 = din.readInt();
			System.out.println("number of words s5:" + numberofwords5);
			}while(true);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
