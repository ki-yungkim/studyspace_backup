package com.work.service;

import com.work.model.dto.StudentScore; 

/**
 * <pre>
 * 학생 성적관련 서비스 제공 클래스
 * 1. 등록 기능 : + addStudentScore(학번, 이름, 성적) : void 
 * 2. 조회 기능
 * 		>> 전체학생성적조회 기능 : + printStudentScore() : void
 * 		>> 학번의 해당학생 상세조회 기능 
 * 3. 총점 계산 기능
 * 4. 평균 계산 기능 
 * 
 * </pre>
 * 
 * @author 김기영
 * @version Ver.1.0
 * @since jdk1.8
 * @see com.work.model.dto.StudentScore 
 * @see com.work.model.dto.StudentScore#printInfo()
 */
public class StudentScoreService {
	/** 학생들의 성적정보 객체를 그룹으로 관리하기 위한 자료 저장구조 : 필요시에 확장*/
	//public StudentScore[] students = new StudentScore[3];
	
	/** 학생들의 성적정보 객체를 그룹으로 관리하기 위한 자료 저장구조 멤버변수 선언 : 배열객체 생성은 생성자 위임처리
	 * -- 접근 권한 : public => private 변경 (외부에서 함부로 변경 안된다 : 보안데이터)
	 * -- 등록 학생수 조회 제공: getter()
	 *  */
	private StudentScore[] students;
	
	/** 등록된 학생의 숫자 정보 및 등록해야 하는 배열요소의 인덱스 번호 
	 * -- 접근 권한 : public => private 변경 (외부에서 함부로 변경 안된다 : 보안데이터)
	 * -- 변경 불가 
	 * -- 
	 * */
	
	private int count;
	/** 기본생성자 : 배열의 크기를 기본 10개 초기화 */
	public StudentScoreService() {
		this(10);
		//students = new StudentScore[10];
	}
	
	/**
	 * 배열의 크기를 전달 받아서 배열생성 할당 초기화 생성자
	 * @param length
	 */
	public StudentScoreService(int length) {
		students = new StudentScore[length];
	}
	
	/** 현재 등록한 학생 성적의 숫자 조회 메서드*/
	public int getCount() {
		return count;
	}
	
	// 1. 등록 기능 : + addStudentScore(학번, 이름, 성적) : void : 메서드 선언 실습
	/**
	 * <pre>
	 * 학생성적 등록 메서드
	 * -- 등록결과 메세지 출력
	 * -- 성공 : 등록 성공
	 * -- 실패 : 등록 실패 
	 * 
	 *  # 처리 수행절차
	 * 1. StudentScore 객체 설정
	 * 2. 아규먼트로 전달받은 정보로 생성 객체 정보 설정 
	 * 3. 생성된 객체를 배열의 count 요소위치에 등록
	 * 4. count 등록인원을 1 증가
	 * 

	 * </pre>
	 * @param studentNo 학번 
	 * @param name 이름 
	 * @param score 성적
	 */

	public void addStudentScore(String studentNo, String name, int score) {
		if (count == students.length) {
			extendStudents(10);
			System.out.println("저장구조 확장");
		}


		StudentScore dto = new StudentScore();

		dto.studentNo = studentNo;
		dto.name = name;
		dto.score = score;

		students[count++] = dto;
	}

	//등록 메서드 중복 정의 studentscore 매개변수 전달받음 
	public void addStudentScore(StudentScore dto) {
		if (count == students.length) {
			extendStudents(10);
			System.out.println("저장구조 확장");
		}

		students[count++] = dto;
	}

	public void extendStudents(int length) {
		StudentScore[] studentsTemp = new StudentScore[students.length + length];

		for (int index = 0; index < students.length; index++) {
			studentsTemp[index] = students[index];
		}

		students = studentsTemp;
	}


	public void printStudentScore() {
		for (int index = 0; index < count; index++) {
			students[index].printInfo();

		}

	}



}