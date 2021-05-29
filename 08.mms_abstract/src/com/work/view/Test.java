package com.work.view;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.model.service.MemberService;
import com.work.model.service.MemberServiceAbstract;

public class Test {

	public static void main(String[] args) {

		/*
		 * Member dto1 = new GeneralMember("user01","password01","홍길동","01012341000","user01@work.com", "2020-12-15", "G", 50000);
		 * Member dto2 = new GeneralMember("user02","password02","강감찬","01012342000","user02@work.com", "2021-01-05", "G", 950000);
		 * Member dto3 = new SpecialMember("user03","password03","이순신","01012343000","user03@work.com", "2020-11-15", "S", "강동원");
		 * Member dto4 = new SpecialMember("user04","password04","김유신","01012344000","user04@work.com", "2021-01-05", "S", "김하린");
		 * Member dto5 = new AdminMember("administrator","admin1004","유관순","01012345000","administrator@work.com", "2020-04-01", "A", "선임");
		 */		

		Member dto6 = new GeneralMember("user06", "password06","김기영","0101234600","user06@work.com", "2020-12-06", "G", 70000); 
		Member dto7 = new GeneralMember("user01", "password07","김기영","0101234700","user07@work.com", "2020-12-07", "G", 70000); // 회원 정보 변경 용

		//MemberServiceAbstract service = new MemberServiceAbstract(); 
		//error : Cannot instantiate the type MemberServiceAbstract
		// 이유 : 추상클래스는 직접 객체생성불가 


		// 회원관리 서비스를 이용하기 위한 구현객체 생성
		//System.out.println("\n### 회원관리 서비스 이용 위한 객체 생성");

		print("회원관리 서비스 이용위한 객체 생성");
		MemberService service = new MemberService(); //

		print("회원 초기화 등록)");
		service.initMember();


		print("회원등록");
		//		service.addMember(dto1);
		//		service.addMember(dto2);
		//service.addMember(dto2);  //중복 문제 count가 올라간다. equals 재정의 필요 => 등록되지 않음
		//		service.addMember(dto3);
		//		service.addMember(dto4);
		//		service.addMember(dto5);
		service.addMember(dto6);

		print("등록인원수 : " + service.getCount());

		print("user01 상세조회");
		Member dto = service.getMember("user01");
		if (dto != null) {
			System.out.println(dto); // virtual method invocation : 실제 자식객체의 재정의한 toString() 수행 결과 출력
		}

		print("user99 상세조회");
		dto = service.getMember("user99");
		if (dto != null) {
			System.out.println(dto); // virtual method invocation : 실제 자식객체의 재정의한 toString() 수행 결과 출력
		}

		print("전체조회");
		service.getMember();

		print("회원정보 전체변경");
		service.setMember(dto7);


		print("암호변경");
		service.setMemberPw("user02", "password02", "newword");

		print("회원탈퇴");
		service.removeMember("user03", "password03");


		print("회원전체탈퇴(배열요소 초기화)");
		service.removeMember();
		
		// 여기까지 기본 
		
		
		print("로그인, 로그아웃");
		service.initMember();
		
		service.login("user01", "password01");
		service.login("user01", "password02");
		service.login("user", "password02");
		
		//service.logout("user01");
		
//		print("로그인 후 마일리지 추가");
//		service.loginplus("user01", "password01");
		
		print("가입일로 아이디 찾기");
		service.entryDateId("2020-12-15");
		
		print("전화번호, 이메일로 아이디 찾기");
		service.searchId("01012344000","user04@work.com");
		
		print("전화번호, 이메일로 비밀번호 찾기");
		service.searchPw("01012344000","user04@work.com");
		
		print("등급 별 아이디 조회");
		service.gradeMember("S");
		
		
	}

	/** 테스트시에 출력위한 메서드 */
	//매번 sysout에 원하는 형식 치지 말고 이렇게 메서드 만들어두고 편하게 쓰자 
	public static void print(String message) {
		System.out.println("\n### " + message);

	}

}
