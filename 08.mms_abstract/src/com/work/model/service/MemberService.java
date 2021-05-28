// new-class에서 체크 체크 해서 만듬 
/** 
 * 
 */
package com.work.model.service;

import com.work.model.dto.Member;

/**
 * @author kky
 *
 */
public class MemberService extends MemberServiceAbstract {



	/**
	 * 회원들을 관리하기 위한 자료 저장구조 : 배열 다형성 반영(부모타입) :
	 * 생성자 사용 초기화, 확장, 고정 본인이 편한 로직으로 진행
	 */
	// private..  MemberService에 있어야 한다 
	private Member[] members = new Member[10];

	private int count;

	/**
	 * 현재 등록 인원수 조회
	 * @return 현재 등록 인원수 
	 */

	public int getCount()	{
		return count;
	}


	/*
	 * 회원등록 구현 절차 :
	 * 1. 현재 등록된 회원수 (count)와 현재배열의 크기와 같은지 비교해서      
	 * 
	 *  => 별도의 매서드로 분리설계 : 구현 클래스에서 메서드 (내가 맘대로 할 거니까)
	 * 2. 같으면 새로이 확장배열(기존배열의 크기 +)을 생성해서  (고정적, 동적 다 가능 고정 10개 or 배열의 크기만큼 더 추가 )
	 * 3. 새로이 확장한 배열요소에 기존 배열요소에 저장된 객체들을 이동저장 시킨 후
	 * 4. 기존에 참조하고 있는 배열대신에 새로이 확장한 배열요소 변경 참조설정 
	 * ...  
	 * 5. count의 배열요소에 아규먼트로 전달받은 회원객체 등록 : 
	 * 6. count를 1 증가 시킴 
	 */


	@Override   //선언문 동일 
	public void addMember(Member dto) { 
		if (count == members.length) {
			extendMembers();
		} 

		if (exist(dto.getMemberId()) == -1) { //전달 받은 dto는 객체 지금 원하는건 속성 memberId
			members[count++] = dto; 

		} else { 
			System.out.println("[오류] 000 아이디는 사용할 수 없습니다.");

		}


		// 무조건 등록 문제 : 중복  => 해결 방법 : 등록하기 전에 등록된 회원의 아이디가 같은지(같은 객체 equals())
		// 동일아이디를 갖는 회원객체 존재하는 경우에는 오류메세지 출력 (void 라서 오류메세지로)
		// 오류메세지 : [오류] 000 아이디는 사용할 수 없습니다.
	}

	// 기존 배열요소를 기본배열크기 + 배열크기를 확장처리 메서드 
	// System.arraycopy() 메서드 활용
	// System.arraycopy(Object원본, int 시작위치, Object 복사해줄 대상, int 시작위치, int 길이)
	// static 시스템이 가지고 있다
	/**
	 * <pre>
	 * 배열구조 추가 확장해서 기존 저장정보 이동 처리 메서드
	 * 1. memberTemp 배열을 member 길이만큼
	 * 2.
	 * 3.
	 * 4.
	 * </pre>
	 * @see java.lang.System#arraycopy(Object, int, Object, int, int)
	 * 
	 */
	public void extendMembers() { //반환타입 필요 없다 members 가져온다 
		Member[] memberTemp = new Member[members.length + members.length];
		System.arraycopy(members, 0, memberTemp, 0, members.length);
		members = memberTemp;
	}
	
	
	/*
	 * 회원상세조회 절차 :
	 * 
	 * 1. exist(String memberId) 수행결과 : 저장위치 반환 
	 * 2. 저장위치 0보다 크거나 같은지 비교해서
	 * 3. True면 존재하니까 해당 배열요소의 객체를 return 반환 
	 * 4. False면 (0보다 작으면) 존재하지 않음 : 존재하지 않으므로 객체타입의 기본 값  return null
	 */
	
	/**
	 * 회원상세조회
	 */
	@Override
	public Member getMember(String memberId) {
		int index = exist(memberId);
		if (index >= 0) { 
			return members[index];
		}  			
		
		System.out.println("[오류]" + memberId + "는 존재하지 않는 아이디입니다.");
		return null;
	}


