package com.vivek.problems;

class X {
	   static int i = 1111;

	   static{
	       i = i-- - --i;    //L1
	       System.out.println("static block X: i- "+i);
	   }

	   {
	       i = i++ + ++i;    //L2
	       System.out.println("initialize block X, i: "+i);
	   }
	}

	class Y extends X{
		
	   public Y() {
	       System.out.println("Constructor Y");
	   }
	   static{
	       i = --i - i--;    //L3
	       System.out.println("static block Y, i: "+i);
	   }
	   {
	       i = ++i + i++;    //L4
	       System.out.println("initialize block Y, i: "+i);
	   }
	}

	public class DriverClass{
	   public static void main(String[] args){
	       Y y = new Y();
	       System.out.println(y.i);    //L5
	       
	   }
	}
