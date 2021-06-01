package com.work.model.service;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

/**
 * <pre>
 * 회원을 관리하기 위한 서비스 클래스 
 * 추상 클래스 @see {@link MemberServiceAbstract} 
 * 
 * 1. 회원등록
 * 2. 회원상세조회
 * 3. 전체조회
 * 4. 전체변경
 * 5. 비밀번호 변경
 * 6. 회원 탈퇴
 * 7. 회원 전체탈퇴(초기화)
 * 8. 초기 회원 등록 
 * 9. 로그인 
 * 10. 가입일 조회하여 아이디 출력
 * 11. 전화번호, 이메일 조회하여 아이디 출력
 * 12. 아이디, 전화번호, 이메일 조회하여 비밀번호 출력
 * 13. 등급별 아이디 조회
 * </pre>
 * 
 * @author 김기영
 * @version ver.1.0
 * @since jdk1.8
 */
public class MemberServiceArray {

	/**
	 * 회원들을 관리하기 위한 자료 저장구조
	 */
	private Member[] members = new Member[10];
	private int count;

	/**
	 * 현재 등록 인원수 조회
	 * @return 현재 등록 인원수 
	 */

	public int getCount()	{
		return count;
	}

	/**
	 * 
	 * 회원등록 메서드
	 * 1. 현재 등록된 회원수(count)와 현재 배열의 크기가 같은지 비교
	 * 2. 같으면 새로이 (현재 배열 크기 X 2) 크기의 확장배열 생성
	 * 3. 확장한 배열요소에 기존 배열요소 이동, 저장
	 * 4. 기존에 참조하고 있는 배열 대신 새로운 배열요소 변경 참조 설정
	 * 5. 회원수가 배열의 크기와 다르면 이미 등록된 회원 아이디와 일치하는지 확인
	 * 6. 일치하면 index 번호 반환, 다르면 -1 반환
	 * 6. -1이 반환되면 count 1 증가하고 members[count]에 아규먼트로 전달받은 회원객체 등록
	 * 
	 */
	public void addMember(Member dto) { 
		if (count == members.length) {
			extendMembers();
		} 

		if (exist(dto.getMemberId()) == -1) { 
			members[count++] = dto; 
		} else { 
			System.out.println("[오류]" + dto.getMemberId() + " 아이디는 사용할 수 없습니다.");

		}
	}

	/**
	 * 배열구조 추가 확장해서 기존 저장정보 이동 처리 메서드
	 * 1. memberTemp 배열을 (members x 2} 길이로 생성 
	 * 2. System.arraycopy로 배열 복사 
	 * 3. members에 참조 변경
	 * 
	 * @see java.lang.System#arraycopy(Object, int, Object, int, int)
	 * 
	 */
	public void extendMembers() { 
		Member[] memberTemp = new Member[members.length + members.length];
		System.arraycopy(members, 0, memberTemp, 0, members.length);
		members = memberTemp;
	}

	/**
	 * 초기회원 등록 메서드
	 */

	public void initMember() {
		
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
	}


	/**
	 * 회원상세조회
	 * 1. exist(String memberId) 수행결과 : 저장위치 반환 
	 * 2. 저장위치 0보다 크거나 같은지 비교해서
	 * 3. True면 존재하니까 해당 배열요소의 객체를 return 반환 
	 * 4. False면 (0보다 작으면) 존재하지 않음, 오류 메세지 출력  
	 * 5. 존재하지 않으므로 객체타입의 기본 값  return null
	 * 
	 */
	public Member getMember(String memberId) {
		int index = exist(memberId);
		if (index >= 0) { 
			return members[index];
		}  			

		System.out.println("[오류]" + memberId + "는 존재하지 않는 아이디입니다.");
		return null;
	}


	/**
	 * CRUD 메서드에서 사용하기 위한 회원 존재유무 및 저장 위치 조회 메서드
	 * 1. 현재 등록된 회원수만큼 반복하면서 
	 * 2. 배열에 저장된 순서대로 저장된 객체의 아이디와(dto.getMemberId()) 아규먼트로 전달받은 아이디가 같은지 비교해서 (Sting#equals(문자열))
	 * 3. 아이디가 같으면 현재 저장된 배열요소의 인덱스 번호를 반환 
	 * 4. 반복을 다 했는데도 return 되지 않았다면 아이디 정보를 갖는 회원객체가 존재하지 않으므로 return -1
	 * 5. 같은 방식으로 다른 요소들도 존재 유무 확인
	
	 */
	public int exist(String memberId) {

		for (int index = 0; index < count; index++) { 

			if(members[index].getMemberId().equals(memberId)) {
				return index;
			}
		}
		return -1;

	}

	public int existPw(String memberPw) {
		for (int index = 0; index < count; index++) { 

			if(members[index].getMemberPw().equals(memberPw)) {
				return index;
			}
		}
		return -1;
	}

	public int existEntryDate(String entryDate) {
		for (int index = 0; index < count; index++) { 

			if(members[index].getEntryDate().equals(entryDate)) {
				return index;
			}
		}
		return -1;
	}

