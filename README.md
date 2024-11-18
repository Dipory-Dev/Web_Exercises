# JSP / Spring 실습내역

![license](https://img.shields.io/badge/license-MIT-blue)



### MVC패턴과 JDBC 활용 등 다양한 방식의 프로젝트 진행



## 목적

* JSP를 이용하여 프로젝트를 구현함.
* Oracle DB를 사용하여 입력한 값들을 저장했다.



## 사용한 프레임워크

* Oracle : 19
* JDK : Amazon Corretto 11 / Oracle OpenJDK 22
* JSP
* OJDBC 8
* Intelli J
* Tomcat 9


## 각 프로젝트 별 기능

### Jsp01_MyBoard
* JDBC를 이용하여 게시판 기능 구현
* CRUD 기능을 활용하여 DB 관리


### Jsp01_MyBoard_Mybatis
* 기존 JDBC를 활용한 게시판을 Mybatis로 변경


### Jsp02_MVC
* MVC 패턴을 이용하여 게시판 기능 구현
* JDBC연동의 반복작업 해소를 위해 JDBCTemplate 제작


### Jsp03_LoginBoard
* 간단한 로그인 기능 구현
* Session을 이용한 권한 부여
* 계정별 권한에 따라 다른 페이지 제공


### Jsp04_HelloServlet
* web.xml 파일에 Servlet 정의 후 기능 구현


### Jsp05_Scope
* page / request / session / application 단위의 Scope 실습
* page : JSP 페이지 내에서만 유효한 범위
* request : 하나의 hhtp 요청에 대해 유효 (다른 페이지로 포워딩하여 공유)
* session : 특정 사용자의 세션이 유효한 범위 (여러 페이지를 이동하며 객체 공유)
* applicaiton : 웹 전역에서 접근할 수 있는 범위 (웹 시작부터 종료시까지 유효) 


### Jsp06_EL_JSTL
* EL / JSTL 실습
* EL : 데이터에 접근하고 간단한 표현식 사용 / ${} 구문을 사용하여 JSP에서 변수 값 출력
* JSTL : JSP에서 쓰이는 라이브러리 (반복문, 조건문, 데이터 포매팅 등 사용) / core, xml 태그 사용


### Jsp07_MVC-Advanced-
* 기존 MVC 패턴에서 Service 단을 추가하여 프로젝트 진행
* 간단한 게시판 기능 구현 (CRUD 기능을 활용하여 DB 관리)

### Jsp08_AnswerBoard
* Oracle DB에서 space값을 지정하여 들여쓰기 기능 구현
* 원글, 댓글, 대댓글 기능 구현


### Jsp09_Ajax
* 비동기 통신을 이용한 실시간 점수 계산 프로그램 구현


### Jsp10_Bike
* 따릉이 공공 데이터를 통한 실습
* CRUD 기능 구현


### Spring01_Hello
* Spring 구조 실습을 위한 Bean 기초 테스트
* pom.xml에 spring-context, spring-core 라이브러리 호출

### Spring02_Bean
* applicationContext.xml 에 클래스 객체의 매개변수를 지정 후 호출
* Bean 심화 테스트

### Spring03
* Emp 클래스를 상속받아 Developer, Engineer 클래스 구현
* Bean에서 지정 후 호출 시 결과 확인

### Spring04
* Food 클래스 생성하여 Spring03과 같이 실습 진행


### Spring05_Annotation
* Bean으로 class 객체 생성하여 메인에서 호출
* Component 태그 활용하여 실습 진행


### Spring06_AOP
* Aspect를 이용하여 특정 메소드 before, after 기능 구현
* Person 클래스를 상속받아 Student, Teacher 클래스 구현
* MyAspect의 메소드를 기준으로 before, after 실행


### Spring06_TestAOP
* Spring06_AOP 복습 진행


### Spring07_HelloMVC
* Annotaition을 활용한 servlet 실습


### SpringMVC01
* Spring Legacy 프로젝트 생성 후 MVC패턴 실습 진행


### SpringMVC02
* maven Dependency를 이용한 MVC패턴 실습


### SpringMVC03
* Restful Api 실습


### SpringMVC03_Filter
* filter dependency 추가 후 실습 진행


### SpringMVC03_Filter_AOP
* AOP 추가 하여 before, after 메서드 구현


### SpringMVC03_Filter_AOP_login
* mybatis를 활용하여 로그인 기능 구현

### SpringMVC03_Filter_AOP_login_intercepter
* intercepter 기능 추가로 특정 메서드 실행 전 검증 단계 추가


### SpringMVC03_Filter_AOP_login_intercepter_transaction
* transaction 기능 추가하여 기능 실습


### SpringMVC03_Filter_AOP_login_intercepter_transaction_password
* password 인코딩 하여 계정 추가 후 match로 인코딩 한 데이터와 대조 후 로그인

### SpringMVC04_file
* file 업로드 및 선택한 파일 쓰기 실습


### SpringMVC05_RESTController
* Restfull API 실습 2


### StrartBoot01
* Spring Boot 프로젝트 생성 및 실습


### SpringBoot02
* Interface 파일을 이용한 mapper 기능 정의
* CRUD 기능을 활용하여 DB관리


### SpringBoot03
* Thymeleaf를 이용한 MVC패턴 프로젝트 확인
* Thymeleaf 표현식 활용 (if, unless / each, case)


### SpringBoot04
* Hibernate를 이용하여 CRUD 기능 활용
* Dao Interface에서 Hibernate의 고유 메서드 확인
