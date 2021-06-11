package com.work.view;

import com.work.model.dto.StudentScore;
import com.work.service.StudentScoreService;

/**
 * <pre>
 * 학생 성적 관리 프로그램 시작 클래스
 * 
 * </pre>
 * 
 * @author 김기영
 * @version Ver.1.0
 * @since jdk1.8
 * @see com.work.model.dto.StudentScore 
 * @see com.work.model.service.StudentScoreService
 */
public class Test {
	
	/* this() 테스트*/
	public static void main3(String[] args) {
		StudentScore dto3 = new StudentScore("3번", "이순신", 77);
		dto3.printInfo();
	}
	
	/* 생성자 테스트 */
	public static void main2(String[] args) {
		// 기본 생성자 이용한 객체 생성
		StudentScore dto1 = new StudentScore();
		dto1.studentNo  = "1번";
		dto1.setName("홍길동");
		dto1.setScore(92);
		
		// 필수 초기화 생성자 이용한 객체 생성
		StudentScore dto2 = new StudentScore("2번", "강감찬");
		dto2.setScore(92);
		
		// 전체초기화 생성자 이용한 객체 생성
		StudentScore dto3 = new StudentScore("3번", "이순신", 77);
		
		dto1.printInfo();
		dto2.printInfo();
		dto3.printInfo();
	}

	/**
	 * 학생 성적 관리 프로그램 시작 메서드
	 * @param args 시작시 전달받은 문자열타입 배열정보
	 */
	public static void main(String[] args) {
		StudentScoreService service = new StudentScoreService();
		
	// 회원들의 자료저장구조 배열을 접근해서 변경 가능
   // service.students = null;   				// null => 배열객체 접근 불가 => NullPointException 예외 발생 
	  System.out.println("\n### 등록");
	  service.addStudentScore("1번", "홍길동", 92);
	  service.addStudentScore("2번", "강감찬", 85);
	  service.addStudentScore("3번", "이순신", 77);
	  service.addStudentScore("4번", "김유신", 98); // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
	  service.addStudentScore("5번", "유관순", 65);
	  
	 // service.students = null; 
	  // 기존 학생들의 성적정보가 저장된 배열 객체가 메모리에서 사라짐 
	  // public => private 접근 권한 변경으로 인해서 외부에서 함부로 변경불가 (보안문제 해결)
	  
	  //System.out.println("\n### 성적 등록 학생 수 : " + service.count);
	  System.out.println("\n### 성적 등록 학생 수 : " + service.getCount());
	  
	  //service.count = 500; // => 학생 등록 숫자 및 다음에 저장될 배열요소 인덱스 문제
	  service.addStudentScore("1번", "홍길동", 92); //bound 오류
	  
	  System.out.println("\n### 전체 학생 성적 조회");
	  service.printStudentScore();

	
	}

}
