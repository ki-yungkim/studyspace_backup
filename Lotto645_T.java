

package com.work.view;

//import java.util.Arrays;
import java.util.Random;

public class Lotto645 {

	/* 강사님 코드 + 

	 * # 개선사항 
	 * 1. 정렬 알고리즘 O
	 * 2. 1게임, 5게임 허용 O

	 * # 기술 
	 * -- 반복문 
	 * => break;    역할 찾아보기
	 * => continue; 역할 찾아보기
	 * -- 중첩반복문 
	 * => 반복문에 레이블 지정 방법 outerLoop: 처럼
	 * => break 레이블명;
	 * => continue 레이블명;
	 * 
	 * .Arrays 안 쓰고 정렬 해보기
	 */

	public static void main(String[] args) {
		game1();
		game5();
	}

	public static void game5() {
		int[][] Numbers = new int[5][6];

		for (int index = 0; index < 5; index++) {
			for (int i = 0; i < 6; i++) {
				Numbers[index][i] = getLottoNo();
				for (int j = 0; j < i; j++) {
					if (Numbers[index][i] == Numbers[index][j]) {
						i--;
					}
				}
			}
		}
		//int[] Sorting = new int[6];
		
		System.out.println("[로또 5게임]");
		for (int index = 0; index < 5; index++) {
			for (int j = 0; j < 6; j++) {
				//System.out.print(Numbers[index][j] + "\t");
			}
			//System.out.println();
		}
		for (int i = 0; i < 5; i++) {    
			for (int k = 0; k < 6; k++) { 
				for (int j = 0; j < 5; j++) {
					if (Numbers[i][j] > Numbers[i][(j + 1)]){
						int tmp = Numbers[i][j];
						Numbers[i][j] = Numbers[i][(j + 1)];
						Numbers[i][(j + 1)] = tmp;
					}
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(Numbers[i][j] + "\t");
			}
			System.out.println();		
		}
		
		
/*		Array.sort 쓴 경우, 안 쓰고 정렬해보기 
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 6; i++) {
				Sorting[i] = Numbers[j][i];
			}
			Arrays.sort(Sorting);
			for (int k = 0; k < 6; k++) {
				System.out.print(Sorting[k] + "\t");
			}
			System.out.println();		
		}
*/
		}

	public static void game1() {
		int[] lottos = new int[6];
		int uniqueLength = 0;

		int randomNo;

		//중복 체크
		outerLoop:
			while(uniqueLength < 6) {
				randomNo = getLottoNo();

				for (int index = 0; index < uniqueLength; index++) {
					if (lottos[index] == randomNo) {
						continue outerLoop;
					}
				}

				lottos[uniqueLength++] = randomNo;
			}
		
		for (int j = 0; j < 6 ; j++) {    
				for (int i = 0; i < 5; i++) {
					if (lottos[i] > lottos[(i + 1)]){
						int tmp = lottos[i];
						lottos[i] = lottos[(i + 1)];
						lottos[(i + 1)] = tmp;
					}
				}
			
		}

		System.out.println("[1등 당첨예약 번호] ");
		for (int index = 0; index < lottos.length; index++) {
			System.out.print(lottos[index] + "\t");
		}
		System.out.println();
		System.out.println();
	}

	public static int getLottoNo() {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		return random.nextInt(45) + 1;
	}

}
