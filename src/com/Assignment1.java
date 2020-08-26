package com;

public class Assignment1 {
	public static void main(String args[]){
		A a=new A();
		A c=new A();
		if(null!=a.b)
		a.b.c=c.b.a;		
	}	
}
class A{
	 A a;
	 A b;
	 A c;
}

