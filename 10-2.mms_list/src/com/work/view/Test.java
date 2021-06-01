package com.work.view;

import java.util.ArrayList;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.model.service.MemberService;
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

	/**
	 * 회원관리시스템 테스트 메서드
	 * 
	 * -- 회원등록(아이디, 비밀번호, 이름, 휴대폰, 이메일) : 사용자 입력
	 * -- service(model) : 사용자입력정보 + 시스템(가입일 현재날짜, 등급 일반회원, [+ 마일리지 정책 가입시 1000])
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		print("회원관리 서비스 이용위한 객체 생성");
		MemberService service = new MemberService();

		print("초기화 회원 등록 : " + service.initMember());  


		print("회원등록");
		//Member dto = new GeneralMember("아이디", "비밀번호", "이름", "휴대폰", "이메일");
		service.addMember("test01", "pass01", "테스터1", "010-1000-1000", "test01@work.com");
		service.addMember("test02", "pass02", "테스터2", "010-1000-2000", "test02@work.com");
		service.addMember("test01", "pass01", "테스터1", "010-1000-1000", "test01@work.com");

		print("현재 등록회원수 : " + service.getCount());


		print("전체회원 조회");
		ArrayList list = service.getMember();
		for (int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
		}

		print("회원 상세조회 : user01");
		Member dto = service.getMember("user01");
		if (dto != null) {
			System.out.println(dto);
		}


		print("회원 상세조회 : 신규등록 회원 test");
		dto = service.getMember("test01");
		if (dto != null) {
			System.out.println(dto);
		}


		print("user01 회원 전체정보 변경 ");
		//dto = new GeneralMember("user01", "", "", "", "" );
		dto = service.getMember("user01");

		print("변경전 user01 정보 : " + dto);
		// 변경하고자하는 속성 setter 이용해서 변경 

		dto.setName("김고영");
		dto.setMobile("010-1232-1234");
		dto.setMemberPw("pass0100");

		//변경수행 
		boolean result = service.setMember(dto);

		dto = service.getMember("user01");
		print("변경 후 user01 정보 : " + dto);

		// 변경객체 : invalid : 없는 아이디 회원 변경 
		dto = new GeneralMember("xxxx", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);

		result = service.setMember(dto);
		if(result) {
			System.out.println(service.getMember("xxxx"));

		} else {
			System.out.println("xxxx 아아디 회원정보가 존재하지 않습니다.");
		}

		// 비밀번호 변경 
		print("비밀번호 변경전 조회 : ");
		dto = service.getMember("user02"); //user02, password02
		System.out.println(dto);

		//비밀번호 변경 
		result = service.setMemberPw("user02", "password02", "goodluck");
		if(result) {
			System.out.println("비밀번호 정상 변경처리되었습니다.");
		} else {
			System.out.println("[오류] 회원의 정보를 다시 확인하시기 바랍니다.");

		}
		
		dto = service.getMember("user02");
		System.out.println(dto);
		
		
		
//		print("user01");
//		System.out.println(service.getMember("user01"));
//		dto = service.removerMember("user01");
//		if (dto != null) {
//			System.out.println("[탈퇴성공]" + dto.getName() + "님 그동안 서비스를 이용해주셔서 감사합니다.");
//		} else {
//			System.out.println("[탈퇴실패] 회원의 정보를 다시 확인하시기 바랍니다." );
//			
//		}
		
	}


















	public static void main1(String[] args) {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");






		print("회원관리 서비스 이용위한 객체 생성");
		MemberService service = new MemberService(); 




		print("회원등록");
		service.addMember(dto1);
		service.addMember(dto2);
		service.addMember(dto3);
		service.addMember(dto4);
		service.addMember(dto5);

		service.addMember(dto5);
		service.addMember(dto2);

		print("등록인원수 : " + service.getCount());


		//		print("회원 초기화 등록");
		//		service.initMember();		

		//		print("user01 상세조회");
		//		Member dto = service.getMember("user01");
		//		if (dto != null) {
		//			System.out.println(dto); 
		//		}
		//
		//		print("user99 상세조회");
		//		dto = service.getMember("user99");
		//		if (dto != null) {
		//			System.out.println(dto); 
		//		}
		//
		//		print("전체조회");
		//		service.getMember();
		//
		//		print("회원정보 전체변경");
		//		service.setMember(dto7);
		//
		//		print("암호변경");
		//		service.setMemberPw("user02", "password02", "newword");
		//		service.setMemberPw("user02", "0000", "newword");
		//
		//		print("회원탈퇴");
		//		service.removeMember("user03", "password03");
		//		System.out.println();
		//		service.removeMember("user01", "p0000");
		//		service.removeMember("user0", "password0");
		//
		//
		//		print("회원전체탈퇴(배열요소 초기화)");
		//		service.removeMember();
		//		
		//		print("로그인");
		//		service.initMember();
		//		
		//		service.login("user01", "password01");
		//		service.login("user01", "password02");
		//		service.login("user", "password02");
		//		
		//		print("가입일로 아이디 찾기");
		//		service.entryDateId("2020-12-15");
		//		service.entryDateId("2020-1");
		//		
		//		print("전화번호, 이메일로 아이디 찾기");
		//		service.searchId("01012344000","user04@work.com");
		//		service.searchId("000","user04@work.com");
		//		
		//		print("아이디, 전화번호, 이메일로 비밀번호 찾기");
		//		service.searchPw("user04", "01012344000","user04@work.com");
		//		service.searchPw("04", "01012344000","user04@work.com");
		//		
		//		print("등급 별 아이디 조회");
		//		service.gradeMember("G");
		//		service.gradeMember("N");


	}

	/** 테스트시에 출력위한 메서드 */
	public static void print(String message) {
		System.out.println("\n### " + message);

	}

}
