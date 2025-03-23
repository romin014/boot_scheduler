# boot_scheduler

## 개요
이 프로젝트는 일정관리 애플리케이션입니다. 
이 일정관리 애플리케이션은 

## 개발기간
2025.3.19 ~ 2025.3.26

## 기능
- 

## 사용법
원하는 카테고리를 선택하고 메뉴를 선택하여 장바구니에 넣습니다. 메뉴 선택이 끝났다면 총액수를 출력하고 결제를 진행합니다.

## API 명세서
| 기능 | Method | URL | Request | Response | 상태코드 |
| :---- | :---- | :---- | :---- | :---- | :---- |
| 일정 생성 | POST | /schedule | 요청 body { “Todo Title” : “일정 제목” “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 “Date of creation/modification” : 생성/수정일 } | 등록 정보 | 201 : 정상 생성 |
| 일정 조회(전체) | GET | /schedule | 요청 param | 응답 정보 { “id” : 아이디 “Todo Title” : “일정 제목” “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 “Date of creation/modification” : 생성/수정일 } | 200 : 정상 조회 |
| 일정 조회(선택) | GET | /schedule/{id} | 요청 param | 응답 정보 { “id” : 아이디 “Todo Title” : “일정 제목” “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 “Date of creation/modification” : 생성/수정일 } | 200 : 정상 조회 |
| 선택 일정 수정 | PUT | /schedule/{id} | 요청 body { “Todo Title” : “일정 제목” “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 “Date of creation/modification” : 생성/수정일 } | 수정 정보 { “id” : 아이디 “Todo Title” : “일정 제목” “Todo Contents” : “일정 내용” “Author” : “작성자명” “Password” : 비밀번호 “Date of creation/modification” : 생성/수정일 } | 200 : 정상 수정 |
| 선택 일정 삭제 | DELETE | /schedule/{id} | 요청 body { “Password” : 비밀번호 } | \- | 200 : 정상 삭제 |

## ERD  

| Schedule |  |  |
| :---- | :---- | :---- |
| id | 식별자 | int |
| todo\_title | 할일 제목 | varchar(20) |
| todo\_contents | 할일 내용 | varchar(100) |
| author | 작성자 | varchar(10) |
| password | 비밀번호 | int |
| date\_of\_creation | 생성일 | timestamp |
| date\_of\_modification | 수정일 | timestamp |


