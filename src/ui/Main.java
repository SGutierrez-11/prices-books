package ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int minRelation = Integer.MAX_VALUE;
	static int bestOption1=-1;
	static int bestOption2=-1;

	public static void main(String[] args) throws IOException {

		Scanner sc = new  Scanner(System.in);
		
		int amount = Integer.parseInt(sc.nextLine());

		String[] bookPrice = sc.nextLine().split(" ");
		
		int[] prices = new int[amount];

		for (int i=0; i < bookPrice.length;i++) {
			
			prices[i] = Integer.parseInt(bookPrice[i]);

		}

		int savings = Integer.parseInt(sc.nextLine());

		
		Arrays.sort(prices);
		
		difference(prices, savings);
		
		System.out.println("Peter should buy books whose prices are "+bestOption1+" and "+bestOption2);
		
		sc.close();
	}

	public static void difference(int[] prices, int savings) {
		
		int minus = 0;
		
		int num = 0;
		
		for(int i = 0; i<prices.length; i++) {
			
			minus = savings-prices[i];	
			
			int iterations = binarySearch(prices, minus);
			
			if (iterations >= 0) {
				
				int relations = Math.abs(prices[i] - prices[iterations]);
				
				if(relations < minRelation || num==0) {
					
					bestOption1 = prices[i];
					
					bestOption2 = prices[iterations];
					
					minRelation = relations;
				}

				num++;
			
			}
			
		}

	}
	
	public static int binarySearch(int[] prices, int savings) {
		
		int pos = -1;
		int i = 0;
		int j = prices.length-1;


		while(i<=j && pos<0) {
			int m = (i+j)/2;
			if(prices[m]==savings) {
				pos = m;
			}else if(prices[m] > savings) {
				j = m-1;
			}else {
				i = m+1;
			}
		}

		return pos;
	}
	
}