package com.work.view;

import com.work.model.dto.Member;

public class Test {
	// Member dto = new Member로 처음부터 다 입력은 안되나? 확인 
	/*encapsulation 테스트 */
	public static void main(String[] args) {
		Member dto = new Member("test1", "pass", "기영", "01012341234", "www@www.com");
		
//		String memberId, String memberPw, String name, String mobile, String email, String entryDate,
//		String grade, int mileage, String manager
		System.out.println("변경 전 : " + dto);
		// 아이디 변경 ㅣ 멤버변수 직접 접근 불가
		//dto.memberId = "aaa"; //오류  Member 접근권한 private 선언, 외부에서 직접 접근 불가
		
		// 아이디 변경 ㅣ setter() 
		// 올바른 아이디 검증 규칙 준수
		dto.setMemberId("happyday2021");
		System.out.println("변경후 : " + dto);
			
		dto.setMileage(1000);
		System.out.println("변경후 : " + dto);
	}
	
	/* toString() 메서드 재정의 및 사용 테스트 */
	public static void main1(String[] args) {
		// 회원의 가입시 입력데이터 초기화생성자 이용해서 객체 생성 
		// 가입 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
		Member dto = new Member("test1", "pass", "기영", "01012341234", "www@www.com");
		
		// 생성한 회원객체의 정보를 출력
		// System.out.println(참조변수명); => 참조변수명.toSring() 수행결과문자열을 콘성창 출력;
		// toSring() 메서드 생략 가능
		//System.out.println(dto.toString());
		System.out.println(dto);
		
		
		
	
	}
	
}
