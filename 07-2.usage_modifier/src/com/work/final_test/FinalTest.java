package com.work.final_test;

/*
 *8교시
 */
public class FinalTest {

}
//public class A { } : error  A.java로 하면 되긴 한다 가독성 안 좋음
//
//class A extends String { }  : error The type A cannot subclass the final class String

class B {
	public void doA() {
		System.out.println("A");
	}
	public final void doB() {
		System.out.println("B");
	}
	
}

class C extends B {
	public int count = 100;  //인스턴스 변수 
	
	// 상수 선언 
	public static final int MAX_COUNT = 30;
	
	@Override
	public void doA() {
		count = 200; //인스턴스 안에서는 변경 가능
		//MAX_COUNT = 500; //error : The final field C.MAX_COUNT cannot be assigned
		System.out.println("자식에서 재정의 변경합니다.");
	}
	
//	public void doA() { //Duplicate method doA() in type C 중복정의 위반 아규먼트 달라야 한다. 
//	}
	
	public void doA(int no1, final int no2) {
		no1 = 100;
		//no2 = 100; //error : The final local variable no2 cannot be assigned. (전달 받은 값 그대로 써야한다)
		
	}
	
//	@Override 
//	public void doB() {										//- Cannot override the final method 
//		System.out.println("자식에서 재정의 병경합니다.");  
//	}
}

