# Playdata_DE_Day2_210518_Java
Playdata 빅데이터 엔지니어 양성과정 2일차 210517 Java



## 자바 파일 구조
1. package 선언문
-- 폴더같은 개념, 계층 구조
-- 같은 종류의 클래스를 같은 폴더에 관리
-- 관리 효율성, 이름 충돌 방지, 접근 권한 제어
-- 형식 : package 패키지명.패키지명;
-- 선언 횟수 : 0, 1 (생략하거나 지정하거나)
-- package 선언하지 않으면 default package



2. import 선언문

3. class 선언문
-- 형식 : 
	[modifiers] class 클래스이름 {   
		// class 구성요소

	}
 (이름 뒤에 한칸 씩 떼주는게 코딩 컨벤션 코딩 컨벤션 안 지키면 안 봐준다)
	
## class 구성요소
1. 멤버변수 -> 속성
2. 생성자
3. 메서드(매개변수): 반환타입 
[
	4. inner clas
	5. static 블럭 초기화
	6. instance 블럭 초기화
] (이번 과정엔 필요 X)


	매서드 : 기능, 일
	매개변수 argument : 도구
	
	
src 우클릭 new - package

name : com.work.view
비어있는 쌀가마 같은 것 생김
src 우클릭 new - class
class 만들면서 새 package 만들 수 있다
name : Member
package : com.work.model.dto
밑에 체크는 없이

view package 선택
new class
name : Test
쌀가마 채워진 아이콘으로 변화


## 자바 프로그래밍 기본 규칙
-- 자바 프로그래밍 시작 메서드 형식: 규칙
   public static void main(String[] args) {
   //수행문
   }
   
   배열명 (기본은 args) 은 맘대로 해도 된다
   
   main + crtl + space 해도 됨
	
	
주의점! 업데이트는 하지 말 것
jre가 1.8 최신으로 됨
같이 프로젝트 할때 충돌 

	
--대소문자 구분

main을 대문자로 하면 저장은 됨 실행하면 오류
String의 [] 빼도 오류
arg는 수정해도 됨

--{} 반드시 짝을 이루어서 열고 닫아야 함
-- 이름규칙(자바 명명규칙) 준수 권장

## 이름규칙 (자바 명명규칙)

-- 클래스이름 : 
	>> 대문자시작 + 대문자시작
	>> System, String, HelloWorld, Member
	
-- 변수이름
	>> 첫단어는 모두 소문자 + 대문자시작
	>> companyName, minlength, age
	
-- 매서드이름
	>> 첫단어는 모두 소문자 + 대문자시작([매개변수타입 매개변수명, 매개변수타입 매개변수명])

-- 상수이름
	>> 모두 대문자_모두 대문자
	>> 구분자 _(밑 줄)
	>> MAX_COUNT, MAX_VALUE, PI, E
	
-- 패키지이름
	>> 모두 소문자.모두 소문자
	>> 구분자 .(DOT)
	>> java.lang, java.util, com.work.view, com.work.model.dto
	
