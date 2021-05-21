package com.work.view;

import java.util.Random;

/*랜덤 조짜기 실습
 * args 입력 값이 조별 팀원 수
 * 랜덤 코드를 args 값 만큼 돌리고 그 값 팀에 넣고 중복 검사하고 행 넘기고 그 값을 names에서 찾아서 행렬 출력
 * 
 */

public class RandomTeamTest {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: javac RamdomTeamTest 팀원 숫자");
			System.exit(0);
		}
		
		int teamNum = Integer.parseInt(args[0]); 
		// String 문자열타입의 숫자데이터를 int 타입으로 변환
		
		
		// 학생의 이름정보는 배열요소 30명 저장 
		
		// 2차원 배열 행크기, 열크기 분석해서 선언 및 생성
		// 한번 나온 숫자 안 나와야 함
		
		System.out.println();
		int[] num = new int[30];
		for (int i = 0; i < 30; i++) {
				int randomNO = getRandomNo();
				
				num[i] = randomNO;
				//중복 체크
				for (int j = 0; j < i; j++) {
					if(num[i] == num[j]) {
						i--;
					}
				}			
			}	
		for (int i = 0; i<num.length; i++) {
			System.out.print(num[i] +" ");
		}
			
			System.out.println();
		
		
		int[][] team = new int[6][5];
		
		team[0][0] = num[0];
		team[0][1] = num[1];
		team[0][2] = num[2];
		team[0][3] = num[3];
		team[0][4] = num[4];
		
		team[1][0] = num[5];
		team[1][1] = num[6];
		team[1][2] = num[7];
		team[1][3] = num[8];
		team[1][4] = num[9];
		
		team[2][0] = num[10];
		team[2][1] = num[11];
		team[2][2] = num[12];
		team[2][3] = num[13];
		team[2][4] = num[14];
		
		team[3][0] = num[15];
		team[3][1] = num[16];
		team[3][2] = num[17];
		team[3][3] = num[18];
		team[3][4] = num[19];
		
		team[4][0] = num[20];
		team[4][1] = num[21];
		team[4][2] = num[22];
		team[4][3] = num[23];
		team[4][4] = num[24];
		
		team[5][0] = num[25];
		team[5][1] = num[26];
		team[5][2] = num[27];
		team[5][3] = num[28];
		team[5][4] = num[29];
	
		for (int i = 0; i < team.length; i++) { 	
				for (int j = 0; j < team[i].length; j++ ) {
				System.out.print(team[i][j] + "\t");
			}
				System.out.println();
		}
	}
	
	
		
//	
//		String[] names = {"김기영", "김나연", "김대현", "김수정", "김의현", "김재현", "김종환", "김주리",
//				"김주엽", "김지원", "김현수", "김현진", "김혜진", "노한나", "문수인", "박민재",
//				"박영규", "박유정", "신지수", "유건", "유동국", "유준성", "이태규", "이택근",
//				"이희원", "장현우", "조성현", "최낙원", "한다예", "황윤아"};
//		
//	
//	
	
		
	

//매서드
	public static int getRandomNo() {
		/* 임의의 정수형 숫자를 추출하기 위한 제공 코드입니다. */
		Random extractNo = new Random((long)(Math.random() * System.nanoTime()));
		//패턴 찾기 어렵게 
		
		/* 0 ~ 29 사이의 임의의 숫자 추출 */
		int no = extractNo.nextInt(30); 
		return no;
	}

	
}


