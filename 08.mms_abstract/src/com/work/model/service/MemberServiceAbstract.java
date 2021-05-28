package com.work.model.service;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

/**
 * 회원을 관리하기 위한 서비스 클래스 (추상클래스 설계 변경) 
 * -- 추상클래스 구성요소
 * 	>> 클래스 구성요소 + [추상메서드] //추상메서드 없어도 추상 클래스일 수 있다
 * 
 * 
 * 
 * 
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
// 추상 클래스 
public abstract class MemberServiceAbstract {
	
	
	/**
	 * 회원등록
	 * -- 메서드명
	 * -- 매개변수 : 다형성 반영 모든회원을 등록하기 위한 메서드 
	 * -- 반환 타입
	 */
	public abstract void addMember(Member dto); //abstract 없으면 error : This method requires a body instead of a semicolon  
												//Member 
	
	/**
	 * CRUD 메서드에서 사용하기 위한 회원 존재유무 및 저장 위치 조회 메서드
	 * @param memberId 아이디
	 * @return 존재시에 저장위치 번호, 미존재시 -1
	 */
	public abstract int exist(String memberId); //저장하면 구현 클래스 MemberService에서 error 
	
	

	/**
	 * 전체조회
	 * -- 메서드명 : getMember()
	 * -- 매개변수 : no argument
	 * -- 반환 타입 : 현재 등록된 모든 회원들의 정보만을 저장한 배열, 다형성 Member[]
	 *  System.arraycopy 사용 
	 */
	
	public abstract Member[] getMember();
	
	
	/**
	 * 상세조회
	 * -- 메서드명 : getMember() 
	 * -- 매개변수 : memberId
	 * -- 반환 타입 : Member (반환타입다형성 : 부모타입) 추상메서드 선언!
	 * 
	 */
	
	public abstract Member getMember(String memberId);
	
	/**
	 * 전체변경
	 * 존재하는 위치를 알아와서 아규먼트로 전달 받은 것을 왕창 교체 (아이디, 비밀번호, 이름 등등)
	 * -- 메서드명 : setMember()
	 * -- 매개변수 : Member
	 * -- 반환 타입 : void (일단 void) / 오류 발생시 메세지 처리
	 */
	
	public abstract void setMember(Member dto);
	
	/**
	 * 비밀번호변경
	 * 아이디 비밀번호 변경암호 
	 * 아이디 위치 - 저장되어 있는 비밀번호와 전달받은 비밀번호가 같은지 비교 equals - 같으면 변경 암호로 변경 - setMemberPw, 아이디부터 없으면 존재X, 아이디는 존재하는데 비밀번호 안 맞으면 안 맞다고 출력 (오류사항 2개)
	 * -- 메서드명 : setMemberPw()
	 * -- 매개변수 : 아이디, 비밀번호, 변경비밀번호
	 * -- 반환 타입 : boolean 암호변경성공 true, 실패하면 false 
	 */
	
	public abstract boolean setMemberPw(String memberId, String memberPw, String newPW);

	/**
	 * 회원탈퇴 
	 * 
	 * 아이디 비밀번호 각각 조회 후 동일하면 null 넣으면 됨,  (count - 1), null 칸이 늘어남 낭비, null 체크 코드 추가 해야함 - 요소들 다 한칸 앞으로 이동시키는 방식은 IO 많이 발생! - 맨 마지막 요소를 삭제된 요소애 넣기 - 마지막 칸은 null 처리 - 
	 * -- 메서드명 : removeMember()
	 * -- 매개변수 : 아이디, 비밀번호
	 * -- 반환 타입 : void
	 */
	
	public abstract void removeMember(String memberId, String memberPw);
	
	/**
	 * 회원전체탈퇴 (데이터초기화) 
	 * -- 메서드명 : removeMember()
	 * -- 매개변수 : no argument
	 * -- 반환 타입 : void 
	 */
	
	public abstract void removeMember();
	
	
	/**
	 * 로그인 로그아웃
	 * 이건 나중에 
	 * 
	 */
	


}
