package com.work.model.dto;

public class StudentScore {
	public String studentNo = "210517";
	public String name;
	public int score;
	
	//멤버변수 선언 
	
	// 학생의 성적 정보를 출력하는 메서드 선언
	public void printInfo() {
		System.out.println(studentNo + ",  " + name + ",  " + score );
	}
	
	// 학생의 성적을 아규먼트로 전달받은 데이터로 변경하는 메서드
	public void setScore(int modifyScore) {
		score = modifyScore;
	}
	
	// 학생의 성적을 조회하는 메서드
	public int getScore() {
		return score;
	}
	
	// 학생의 이름 정보를 변경하는 메서드
	public void setName(String modifyName) {
		name = modifyName;
	}
	// 학생의 이름 정보를 반환하는 메서드
	public String getName() {
		return name;
	}
}
