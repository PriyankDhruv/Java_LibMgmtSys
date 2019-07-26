package com.lib.view;

import java.io.PrintStream;
import java.util.Scanner;

import com.lib.model.*;
import com.lib.controller.LibController;
import java.io.*;

public class ViewFile extends Thread{

	public static void main(String a[]) throws IOException{
		//char exit = '';
		//PrintStream out = new PrintStream(System.out, true, "UTF-8");
		int uid;
		int bid;
		LibController l = new LibController();
		File fb = null;
		File fStd = null;
		File fStf = null;
		try{
			fb = new File("book_db.csv");
			fStd = new File("std_db.csv");
			fStf = new File("stf_db.csv");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(fb.exists() && fStd.exists() && fStf.exists()){
			DAO obj = new DAO();
			obj.initData();
			l.readBookData();
			l.readStdData();
			l.readStfData();
		}
		else{
			DAO obj = new DAO();
			obj.initData();
		}
		char wlcm[] = {'W' , 'E' , 'L' , 'C' , 'O' , 'M' , 'E' };
		try{
			System.out.print("      ");
			for(int i=0; i<7 ; i++){
				System.out.print(wlcm[i]);
				Thread.sleep(250);
			}
		}catch(Exception e){
			
		}
		
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true){
			System.out.println();
			System.out.println("--------------------");
			System.out.println((char)124 + " 1: Issue Book    " + (char)124);
			System.out.println((char)124 + " 2: Return Book   " + (char)124);
			System.out.println((char)124 + " 3: Check Balance " + (char)124);
			System.out.println((char)124 + " 4: Exit          " + (char)124);
			System.out.println("--------------------");
			
				
			System.out.println("Enter value : ");
			choice = sc.nextInt();
			switch(choice){
				
				case 1: System.out.println("Enter User ID and Book ID : ");
						uid = sc.nextInt();
						//System.out.println("New value is " + uid);
						bid = sc.nextInt();
						//System.out.println("New value of uid " + uid + " & bid is " + bid);
						l.issueBook(uid,bid);
						break;
				case 2: System.out.println("Enter User ID and Book ID : ");
						uid = sc.nextInt();
						bid = sc.nextInt();
						l.returnBook(uid,bid);
						break;
				case 3: System.out.println("Enter User ID : ");
						uid = sc.nextInt();
						//bid = sc.nextInt();
						l.checkStatus(uid);
						break;
				case 4: l.saveBookData();
						l.saveStdData();
						l.saveStfData();
						System.exit(0);
				case 5: System.exit(0);
			}
			
		}
	}
}