	public int existMobile(String mobile) {
		for (int index = 0; index < count; index++) { 

			if(members[index].getMobile().equals(mobile)) {
				return index;
			}
		}
		return -1;
	}

	public int existEmail(String email) {
		for (int index = 0; index < count; index++) { 

			if(members[index].getEmail().equals(email)) {
				return index;
			}
		}
		return -1;
	}

	public int existGrade(String grade) {
		for (int index = 0; index < count; index++) { 

			if(members[index].getGrade().equals(grade)) {
				return index;
			}
		}
		return -1;
	}

	public int[] existGradeArray(String grade) {
		int[] temp = new int[count];
		int index = 0;
		for (int i = 0; i < count; i++) {
			if(members[index].getGrade().equals(grade)) {
				temp[i] = index ;
			} else {
				temp[i] = -1;
			}
			index++;
		}
		return temp; 
	}

	/** 
	 * 전체 조회
	 * 
	 * 1. members 길이만큼의 배열 memberPrint 만들고
	 * 2. members의 요소들 복사
	 * 3. memberPrint 배열 출력
	 * 
	 * checKpoint : 다른 방법 고안 중
	 * @see java.lang.System#arraycopy(Object, int, Object, int, int)
	 */

	public Member[] getMember() {
		Member[] memberPrint = new Member[members.length]; 
		System.arraycopy(members, 0, memberPrint, 0, count);
		for (int index = 0; index < count; index++) {
			System.out.println(memberPrint[index]);
		}

		return null;
	}

	/**
	 * 전체변경 (아이디가 일치하면 정보 변경)
	 * 1. 받은 아규먼트의 아이디를 조회하여 존재하는지 확인하고 
	 * 2. 존재하면 요소 위치를 받아와서 
	 * 3. 그 요소 위치에 있는 정보들을 받은 아규먼트에 있는 정보로 아이디 제외 전부 교체
	 * 4. 오류 발생시 메세지 처리
	 * checKpoint : 아이디까지 바꿀 수 있는 다른 방법 고안 중 
	 */
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

	/** 
	 * 비밀번호 변경
	 * 1. 받은 아이디가 존재하는지 확인하고 존재하면 요소 위치 받아서
	 * 2. 그 위치의 비밀번호와 아규먼트로 전달받은 비밀번호가 같은지 비교하고
	 * 3. 같으면 전달받은 새로운 비밀번호로 변경
	 * 4. 오류 : 아이디가 존재하지 않는 경우, 비밀번호가 맞지 않는 경우 
	 * 
	 */
	public boolean setMemberPw(String memberId, String memberPw, String newPw) {
		int index = exist(memberId);
		if (index >= 0) {
			if (members[index].getMemberPw().equals(memberPw) == true) {
				members[index].setMemberPw(newPw);
				System.out.println(members[index]);
			} else {
				System.out.println("[오류]" + "아이디 또는 비밀번호가 맞지 않습니다.");
			}

		} else {
			System.out.println("[오류]" + "아이디 또는 비밀번호가 맞지 않습니다.");
		}

		return false; 
	}

	/** 
	 * 회원탈퇴
	 * 1. 아이디, 비밀번호 존재하는지, 요소 위치 조회
	 * 2. 아이디, 비밀번호 요소 위치가 동일하면  
	 * 3. (count - 1)에 있는 요소를 그 위치로 옮기고 마지막 요소는 null 처리
	 * 4. 오류 : 아이디가 없는 경우, 비밀번호가 틀린 경우 
	 * 
	 */
	public void removeMember(String memberId, String memberPw) {
		int indexId = exist(memberId);
		int indexPw = existPw(memberPw);

		if (indexId < 0) {
			System.out.println("[오류]" + "없는 아이디 입니다.");
			return;
		}
		
		if (indexPw < 0) {
			System.out.println("[오류]" + "비밀번호가 틀립니다.");
			return;
		}

		if (indexId == indexPw) {
			members[indexId] = members[(count - 1)];
			members[(count - 1)] = null; 
			count--;
		} else {
			System.out.println("[오류]" + "비밀번호가 틀립니다.");
		}

		for (int index = 0; index < count; index++) {
			System.out.println(members[index]);
		}
	}

	/** 
	 * 회원 전체탈퇴 (데이터초기화)
	 * 1. members 배열 요소를 모두 null 만들고
	 * 2. count를 0으로 만듬
	 *
	 */
	public void removeMember() {
		for (int index = 0; index < count; index++) {
			members[index] = null;
			System.out.println(members[index]);
		}
		count = 0;
	}


	/**
	 * 계정 로그인 기능
	 * 1. 입력된 아이디, 비빌번호 존재 유무, 위치 조회
	 * 2. 아이디, 비밀번호 요소 위치 동일하면 로그인 메세지 출력 
	 * 3. 오류 : 아이디가 존재하지 않는 경우, 아이디와 비밀번호 요소 위치가 다른 경우
	 * 
	 * 추가 고안 사항 : 로그인 시 마일리지 추가하는 기능
	 * getMileage를 불러오는 방식을 실패하여 막혀있음
	 * 		
	 */

