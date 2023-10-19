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

![ERD 다이어그램]()

---

### 뷰 명세서

- Ajax 통신을 이용해 브라우저 랜더링 과정을 간소화함

| 기능 | 메소드 | URI |
| --- | --- | --- |
| 게시글 전체 목록 | GET | / |
| 게시글 상세보기 | GET | /posts/{postid} |
| 게시글 작성 | GET | /posts/save |
| 게시글 수정 | GET | /posts/update/{postid} |

---

### API 명세서

- URI : 정보의 자원을 표현
- 뷰와 구분하기 위해 URI에 /api 를 명시함
- 메소드 : 자원에 대한 행위는 URI에 포함하지 않고 메소드로 표현함

| 자원 | 메소드 | URI | 설명 |
| --- | --- | --- | --- |
| posts | POST | /api/posts | 하나의 게시글을 작성하는 API |
| posts | GET | /api/posts | 전체 게시글을 조회하는 API |
| posts | GET | /api/posts/{postid} | 특정 게시글을 조회하는 API |
| posts | PUT | /api/posts/{postid} | 특정 게시글을 수정하는 API |
| posts | DELETE | /api/posts/{postid} | 특정 게시글을 삭제하는 API |
| comments | GET | /api/comments/{commentid} | 특정 댓글을 조회하는 API |
| comments | POST | /api/comments/ | 하나의 댓글을 작성하는 API |
| comments | PUT | /api/comments/{commentid} | 특정 댓글을 수정하는 API |
| comments | DELETE | /api/comments/{commentid} | 특정 댓글을 삭제하는 API |

---

## 스크린샷

### 1. 초기 화면

![게시글 전체 목록 조회 가능](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/68812006-6f88-4a7d-9c09-c02a9673957b/Untitled.png)

게시글 전체 목록 조회 가능

### 2. 로그인 관련 기능

![구글 소셜 로그인 화면](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/6b52f231-da3d-40bd-a039-e995fd6c9792/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2023-10-18_182410-bw.png)

구글 소셜 로그인 화면

![로그인 성공 시 출력 화면](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/f31fa176-6dd1-4f3e-8624-9eec22f6c0ea/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2023-10-18_182736-vw.png)

로그인 성공 시 출력 화면

### 3. 게시글 관련 기능

![게시글 등록 성공 시 팝업 출력](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/bab3b3d8-3540-4ce6-afd5-da14450c90e5/Untitled.png)

게시글 등록 성공 시 팝업 출력

![게시글 수정](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/568d6a9a-7b17-48ba-a9a5-df70492ad63a/Untitled.png)

게시글 수정

![게시글 삭제](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/01d17561-1370-47d5-a020-fec066908bf8/Untitled.png)

게시글 삭제

![게시글 상세 조회](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/dc95dda7-e6da-4bc6-8ebc-4933ea62b285/Untitled.png)

게시글 상세 조회

![게시글 수정 기능 정상 작동 확인](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/14118f24-0c05-4134-a1ce-c2942d00e3ee/Untitled.png)

게시글 수정 기능 정상 작동 확인

![게시글 삭제 기능 정상 작동 확인](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/fb13b002-3cf5-4b9f-adce-d6fa9f20e97c/Untitled.png)

게시글 삭제 기능 정상 작동 확인

### 4. 댓글 관련 기능

![댓글 등록 성공 시 팝업 출력](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/2566b780-a524-450c-87c4-9bc590c1ea2b/Untitled.png)

댓글 등록 성공 시 팝업 출력

![댓글 수정 버튼 클릭 시 입력폼이 나타나고 수정 완료 시 팝업 출력](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/bd4e41fa-f8d7-4f58-91db-f6cb66580d26/Untitled.png)

댓글 수정 버튼 클릭 시 입력폼이 나타나고 수정 완료 시 팝업 출력

![댓글 삭제 기능 정상 작동 확인](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/1e2c076c-aebe-471c-a6ac-4b3e7246f4e3/Untitled.png)

댓글 삭제 기능 정상 작동 확인

![게시글 상세 조회 화면에서 댓글 전체 조회 가능](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/d7553be3-a2cb-4632-9f75-279f666f5c90/Untitled.png)

게시글 상세 조회 화면에서 댓글 전체 조회 가능

![댓글 수정 기능 정상 작동 확인](https://prod-files-secure.s3.us-west-2.amazonaws.com/7e758bb6-f0dd-4f7f-85f5-68cc1697a12a/1607bda1-8bd3-4c23-8c19-a0b608f606cf/Untitled.png)

댓글 수정 기능 정상 작동 확인
