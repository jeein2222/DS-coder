## **\[DS-coder\] 덕성여자대학교 sw 전공 학생들을 위한 코딩 오답노트 프로그램💻**

-   2022.8.22~26일 간 진행된 덕성여대 IT공학부 연합 해커톤 5일간의 기록😊

---

**제작 기간**: 2022.8.22~26(4일 제작, 26일 발표 및 심사)


**제작 인원**: 4명

-   20181008 컴퓨터공학과 박지인(PM)
-   20200865 컴퓨터공학과 고민정
-   20210802 컴퓨터공학과 이수아
-   20210940 사이버보안전공 이채민


---


### **[목차]**

**1️⃣ 프로젝트 개요**

1.  팀/프로젝트 명
2.  프로젝트 소개/제안 배경
3.  적용 기술
4.  프로젝트 주요 기능/역할 분담

**2️⃣ 프로젝트 결과물**

1.  웹페이지
2.  문서

**3️⃣ 팀원들의 느낀 점/아쉬운 점**

---

### **1️⃣ 프로젝트 개요**

**1-1. 팀/프로젝트 이름**

-   **팀 이름**: DS-Coder
    -   덕성여대의 자랑스러운 IT공학부 학생이 되자는 의미로 팀원들의 개발에 대한 열정?😊을 담았다
-   **프로젝트 이름**: Wise Coder
    -   이 프로그램의 사용자가 프로그램의 여러 기능을 통해 효율적이고 현명하게 개발할 수 있는 개발자가 될 수 있기를 바라는 의미에서
        이름을 지었다.


**1-2. 프로젝트 소개/제안 배경**

-   개발자, 개발을 공부하는 학생에게 이제 기록은 선택이 아닌 필수이다. 개발 중 발생하는 오류와 솔루션을 기록하는 것은 개발 실력의 향상 뿐만 아니라
    비슷한 문제 발생시 문제 해결에 쏟는 시간을 절약할 수 있다.
-   우리는 학생들이 코딩 중에 발생하는 문제점과 솔루션을 한 곳에 기록하여 자신만의 정보 창고를 마련하고, 각종 IT관련 대외 활동 정보 및 IT
    용어 정보를 얻을 수 있는 기능을 제공함으로써 사용자의 개발 동기 부여 및 실력 향상에 목적을 두고 있다.


**1-3. 적용 기술**

![image](https://user-images.githubusercontent.com/96341808/216768158-a44200f6-3a0f-4c68-8cbc-e15d4583b953.png)



**1-4. 프로젝트 주요 기능**

| 구분 | 기능 | 설명 | 인원수/담당자 |
| --- | --- | --- | --- |
| 1 | 회원가입, 로그인  |  사용자 회원가입, 로그인(JWT 토근으로 로그인 여부 저장, spring security로 인증, 인가 구현) | 1/박지인 |
| 2 |  오답노트 작성, 게시판 | 자신의 솔루션과 코드를 올리고, 확인할 수 있는 게시판.(CRUD) | 2/고민정, 박지인 |
| 3 |  IT 영한 사전  | CS관련 영어 단어를 검색하면 한글로 번역한 결과를 리턴. | 1/이수아 |
| 4 | 다양한 IT 정보 |  IT관련 각종 공모전이나 대외활동에 대한 정보 제공 | 1/이채민      |



---


### **3️⃣ 프로젝트 결과물**

**3-1. 웹페이지**

![기능](https://user-images.githubusercontent.com/96341808/216768345-6fedab57-98bc-4547-8b2c-66522a00d871.JPG)



**3-2. 문서**

발표 PPT : [Wise Coder 발표](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/87117d32-5a7d-43b4-a52e-ab4aa8237674/DS-coder%EC%B5%9C%EC%A2%85_PPT.pdf?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230204%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230204T111421Z&X-Amz-Expires=86400&X-Amz-Signature=23b6a925a8d9b9db8012be05a2164109aa51680935c466d82dd9aba183145736&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%255BDS-coder%255D%25EC%25B5%259C%25EC%25A2%2585%2520PPT.pdf%22&x-id=GetObject)

---

### **4️⃣ 느낌 점/아쉬운 점**

-  서로 다른 학과 친구들과 학교에서 잠을 자며 짧은 기간 동안 집중해서 개발을 한 기억이 오래 남을 것 같다. 시간이 좀 더 있었더라면,
    사용자끼리 질의응답 채팅 기능을 구현해보고 싶어서 조금 아쉬웠다.
-  처음에 목표한 기능들을 잘 구현할 수 있어서 좋았다. 처음 해보는 프로젝트여서 긴장을 많이 했는데, 팀원들끼리 큰 의견 충돌없이 4일 동안 
    잘 진행할 수 있어서 좋았다.
-  Spring Boot로 처음 프로젝트를 해보았는데 짧은 기간이었지만 많은 것을 알 수 있었다. 특히, 로그인/회원가입 기능을 구현하면서 인증, 인가를 
    배울 수 있어서 좋았다. 마지막으로 **학생들이 사용하고 싶은 서비스로 투표상😊**도 받을 수 있어서 4일간 고생한 보람이 느껴져 뿌듯했다.

