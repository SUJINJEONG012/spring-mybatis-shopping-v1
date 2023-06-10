# 스프링 MVC 쇼핑몰 
![screencapture-localhost-8080-2023-06-11-02_46_05](https://github.com/SUJINJEONG012/spring-mybatis-shopping-v1/assets/56811978/944a742a-b2ca-4d99-879e-f8c998e183ff)


## 프로젝트 환경설정

- STS3, JAVA11
- MySQL
- Jquery
- JSP
- Apache Tomcat 8.5
- MyBatis

## 초기세팅

1. **스프링/자바 버전 변경**
2. **테스트/로그 라이브러리 추가, Junit 라이브러리 버전 변경**
3. ****JDBC 라이브러리 추가 및 JDBC 연결 테스트****
4. ****커넥션 풀 & DataSource 설정****
5. ****My Batis 라이브러리 추가, SQLSessionFactory 설정****
6. ****Log4jdbc-log4j2 추가 및 설정.****

## 패키지 설정

Controller
Model : VO( Value Object ) 데이터 타입 저장
Mapper : DAO( Data Access Object) 역할, 데이터베이스 접속하는 역할
Service :   mapper와 Controller 사이를 연결, 비즈니스 로직

## 마이바티스 설정

- mapper로 사용할 xml 경로 지정
- mapper패키지가 스프링에서 인식할수 있도록 root-context.xml파일 생성
- Servlet 버전 변경 : 자바설정 등 이용하기 위해서 Servlet 3.0 이상 버전을 사용
- pom.xml 에서 기존 servlet 2.5 버전을 주석 처리 혹은 삭제 후 3.1.0 버전을 추가

## DBMS

![SpringERD](https://github.com/SUJINJEONG012/spring-mybatis-shopping-v1/assets/56811978/43c25e72-88cd-4713-8828-486e53619628)


### 장바구니 설계

장바구니 상품은 회원한명에 속해 
회원은 여러개의 장바구니 상품을 가질 수 있다.
장바구니 상품이 N 장바구니 상품 테이블에 외래키 memberId 를 두 었다.
회원, 카트, 상품
장바구니 상품 N ,  장바구니 상품 테이블에 memberId 를 두었다.
장바구니 상품 N ,  장바구니 상품 테이블에 bookId 를 두었다.
cart 테이블에 memberId, bookId 를 외래키로 설정

### 주문구현 데이터베이스 설계

관계 설계 
회원과 주문의 관계를 생각하면, 한명의 회원은 여려번의 주문을 할 수 있다.
하지만 주문의 경우 반드시 한명의 회원에 속해야 한다.
회원과 주문은 일대다(1:N) 관계
회원과 상품에 대해 생각해보겠습니다. (영수증을 생각해보면 이해하기 쉬움. )
하나의 주문에는 여러개의 상품을 가질 수 있다.
그리고 하나의 상품은 여러 주문에 속할 수 있다. 따라서 ‘주문’과 ‘상품’은 다대다(N:N)관계

이관계를 근거로 테이블 설계는 다대다 관계가 존재할 수 없다. 
주문, 상품의 다대다관계에 주문상품을 중간에 넣어서
회원 과 주문  1: N  (회원은 한명이 여러개의 주문을 할 수 있다.)
주문  1 : N 주문상품  1 : N 상품  
하나의 주문에는 여러개의 상품이들어갈수있고,
하나의 상품이 여러 주문에 속할 수 있습니다. 중간에 주문한 테이블을 찾을 수 있는 관계 설계