## 식별자 : identifier
-- 이름
-- 대소문자 구분 
-- 길이 제한 없음
-- 시작 : 영문자, _, $ 
-- 조합 : 숫자 (숫자로 시작은 불가 -> you4(ok), 4you(error) -> 모든 언어 공통
-- keywork(예약어: 자바에서 이미 정의되어 있는 키워드) 사용 불가 
	public, static, void 등
-- 약어 사용하지 말 것
	>> MH, DR, D, GJ, G 
	>> ID, DAO, DTO: 누구나 알 수 있는 약어는 사용하기도 함
	
## keyword (예약어)
-- 미리 사용이 정해져 있는 식별자
-- 모두 소문자
-- public, static, void, class, package, for, if, switch 등
-- const : 키워드이지만 지원하지는 않음 (C언어 상수 표현 예약어)
-- sizeof : 키워드는 아니지만 식별자 지정 사용하지 말 것(C언어에서 데이터 타입의 크기를 체킹 예약어)

-- null : 어떠한 객체도 참조하지 않음, 객체 타입의 기본값
-- true /false : 참 / 거짓

## 자바 데이터 타입
1. 기본형
-- primitive type
-- 정수형 : byte(8bit), short(16bit), int(32bit, default), long(64bit)
	>> 5 (int)
	>> 5L (long, 대문자 L, 소문자 l)
	
-- 실수형 : float(32bit), double(64bit, default)
	>> 5.2 (double, D 생략가능), 5.2D, 5.2d
	>> 5.2F, 5.2f
	
-- 논리형 : boolean
	>> true / false : 참 / 거짓
	
-- 단일문자형 : char(16bit, 2byte, unicode, 모든 언어 지원)
	>> 'A', '가'
	>> '\uXXX', 공백문자 유니코드 : '\u0000'
		문자 입력할 때는 유니코드 표 확인
	>>  특수문자 : '\n' 새로운 라인, '\t' tab key (일정 간격 띄우기), \', \", \\ (백 슬래시 기호가 필요할 때)
	

2. 참조형(객체형)
-- reference type
-- 모든 클래스 (인터페이스 포함), 배열(array)

-- 문자열 클래스 : String
	>> 객체인데 기본형처럼 사용 가능할 유일한 클래스
	>> "문자열" 
	>> '가' : char 타입
	>> "가" : String 타입


## 변수 (variable)
1. 멤버변수
-- 선언위치 : 클래스 구성요소
-- (1) 인스턴스 멤버변수 : static이 붙지 않은 멤버변수
-- (2) 클래스 멤버변수: static이 붙은 멤버변수
-- 선언방법 : 
	(1) [modifiers] 타입 멤버변수명;
	(2) [modifiers] 타입 멤버변수명 = 명시적초기값;
-- 멤버변수는 선언만 하면 기본값으로 객체 생성시 자동 초기화 수행

2. 지역변수
-- 선언위치 : 
	>> 매세드 내부, 생성자 내부, 제어문 내부
	>> 매서드, 생성자 아규먼트 : 매개변수

-- 선언방법 : 
	(1) 타입 변수명;
	(2) 타입 변수명 = 초기값

--지역변수는 선언만 하면 자동 초기화가 수행되지 않음, 반드시 사용하기 전에 명시적으로 값을 초기화 수행해줘야 함


## modifiers(제어자, 제한자, 지정자)
1. Access Modifiers
-- 접근 권한 제어자
-- public : unverse (누구나 필요시에 접근 허용)
-- protected : sub-class (다른 패키지에 있지만 상속 받았다면 접근 허용)
-- 생략(package, default, friendly) : same package (같은 패키지에 있는 클래스들에게만 접근 허용)
-- private : same class (클래스 내부에서만 접근 허용) 

-- class : public, 생략(package)
-- 멤버변수, 메서드, 생성자 : public, 생략(package), protected, private 
-- 지역변수, 매개변수 : 생략(package)

2. Usage Modifiers(Non-Access Modifiers)
-- 사용/활용 제어자 
-- static
-- final
-- abstract

## 연산자
-- 할당연산자
	>> [타입] 변수명 = 값; 여기서 =   
	>> 값 위치에 올 수 있는 것 : 값, 변수명, 수식, 값을 반환하는 매서드호출문(), new 클래스이름() 객체생성
	
	>> = (할당) 연산자 수행
	1. 왼쪽 기억공간타입과 저장하는 값의 타입이 같으면 자동 할당
	2. 왼쪽 기억공간타입이 저장하는 값의 타입보다 큰 타입이면 자동 할당 
	
	3. 왼쪽 기억공가느이 타입이 큰 타입도 아니고, 다른 타입이면 오류 발생
	
	4. 왼쪽 기억공간의 타입이 다른 경우에 명시적으로 형변환을 하면 할당 가능 
		> 값의 유실이 발생할 수 있음
		

Test.java

이름 정보 변수에 저장
String name = "홍길동";
나이 정보
int age = 30;

노란 전구 : 변수가 사용되지 않은 경우

public 앞에 붙이면 오류
name // = "" 
지역변수는 자동 초기화가 안됨 	
 
=  앞 뒤에 한칸씩 띄워야 보기 좋다

int no1 = 5; //int = int 같은 타입 자동할당
long no2 = 5; //long = int 큰 타입 자동할당
int no3 = 5.2; //int = double 오류

## 형변환
1. 자동형변환
-- 작은타입은 큰 타임으로 자동형변환
-- 기본형 : byte => short, char => int => long => float =>double
-- 참조형 : 자식 클래스 (sub-class) => 부모클래스(super class)
 
boolean은 크기를 가지고 있는게 아니니 형변환이 안됨

2. 명시적(묵시적) 형변환
-- 큰 타임을 작은 타입으로 강제(명시적) 변환
-- 형식 : 타입 변수명 = (타입) 값;

int no4 = (int)5.2;
소수 이하 자리는 버림

char c1= '0'; //char = char 같은 타입 할당
int c2 = c1; // int char 자동형변환) 큰타입 할당

// ascii code : A-65, a-97, 0-48

System.out.println((char)70); -> F

byte a = 5; //선언 및 초기화인 경우에만 byte = int, 연산의 기본은 int
byte b = 10; // 
		
byte result = a + b; //byte = int + int 연산의 수행결과 오류발생, 자동형변환 발생하지 않음
byte result = (byte)a + b; // 연산자 우선순위 byte = byte + int => byte = int 수행결과 오류 발생
byte result = (byte)(a + b); // 연산 수행결과에 대해서 명시적 형변환 할당



-- 산술연산자
	>> +, -, *, /(몫), %(나머지)
	>> + 중복연산자 
	>> 숫자 + 숫자 = 덧셈연산
	>> "문자열" + 숫자, 숫자 + "문자열", "문자열" + "문자열" : 연결연산자(concat)
	
-- 비교연산자 : 
	>> 값의 크기를 비교한 결과를 boolean 타입 반환, 제어문 조건식
	>> 왼쪽을 기준으로 결과 반환
		<, >, <=, >=, ==, !=

-- 논리연산자
	>> 조건식1 논리연산자 조건식2

	>> & (AND) : 
		=> 조건식결과 모두 true => true, 조건식결과가 하나라도 false => false
		=> 조건식1 수행결과 & 조건식2 수행결과 => 결과에 대해서 논리연산 수행결과 반환 
	>> | (OR) : 
		=> 조건식결과 모두 false => false, 조건식결과가 하나라도 true => true
		=> 조건식1 수행결과 & 조건식2 수행결과 => 결과에 대해서 논리연산 수행결과 반환
	>> ! (NOT) : true이면 false, false이면 true
	
	단축 논리 연산 
	>> && (AND) : 
		=> 조건식1 수행결과에 따라서 조건식2 수행여부를 결정
		=> 조건식1 수행결과가 false => 조건식2를 수행하지 않고 결과를 false
		
	>> || (OR) : 
		=> 조건식1 수행결과에 따라서 조건식2 수행여부를 결정
		=> 조건식1 수행결과가 true => 조건식2를 수행하지 않고 결과를 true
	
-- 증감연산자
	>> 1을 더하거나, 1을 빼기 연산자, 제어문(반복문)
	>> ++, --
	>> 전치증감연산 : ++변수명, --변수명, 먼저 1을 더하거나 빼고 나서 해당수행문 수행  
	>> 후치증감연산 : 변수명++, 변수명--, 먼저 수행하고 나서 1을 더하거나 빼기
	
	int no = 5;
	System.out.println(++no); //6
	System.out.println(no--); //6 => 6-1
	System.out.println(no); //5

-- 단축대입연산자
	>> +=, -=, *=, /=, %= : 제어문(반복문)
	>> int no = 5;
	>> no = no + 10;
	>> no += 10;
	
-- 삼항연산자
	[타입]변수명 = (조건식) ? 참인경우할당값 : 거짓인경우할당값;
	
실습
class TestOpertor

System.out.println(5 + 10);
System.out.println(5 / 2); // 나눗셈 몫반환 2
System.out.println(5 % 2); // 나눗셈 나머지 1
		
// 문제 : 성적을 변수에 저장해서 성적이 100, 90, 80, 70, 60 점대인지를 확인
int score = 95; // 99 ~ 90
System.out.println(score / 10);

## 제어문
-- 조건문, 반복문, 분기문

## 조건문 
-- 조건식의 결과타입 : boolean

-- if (조건식) {
		// true 수행문 
	} else {
		//false 수행문
	}

-- 다중조건문

if (조건식1) {
		// 조건식1 true 수행문 
	} else if (조건식 2){
		// 조건식2 true 수행문
	} else {
		// 해당 조건식에 부합되지 않는 경우 : 기본 수행 
	}

키워드 뒤에 한칸 띄우는게 좋다

if 문 실습

IfTest

/*
*/ 여러 줄 주석
/*실습
	 * -- 성적에 따라 등급을 출력하는 프로그램을 완성하세요
	 * -- 성적은 0 ~ 100점 이내
	 * -- A : 90 ~ 100점
	 * -- B : 80 ~ 89점
	 * -- C : 70 ~ 79점
	 * -- D : 60 ~ 69점
	 * -- F : 0 ~ 59점
	 * 
	 * -- 출력형식
	 * 00점 0등급

초보와 고수의 차이
valid만 확인 vs invalid까지 확인 

최적화, 가독성, 수정하기 용이하게 코드 만들기


## 다중 조건문 
-- expression 결과값에 수행 : 값, 변수명, 수식
-- type : int(byte, short, char), jdk7.x부터는 String도 가능 
-- 해당 case 부터 break; 구문을 만날 때까지 순차적으로 수행
-- break; 구문을 or (또는 논리연산자처럼 사용 가능)
switch (expression) {
	case 값1:
		값1인 경우 수행문 
		[break;]
	
	case 값x:
		값x인 경우 수행문 
		[break;]
	
	[
	default:
		기본수행
	] [] : 쓸 수도 안 쓸 수도 있음 

}

//실습 : if ~ else 구문을 switch 구문으로 변경
성적 / 10 이용

개발자는 일단 결과가 나와야 한다 길어도 짜서 일단 결과 낸 다음
그 다음에 줄여보는 것

switch case가 성능적으로 빠르다
딱 떨어지는 값이면 switch 사용 가능


## 반복문 
-- 조건식이 true인 동안 반복 수행
-- for (), While (), do~while ()
-- break; : 반복문을 빠져나감
-- continue; : 반복문의 조건식으로 분기해서 반복여부를 결정

-- for : jdk1.4
	>> for (초기값; 조건식; 증감값) {
		// 반복 수행문
		}
	>> 초기값 : 0 ~ N, 다중 선언시에는 같은 타입만 가능, 타입 변수명 = 초기값
	>> 조건식 : 0 or 1  (조건식 없는 경우 무한루프 가능)
	>> 증감값 : 0 ~ N 
	
	>> 예시 : 1 ~ 10까지 반복 수행 
		for (int i = 1; i <= 10; i++) {
			
		}		
	
// 실습 : for 구문을 이용해서 1~ 10까지 출력하면서 누적된 결과를 출력해보세요
		짝수만 출력하고 누적 값 출력
		
// 실습 : 영문 대문자에 대한 ascii code를 출력하는 프로그램을 작성하세요
	  
	  출력형식: 영문알파벳 26자, type casting (형변환)
	  A : 65
	  B : 66
	  ...
	  Z : xx
	  
	
-- for : jdk1.5
	>> array, collection
	
-- while (조건식)

	// 초기값 수행문 직접 표기
	while(조건식) {
		// 반복 수행문
		// 증감값 수행문 직접 표기
	}
	>> 반복 수행 전에 조건식을 비교해서 조건식이 거짓이면 한번도 수행하지 않음
	
-- do~while();
	do {
		// 반복 수행문
	} while (조건식);
	
	>> 최소 1번은 수행 
	
		\n : 엔터 
	
	ctrl + C 또는 빨간 버튼으로 종료
	
	실습 
	
	/*  1~ 5까지 출력하면서 누적된 결과를 출력해보세요
	 * 1. for 구문
	 * 2. while 구문
	 * 3. do~while 구문
	 */
	 
	 강의는 보통 4시까지 하고 미션 줄 예정

코드 만들고 다 지우고 다시 만들고 
5번만 하면 코드가 본인 것이 된다. 
