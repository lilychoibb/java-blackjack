# java-blackjack

블랙잭 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 용어 정리

- Hit : 카드를 더 뽑는 것
- Stay : 카드를 더 뽑지 않고 차례를 마치는 것

## 기능 목록

### 블랙잭 게임

- [ ] 게임 시작 시 카드 2장 획득

- [ ] 카드 획득
    - [ ] 52장의 카드 중 랜덤으로 1장 획득
    - [ ] 획득한 카드를 다시 획득 불가

- [ ] 카드 숫자 합 계산
    - Ace는 1 또는 11로 계산 가능
    - King, Queen, Jack은 각 10으로 계산

- [ ] 카드 합이 21 또는 21에 가까운 숫자가 승리

### 딜러

- [ ] 처음에 받은 2장의 합계가 16점 이하면 카드 1장 획득, 17점 이상 이면 카드 획득 불가

### 플레이어

- [ ] 21을 넘지 않을 때까지 Hit 가능

### 입력

- [ ] 게임에 참여할 사람 이름 입력
    - [ ] 이름은 쉼표를 기준으로 분리
    - [ ] 플레이어는 1명 이상
    - [ ] 이름 앞 뒤 공백 제거

- [ ] Hit 여부 입력
    - [ ] y 와 n 이외의 문자 입력

### 출력

- [ ] 처음 받은 카드 2장 출력
- [ ] Hit 후 보유한 카드 출력
- [ ] 딜러의 카드 획득 여부 출력
- [ ] 최종 카드 현황 및 결과 출력
- [ ] 최종 승패 출력
