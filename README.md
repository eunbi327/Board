# Board

## 프로젝트 개요

게시글 및 댓글 CRUD 기능, 소셜 로그인 기능이 포함된 게시판 웹 애플리케이션

---

### 사용 언어 및 툴

- JAVA 8, Spring Boot 2.7.15, Gradle, Spring Security, OAuth2, JPA, mustache

---

### 주요 기능

1. 소셜 로그인 기능
    - 인증 방식 : Spring Security + Session
    - 로그인을 하지 않은 경우 출력
    - 로그인 버튼
    - 로그인을 한 경우 출력
        - 사용자 닉네임
        - 로그아웃 버튼
2. 게시글 기능
    - 게시글 작성, 전체 조회, 상세 조회, 수정, 삭제
    - 조회수 기능
3. 댓글 기능
    - 댓글 작성, 조회, 수정, 삭제
    - 게시글 삭제 시 게시글에 달린 댓글도 같이 삭제

---

### ERD 다이어그램

![ERD 다이어그램]("https://github.com/eunbi327/Board/blob/eb2dd90c07fceb2bb298aa3c9d7c463653fea8d6/src/main/resources/img/ERD.png")

---

### 뷰 명세서

- Ajax 통신을 이용해 브라우저 랜더링 과정을 간소화함

| 기능        | 메소드 | URI                    |
|-----------|-----|------------------------|
| 게시글 전체 목록 | GET | /                      |
| 게시글 상세보기  | GET | /posts/{postid}        |
| 게시글 작성    | GET | /posts/save            |
| 게시글 수정    | GET | /posts/update/{postid} |

---

### API 명세서

- URI : 정보의 자원을 표현
- 뷰와 구분하기 위해 URI에 /api 를 명시함
- 메소드 : 자원에 대한 행위는 URI에 포함하지 않고 메소드로 표현함

| 자원       | 메소드    | URI                       | 설명                |
|----------|--------|---------------------------|-------------------|
| posts    | POST   | /api/posts                | 하나의 게시글을 작성하는 API |
| posts    | GET    | /api/posts                | 전체 게시글을 조회하는 API  |
| posts    | GET    | /api/posts/{postid}       | 특정 게시글을 조회하는 API  |
| posts    | PUT    | /api/posts/{postid}       | 특정 게시글을 수정하는 API  |
| posts    | DELETE | /api/posts/{postid}       | 특정 게시글을 삭제하는 API  |
| comments | GET    | /api/comments/{commentid} | 특정 댓글을 조회하는 API   |
| comments | POST   | /api/comments/            | 하나의 댓글을 작성하는 API  |
| comments | PUT    | /api/comments/{commentid} | 특정 댓글을 수정하는 API   |
| comments | DELETE | /api/comments/{commentid} | 특정 댓글을 삭제하는 API   |

---

