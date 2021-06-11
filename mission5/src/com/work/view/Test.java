package com.work.view;

import com.work.model.dto.Member;

/**
 * <pre>
 * 회원관리 시스템 프로그램 시작 클래스
 * </pre>
 * 
 * @author 김기영
 * @version ver1.0
 * @since jdk1.8
 * see com.work.model.dto.Member
 * see com.work.model.dto.MemberService
 *
 */

public class Test {
	public static void main(String[] args) {
		Member dto = new Member("210525", "tomato", "www", "tt", "11", "A", 100, "kkk");
		dto.printInfo();
		
//		
//		 * @param signupDate 가입일
//		 * @param id 아이디
//		 * @param passwd 비밀번호
//		 * @param email 이메일
//		 * @param phone 휴대폰 번호
//		 * @param grade 등급
//		 * @param point 마일리지
//		 * @param name 이름
	}
}
