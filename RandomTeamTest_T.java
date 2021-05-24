/*
* 강사님 코드 + 
 * 6번 줄       ++ 추가 중복체크 안되던 것 수정
 * 77 ~ 99번 줄 가나다라 순으로 정렬 추가
 */

package com.work.view;

import java.util.Random;

public class RandomTeamTest {
	public static void main(String[] args) {
		int teamMemberLengthCols = 4;
		if (args.length == 1) {
			teamMemberLengthCols = Integer.parseInt(args[0]);
		} else {
			System.out.println("[사용방법] java RandomTeamTest 팀별인원숫자");
			System.out.println("[팀당 인원수를 입력하지 않아 팀당 인원수를 기본 4명으로 진행합니다.]");
		}

		String[] names = {
				"김기영", "김나연", "김대현", "김수정", "김의현", "김재현", "김종환", "김주리", "김주엽", "김지원", 
				"김현수", "김현진", "김혜진", "노한나", "문수인", "박민재", "박영규", "박유정", "신지수", "유건", 
				"유준성", "이태규", "이택근", "이희원", "장현우", "조성현", "최낙원", "한다예", "황윤아", "유동국"
		};

		String[][] teamMembers = null;
		int teamLengthRows = names.length / teamMemberLengthCols;;
		int remainderLength = names.length % teamMemberLengthCols;

		if (remainderLength == 0) { 
			teamMembers = new String[teamLengthRows][teamMemberLengthCols];
			System.out.println(teamLengthRows + "개의 팀에 " + teamMemberLengthCols + "명의 팀원을 균등하게 배정합니다.");
		} else {
			teamMembers = new String[teamLengthRows][];
			for (int index = 0; index < remainderLength; index++) {
				teamMembers[index] = new String[teamMemberLengthCols + 1];
			}

			for (int index = remainderLength; index < teamLengthRows; index++) {
				teamMembers[index] = new String[teamMemberLengthCols];
			}

			/*
			 			for (int teamRows = 0; teamRows < teamMembers.length; teamRows++) {
			 				System.out.println((teamRows + 1) + "팀의 팀원은 " + teamMembers[teamRows].length + "명을 배정합니다.");
			 			}
			*/
			System.out.println(teamLengthRows + "개의 팀에 " + teamMemberLengthCols + "명을 배정합니다.");
			System.out.println("남은 인원은 " + remainderLength + "개의 팀에 1명씩 추가로 균등 배정합니다.");
		}

		int[] uniqueNamesIndex = new int[names.length];
		int uniqueLength = 0;

		int randomNo;
		for (int teamRows = 0; teamRows < teamMembers.length; teamRows++) {
			for (int teamCols = 0; teamCols < teamMembers[teamRows].length; teamCols++) {

				randomLoop:
					while(true) {
						randomNo = getRandomNo();
						for (int index = 0; index < uniqueLength; index++) {  
							if (uniqueNamesIndex[index] == randomNo) {
								continue randomLoop;
							}

						}

						uniqueNamesIndex[uniqueLength++] = randomNo; 
						teamMembers[teamRows][teamCols] = names[randomNo];
						break randomLoop;
					} 

			}
		}

		for (int i = 0; i < remainderLength; i++) {    
			for (int k = 0; k <= teamMemberLengthCols; k++) { 
				for (int j = 0; j < teamMemberLengthCols; j++) {
					if ((teamMembers[i][j]).compareTo(teamMembers[i][(j + 1)]) > 0) {
						String tmp = teamMembers[i][j];
						teamMembers[i][j] = teamMembers[i][(j + 1)];
						teamMembers[i][(j + 1)] = tmp;
					}
				}
			}
		}

		for (int i = remainderLength; i < teamLengthRows; i++) {    
			for (int k = 0; k <= teamMemberLengthCols; k++) { 
				for (int j = 0; j < (teamMemberLengthCols - 1); j++) {
					if ((teamMembers[i][j]).compareTo(teamMembers[i][(j + 1)]) > 0) {
						String tmp = teamMembers[i][j];
						teamMembers[i][j] = teamMembers[i][(j + 1)];
						teamMembers[i][(j + 1)] = tmp;
					}
				}
			}
		}

		System.out.println();
		System.out.println("[팀별 팀원 배정 정보]");

		for (int teamRows = 0; teamRows < teamMembers.length; teamRows++) {
			System.out.print((teamRows + 1) + "팀 팀원 : ");
			for (int teamCols = 0; teamCols < teamMembers[teamRows].length; teamCols++) {
				System.out.print(teamMembers[teamRows][teamCols] + "\t");
			}
			System.out.println();
		}
	}

	public static boolean isUniqueNo(int randomNo) {
		return false;
	}

	public static int getRandomNo() {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		return random.nextInt(30);
	}
}

