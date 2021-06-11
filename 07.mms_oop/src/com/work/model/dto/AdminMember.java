/**
 * 
 */
package com.work.model.dto;

/**
 * <pre>
 * 관리자 회원 도메인 클래스 
 * -- 회원(부모클래스)의 자식(상속)
 * 
 * # 일반회원 속성
 * 1. 아이디
 * 2. 비밀번호
 * 3. 이름
 * 4. 휴대폰
 * 5. 이메일
 * 6. 가입일
 * 7. 등급
 * 
 * 8. 마일리지
 * 9. 직책
 *  
 * </pre>
 * @author 김기영
 * @version ver.1.0
 * @since jdk1.8
 */
public class AdminMember extends Member {
	private String position;
	
	public AdminMember() {
		
	}
	
	public AdminMember(String memberId, String memberPw, String name, String mobile, String email) {
		
		setMemberId(memberId);
		setMemberPw(memberPw);
		setName(name);
		setMobile(mobile);
		setEmail(email);
		
		
		setEntryDate("2021-05-26");
		setPosition("팀장");
		
	}


	/**
	 * 
	 * 일반회원 모든데이터초기화 생성자
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 * @param entryDate 가입일
	 * @param manager 담당자
	 * @param position 직책
	 */
	public AdminMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate, String grade, String position) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.position = position;
	}
	
	/**
	 * @return the 
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return super.toString() + "," +  position;
	}

}
