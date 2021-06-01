package com.work.model.service;

import java.util.ArrayList;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.util.Utility;

/**
 * Collection API 활용 변경 
 * -- ArrayList
 * @author 김기영
 * @version
 * @since
 *
 */

public class MemberService {
	/**
	 * 회원들을 저장관리하기 위한 자료 저장구조  
	 */
	private ArrayList list = new ArrayList();


	/** 기본생성자 : 초기화 회원 등록 */
	public MemberService() {
		//		int count = initMember();
		//		System.out.println("초기화 회원 등록 작업이 완료되었습니다. : " + count);
		//System.out.println("초기화 회원 등록 작업이 완료되었습니다. : " + initMember());

	}

	/**
	 * 회원탈퇴
	 * @param memberId 아이디
	 * @param memberPw 비밀번호 
	 * @return 성공시 탈퇴회원기존 정보, 실패시 null
	 */
	public Member removerMember(String memberId, String memberPw) {
		int index = exist(memberId);
		if(index >= 0) {
			Object obj = list.get(index);
			if (obj instanceof Member) {
				Member dto = (Member)obj;
				if(dto.getMemberId().equals(memberPw)) {
					return (Member)list.remove(index);
					
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 회원탈퇴
	 * @param memberId 아이디
	 * @return 성공시 탈퇴회원기존 정보, 실패시 null
	 */
	public Member removerMember(String memberId) {
		int index = exist(memberId);
		if(index >= 0) {
			return (Member)list.remove(index);
		}
		return null;
	}
 
	
	/**
	 * 회원정보 전체 
	 * @param dto 변경회원객체
	 * @return 성공시 true, 실패시 false
	 */
	public boolean setMember(Member dto) {
		
		int index = exist(dto.getMemberId());
		if(index >= 0) {
			list.set(index, dto);
			return true;
		}
		return false;
	}
		
		
	/**
	 * 비밀번호 변경
	 * -- 아규먼트 : 아이디, 비밀번호, 변경비밀번호  
	 * -- 도메인 데이터 각각 : 아이디, 비밀번호, 변경비밀번호 
	 * -- 도메인 객체? : Member? => X - 도메인 속성에 변경 비밀번호는 없다.
	 * -- Map : key:value 
	 * @return 
	 */
	public boolean setMemberPw(String memberId, String memberPw, String modifyMemberPw) {
		
		int index = exist(memberId);
		if(index >= 0) {
			Object obj = list.get(index);
			if (obj instanceof Member) {
				Member dto = (Member)obj;
				if(dto.getMemberPw().equals(memberPw)) {
					dto.setMemberPw(modifyMemberPw);
					return true;
				}
			}
		}
		return false; // 아이디가 존재하지 않거나, 기존 비밀번호 틀린경우 
	}
	
	
	/** 현재 등록한 전체 회원 조회*/
	public ArrayList getMember() {
		return list;
	}

	/**
	 * 현재 등록 인원수 조회
	 * @return 현재 등록 인원수 
	 */
	public int getCount()	{
		return list.size();
	}

	/**
	 * 회원등록
	 * -- 사용자 입력 데이터 : 아이디, 비밀번호, 이름, 휴대폰, 이메일 
	 * -- 시스템 최초 가입시 일반회원 가입처리 : 가입일, 등급, [마일리지]
	 * @param dto 등록회원 
	 */
	public void addMember(Member dto) { 
		if (exist(dto.getMemberId()) == -1) {
			list.add(dto); //list 순서 존재, 중복 허용 -> 개발자 등록 전에 중복여부 검증처리 : 순서 인덱스는 사용하고, 중복되지 않고 처리 가능
		} else {
			System.out.println("[오류] 동일한 아이디가 존재합니다. : " + dto.getMemberId());
		}
	}
	/**
	 * 회원등록
	 * -- 사용자 입력 데이터 : 아이디, 비밀번호, 이름, 휴대폰, 이메일 
	 * -- 시스템 최초 가입시 일반회원 가입처리 : 가입일, 등급, [마일리지
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 */
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) {
		GeneralMember dto = new GeneralMember(memberId, memberPw, name, mobile, email);
		dto.setGrade("G");
		dto.setEntryDate(Utility.getCurrentDate());
		dto.setMileage(1000);

		addMember(dto);
	}

	/**
	 * 회원존재유무 조회 : 저장된 회원의 크기만큼 반복, 저장 객체 조회(Object), instanceof, type casting, equals()
	 * @param memberId 아이디 
	 * @return 존재시 저장 위치 인덱스번호, 미존재시 -1
	 */
	public int exist(String memberId) {

		// jdk1.4 
		for (int index = 0; index < list.size(); index++) {  // list 사이즈 만큼 반복
			Object obj =  list.get(index);					 // 저장 객체 Object 조회 
			if (obj instanceof Member) {					// instanceof 객체 타입 비교 자식은 부모의 객체 가능 
				Member dto = (Member)obj;					//  type casting
				if(dto.getMemberId().equals(memberId)) {			// 부모에게서 아이디 가져와서 equals로 중복 체크 
					return index;
				}
			}
		}
		return -1;
	}
	// False 
	//	for (int index = 0; index < list.size(); index++) {
	//	if(list.get(index).equals(memberId)) {    // => 문법상 문제는 없는데 Member class의 아이디를 비교하는게 equals 
	
		// => Member#equals(String) : Member 객체하고 String 같은지 비교 
	//		return index;
	//	}
	//}	
	//
	//return -1;
	//}

	//jdk 1.5 // 인덱스 번호가 없다. 

	//		for (objec obj : list) {
	//			if (obj.equals(memberId)) {
	//				return;
	//			}
	//		}

	public int initMember() {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");

		addMember(dto1);
		addMember(dto2);
		addMember(dto3);
		addMember(dto4);
		addMember(dto5);

		return list.size();
	}

	/**
	 * 회원 상세 조회
	 * @param memberId 회원아이디
	 * @return 존재하면 회원객체, 미존재 null
	 * @see exist(String)
	 */
	public Member getMember(String memberId) {
		int index = exist(memberId);
		if (index >= 0) {
			return (Member)list.get(index);
		}

		return null;
	}


}
