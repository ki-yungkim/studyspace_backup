/*
 랜덤 조짜기 실습
 210522 14시 : 1차원 배열로 저장하고 args 수 만큼 랜덤 이름 뽑아서 한 조로 나오게 하는 형식은 완성
- 중복 체크 추가 O 
- 2차원 배열 사용 X
- 조별 팀원 수가 다른 경우 조치 X

2차원 배열 행크기, 열크기 분석해서 선언 및 생성

#Integer.parseInt : String 문자열타입의 숫자데이터를 int 타입으로 변환

 */



package com.work.view;

import java.util.Random;

public class RandomTeamTest {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: javac RamdomTeamTest 팀원 숫자");
			System.exit(0);
		}
		
		int teamNum = Integer.parseInt(args[0]); 

		String[] names = {"김기영", "김나연", "김대현", "김수정", "김의현", "김재현", "김종환", "김주리",
				"김주엽", "김지원", "김현수", "김현진", "김혜진", "노한나", "문수인", "박민재",
				"박영규", "박유정", "신지수", "유 건", "유동국", "유준성", "이태규", "이택근",
				"이희원", "장현우", "조성현", "최낙원", "한다예", "황윤아"};	
		
		
		int[] num = new int[names.length];
		for (int i = 0; i < names.length; i++) {
				int randomNO = getRandomNo();
				
				num[i] = randomNO;
				
				for (int j = 0; j < i; j++) {
					if(num[i] == num[j]) {
						i--;
					}
				}			
			}	
		
		int index = 0;
		String team = null;
		
		for(int i = 0; i < names.length; i++) {
			index = num[i];
			team = names[index];
			
			if ((i + 1) % teamNum == 0) {
				System.out.println(team + " ");
				
			} else {
				System.out.print(team + " ");
			}
		}
	}
	
//매서드  임의의 정수형 숫자를 추출하기 위한 제공 코드입니다.  0 ~ 29 사이의 임의의 숫자 추출
	public static int getRandomNo() {
		Random extractNo = new Random((long)(Math.random() * System.nanoTime()));
		int no = extractNo.nextInt(30); 
		return no;
	}
}

