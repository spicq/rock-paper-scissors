package com.coach.rockpaperscissors;

/**
 * Created by sebastien on 14/11/2016.
 */
public class GameResult {
    Player player1, player2;

    public GameResult(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    boolean hasFirstPlayerWon() {
        return player1.getScore() > player2.getScore();
    }

    boolean isTieResult() {
        return player1.getScore() == player2.getScore();
    }
}