	public void login(String memberId, String memberPw) {
		int indexId = exist(memberId);
		int indexPw = existPw(memberPw);

		if (indexId < 0) {
			System.out.println("[오류]" + "아이디 또는 비밀번호가 틀립니다.");
			return; 
		}

		if (indexId == indexPw) {
			System.out.println(memberId + "로 로그인되었습니다.");
		} else {
			System.out.println("[오류]" + "아이디 또는 비밀번호가 틀립니다.");
		}
	}

	/**
	 * 가입일 조회해서 아이디 출력
	 * 1. 입력된 가입일 존재 유무, 위치 조회
	 * 2. 가입일 요소 위치에 해당하는 아이디 출력 
	 * 3. 오류 : 가입일이 없는 경우
	 * 
	 * 추가 고안 사항 : 입력한 가입일 기준 그 이후 가입 아이디 출력 기능 구현 
	 */
	public void entryDateId(String entryDate) {
		int index = existEntryDate(entryDate);
		if (index >= 0) {
			String ID = members[index].getMemberId();
			System.out.println("해당 가입일에 맞는 아이디는 : " + ID + "입니다");
		} else {
			System.out.println("[오류] 가입일 : " + entryDate + "인 아이디는 존재하지 않습니다.");
		}
	}

	/**
	 * 전화번호, 이메일  조회해서 아이디 출력
	 * 1. 입력된 전화번호, 이메일 존재 유무, 위치 조회
	 * 2. 전화번호, 이메일의 요소 위치가 동일하면  
	 * 3. 요소 위치에 해당하는 아이디 출력
	 * 4. 오류 : 전화번호가 없는 경우, 이메일이 없는 경우, 요소 위치가 다른 경우
	 * 
	 */
	public void searchId(String mobile, String email) {
		int indexMobile = existMobile(mobile);
		int indexEmail = existEmail(email);

		if (indexMobile < 0) {
			System.out.println("[오류]" + "없는 전화번호입니다.");
			return; 
		}

		if (indexEmail < 0) {
			System.out.println("[오류]" + "없는 이메일입니다.");
			return; 
		}

		if (indexMobile == indexEmail) {
			String ID = members[indexMobile].getMemberId(); 
			System.out.println("[오류]" +  "해당 정보에 맞는 아이디는 " + ID + "입니다.");
		} else {
			System.out.println("[오류]" + "전화번호 또는 이메일 정보가 정확하지 않습니다.");
		}
	}

	/**
	 * 아이디, 전화번호, 이메일 조회해서 비밀번호 출력
	 * 1. 입력된 아이디, 전화번호, 이메일 존재 유무, 위치 조회
	 * 2. 아이디, 전화번호, 이메일의 요소 위치가 동일하면  
	 * 3. 요소 위치에 해당하는 비밀번호 출력
	 * 4. 오류 : 아이디가 없는 경우, 전화번호가 없는 경우, 이메일이 없는 경우, 요소 위치가 다른 경우
	 */
	public void searchPw(String memberId, String mobile, String email) {
		
		int indexId = exist(memberId);
		int indexMobile = existMobile(mobile);
		int indexEmail = existEmail(email);
		
		if (indexId < 0) {
			System.out.println("[오류]" + "없는 아이디입니다.");
			return; 
		}
		
		if (indexMobile < 0) {
			System.out.println("[오류]" + "없는 전화번호입니다.");
			return; 
		}

		if (indexEmail < 0) {
			System.out.println("[오류]" + "없는 이메일입니다.");
			return; 
		}

		if ((indexId == indexMobile)&&(indexMobile == indexEmail) ) {
			String PW = members[indexId].getMemberPw(); 
			System.out.println( "해당 정보에 맞는 비밀번호는 " + PW + "입니다.");
		} else {
			System.out.println("[오류]" + "정보가 정확하지 않습니다.");
		}
	}

	/**
	 * 등급별 아이디 조회
	 * 1. 입력된 등급이 존재하면 요소 위치를, 존재하지 않으면 -1을 반환하는 existGradeArray 이용
	 * 2. 배열 indexGrade에 값들을 넣고 요소 값이 0 이상이면 요소에 맞는 아이디 출력 
	 * 3. 오류 : 값이 -1이면 잘못된 등급을 입력하셨습니다 출력
	 * 
	 */

	public void gradeMember(String grade) {
		int[] indexGrade = existGradeArray(grade);
		String[] ID = new String[count];
		for (int i = 0; i < count; i++) {
			if (indexGrade[i] >= 0) {
				int j = indexGrade[i];
				ID[i] = members[j].getMemberId();
				System.out.println("해당 등급에 해당하는 아이디는 : " + ID[i] + "입니다");
			} 
		}
		if (existGrade(grade) < 0) {
			System.out.println("[오류]" + "잘못된 등급을 입력하셨습니다.");
		}
	}

}
