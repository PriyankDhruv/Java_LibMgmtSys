package com.lib.model;


public class Student extends Reader{
	int stdid;
	int bookSlot[] = new int[3];
	int balance;
	String bName[] = {null , null , null};
	public Student(int id){
		stdid = id;
		rid++;
		balance = 3;
		for(int i = 0; i<3; i++){
			bookSlot[i] = 0;
		}
	}
	
	public int getStdId(){
		return this.stdid;
	}
	
	public void incrBalance(){
		this.balance = this.balance + 1;
	}
	public void dcrBalance(){
		this.balance = this.balance - 1;
	}
	
	public int getBookSlot(int i){
		return this.bookSlot[i];
	}
	public void setBookSlot(int i,int bid){
		bookSlot[i] = bid;
	}
	
	public void setBalance(int b){
		this.balance = b;
	}
	
	public int getBalance(){
		return this.balance; 
	}
	
	public void setBName(int i, String name){
		bName[i] = name;
	}
	public String getBName(int i){
		return this.bName[i];
	}
}