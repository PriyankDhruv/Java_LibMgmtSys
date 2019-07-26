package com.lib.model;

public class Book{
	int bid,avabilityBit;
	String publisher,writer,bName;
 	
	Book(){}
	
	Book(String argBName,int argBid,int argAvabilityBit,String argPublisher,String argWriter){
		bName = argBName;
		bid = argBid;
		avabilityBit = argAvabilityBit;
		publisher = argPublisher;
		writer = argWriter;
	}
	
	public int getBid(){
		return bid;
	}
	
	public void setAvabilityBit(int bit){
		this.avabilityBit = bit;
	}
	public int getAvabilityBit(){
		return avabilityBit;
	}
	
	public String getBName(){
		return this.bName;
	}
	
	
}