package com.lib.controller;
//static import com.lib.model.*;
import static com.lib.model.Book.*;
import static com.lib.model.Student.*;
import static com.lib.model.Staff.*;
import static com.lib.model.DAO.*;
import com.lib.model.*;
import java.io.*;

public class LibController{
	
	public static void issueBook(int uid,int bid){
		if(uid>100 && uid<106){
			DAO daoObj = new DAO();
			int identifyUser = uid - 101;
			//System.out.println(stdObj[1].getBalance());
			if(stdObj[identifyUser].getBalance() <= 0 ){
				System.out.println("-----You have no Balance...!!");
			}
			else{
				for(int i = 0; i<10; i++){
					if(b[i].getBid() == bid){
						if(b[i].getAvabilityBit() == 1){
							stdObj[identifyUser].dcrBalance();
							b[i].setAvabilityBit(0);
							
							for(int j = 0; j<3; j++){
								if(stdObj[identifyUser].getBookSlot(j) == 0){
									stdObj[identifyUser].setBookSlot(j,bid);
									stdObj[identifyUser].setBName(j,b[i].getBName());
									break;
								}
							}
							
							System.out.println("-----Book Issued");
						}
						else{
							System.out.println("-----Book not Available");
						}
					}
				}
			}
		}
		else if(uid>200 && uid<204){
			int identifyUser = uid - 201;
			if(stfObj[identifyUser].getBalance() <= 0 ){
				System.out.println("-----You have no Balance...!!");
			}
			else{
				for(int i = 0; i<10; i++){
					if(b[i].getBid() == bid){
						if(b[i].getAvabilityBit() == 1){
							stfObj[identifyUser].dcrBalance();
							b[i].setAvabilityBit(0);
							
							for(int j = 0; j<5; j++){
								if(stfObj[identifyUser].getBookSlot(j) == 0){
									stfObj[identifyUser].setBookSlot(j,bid);
									stfObj[identifyUser].setBName(j,b[i].getBName());
									break;
								}
							}
							
							System.out.println("-----Book Issued");
						}
						else{
							System.out.println("-----Book not Available");
						}
					}
				}
			}
			/*int identifyUser = uid - 201;
			if(stfObj[identifyUser].balance <= 0 ){
				System.out.println("You have no Balance...!!");
			}
			else{
				for(int i = 0; i<10; i++){
					if(b[i].bid == bid){
						if(b[i].avabilityBit == 1){
							stfObj[identifyUser].balance--;
							b[i].avabilityBit = 0;
							
							for(int j = 0; j<5; j++){
								if(stfObj[identifyUser].bookSlot[j] == 0){
									stfObj[identifyUser].bookSlot[j] = bid;
								}
							}
							System.out.println("Book Issued");
						}
						else{
							System.out.println("Book not Available");
						}
					}
				}
			}*/
		}
		else{
			System.out.println("-----Please Check User ID");
			System.out.println("-----User ID is must in Between");
			System.out.println("	 	For Student :- 101 to 105");
			System.out.println("	 	For Staff :- 201 to 203");
		}
		
	}
	
	public void returnBook(int uid,int bid){
		boolean retBook = false;
		if(uid>100 && uid<106){
			int identifyUser = uid - 101;
			if(stdObj[identifyUser].getBalance() == 3 ){
				System.out.println("-----You didn't have any Book...!!");
			}
			else{
				for(int i = 0; i<3; i++){
					if(stdObj[identifyUser].getBookSlot(i) == bid){
						for(int j = 0; j<10; j++){
							if(b[j].getBid() == bid){
								b[j].setAvabilityBit(1);
								stdObj[identifyUser].setBookSlot(i,0);
								stdObj[identifyUser].incrBalance();
								//stdObj[identifyUser].setBName(j," ");
								System.out.println("-----Book Returned...!!");
								retBook = true;
							}
						}
					}
				}
			}
			if(retBook == false){
			System.out.println("-----You didn't have that Book...!!");
			}
		}
		else if(uid>200 && uid<204){
			int identifyUser = uid - 201;
			if(stfObj[identifyUser].getBalance() == 5 ){
				System.out.println("-----You didn't have any Book...!!");
			}
			else{
				for(int i = 0; i<5; i++){
					if(stfObj[identifyUser].getBookSlot(i) == bid){
						for(int j = 0; j<10; j++){
							if(b[j].getBid() == bid){
								b[j].setAvabilityBit(1);
								stfObj[identifyUser].setBookSlot(i,0);
								stfObj[identifyUser].incrBalance();
								//stfObj[identifyUser].setBName(j," ");
								System.out.println("Book Returned...!!");
								retBook = true;
							}
						}
					}
				}
				if(retBook == false){
					System.out.println("-----You didn't have that Book...!!");
				}
			}
			/*if(stfObj[identifyUser].balance == 5 ){
				System.out.println("You didn't have any Book...!!");
			}
			else{
				for(int i = 0; i<3; i++){
					if(stfObj[identifyUser].bookSlot[i] == bid){
						for(int j = 0; j<10; j++){
							if(b[j].bid == bid){
								b[j].bid = 1;
								stfObj[identifyUser].bookSlot[i] = 0;
								System.out.println("Book Returned...!!");
						
							}
						}
					}
					else{
						System.out.println("You didn't have that Book...!!");
					}
				}
			}*/
		}
		else{
			System.out.println("-----Please Check User ID");
			System.out.println("-----User ID is must in Between");
			System.out.println("	 	For Student :- 101 to 105");
			System.out.println("	 	For Staff :- 201 to 203");
		}
	}
	
