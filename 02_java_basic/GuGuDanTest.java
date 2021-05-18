package com.work.view;

public class GuGuDanTest {
	
	//do ~ while 구문
	public static void main(String[] args) {
		System.out.println("3. do ~ while 구문을 활용한 구구단\n");
		
		int i = 1;
		int dan = 2;
		
		do {
			System.out.print(dan + "단\t");
			dan += 1;
			
		} while(dan <= 9);
		System.out.println();
		dan = 2;
		
		do {
			do {
				System.out.print(dan + "*" + i + "=" + i * dan + "\t");
				dan += 1;
				
			} while (dan <= 9);
			System.out.println();
			dan = 2;
			i += 1;
		} while (i <= 9);
			
	}
	
	
	
	
	
	
	//while 구문
	public static void main3(String[] args) {
		System.out.println("2. while 구문을 활용한 구구단\n");
		
		int i = 1;
		int dan = 2;
		
		while (dan <= 9) {
			System.out.print(dan + "단\t");
			dan += 1;
		}
		System.out.println();
		dan = 2;
		while (i <= 9) {
			while (dan <=9) {
				System.out.print(dan + "*" + i + "=" + i * dan + "\t");
				dan +=1;
			}
			i += 1;
			dan = 2;
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	
	
	//for 구문 2차 이건 다시 해보기
	public static void main2(String[] args) {
		System.out.println("1. for 구문을 활용한 구구단\n");
		int i;
		int dan;
		for (dan = 2; dan <= 9; dan++) {
			System.out.print(dan +"단\t");
		}
		System.out.println();
		for (i = 1; i <=9; i++) {
			for (dan =2; dan <= 9; dan++) {
				System.out.print(dan + "*" + i + "=" + i * dan + "\t");
			}
			System.out.println();
		}
	}
	
	
	

	// for 구문 1차 시도
	public static void main1(String[] args) {
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

