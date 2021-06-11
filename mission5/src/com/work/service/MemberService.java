package com.work.service;

import com.work.model.dto.Member;

/** 
 * <pre>
 * 회원관리 시스템 서비스 제공 클래스
 * 1. 등록 기능 : addMembers(가입일, 아이디, 비밀번호, 이메일, 전화번호, 등급) : void
 * 2. 조회 기능
 * 		> 비밀번호 조회
 * 		> 
 * 3. 변경 기능
 * 		> 비밀번호 변경, 내정보전체변경
 * 		> 등급 변경
 * 4. 휴대폰과 이메일 정보로 비밀번호 찾기 
 * </pre>
 */

/**
 * 
 * @author 김기영
 * @version Ver1.0
 * @since jdk1.8
 * @see com.work.model.dto.Member
 *
 */

public class MemberService {

	private Member[] members;

	private int count;

	public MemberService() {
		this(30);
	}

	public MemberService(int length) {
		members = new Member[length];

	}

	public int getCount() {
		return count;
	}

	public void addMembers(String signupDate, String id, String passwd, String email, String phone, String grade, int point, String name ) {
		if (count == members.length) {
			extendMembers(10);
			System.out.println("저장 공간 확장");
		}

		Member dto = new Member();

		dto.signupDate = signupDate;
		dto.id = id;
		dto.passwd = passwd;
		dto.email = email;
		dto.phone = phone;
		dto.grade = grade;
		dto.point = point;
		dto.name  = name;

		members[count++] = dto;
	}
	public void addMembers(Member dto) {
		if (count == members.length) {
			extendMembers(30);
			System.out.println("저장 공간 확장");
		}
		members[count++] = dto;
	}

	public void extendMembers(int length) {
		Member[] membersTemp = new Member[members.length + length];
		for (int index = 0; index < members.length; index++) {
			membersTemp[index] = members[index];
		}
		
		members = membersTemp;
	}
	public void printMember() {
		for (int index = 0; index < count; index++) {
			members[index].printInfo();
		}
	}


}

