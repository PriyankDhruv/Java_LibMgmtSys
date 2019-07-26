package com.lib.model;

class Reader{
	public static int rid=0;
	public int balance;
	
	Reader(){}
	
	/*public void setBalance(int b){
		this.balance = b;
	}
	
	public int getBalance(){
		return balance; 
	}*/
}



public class DAO{
	
	static public Book b[] = new Book[10];
	static public Student stdObj[] = new Student[5];
	static public Staff stfObj[] = new Staff[3];
	
	public void initData(){
		

		b[0] = new Book("Harry Potter",1,1,"A1","X1");
		b[1] = new Book("Wings of Fire",2,1,"A2","X2");
		b[2] = new Book("Positive Mind Set",3,1,"A3","X3");
		b[3] = new Book("Goals",4,1,"A4","X4");
		b[4] = new Book("Sacred Games",5,1,"A5","X5");
		b[5] = new Book("Kuchh Toh Log Kahenge - Sanju",6,1,"A6","X6");
		b[6] = new Book("Flash",7,1,"A7","X7");
		b[7] = new Book("Iron Man",8,1,"A8","X8");
		b[8] = new Book("Man of Steel",9,1,"A9","X9");
		b[9] = new Book("Dark Knight Rises",10,1,"A10","X10");
		
		stdObj[0] = new Student(101);
		stdObj[1] = new Student(102);
		stdObj[2] = new Student(103);
		stdObj[3] = new Student(104);
		stdObj[4] = new Student(105);
		
		stfObj[0] = new Staff(201);
		stfObj[1] = new Staff(202);
		stfObj[2] = new Staff(203);
	}	
}