	//The type MemberService must implement the inherited abstract method MemberServiceAbstract.exist(String)
	/*
	 * CRUD 메서드에서 사용하기 위한 회원 존재유무 및 저장 위치 조회 메서드
	 * 1. 현재 등록된 회원수만큼 반복하면서 
	 * 2. 배열에 저장된 순서대로 저장된 객체의 아이디와(dto.getMemberId()) 아규먼트로 전달받은 아이디가 같은지 비교해서 (Sting#equals(문자열))
	 * 3. 아이디가 같으면 현재 저장된 벼열요소의 인덱스 번호를 반환 
	 * 
	 * 4. 반복을 다 했는데도 return 되지 않았다면 아이디 정보를 갖는 회원객체가 존재하지 않으므로 return -1

	 * @param memberId 아이디
	 * @return 존재시에 저장위치 번호, 미존재시 -1
	 */
	@Override
	public int exist(String memberId) {
		
		for (int index = 0; index < count; index++) { 
			
			if(members[index].getMemberId().equals(memberId)) {
				return index;
			}
		}
		return -1;
		
	}
	
	/** 전체 조회
	 * 
	 * System.arraycopy 사용
	 * 현재 등록된 모든 회원들의 정보만을 저장한 배열, 다형성 Member[]
	 * 
	 * 뭔가 다른 방법이 있을 거다 생각해보자
	 */

	@Override
	public Member[] getMember() {
		
		
		Member[] memberPrint = new Member[members.length]; 
		System.arraycopy(members, 0, memberPrint, 0, count);
		for (int index = 0; index < count; index++) {
			System.out.println(memberPrint[index]);
		}
		
		return null;
	}

	
	
	
	/**전체변경
	 *  존재하는 위치를 알아와서 아규먼트로 전달 받은 것을 왕창 교체 (아이디, 비밀번호, 이름 등등)
	 *  오류 발생시 메세지 처리
	 *  뭔가 이거 아닌거 같은데.. 일단 아이디가 동일하면 나머지 입력 받은 정보로 바꿔주는 메서드 
	 * */
	@Override
	public void setMember(Member dto) {
		int index = exist(dto.getMemberId());
		if (index >= 0) {
			members[index] = dto;
			System.out.println(dto);
		} else {
			System.out.println("[오류]" + dto.getMemberId() + "는 존재하지 않는 아이디입니다.");
		}
		return;
	}

	/** 비밀번호 변경
	 * 아이디 찾고 
	 *  저장되어 있는 비밀번호와 전달받은 비밀번호가 같은지 비교 equals - 같으면 변경 암호로 변경 
	 *  - setMemberPw, 아이디부터 없으면 존재X, 아이디는 존재하는데 비밀번호 안 맞으면 안 맞다고 출력 
	 *  (오류사항 2개)
	 *  매개변수 아이디, 비밀번호, 변경비밀번호
	 * boolean 암호변경성공 true, 실패하면 false 
	 * */
	@Override
	public boolean setMemberPw(String memberId, String memberPw, String newPw) {
		int index = exist(memberId);
		if (index >= 0) {
			if (members[index].getMemberPw().equals(memberPw) == true) {
				members[index].setMemberPw(newPw);
				System.out.println(members[index]);
		} else {
			System.out.println("맞지 않는 비밀번호입니다");
		}
		
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		
		return false; 
	}

	/** 회원탈퇴
	 * 아이디 비밀번호 각각 조회 후 동일하면 null 넣으면 됨,  (count - 1), null 칸이 늘어남 낭비, null 체크 코드 추가 해야함
	 *  - 요소들 다 한칸 앞으로 이동시키는 방식은 IO 많이 발생!
	 *  - 맨 마지막 요소를 삭제된 요소에 넣기 - 마지막 칸은 null 처리
	 * */
	@Override
	public void removeMember(String memberId, String memberPw) {
		int indexId = exist(memberId);
		int indexPw = exist(memberPw);
		
		if (indexId == indexPw) {
			members[indexId] = members[(count - 1)];
			members[(count - 1)] = null; 
		}
		for (int index = 0; index < count; index++) {
			System.out.println(members[index]);
		}
	}

	/** 회원 전체탈퇴 (데이터초기화)*/
	@Override
	public void removeMember() {
		
		
	}

	
	
	
	
	
//	public class login {
//	public boolean login(String memberId, String memberPw) {
//		if (memberId.equals("홍길동") && memberPw.equals("12345")) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public void logout(String memberId) {
//		System.out.println("로그아웃 되었습니다.");
//	}
//}
//
	
	
}
