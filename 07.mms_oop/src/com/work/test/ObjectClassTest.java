package com.work.test;

import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;

public class ObjectClassTest {
	
	// Member 클래스 : equals() 재정의 테스트
	// 회원의 아이디가 같으면 같은 객체 
	// 중요!!!!!!!!!! 같은 객체여부를 비교할 때는 반드시 equals() 메서드로 비교해야 함 
	public static void main(String[] args) {
		Member dto1 = new GeneralMember("user01","password01","홍길동","01012341000","user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user01","password01","홍길동","01012341000","user01@work.com", "2020-12-15", "G", 50000);
		Member dto3 = new GeneralMember("user02","password01","홍길동","01012341000","user01@work.com", "2020-12-15", "G", 50000);
		
		//해시코드 값은 별 의미 없다 읽기 전용  논리적인 개념 
		//재정의 해주든 말든 아무 숫자만 넘겨줘도 문제 없다
		System.out.println("dto1 : " + dto1.hashCode()); // 참조값a
		System.out.println("dto2 : " + dto2.hashCode()); // 참조값a
		System.out.println("dto3 : " + dto3.hashCode()); // 참조값x
		
		System.out.println();
		System.out.println(dto1 == dto2);	// false     
		System.out.println(dto1 == dto3);	// false
		
		System.out.println();
		System.out.println(dto1.equals(dto2)); // true
		System.out.println(dto1.equals(dto3)); // false
		
	}
	
	//Member 클래스 : equals() 재정의하지 않고 테스트
	// Object 비교 : 같은 객체는 같은 참조값 , 따라서 ==, equals() 동일한 결과 
	public static void main2(String[] args) {
		Member dto1 = new GeneralMember("user01","password01","홍길동","01012341000","user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user01","password01","홍길동","01012341000","user01@work.com", "2020-12-15", "G", 50000);
		Member dto3 = new GeneralMember("user02","password01","홍길동","01012341000","user01@work.com", "2020-12-15", "G", 50000);


		// 생성한 객체의 hashCode() 참조값 출력
		// 각각 만들었기 때문에 각각 다른 객체 
		System.out.println("dto1 : " + dto1.hashCode());
		System.out.println("dto2 : " + dto2.hashCode());
		System.out.println("dto3 : " + dto3.hashCode());

		System.out.println();
		System.out.println(dto1 == dto2);	// false
		System.out.println(dto1 == dto3);	// false
		
		System.out.println();
		System.out.println(dto1.equals(dto2)); // false
		System.out.println(dto1.equals(dto3)); // false

	}


	public static void main1(String[] args) {
		// Object 비교 : 같은 객체는 같은 참조값 , 따라서 ==, equals() 동일한 결과 
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = obj1;

		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());

		System.out.println();
		System.out.println(obj1 == obj2); // false
		System.out.println(obj1 == obj3); // true

		System.out.println();
		System.out.println(obj1.equals(obj2)); // false
		System.out.println(obj1.equals(obj3)); // true
	}

}
