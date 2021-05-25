package com.work.model.dto;

/**
 * <pre>
 * 회원관리 시스템 도메인 클래스
 *</pre>
 *
 * @author 김기영
 * @version ver.1.0
 * @since jdk1.8
 * 
 */
public class Member {
	/** 가입일 : 식별키 */
	public String signupDate;
	
	/** 아이디 : 필수 */
	public String id;
	
	/** 비밀번호 : 필수 */
	public String passwd;
	
	/** 이메일 : 필수 */
	public String email;
	
	/** 휴대폰번호 : 필수 */
	public String phone;
	
	/** 등급 : 필수 */
	public String grade;
	
	/** 마일리지 : 필수 */
	public int point;
	
	/** 이름 : 선택 */
	public String name;
	
	/** 기본생성자 */
	public Member() {
		
	}
	/**
	 * 필수 데이터 초기화 생성자
	 * @param signupDate 가입일
	 * @param id 아이디
	 * @param passwd 비밀번호
	 * @param email 이메일
	 * @param phone 휴대폰 번호
	 * @param grade 등급
	 * @param point 마일리지
	 */
	public Member(String signupDate, String id, String passwd, String email, String phone, String grade, int point) {
		this();
		this.signupDate = signupDate;
		this.id = id;
		this.passwd = passwd;
		this.email = email;
		this.phone = phone;
		this.grade = grade;
		this.point = point;
		
	}
	/** 전체 데이터 초기화 생성자
	 * @param signupDate 가입일
	 * @param id 아이디
	 * @param passwd 비밀번호
	 * @param email 이메일
	 * @param phone 휴대폰 번호
	 * @param grade 등급
	 * @param point 마일리지
	 * @param name 이름
	 */
	public Member(String signupDate, String id, String passwd, String email, String phone, String grade, int point, String name) {
		this(signupDate, id, passwd, email, phone, grade, point);
		this.name = name;
	}
	
	/** 정보 출력 메서드 */
	public void printInfo() {
		System.out.println(signupDate + "\t" +  id + "\t" + name);  
	}
	
	/** 비빌번호 변경 메서드
	 * @param modifyPasswd 비밀번호 변경
	 */
	
	public void setpasswd(String modifyPasswd) {
		passwd = modifyPasswd;
	}
	
	/**
	 * 비밀번호 조회 메서드
	 * @return 비밀번호
	 */
	public String getPasswd() {
		return passwd;
	}
}
