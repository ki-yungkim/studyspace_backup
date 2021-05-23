/*
 김기영_210523 완성

 랜덤 조짜기 실습
 210522 14시 : 1차원 배열로 저장하고 args 수 만큼 랜덤 이름 뽑아서 한 조로 나오게 하는 형식은 완성
- 중복 체크 추가 O 
- 2차원 배열 사용 X
- 조별 팀원 수가 다른 경우 조치 X

2차원 배열 행크기, 열크기 분석해서 선언 및 생성

210522 21시 :
- 2차원 배열 사용 O
- 조별 팀원 수가 다른 경우 > 딱 떨어지지 않고 남는 인원 처리 X
  조별 인원수 배열 조정이 필요 

#Integer.parseInt : String 문자열타입의 숫자데이터를 int 타입으로 변환
index에서 name.length % teamNum 만큼 뒤에서 세서 배열에 랜덤으로 추가 
index 시작이 teamcount * teamNum 
j는 0부터 해도 됨
k는 teamNum 
j는 랜덤으로 0 ~ (teamcount - 1) 


210523 11시 :
- 조별 팀원 수가 다른 경우 랜덤으로 한명씩 더 넣는 코드 추가
- 2차원 배열 출력 방법 추가 (반복문 사용)
- 쉬운 방법으로는 아래에 있는 것 사용 가능
- import java.util.Arrays; System.out.println(Arrays.deepToString(Team));
 
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

		int teamcount = names.length / teamNum;

		String[][] Team  = new String[teamcount][];


		for(int i = 0; i < teamcount; i++) {
			Team[i] = new String[(teamNum + 1)]; 
		}

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
		int i = 0;
		for(int j = 0; j < teamcount; j++) {
			for(int k = 0; k < teamNum; k++) {
				index = num[i];
				Team[j][k] = names[index];
				if(i < (names.length)) {
					i++;
				} else {
					break;
				}
			}
		}

		int[] check = new int[teamcount];
		for(i = 0; i < teamcount; i++ ) {
			check[i] = (int)(Math.random() * teamcount);
			for (int j = 0; j < i; j++) {
				if(check[i] == check[j]) {
					i--;
				}
			}
		}
		int k = 0;
		int j = 0;
		for(i = (teamcount * teamNum); i < names.length;) {
			for(j = 0; j < (names.length % teamNum); j++) {
				k = check[j];
				index = num[i];
				Team[k][teamNum] = names[index];
				i++;
			}
		}

		for (i = 0; i < Team.length; i++) {
			String[] inTeam = Team[i];
			System.out.print((i + 1) + " 팀 : ");
			for (j = 0; j < inTeam.length; j++) {
				System.out.print(inTeam[j] + " ");
			}
			System.out.println();
		}
		
	}

	//매서드  임의의 정수형 숫자를 추출하기 위한 제공 코드입니다.  0 ~ 29 사이의 임의의 숫자 추출
	public static int getRandomNo() {
		Random extractNo = new Random((long)(Math.random() * System.nanoTime()));
		int no = extractNo.nextInt(30); 
		return no;
	}	
}

