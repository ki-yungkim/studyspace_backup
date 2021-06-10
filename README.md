
# Playdata_DE_Day17_210610
## Playdata 빅데이터 엔지니어 양성과정 17일차 210610

## DB 1일차
## MySQL, Oracle 설치

 
## MySQL 설치
* https://www.mysql.com/ - Community Edition -  MySQL Community (GPL) Downloads
	- community - 8.0.25 version

* default - port는 그대로 - 루트 계정 암호 설정, 유저 추가 - next - finish

## MySQL 실행 
* 환경변수 path 확인 
* cmd - mysql -u 아이디 -p비밀번호 
* cmd - mysql -u 아이디 -p - 엔터 후 비밀번호(안 보임)

## Database 생성, 설정 
* mysql>create database 이름 default character set utf8;
* 상태확인 => status; 

## 사용할 database 설정
* mysql> use 데이터베이스이름;

## 현재 계정의 테이블 목록 조회
* show tables;

## 사용자 계정 생성 
* root 권한 : root 계정 접속 (mysql -u root -padmin1004)
* dos > mysql -u root -p 

* 사용자 계정 삭제 
* drop user scott@localhost;

* 사용자 계정 생성
* create user scott@localhost identified by 'tiger';

* 사용자 권한 부여 
* grant all privileges on *.* to scott@localhost; => 모든 권한 부여 - 루트 권한 급	

## 에러 주의
* error in your SQL syntax : 보통 오타

 

## Oracle 설치 
* 유의사항 계정명 영문, 공백불가 
* c:\드라이브 기본 폴더 설치 
* 설치 후 오라클 path 자동 추가 : 맨 앞에 추가 시켜 줌 

* 압축 해제 - setup.exe 실행	- next - 라이센스 동의 next - 설치 폴더 기본으로 
* - 관리자 계정 -> System  (mysql은 root) -password 입력 - install - Finish 

## Oracle 실행	 
1. cui : 명령창 > sqlplus id/pw 
2. gui : SQLDeveloper(oracle 제공), toad(상용), orange(상용).. gui는 많다

* sqlplus id 치고 엔터 - 비밀번호 입력 
* sqlplus id/pw 한번에 입력도 가능 

## SQL*PLUS 명령어 
* 콘솔창이 떠있는 동안에만 적용

* 설정확인
 * show 
* 환경설정 전체 확인
 * show all 
* 설정
 * set linesize 300
 * set pagesize 300


* 화면 지우기
 * cl scr 
 
* ; 있어도 되고 없어도 된다.

* 종료
 * exit/quit

* 연결 해제
 * discon

* 연결 계정 사용자 아이디 조회
 * show user 

* 재연결
 * conn id/pw 

## 오라클 설치 기본 사용자 계정명 
* sys : 관리자 계정 
* system : 관리자 계정 ( 설치시 비밀번호 입력 )
* hr : 10g 테스트를 위한 사용자 계정 (계정 잠금) 
* scott/tiger :8i, 9i (계정 사용가능) => 보안 이슈 발생 문제 

## SQL 구문 명령어
* ; 꼭 있어야 한다.

* 계정 잠금 해제 : hr 계정 
 * alter user hr account unblock;

* 계정 암호 변경
 * alter user hr identified by 비밀번호;

* 전체 테이블 목록 조회
 * SELECT * FROM TAB;

* 테이블 구조 (스키마) 조회
 * desc 테이블;

* 계정 생성
 * create user 아이디 identified by 비밀번호;

* 권한 부여
 * grant connect, resource, create view to 아이디;

* 계정 삭제
 * drops user 아이디 cascade; - 연결되어 있는거 다 삭제
 * drop user 아이디; - 그냥 지우면 에러

* 계정 잠금
 * drop user 아이디 account lock;

## 실행 
* start c:\dir\dir\script-file.sql
* start script-file.sql
* @script-file.sql

## Spool
* SPO[OL] [file_name[.ext] [CRE[ATE] | REP[LACE] | APP[END]] | OFF | OUT]
* spool 210610_select.sql
* spool off
* 종료할 때 저장해서 210610_select.sql로 만들어 준다.
 
 
## 데이터 타입 
* 숫자 
	>> 정수 number, number(길이) (길이 지정 안 하면 최대한의 길이)
	>> 실수 number(전체길이, 소수이하길이) 
	
* 문자열
	>> 고정문자열 char(길이)
	>> 가변문자열 varchar2(길이) ex) 자소서 2000자 이내 
	
	
* 날짜 
	>> 문자열 : 날짜형식고정, 날짜연산수행하지 않는 경우
	>> 날짜 타입 date 
		=> 날짜형식가변, 날짜연산 수행경우 => 게시글 오늘 글은 시간만, 어제 글은 날짜 시간 이런 경우 
		=> 길이 지정하지 않음  
		=> 날짜, 시간 


## 데이터 표현
* 문자, 날짜 : '문자열', '2016-06-10'
* 숫자 : 1234,123,5678
* 별명(ALIAS) : 테이블, 컬럼에 대한 별명지정 "별명"

## DML(DQL) : C 레코드 추가 (insert), R조회 (select), U변경(update), D삭제(delete)

## DQL : 조회 (select)
1. 필수형식
* SELECT * | 컬럼명1, 컬럼명X | 컬럼명1 "별명", 컬럼명X "별명"  (* 는 모든 컬럼) 
*		| 수식 | 함수명() | (SUB-QUERY)
* FROM 테이블명;
		
*	> SELECT EMPNO, ENAME, SAL FROM EMP;
*	> SELECT EMPNO "사번" , ENAME "이름" , SAL "급여"  FROM EMP;
*	> select 5 * 3 + 10 FROM DUAL;
* 컬럼 별명 : 
*	>> "대소문자 구분"
*	>> "공백 가능"
*	>> "특수문자"
*	
*	>> 별명 "" 생략가능 :  대문자, 공백없고, 특수문자 없는 경우	
	
*	> SELECT EMPNO "Employee No" , ENAME "Name" , SAL "Salary"  FROM EMP;
*	> SELECT EMPNO EmployNo , ENAME Name , SAL Salary  FROM EMP;

* DUAL 테이블 
*	>> 오라클 SELECT 필수형식을 위한 DUMMY 테이블 
*	>> 연산식 테스트, 함수 테스트 등 
	
2. 전체형식

* SELECT ~~
* FROM 테이블명 1 [, 테이블명X, (SUB-QUERY) ]
* WHERE 조건식1 [AND | OR | NOT ] 조건식 X 
* GROUP BY 그룹핑 대상 컬럼명 [, 그룹핑대상컬럼명X] 
* HAVING 그룹핑결과에대한조건식
* ORDER BY 정렬컬럼명 정렬방법, 정렬컬럼명X 정렬방법
* ;

* 정렬항목 : 컬럼명, SELECT 항목에 대한 인덱스 번호, 별명, 수식 
* 정렬방법 : 올림차순(ASC, 기본), 내림차순 (DESC)
* 정렬기준 : 
*	>> 숫자, 날짜 (작은 것 => 큰 것, 1900, 1901, 1902 ...  ) 
*	>> 영문 : ABC...
*	>> 한글 : 가나다...
*	최근 입사자 조회하려면 DESC 

