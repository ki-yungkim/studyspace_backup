package com.work.view;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.model.service.MemberService;
import com.work.model.service.MemberServiceAbstract;
/**
 * <pre>
 * 테스트 클래스

 *  </pre>
 *  
 * @author 김기영
 * @version ver.1.0
 * @since jdk1.8
 */
public class Test {

	public static void main(String[] args) {

		Member dto6 = new GeneralMember("user06", "password06","김기영","0101234600","user06@work.com", "2020-12-06", "G", 70000); 
		Member dto7 = new GeneralMember("user01", "password07","김기영","0101234700","user07@work.com", "2020-12-07", "G", 70000); 

		print("회원관리 서비스 이용위한 객체 생성");
		MemberService service = new MemberService(); 

		print("회원 초기화 등록");
		service.initMember();


		print("회원등록");
		service.addMember(dto6);

		print("등록인원수 : " + service.getCount());

		print("user01 상세조회");
		Member dto = service.getMember("user01");
		if (dto != null) {
			System.out.println(dto); 
		}

		print("user99 상세조회");
		dto = service.getMember("user99");
		if (dto != null) {
			System.out.println(dto); 
		}

		print("전체조회");
		service.getMember();

		print("회원정보 전체변경");
		service.setMember(dto7);

		print("암호변경");
		service.setMemberPw("user02", "password02", "newword");
		service.setMemberPw("user02", "0000", "newword");

		print("회원탈퇴");
		service.removeMember("user03", "password03");
		System.out.println();
		service.removeMember("user01", "p0000");
		service.removeMember("user0", "password0");


		print("회원전체탈퇴(배열요소 초기화)");
		service.removeMember();
		
		print("로그인");
		service.initMember();
		
		service.login("user01", "password01");
		service.login("user01", "password02");
		service.login("user", "password02");
		
		print("가입일로 아이디 찾기");
		service.entryDateId("2020-12-15");
		service.entryDateId("2020-1");
		
		print("전화번호, 이메일로 아이디 찾기");
		service.searchId("01012344000","user04@work.com");
		service.searchId("000","user04@work.com");
		
		print("아이디, 전화번호, 이메일로 비밀번호 찾기");
		service.searchPw("user04", "01012344000","user04@work.com");
		service.searchPw("04", "01012344000","user04@work.com");
		
		print("등급 별 아이디 조회");
		service.gradeMember("G");
		service.gradeMember("N");
		
		
	}

	/** 테스트시에 출력위한 메서드 */
	public static void print(String message) {
		System.out.println("\n### " + message);

	}

}
