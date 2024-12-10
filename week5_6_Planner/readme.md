# 일정관리앱 프로젝트

## API 명세서

|기능|Method|URL|request|response|상태코드|
|------|---|---|---|---|---|
|일정 생성 API|POST|/planner|요청 body|등록 정보|200:CREATED|
|일정선택조회 API|GET|/planner/{id}|요청 param|단건응답 정보|200:OK|
|일정목록조회 API|GET|/planner|요청 param|다건응답 정보|200:OK|
|일정 수정 API|PUT|/planner/{id}|요청 body|수정 정보|200:OK|
|일정 삭제 API|DEL|/planner/{id}|요청 param| - |200:OK|


## ERD

![image](https://github.com/user-attachments/assets/bee89d63-eb86-4d79-b6cd-ad46da6aff38)
