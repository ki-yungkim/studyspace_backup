/**
 * 
 */
package com.work.model.dto;

/**
 * <pre>
 * 일반회원 도메인 클래스
 * -- 회원(부모클래스)의 자식(상속)
 * 
 * 1. 아이디
 * 2. 비밀번호
 * 3. 이름
 * 4. 휴대폰
 * 5. 이메일
 * 6. 가입일
 * 7. 등금 
 * 
 * 8. 마일리지 
 * </pre>
 * @author 김기영
 * @version ver.1.0
 * @since jdk1.8
 */
public class GeneralMember extends Member {
	private int mileage;
	
	public GeneralMember() {
		System.out.println("일반 자식 기본생성자");
	};
	

	public GeneralMember(String memberId, String memberPw, String name, String mobile, String email) {
		// 자식객체의 생성자에서 부모객체의 생성자를 미지정 => javac 자동으로 부모의 기본생성자 super() 자동 호출
		
		// 자식객체의 생성자에서 부모객체의 생성자를 명시적으로 지정
		//super(memberId, memberPw, name, mobile, email);
		
		// 부모의 private 멤버는 접근권한으로 인해서 자식클래스일찌라도 접근 불가
		// super.memberId = memberId;
		
		// 부모로부터 상속받은 setter() 메서드를 이용해서 데이터 초기화 수행
		setMemberId(memberId);
		setMemberPw(memberPw);
		setName(name);
		setMobile(mobile);
		setEmail(email);
		
		setGrade("G");
		setEntryDate("2021-05-26");
		
		
		System.out.println("자식 일반 입력데이터 초기화");
	}

	// 일반 회원 모든 데이터 초기화 생성자 
	
	
	

	/**
	 * 
	 * 일반회원 모든데이터초기화 생성자
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 * @param entryDate 가입일
	 * @param grade 등급
	 * @param mileage 마일리지 
	 * 
	 */
	public GeneralMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.mileage = mileage;
	}
	
	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	
}
