/**
 * 
 */
package com.work.model.dto;

/**
 * @author kky
 *
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
		setPosition("가");
		
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


}
