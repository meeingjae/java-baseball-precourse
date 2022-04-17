# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
-- --
## 기능 목록
* **기능 목록**
    * **Feature**
      * **게임**
        * 게임 시작
        * 사용자 입력  
        * 게임 진행
        * 게임 끝
        * 게임 다시 시작   
      * **정답**
        * 정답 생성
      * **점수**
        * 정답 비교
        * 결과 출력  
      * **난수 생성기**
        * 특정 범위의 난수 생성
      * **예외 처리기**  
          * 잘못 입력 시 Exception 및 게임 완전 종료
            * 입력 값에 숫자가 아닌 값이 포함 된 경우
            * 중복된 값을 입력한 경우
            * 입력해야 하는 값보다 더 많거나 적은 값을 입력한 경우
-- --
## 참고 사항
* **Library**
    * **Java**
        * JDK 8 사용할 것
        * JDK의 Random(), Scanner() 사용 금지
        * JDK 8의 stream api 사용 금지
        * lambda 사용 가능
        * camp.nextstep.edu.missionutils.Randoms.pickNumberInRange() 사용 —> 랜덤 값 추출
        * camp.nextstep.edu.missionutils.Console.readLine() 사용 —> 사용자 입력
    * **Test**
        * [JUnit5](https://www.baeldung.com/parameterized-tests-junit-5) , [AssertJ 사용](https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion)
* **Test**
    * baseBall.ApplicationTest 의 2개 Test Case 성공
        * 별도 Test Case 생성 가능
    * Doamin Logic 단위 테스트 구현
        * UI 로직 제외
* **[Java Code Convention](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)**
    * indent, depth 는 2를 넘지 않도록 구현
    * else 문 사용 금지
    * switch/case 사용 금지
    * method 길이는 10라인을 넘지 않는다
        * Method가 한 가지 기능을 하도록 한다
* **Git**
    * **Commit**
        * **[Commit Message Convension](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)**
        * README에 정리한 기능 목록 단위로 Commit
