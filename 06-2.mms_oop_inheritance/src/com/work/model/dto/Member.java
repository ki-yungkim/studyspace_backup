package com.work.model.dto;

/**
 * <pre>
 * 회원관리 시스템 도메인 클래스
 * -- encapsulation 설계 반영 변경 
 * 
 * ## 회원 검증조건
 * 
1. 아이디 : 6자리 ~ 30자리 이내
2. 비밀번호 : 6자리 ~ 20자리 이내
3. 마일리지 : 0 ~ 100,000
4. 등급 : G, S, A
	>> 문자열 비교 메서드
	>> String
	>> equals(Object anObject) : boolean

	#Inheritance 설계 반영
	모든 회원들의 공통(일반화) : 부모 클래스 설계 변경 
 * 1. 아이디
 * 2. 비밀번호
 * 3. 이름
 * 4. 휴대폰
 * 5. 이메일
 * 6. 가입일
 * 7. 등금
 *</pre>
 *

 * @author 김기영
 * @version ver.1.0
 * @since jdk1.8
 * 
 */
public class Member {
	/** 아이디, 식별키 */
	private String memberId;

	/** 비밀번호, 필수 */
	private String memberPw;

	/** 이름 : 필수 */
	private String name;

	/** 휴대폰번호 : 필수 */
	private String mobile;

	/** 이메일 : 필수 형식 */
	private String email;

	/** 가입일 : 필수, 시스템 */
	private String entryDate;

	/** 등급, 필수, 일반 우수 관리자 시스템 제공 */
	private String grade;

	/** 기본생성자 */
	public Member() {
		System.out.println("부모 기본생성자");
	}

	/**사용자입력 필수데이터 초기화 생성자
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		System.out.println("부모 일반 입력필수데이터 초기화 생성자");
	}

	/**  */
	/**회원 필수 데이터 초기화 생성자 : 입력데이터 + 가입일, 등급
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade) {
		this(memberId, memberPw, name, mobile, email);
		this.entryDate = entryDate;
		this.grade = grade;
		

	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberPw
	 */
	public String getMemberPw() {
		return memberPw;
	}

	/**
	 * @param memberPw the memberPw to set
	 */
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return memberId + ", " + memberPw + ", " + name + ", " + mobile + ", " + email + ", " + entryDate + ", "
				+ grade;
	}









}


