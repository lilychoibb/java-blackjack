package model.view;

import java.util.List;
import java.util.Scanner;
import model.blackjackgame.Answer;
import model.player.Player;
import model.player.Players;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public Players requestPlayersName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        List<String> playerNames = splitName(scanner.nextLine());
        playerNames = playerNames.stream().map(this::removeBlank).toList();
        return Players.from(playerNames);
    }

    public Answer requestHitAnswer(Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        return new Answer(removeBlank(scanner.nextLine()));
    }

    private List<String> splitName(String input) {
        return List.of(input.split(","));
    }

    private String removeBlank(String input) {
        return input.trim();
    }
}
