create table mymember(
                         myno number primary key,
                         myid varchar2(500) not null unique,
                         mypw varchar2(500) not null,
                         myname varchar2(300) not null,
                         myaddr varchar2(4000) not null,
                         myphone varchar2(30) not null unique,
                         myemail varchar2(100) not null unique,
                         myenabled varchar2(2) not null check(myenabled in ('Y', 'N')),
                         myrole varchar2(50) not null
);

create sequence seq_mymember nocache;

insert into mymember values
    (seq_mymember.nextval,
     'admin', '1234', '관리자', '서울시 서초동 반포동',
     '010-1234-1234', 'admin@mymember.com', 'Y', 'Admin');

select * from mymember;