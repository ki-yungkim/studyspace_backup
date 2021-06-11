package com.work.view;

public class LoopTest {
	/*  1~ 5까지 출력하면서 누적된 결과를 출력해보세요
	 * 1. for 구문
	 * 2. while 구문
	 * 3. do~while 구문
	 */
	public static void main(String[] args) {
		int total = 0;
		System.out.println("\n1. for 구문");
		for (int i = 1;i <= 5; i++  ) {
			System.out.println(i);
			total += i;
		}
		System.out.println("total = " + total);
		
		System.out.println("\n2. while 구문");
		
		total = 0;
		int i = 1;
		while (i<=5) {
			System.out.println(i);
			total += i;
			i += 1;
		}
		System.out.println("total = " + total);
			
		System.out.println("\n3. do~while 구문");
		
		total = 0;
	    i = 1;
		do { 
			System.out.println(i);
			total += i;
			i += 1;
			
		} while(i <=5);
		System.out.println("total = " + total);
	}
	
	
	
	
	
	
	
	/*
	 * 실습 :영문 대문자에 대한 ascii code를 출력하는 프로그램을 작성하세요
	 * 출력형식: 영문알파벳 26자, type casting (형변환)
	 * A : 65
	 * B : 66
	 * ...
	 * Z : xx
	 */
	
	public static void main3(String[] args) {
		for (int i = 1, j = 'A'; j <= 'Z';i++, j++) {
			System.out.println((char)j + " : " + j);
			
		}
}
	
	public static void main2(String[] args) {
		for (int i = 1, j = 'A'; i <= 26; i++, j++) {
			System.out.println((char)(i) + " : " + i);
			
		}
}
	
	
	
	public static void main1(String[] args) {
	// for 구문을 이용해서 1~ 10까지 출력하면서 누적된 결과를 출력해보세요
	// 짝수만 출력하고 누적해서 출력
		int sum = 0;
		for (int i = 1; i <=10; i++) {
			
			if (i%2 == 0) {
			System.out.println(i);
			sum += i;
			}
		}
		System.out.println("total : " +  sum);
	}
	
}
