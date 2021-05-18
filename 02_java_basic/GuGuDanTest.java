package com.work.view;

public class GuGuDanTest {

	public static void main(String[] args) {
		System.out.println("1. for 구문을 활용한 구구단\n");
		 
		for (int i = 1; i <=9; i++) {
			
			System.out.println();
			
			for (int j = 2; j <=9; j++) {
				if(i <2){
					System.out.print(j + "단\t");
					
				}
				
			}
			if(i <2){
				System.out.println();
			}
			for (int j = 2; j <=9; j++) {
				
				System.out.print(j+ "*" + i +"="+ i*j +"\t" );
			}
			
		}
			

	}

}
