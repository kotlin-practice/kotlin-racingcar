# kotlin-racingcar
자동차 경주 게임 미션 저장소

## 기능 요구사항
- 주어진 횟수 동안 **n대의 자동차는 전진 또는 멈출 수 있다.**
- 각 자동차에 **이름을 부여** 할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 **이름은 5자 이하만** 가능하다.
- 사용자는 **몇 번의 이동을 할 것인지를 입력** 할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 **random 값이 4 이상일 경우 전진** 하고, **3 이하의 값이면 멈춘다.**
- 자동차 경주 게임을 완료한 후 **누가 우승했는지를 알려준다.** 우승자는 한 명 이상일 수 있다.


## 기능 시나리오
1. 사용자에게 자동차 이름을 입력받는다.
2. 사용자에게 시도할 회수를 입력받는다.
3. 시도한 횟수만큼 자동차가 이동하고, 이 이동한 거리를 콘솔로 출력한다.
4. 시도횟수가 끝나면 가장 멀리 이동한 자동차(들) 우승자를 출력한다.

## 객체 정의
- 도메인
  - 자동차 경주
    - 필드: 시도횟수, 참여할 자동차 리스트
    - 메서드: 자동차 생성, 
  - 자동차
    - 필드: 이름(VO), 이동한 거리
    - 메서드: 
- VO
  - 자동차이름(CarName)
    - 이름 규칙
      - 글자수가 5 이하
      - 알파벳 대소문자만
- 유틸
  - 랜덤 번호 생성기