	public void checkStatus(int uid){
		//boolean identifyBookSlot = false;
		
		if(uid>100 && uid<106){
			int identifyUser = uid - 101;
			System.out.println("User Balance : " + stdObj[identifyUser].getBalance());
			if(stdObj[identifyUser].getBalance() == 3 ){
				System.out.println("-----You didn't have any Book...!!");
			}
			else{
				System.out.println("List of Books that User have :");
				System.out.println("	-----------		-------------");
				System.out.println("	| Book ID |		| Book Name |");
				System.out.println("	-----------		-------------");
				for(int i = 0; i<3; i++){
						if(stdObj[identifyUser].getBookSlot(i) != 0){
						System.out.println("	     " + stdObj[identifyUser].getBookSlot(i) + "			" + stdObj[identifyUser].getBName(i));
						//identifyBookSlot = true;
					}
				}
			}
		}
		else if(uid>200 && uid<204){
			int identifyUser = uid - 201;
			System.out.println("User Balance : " + stdObj[identifyUser].getBalance());
			if(stfObj[identifyUser].getBalance() == 5 ){
				System.out.println("-----You didn't have any Book...!!");
				
			}
			else{
				System.out.println("List of Books that User have :");
				System.out.println("	-----------		-------------");
				System.out.println("	| Book ID |		| Book Name |");
				System.out.println("	-----------		-------------");
				for(int i = 0; i<5; i++){
					if(stfObj[identifyUser].getBookSlot(i) != 0){
					System.out.println("	     " + stfObj[identifyUser].getBookSlot(i) + "			" + stfObj[identifyUser].getBName(i));
					//identifyBookSlot = true;
					}
				}
			}
		}
		else{
			System.out.println("-----Please Check User ID");
			System.out.println("-----User ID is must in Between");
			System.out.println("	 	For Student :- 101 to 105");
			System.out.println("	 	For Staff :- 201 to 203");
		}
	}
	
	 public void readBookData() throws IOException{
		
		FileReader fr = null;
		try{
			File f = new File("book_db.csv");
			fr = new FileReader(f);
			int count;
			String fileCont = new String();
			char buffer[] = new char[4*1024];
			
			while((count=fr.read(buffer)) != -1){
				fileCont += new String(buffer);
			}
			//System.out.println(fileCont);
			String records[] = fileCont.split(";");
			
			for(int i=0; i<records.length-1; i++){
				String data[] = records[i].split(",");
				b[i].setAvabilityBit(Integer.parseInt(data[1]));
			}
			
			System.out.println("----------Book Data Loaded..! ");
		}catch(Exception e){
			//System.out.println("Error");
			System.out.println(e.getMessage()+" e1");
			e.printStackTrace();
		}finally{
			fr.close();
		}

	}
	
	public void readStdData() throws IOException{
		
		FileReader fr = null;
		try{
			File f = new File("std_db.csv");
			fr = new FileReader(f);
			int count;
			String fileCont = new String();
			char buffer[] = new char[4*1024];
			
			while((count=fr.read(buffer)) != -1){
				fileCont += new String(buffer);
			}
			//System.out.println(fileCont);
			String records[] = fileCont.split(";");
			//System.out.println(records[0]);
			//int val1;
			for(int i=0; i<records.length-1; i++){
				String data[] = records[i].split(",");
				stdObj[i].setBookSlot(0,Integer.parseInt(data[1]));
				//System.out.println("Std Data: " + stdObj[i].getBookSlot(0));
				stdObj[i].setBookSlot(1,Integer.parseInt(data[2]));
				stdObj[i].setBookSlot(2,Integer.parseInt(data[3]));
				stdObj[i].setBalance(Integer.parseInt(data[4]));
				stdObj[i].setBName(0,data[5]);
				stdObj[i].setBName(1,data[6]);
				stdObj[i].setBName(2,data[7]);
			}
			//stdObj[0].setBookSlot(0,5);
			System.out.println("----------Std Data Loaded..! ");
		}catch(Exception e){
			//System.out.println("Error");
			System.out.println(e.getMessage()+" e1");
			e.printStackTrace();
		}finally{
			fr.close();
		}

	}
	
