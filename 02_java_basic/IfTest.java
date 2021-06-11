package com.work.view;

public class IfTest {
	
	//실습 : if ~ else 구문을 switch 구문으로 변경
	public static void main(String[] args) {
		int score = 100;
		String grade = null;
		
		if (score >= 0 & score <=100) {
			
		switch (score/10) {
			
			case 10 :
				
			case 9 :
				grade = "A";
				break;
				
			case 8 :
				grade = "B";
				break;
				
			case 7 :
				grade = "C";
				break;
				
			case 6 :
				grade = "D";
				break;
				
			default:
				grade = "F";
				break;
		}
		
		System.out.println("점수 : " + score + " 등급 : " + grade);
		
		
		} else {
			System.out.println("[오류] 성적은 0 ~ 100 이내입니다. : " + score);
		}
	}
	
	
	public static void main3(String[] args) {
		
		int score = 15;
		String grade = null;
		
		if (score >= 0 & score <=100) {
			
			if (score >=90) {
				grade = "A";
			} else if (score >=80) {
				grade = "B";
			} else if (score >=70) {
				grade = "C";
			} else if (score >=60) {
				grade = "D";
			} else {
				grade = "F";
			}
			System.out.println("점수 : " + score + " 등급 : " + grade);
		} else {
			System.out.println("[오류] 성적은 0 ~ 100 이내입니다. : " + score);
		}
	}
	
	
	
	
	/*실습
	 * -- 성적에 따라 등급을 출력하는 프로그램을 완성하세요
	 * -- 성적은 0 ~ 100점 이내
	 * -- A : 90 ~ 100점
	 * -- B : 80 ~ 89점
	 * -- C : 70 ~ 79점
	 * -- D : 60 ~ 69점
	 * -- F : 0 ~ 59점
	 * 
	 * -- 출력형식 00점 0등급
	 * -- 출력형식 변경 => 점수 : 00 등급 : 00
	 
	 
	 
	 */
	
	public static void main2(String[] args) {
		
		int score = 155;
		
		if (score >= 0 & score <=100) {
			
			if (score >=90) {
				System.out.println(score + "점 A등급");
				
			} else if (score >=80) {
				System.out.println(score + "점 B등급");
			
			} else if (score >=70) {
				System.out.println(score + "점 C등급");
			
			} else if (score >=60) {
				System.out.println(score + "점 D등급");
			
			} else {
				System.out.println(score + "점 F등급");
			}
		} else {
			System.out.println("[오류] 성적은 0 ~ 100 이내입니다. : " + score);
		}
	}
	

	
	
	public static void main1(String[] args) {
		// 성적을 변수에 저장
		
		int score = 65;
		
		// 성적이 70점 이상이면 합격출력, 70점 미만이면 불합격 출력
		
		if (score >= 70) {
			System.out.println(score + " 합격");
		} else {
			System.out.println(score + " 불합격");
		
				
		}
		
	}


}

	