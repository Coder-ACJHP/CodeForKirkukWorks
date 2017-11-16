package com.coder.tutorials.rescursive;

public class RecursiveFactorial {

	public static void main(String[] args) {
		
		System.out.println(factorial(5));

	}
	
	private static int factorial(int x) {
		if(x == 0)
			return 1;
		return x * factorial(x-1);
	}

}
