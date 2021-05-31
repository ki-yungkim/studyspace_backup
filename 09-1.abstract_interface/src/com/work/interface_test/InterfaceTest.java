package com.work.interface_test;

public class InterfaceTest {
	// 인터페이스 직접 객체 생성불가 
	// 부모타입의 다형성 반영한 변수 사용 가능 
	public static void main(String[] args) {
		Pet[] pets = new Pet[5]; 
		pets[0] = new Dog();
		pets[1] = new Cat();
		pets[2] = new Dog();
		pets[3] = new Cat();
		pets[4] = new Dog();
		
		for (Pet p : pets ) {
			p.eat();
		}
		
		//pets[0].name = "코코"; // 인터페이스의 멤버변수는 자동으로 상수처리 : 변경불가 
		System.out.println(Pet.name);
		for (Pet p : pets ) {
			System.out.println(p.name);
		}
	}

}
/** 인터페이스의 부모*/
interface Animal{
	public void sleep();
}


/** 부모 인터페이스 - 부모인터페이스 자식인터페이스 관계 : 인터페이스끼리는 상속관계 */
// 인터페이스 : 추상메서드, 상수로만 구성된 클래스 형태
//abstract를 interface로만 변경하면 오류 - 메서드 지워야함
//implements 붙이면 오류 
interface Pet extends Animal {  
	public String name = "씩씩이";
	
	public void eat();
	
	public abstract void speak();
	
	public abstract void song();
	
}
/** 자식 클래스*/
class Dog implements Pet { 
	
	@Override
	public void eat() {
		System.out.println("사료를 맛나게 먹습니다.");
	} 
	
	@Override
	public void speak() {
		System.out.println("멍멍 말을 합니다.");
	}
	
	@Override
	public void song() {
		// 필요없는 기능일지라도 구현 
	}

	@Override
	public void sleep() {
		// Pet 부모인 Animal에서 상속
	}
	
	
}

/** 자식 클래스*/
class Cat implements Pet { 
	
	@Override
	public void eat() {
		System.out.println("저염식을 맛나게 먹습니다.");
	} 
	
	@Override
	public void speak() {
		System.out.println("야옹 말을 합니다.");
	}
	
	@Override
	public void song() {
		// 필요없는 기능일지라도 구현
	}
	
	@Override
	public void sleep() {
		// Pet 부모인 Animal에서 상속
	}
}



