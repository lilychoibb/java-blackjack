package model.blackjackgame;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import model.participants.dealer.Dealer;
import model.participants.player.Player;
import model.participants.player.Players;

public class Blackjack {

    private final boolean isDealer;
    private final Map<Player, Boolean> blackjackStatusOfPlayers;

    public Blackjack(Dealer dealer, Players players) {
        this.isDealer = dealer.isBlackjack();
        this.blackjackStatusOfPlayers = new HashMap<>();
        createPlayerBlackjackStatus(players);
    }

    private void createPlayerBlackjackStatus(Players players) {
        for (Player player : players.getPlayers()) {
            blackjackStatusOfPlayers.put(player, player.isBlackjack());
        }
    }

    public boolean isDealer() {
        return isDealer;
    }

    public Boolean blackjackStatusOfPlayer(Player player) {
        return blackjackStatusOfPlayers.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getName().equals(player.getName()))
                .map(Entry::getValue)
                .findFirst()
                .orElse(false);
    }
}
