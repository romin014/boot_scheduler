# boot_scheduler

## 개요
이 프로젝트는 일정관리 애플리케이션입니다. 
이 일정관리 애플리케이션은 일정을 저장하고 조회하거나 수정 및 삭제를 할 수 있습니다.

## 개발기간
2025.3.19 ~ 2025.3.26

## 기능
- 일정을 생성하고 생성한 일정을 수정하거나 삭제할 수 있습니다.

## 사용법
- 일정 생성 : 일정을 요청 body에 입력한 뒤 생성한다.
- 일정 조회 : 전체 조회(/schedule), 작성자 명을 통한 검색(/schedule/author/{author}), 날짜를 통한 검색(/schedule/date/{date}), 고유 식별자를 통한 단건 검색(/schedule/{id})이 가능하다.
- 일정 수정 : 고유 식별자를 통해 원하는 일정의 내용과 작성자명을 수정할 수 있습니다. 요청 body에는 수정할 내용과 함께 password를 포함해야 합니다. 비밀번호가 옳다면 수정할 수 있습니다.
- 일정 삭제 : 고유 식별자를 통해 원하는 일정을 삭제할 수 있습니다. 요청 body에 비밀번호를 입력하여 비밀번호가 옳다면 일정을 삭제할 수 있습니다.

## API 명세서
| 기능             | Method | URL                       | Request | Response                                                                                                                  | 상태코드 |
|:---------------| :---- |:--------------------------| :---- |:--------------------------------------------------------------------------------------------------------------------------| :---- |
| 일정 생성          | POST | /schedule                 | 요청 body { “Todo Title” : “일정 제목” “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 “Date” : 생성/수정일 } | 등록 정보                                                                                                                     | 201 : 정상 생성 |
| 일정 조회(전체)      | GET | /schedule                 | 요청 param | 응답 정보 { “id” : 아이디 “Todo Title” : “일정 제목” “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 “Date” : 생성/수정일 } | 200 : 정상 조회 |
| 일정 조회(작성자명 검색) | GET | /schedule/author/{author} | 요청 param | 응답 정보 { “id” : 아이디 “Todo Title” : “일정 제목” “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 “Date” : 생성/수정일 } | 200 : 정상 조회 |
| 일정 조회(날짜 검색)   | GET | /schedule/date/{date}     | 요청 param | 응답 정보 { “id” : 아이디 “Todo Title” : “일정 제목” “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 “Date” : 생성/수정일 } | 200 : 정상 조회 |
| 일정 조회(선택)      | GET | /schedule/{id}            | 요청 param | 응답 정보 { “id” : 아이디 “Todo Title” : “일정 제목” “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 “Date” : 생성/수정일 } | 200 : 정상 조회 |
| 선택 일정 수정       | PUT | /schedule/{id}            | 요청 body { “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 } | 수정 정보 { “id” : 아이디 “Todo Title” : “일정 제목” “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 “Date” : 생성/수정일 } | 200 : 정상 수정 |
| 선택 일정 삭제       | DELETE | /schedule/{id}            | 요청 body { “Password” : 비밀번호 } | \-                                                                                                                        | 200 : 정상 삭제 |

## ERD  

| Schedule       |        |       |
|:---------------|:-------|:------|
| id             | 식별자    | BIGINT |
| todo\_title    | 할일 제목  | VARCHAR(100) |
| todo\_contents | 할일 내용  | TEXT COMMENT |
| author         | 작성자    | VARCHAR(30) |
| password       | 비밀번호   | SMALLINT   |
| date\          | 생성/수정일 | DATETIME |


