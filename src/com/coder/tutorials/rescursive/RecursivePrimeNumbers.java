package com.coder.tutorials.rescursive;

public class RecursivePrimeNumbers {

	public static void main(String[] args) {
		
		for (int i = 2; i < 50; i++) {
			
			if(primeNums(i, i-1) == 1)
				System.out.print(i + ",\t");
			else
				continue;
		}

	}
	
	private static int primeNums(int inputVal, int divider) {
		//prime numbers must be greater than one else return one.
		if(divider <= 1) 
			return 1;
		//if entered value it can be divided with itself and with one without residuary.
		else if(inputVal % divider == 0)
			return -1;
		else
			return primeNums(inputVal, divider-1);
	}
}
