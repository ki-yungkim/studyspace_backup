package com.work.view;

public class Test {
	
		
	public static void main4(String[] args) {
		byte a = 5; //선언 및 초기화인 경우에만 byte = int, 연산의 기본은 int
		byte b = 10; // 
		
		//byte result = a + b; //byte = int + int 연산의 수행결과 오류발생, 자동형변환 발생하지 않음
		//byte result = (byte)a + b; // 연산자 우선순위 byte = byte + int => bytr = int 수행결과 오류 발생
		byte result = (byte)(a + b); // 연산 수행결과에 대해서 명시적 형변환 할당
	}
	
	// ascii code : A-65, a-97, 0-48
	public static void main3(String[] args) {
		char c1= '0'; //char = char 같은 타입 할당
		int c2 = c1; // int char 자동형변환) 큰타입 할당
		System.out.println(c1);
		System.out.println(c2);
		System.out.println((char)70);
	}
	
	// = 할당 연산자 활용
	public static void main2(String[] arg) {
		int no1 = 5; //int = int 같은 타입 자동할당
		long no2 = 5; //long = int 큰 타입 자동할당
		//int no3 = 5.2; //int = double 오류
		int no4 = (int)5.2; //int = (int)double 명식적 형변환 할당 (실수를 정수로 형변환 소수이하 버림처리)
	
	}

	public static void main1(String[] arg) {
		// 이름 정보를 변수에 설정해서 저장
		String name; // = "김기영";
		name = "홍길동";
		//나이 정보를 변수에 설정해서 저장
		int age = 30;
		
		// 나의 정보를 콘솔창 출력
		System.out.println(name);
		System.out.println(age);
	}
}
