package com.lib.model;

public class Staff extends Reader{
	int stfid;
	int bookSlot[] = new int[5];
	String bName[] = {null , null , null, null , null};
	int balance;
	public Staff(int id){
		stfid = id;
		rid++;
		balance = 5;
		for(int i = 0; i<5; i++){
			bookSlot[i] = 0;
		}
	}
	
	public int getStfId(){
		return this.stfid;
	}
	
	public void incrBalance(){
		this.balance = this.balance + 1;
	}
	public void dcrBalance(){
		this.balance = this.balance - 1;
	}
	
	public int getBookSlot(int j){
		return this.bookSlot[j];
	}
	public void setBookSlot(int j,int bid){
		this.bookSlot[j] = bid;
	}
	
	public int getBalance(){
		return balance; 
	}
	public void setBalance(int b){
		this.balance = b;
	}
	
	public void setBName(int i, String name){
		bName[i] = name;
	}
	public String getBName(int i){
		return this.bName[i];
	}
}