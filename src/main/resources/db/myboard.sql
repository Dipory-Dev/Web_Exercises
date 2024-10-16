DROP TABLE MYBOARD;

CREATE TABLE MYBOARD(
                        MYNO NUMBER PRIMARY KEY,
                        MYNAME varchar2(100) NOT NULL,
                        MYTITLE varchar2(2000) NOT NULL,
                        MYCONTENT varchar2(4000) NOT NULL,
                        MYDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_MYBOARD NOCACHE;



INSERT INTO MYBOARD VALUES(SEQ_MYBOARD.NEXTVAL, '관리자', '게시판 테스트',
                           '테스트 중입니다. 1234QWERASDFZXCV', CURRENT_DATE);

SELECT * FROM MYBOARD;