/* 자바 미션 #3 */

package com.work.view;

import java.util.Random;
import java.util.Arrays;

/**
	# 자바 미션 #3 : 오늘까지 배운 배열을 활용하여서 Lotto645 게임을 구현하세요.
	임의의 숫자를 추출하는 코드는 아래에 제공합니다.

	-- 로또 645는 1~45번 사이의 숫자 6개를 추출하는 게임입니다.
	-- 6개의 번호는 중복번호 불가입니다.

	-- 실습1 : 로또 1게임 : 1차원 배열 사용
	-- 실습2 : 로또 5게임 : 2차원 배열 사용
	-- 실습3 : 정렬알고리즘을 활용하여서 중복되지 않게 출력된 6개의 로또 번호를 올림차순정렬하여 출력하도록 해보세요.
 */
public class LottoGameTest {
	public static void main(String[] args) {
		game1();
		game5();
	}
	
	
	//## 실습2 로또 5게임 : 2차원 배열 사용
	//## 실습3 정렬알고리즘 사용 6개 로또번호 올림차순정렬 출력
			/*1차원 배열 정렬
			import java.util.Arrays;
			Arrays.sort(배열);
			*/
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
		int[] Sorting = new int[6];
		
		System.out.println("로또 5게임 : 2차원 배열 사용");
		for (int index = 0; index < 5; index++) {
			for (int j = 0; j < 6; j++) {
				//System.out.print(Numbers[index][j] + "\t");
			}
			//System.out.println();
		}
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
	}		

	//## 실습1 로또 1게임 : 1차원 배열 사용
	//## 실습3 정렬알고리즘 사용 6개 로또번호 올림차순정렬 출력
		/*1차원 배열 정렬
		import java.util.Arrays;
		Arrays.sort(배열);
		*/
	public static void game1() {
		int[] num = new int[6];
		for (int index = 0; index < 6; index++) {
			num[index] = getLottoNo();
			for (int j = 0; j < index; j++) {
				if (num[index] == num[j]) {
					index--;
				}
			}
		}
		Arrays.sort(num);
		System.out.println("로또 1게임 : 1차원 배열 사용");
		for (int i = 0; i < 6; i++) {
			System.out.print(num[i] + "\t");
			
			//System.out.print(getLottoNo());
			//System.out.println("\t");
		}
		System.out.println("\n");
	}


	/** 객체를 생성하지 않고 임의의 1~45 사이의 숫자를 반환하는 메서드 */
	public static int getLottoNo() {
		/* 임의의 정수형 숫자를 추출하기 위한 제공 코드입니다. */
		Random extractNo = new Random((long)(Math.random() * System.nanoTime()));
		int no = extractNo.nextInt(45) + 1; // 0 ~ 44 사이의 임의의 숫자 추출 => +1 => 1 ~ 45 사이 임의숫자 추출
		return no;
	}
}













