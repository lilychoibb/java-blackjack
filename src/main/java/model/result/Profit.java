package model.result;

import java.util.HashMap;
import java.util.Map;
import model.blackjackgame.Betting;
import model.blackjackgame.Bettings;
import model.participants.player.Player;
import model.participants.player.Players;

public class Profit {

    private static final double PROFIT_RATE = 1.5;

    private final int dealerProfit;
    private final Map<String, Integer> playerProfit;

    public Profit(Players players, Result result, Bettings bettings) {
        this.playerProfit = new HashMap<>();
        players.getPlayers().forEach(player -> createPlayersProfit(player, result.getResult(player), bettings));
        this.dealerProfit = calculateDealerProfit();
    }

    private int calculateDealerProfit() {
        int totalPlayerProfit = playerProfit.values().stream().mapToInt(i -> i).sum();
        return -totalPlayerProfit;
    }

    private void createPlayersProfit(Player player, GameResult result, Bettings bettings) {
        playerProfit.put(player.getName(), calculatePlayerProfit(result,
                bettings.getBettings()
                        .stream()
                        .filter(betting -> betting.getPlayer().getName().equals(player.getName()))
                        .findFirst()
                        .orElseThrow()));
    }

    private int calculatePlayerProfit(GameResult result, Betting betting) {
        return profit(result, betting.getMoney());
    }

    private int profit(GameResult result, int money) {
        if (winOrDraw(result)) {
            return money;
        }
        if (fail(result)) {
            return -money;
        }
        if (blackjack(result)) {
            return (int) (money * PROFIT_RATE);
        }
        return 0;
    }

    private boolean winOrDraw(GameResult result) {
        return result.equals(GameResult.WIN) || result.equals(GameResult.DRAW);
    }

    private boolean fail(GameResult result) {
        return result.equals(GameResult.FAIL);
    }

    private boolean blackjack(GameResult result) {
        return result.equals(GameResult.BLACKJACK);
    }

    public int getDealerProfit() {
        return dealerProfit;
    }

    public Map<String, Integer> getPlayerProfit() {
        return playerProfit;
    }
}
