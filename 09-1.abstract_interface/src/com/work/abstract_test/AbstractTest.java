package com.work.abstract_test;

public class AbstractTest {

	public static void main(String[] args) {
		//Pet pet = new Pet(); // error : 추상클래스는 직접 객체 생성 불가
		Pet[] pets = new Pet[5]; //부모타입의 다형성 반영한 변수 사용 가능
		pets[0] = new Dog();
		pets[1] = new Cat();
		pets[2] = new Dog();
		pets[3] = new Cat();
		pets[4] = new Dog();
		
		for (Pet p : pets ) {
			p.eat();
		}
		
		pets[0].name = "코코";
		for (Pet p : pets ) {
			System.out.println(p.name);
		}
	}

}

//public 붙이면 오류 
/** 부모추상클래스*/
abstract class Pet { 
	public String name = "씩씩이";
	public void eat() {
		System.out.println("애완동물은 음식을 먹습니다.");
	}
	
	public abstract void speak();
	
	public abstract void song();
	
}
/** 자식 클래스*/
class Dog extends Pet { 
	//재정의 안 하면 error: The type Dog must implement the inherited abstract method Pet.speak()
	
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
}

/** 자식 클래스*/
class Cat extends Pet { 
	
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
}



