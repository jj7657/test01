package org.zerock.domain;

public class exam {
	
	public static void main(String[] args) {
//		System.out.print("  |  ");
//		for (int i = 1; i < 10; i++) {
//			System.out.print(i+" ");
//			if(i==9) {
//				System.out.print("\n");				
//			}
//		}
//		System.out.println("--+-------------------");
//		for (int i = 0; i < 10; i++) {
//			System.out.print(i+" | ");
//			for (int j = 1; j < 10; j++) {
//				int add= j+i;
//				String result;
//				if (add<10) {
//					result=" "+add; 
//				}else {
//					result=""+add;
//				}
//				System.out.print(result);
//				
//			}
//			System.out.println("");
//		}
		
		for (int i = 1; i < 5; i++) {
			for (int j = i+1; j < 5; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < ((i-1)*2)+1 ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
