SQL> cl scr

SQL> -- 화면 지우기
SQL> cl scr

SQL> -- 연결 계정 아이디 조회
SQL> show user
USER is "SCOTT"
SQL> -- 테이블 목록 조회
SQL> select * from tab;

TNAME                                                        TABTYPE         CLUSTERID                                                                                                                                                                                                                      
------------------------------------------------------------ -------------- ----------                                                                                                                                                                                                                      
BONUS                                                        TABLE                                                                                                                                                                                                                                          
DEPT                                                         TABLE                                                                                                                                                                                                                                          
EMP                                                          TABLE                                                                                                                                                                                                                                          
SALGRADE                                                     TABLE                                                                                                                                                                                                                                          

SQL> help spool

 SPOOL
 -----

 Stores query results in a file, or optionally sends the file to a printer.

 SPO[OL] [file_name[.ext] [CRE[ATE] | REP[LACE] | APP[END]] | OFF | OUT]


SQL> spool off
SQL> desc DEPT
 Name                                                                                                                                                                          Null?    Type
 ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -------- --------------------------------------------------------------------------------------------------------------------
 DEPTNO                                                                                                                                                                        NOT NULL NUMBER(2)
 DNAME                                                                                                                                                                                  VARCHAR2(14)
 LOC                                                                                                                                                                                    VARCHAR2(13)

SQL> desc EMP
 Name                                                                                                                                                                          Null?    Type
 ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -------- --------------------------------------------------------------------------------------------------------------------
 EMPNO                                                                                                                                                                         NOT NULL NUMBER(4)
 ENAME                                                                                                                                                                                  VARCHAR2(10)
 JOB                                                                                                                                                                                    VARCHAR2(9)
 MGR                                                                                                                                                                                    NUMBER(4)
 HIREDATE                                                                                                                                                                               DATE
 SAL                                                                                                                                                                                    NUMBER(7,2)
 COMM                                                                                                                                                                                   NUMBER(7,2)
 DEPTNO                                                                                                                                                                                 NUMBER(2)

SQL> desc SALGRADE
 Name                                                                                                                                                                          Null?    Type
 ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -------- --------------------------------------------------------------------------------------------------------------------
 GRADE                                                                                                                                                                                  NUMBER
 LOSAL                                                                                                                                                                                  NUMBER
 HISAL                                                                                                                                                                                  NUMBER

SQL> spool off
