# FastCampus-JAVA 바이트 디그리 과정 


* 패스트 캠퍼스 ERD 설계
  + 해당 프로젝트 내부에 fastcampus_study.mwd , fastcampus_study.sql
  두개의 파일이 존재 합니다. workbench로 mwd파일을 열어서 보시면 됩니다.

* 테이블 물리 DB 생성
  + fastcampus schema 를 생성후 fastcampus_study.sql에 들어 있는 
  쿼리문을 실행키시면 Table이 생성됩니다.
  MySql DB는 docker 또는 PC 또는 Server(AWS, GCP 등등) 아무거나 쓰셔도 무관합니다.
  
* JPA 설정은 해당 코드내에 properties 및 build.gradle , entity, repository package를 참고 합니다.

* CRUD 기본 API Controller는 작성되어 있습니다.  TODO로 되어진 주석을 보고 심화로 더 공부 하시면 됩니다.

* Test Code는 test folder에 들어 있습니다. 마찮가지로 추가로 공부하면서 해야 할 코드 작업은 남아있습니다. 


### build
```$xslt
gradlew -x test build
java -jar ./build/libs/admin-0.0.1-SNAPSHOT.jar
```  

### 환경
```$xslt
JAVA 8
Intellij
Mysql8.0.17
Spring boot 2.2.6
Lombok
```  
  
* * * 
### 1차 미니과제는 feature/first 라는 branch에 따로 들어 있습니다.
##### 해당 코드는 정답이 아닙니다. 참고임을 미리 알려 드립니다.
* * *
