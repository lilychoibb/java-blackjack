package blackjackgame.model.participants.player;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import blackjackgame.model.card.Card;

public class Players {

    private static final String INVALID_PLAYERS_SIZE = "플레이어 수는 1명 이상이어야 합니다.";

    private final List<Player> players;

    private Players(List<Player> players) {
        validateEmptyPlayers(players);
        this.players = players;
    }

    public static Players from(List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .collect(collectingAndThen(toList(), Players::new));
    }

    private void validateEmptyPlayers(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException(INVALID_PLAYERS_SIZE);
        }
    }

    public Players addCards(List<Card> cardsElement) {
        int index = 0;
        List<Player> updatedPlayers = new ArrayList<>();
        for (Player player : players) {
            Player updatedPlayer = player.withAdditionalCards(cardsElement.subList(index, index + 2));
            updatedPlayers.add(updatedPlayer);
            index += 2;
        }
        return new Players(updatedPlayers);
    }

    public Players hit(Player player, Card card) {
        List<Player> updatedPlayers = new ArrayList<>(players);
        Player updatedPlayer = player.withAdditionalCard(card);
        int index = updatedPlayers.indexOf(player);
        updatedPlayers.remove(player);
        updatedPlayers.add(index, updatedPlayer);
        return new Players(updatedPlayers);
    }

    public List<String> playersNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int playersSize() {
        return players.size();
    }
}
