package com.work.test;

public class MethodTest {

	public static void main(String[] args) {
		MethodType test = new MethodType();
		// 참조변수명 할거 없으면 객체 소문자로 하는 것도 가능
		// 정해져 있으면 정해진 것으로 꼭
		
		// jdk1.4 기반의 for 구문
		for (int index = 0; index < 5; index++) {
			test.doA();
		}
		
		// 문자열 배열에 인사말 정보를 저장 : 선언 + 생성 + 명시적초기화 동시
		String [] hello = {"안녕하세요", "반갑습니다", "잘 지냈나요", "밥 잘 먹고 다니나요"};
		
		// jdk1.5 for
		// 반복회수 지정하지 않음 : 배열에 담긴 갯수만큼(items) 자동으로 반복하면서 한개씩 가져와서 할당
		// 배열객체, Collection API 사용 가능
		// 형식 : for (타입 변수명 : 배열명 또는 Collection 객체 참조 변수명) {}
		for (String message : hello) {
			test.doB(message);
			
		}
		System.out.println();
		test.doC();
		int result = test.doC();
		System.out.println(result);
		System.out.println(test.doC());
		
		
		System.out.println();
		result = test.add(100, 1234);
		System.out.println(result);
		
		test.add(100, 200);  //int, int
		test.add(100L, 200); //long, int
		test.add(100, 200L); //int, long
		test.add(100L, 200L); //long, long
		 
		test.add(100, 200F); // int, float => double double 
	}
		
}
