package com.work.model.service;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

/**
 * 회원을 관리하기 위한 서비스 클래스
 * -- 회원들을 관리하기 위한 자료 저장구조 : 배열 다형성 반영(부모타입으로 진행) 
 * -- 메서드 아규먼트 다형성 반영 (부모타입), 반환타입?? 
 * 
 * -- 메서드명(매개변수) : 반환타입
 * 
 * -- C (등록) 
 * -- R (조회)
 * => 단일조회 (상세조회) => 아이디
 * => 다중조회 (전체조회, 그룹조회) => 전체조회(), 등급별회원전체조회(등급)
 * 
 * -- U (변경)
 * => 전체변경()
 * => 부분변경(비밀번호 변경 )
 * 
 * -- D	(삭제)
 * => 전체삭제
 * => 특정삭제 : 아이디 (아이디 입력하면 해당 회원 삭제)
 *  
 *  
 * @author 김기영
 *
 */
public class MemberService {
	
	/**
	 * 초기회원 등록 메서드
	 * 회원들을 관리하기 위한 자료 저장구조 : 배열 다형성 반영(부모타입) :
	 * 생성자 사용 초기화, 확장, 고정 본인이 편한 로직으로 진행
	 */
	
	public void initMember() {
		Member dto1 = new GeneralMember("user01","password01","홍길동","01012341000","user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user02","password02","강감찬","01012342000","user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03","password03","이순신","01012343000","user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04","password04","김유신","01012344000","user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator","admin1004","유관순","01012345000","administrator@work.com", "2020-04-01", "A", "선임");
	}
	
	/** 회원들이 정보 객체를 그룹으로 관리하기 위한 자료 저장구조 */
	
	private Member[] members;
	
	private int count;
	
	/** 기본생성자*/
		public MemberService() {
			members = new Member[10];
	}
		
	/**
	 * 배열의 크기를 전달받아서 배열생성 할당 초기화 생성자
	 * @param length
	 * @return 
	 */
	public MemberService(int length) {
		members = new Member[length];
	}
	
	
		//equals 쓰기 
	
		
		
//	}
	
	
	/**
	 * 회원등록
	 * -- 메서드명
	 * -- 매개변수
	 * -- 반환 타입
	 */
	public void addMember(Member m) {
		
	}
	
	public void getMember(String memberId) {
		return ;
	}
	
	public void editMember(Member m) {
		
	}
	
	public void delete(String memberId) {
		
	}
	
	

	/**
	 * 전체조회
	 * -- 메서드명
	 * -- 매개변수
	 * -- 반환 타입
	 * 
	 */
	public void printMember() {
		for (int index = 0; index < count; index++) {
			members[index].printInfo();
		}
	}
	
	/**
	 * 상세조회
	 * -- 메서드명
	 * -- 매개변수
	 * -- 반환 타입
	 * 
	 */
	public String getMemberPw() {
		//return memberPW;
	}
	
	/**
	 * 전체변경
	 * -- 메서드명
	 * -- 매개변수
	 * -- 반환 타입
	 */
	
	/**
	 * 비밀번호변경
	 * -- 메서드명
	 * -- 매개변수
	 * -- 반환 타입
	 */
	

	/**
	 * 전체삭제
	 * -- 메서드명
	 * -- 매개변수
	 * -- 반환 타입
	 */
	

	/**
	 * 회원삭제(아이디 입력하면 회원 삭제)
	 * -- 메서드명
	 * -- 매개변수
	 * -- 반환 타입
	 */
	
	
	/**
	 * 로그인 로그아웃 
	 * 
	 */
	
	public class login {
		public boolean login(String memberId, String memberPw) {
			if (memberId.equals("홍길동") && memberPw.equals("12345")) {
				return true;
			} else {
				return false;
			}
		}
		
		public void logout(String memberId) {
			System.out.println("로그아웃 되었습니다.");
		}
	}
  

}
