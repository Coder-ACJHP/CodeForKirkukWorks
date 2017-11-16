package com.coder.tutorials.rescursive;

public class RecursiveFibonacci {

	public static void main(String[] args) {
		
		for(int i=0; i < 10; i++) {
			System.out.print(fibonacci(i) + ",\t");
		}

	}
	
	private static int fibonacci(int x) {
		if(x == 0)
			return x;
		else if(x == 1)
			return x;
		else
			return fibonacci(x-1) + fibonacci(x-2);
	}

}
