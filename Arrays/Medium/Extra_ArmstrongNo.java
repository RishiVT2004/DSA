You are given an integer 'n'. Return 'true' if 'n' is an Armstrong number, 
and 'false' otherwise.
An Armstrong number is a number (with 'k' digits) such that the sum of its digits
raised to 'kth' power is equal to the number itself. 
For example, 371 is an Armstrong number because 3^3 + 7^3 + 1^3 = 371.

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = Integer.toString(n);
		int sum = 0;
		int k = s.length();
		int temp = n;

		while(temp > 0){
			int digit = temp%10;
			sum += Math.pow(digit,k);
			temp = temp/10;
		}

		if(sum == n){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
		System.out.println("");
	}
}
  

