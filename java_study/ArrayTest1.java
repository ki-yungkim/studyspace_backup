package com.work.view;

public class ArrayTest1 {
	//자바 어플리케이션 시작메서드
	// args 자바 어플리케이션 시작시에 전달받은 아규먼트 데이터
	public static void main(String[] args) {
		//System.out.println("args.length = " + args.length);
		//main1();
		//main2();
		main3();
	}
	//실습
	public static void main3() {
		String[] names = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		int[] scores = {92, 85, 77, 98, 65};
		int total = 0;
		int avg = 0;
		for (int index = 0; index < names.length; index++) {
			System.out.println((index+1) + "번 " + names[index] + "\t" + scores[index]);
			total += scores[index];
			
			}
		avg = total/names.length;
		System.out.println("총점 : " + total);
		System.out.println("평군 : " + avg);
		
		System.out.println("평균 : " + total/5.0); //int / double = double
		System.out.println("평균 : " + (int)(total/5.0)); //(int) int / double = double
		
	}
	
	
	public static void main2() {
		String[] names = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
	// ""만 했을 경우 -> 공백 문자열
		for (int index = 0; index < names.length; index++) {
			System.out.println(names[index]);
		}
	}

	
	
	
	
	public static void main1() {
		// 5명의 학생의 성적관리하는 프로그램 개발
		// 5명 성적 : 92, 85, 77, 98, 65
		// 배열 자료 저장구조 사용
		// 출력형식 
		// 1번 : 92
		// 2번 : 86
		// 총점 : 000
		// 평균 : 00 (소수 이하 버림) 
		
	int [] scores; 				//배열 선언
	scores = new int[5]; 			//배열 생성
	
	scores [0] = 92; 				//배열요소 사용
	scores [1] = 85;
	scores [2] = 77;
	scores [3] = 98;
	scores [4] = 65;
	
	int total = 0 ;
	int avg = 0;
	for (int index = 0; index < scores.length; index++) {
		System.out.println((index + 1) +  "번 : " + scores[index]);
		total += scores[index];
		
	}
	
	avg = total / scores.length;
	System.out.println("총점 : " + total);
	System.out.println("평균 : " + avg);
	
	}

}