	public void readStfData() throws IOException{
		
		FileReader fr = null;
		try{
			File f = new File("stf_db.csv");
			fr = new FileReader(f);
			int count;
			String fileCont = new String();
			char buffer[] = new char[4*1024];
			
			while((count=fr.read(buffer)) != -1){
				fileCont += new String(buffer);
			}
			//System.out.println(fileCont);
			String records[] = fileCont.split(";");
			
			for(int i=0; i<records.length-1; i++){
				String data[] = records[i].split(",");
				stfObj[i].setBookSlot(0,Integer.parseInt(data[1]));
				stfObj[i].setBookSlot(1,Integer.parseInt(data[2]));
				stfObj[i].setBookSlot(2,Integer.parseInt(data[3]));
				stfObj[i].setBookSlot(3,Integer.parseInt(data[4]));
				stfObj[i].setBookSlot(4,Integer.parseInt(data[5]));
				stfObj[i].setBalance(Integer.parseInt(data[6]));
				stfObj[i].setBName(0,data[7]);
				stfObj[i].setBName(1,data[8]);
				stfObj[i].setBName(2,data[9]);
				stfObj[i].setBName(3,data[10]);
				stfObj[i].setBName(4,data[11]);
			}
			
			System.out.println("----------Stf Data Loaded..! ");
		}catch(Exception e){
			//System.out.println("Error");
			System.out.println(e.getMessage()+" e1");
			e.printStackTrace();
		}finally{
			fr.close();
		}

	}
	
	public void saveBookData() throws IOException{
		
		FileWriter fw = null;
		
		try{
			File f = new File("book_db.csv");
			fw = new FileWriter(f);
			for(int i = 0; i<b.length; i++){
				String bookContent = new String();
				bookContent += b[i].getBid() + ",";
				bookContent += b[i].getAvabilityBit() + ";";
				fw.write(bookContent.toCharArray());
			}
			System.out.println("----------Book Data Saved..!");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			fw.close();
		}
		
	}
	
	public void saveStdData() throws IOException{
		
		FileWriter fw = null;
		
		try{
			File f = new File("std_db.csv");
			fw = new FileWriter(f);
			for(int i = 0; i<stdObj.length; i++){
				String stdContent = new String();
				stdContent += stdObj[i].getStdId() + ",";
				stdContent += stdObj[i].getBookSlot(0) + ",";
				stdContent += stdObj[i].getBookSlot(1) + ",";
				stdContent += stdObj[i].getBookSlot(2) + ",";
				stdContent += stdObj[i].getBalance() + ",";
				stdContent += stdObj[i].getBName(0) + ",";
				stdContent += stdObj[i].getBName(1) + ",";
				stdContent += stdObj[i].getBName(2) + ";";
				
				fw.write(stdContent.toCharArray());
			}
			System.out.println("----------Student Data Saved..!");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			fw.close();
		}
		
	}
	
	public void saveStfData() throws IOException{
		
		FileWriter fw = null;
		
		try{
			File f = new File("stf_db.csv");
			fw = new FileWriter(f);
			for(int i = 0; i<stfObj.length; i++){
				String stfContent = new String();
				stfContent += stfObj[i].getStfId() + ",";
				stfContent += stfObj[i].getBookSlot(0) + ",";
				stfContent += stfObj[i].getBookSlot(1) + ",";
				stfContent += stfObj[i].getBookSlot(2) + ",";
				stfContent += stfObj[i].getBookSlot(3) + ",";
				stfContent += stfObj[i].getBookSlot(4) + ",";
				stfContent += stfObj[i].getBalance() + ",";
				stfContent += stfObj[i].getBName(0) + ",";
				stfContent += stfObj[i].getBName(1) + ",";
				stfContent += stfObj[i].getBName(2) + ",";
				stfContent += stfObj[i].getBName(3) + ",";
				stfContent += stfObj[i].getBName(4) + ";";
				//System.out.println(stfContent);
				fw.write(stfContent.toCharArray());
			}
			System.out.println("----------Staff Data Saved..!");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			fw.close();
		}
		
	}
}