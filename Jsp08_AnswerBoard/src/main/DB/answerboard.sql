DROP TABLE answerboard;

CREATE TABLE answerboard(
                            bno NUMBER PRIMARY KEY,
                            gno NUMBER NOT NULL,
                            gseq NUMBER NOT NULL,
                            titletab NUMBER NOT NULL,
                            title varchar2(2000) NOT NULL,
                            content varchar2(4000) NOT NULL,
                            writer varchar2(1000) NOT NULL,
                            regdate DATE NOT NULL
);

CREATE SEQUENCE bno_seq nocache;
CREATE SEQUENCE gno_seq nocache;


SELECT * FROM answerboard ORDER BY gno DESC, gseq;

INSERT INTO answerboard VALUES
    (bno_seq.nextval, gno_seq.nextval, 1, 0, '첫번째 글', '1번 글입니다.', '유저1', current_date);

INSERT INTO answerboard VALUES
    (bno_seq.nextval, gno_seq.nextval, 1, 0, '두번째 글', '2번 글입니다.', '유저2', current_date);


INSERT INTO answerboard VALUES
    (bno_seq.nextval,
     (SELECT gno FROM answerboard WHERE bno=1),
     (SELECT gseq FROM answerboard WHERE bno=1) + 1,
     (SELECT titletab FROM answerboard WHERE bno=1) + 2,
     'Re : 첫번째 글', '1번 글의 답글', '유저2', current_date
    );

INSERT INTO answerboard VALUES
    (bno_seq.nextval, gno_seq.nextval, 1, 0, '세번째 글', '3번 글입니다.', '유저3', current_date);

INSERT INTO answerboard VALUES
    (bno_seq.nextval,
     (SELECT gno FROM answerboard WHERE bno=2),
     (SELECT gseq FROM answerboard WHERE bno=2) + 1,
     (SELECT titletab FROM answerboard WHERE bno=2) + 2,
     'Re : 두번째 글', '2번 글의 답글', '유저1', current_date
    );


INSERT INTO answerboard VALUES
    (bno_seq.nextval,
     (SELECT gno FROM answerboard WHERE bno=5),
     (SELECT gseq FROM answerboard WHERE bno=5) + 1,
     (SELECT titletab FROM answerboard WHERE bno=5) + 2,
     'ReRe : 두번째 글', '2번 글의 답글의 답글', '유저1', current_date
    );


UPDATE answerboard SET gseq = (gseq + 1) WHERE
    gno = (SELECT gno FROM answerboard WHERE bno = 2) AND
    gseq > (SELECT gseq FROM answerboard WHERE bno = 2);

INSERT INTO answerboard VALUES
    (bno_seq.nextval,
     (SELECT gno FROM answerboard WHERE bno=2),
     (SELECT gseq FROM answerboard WHERE bno=2) + 1,
     (SELECT titletab FROM answerboard WHERE bno=2) + 2,
     'Re : 두번째 글', '2번 글의 답글2', '유저3', current_date
    );


UPDATE answerboard SET gseq = (gseq + 1) WHERE
    gno = (SELECT gno FROM answerboard WHERE bno = 7) AND
    gseq > (SELECT gseq FROM answerboard WHERE bno = 7);


INSERT INTO answerboard VALUES
    (bno_seq.nextval,
     (SELECT gno FROM answerboard WHERE bno=7),
     (SELECT gseq FROM answerboard WHERE bno=7) + 1,
     (SELECT titletab FROM answerboard WHERE bno=7) + 2,
     'ReRe : 두번째 글', '2번 글의 답글2의 답글', '유저1', current_date
    );