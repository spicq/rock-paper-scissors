package com.coach.rockpaperscissors;

/**
 * Created by sebastien on 14/11/2016.
 */
public abstract class AbstractPlayer implements Player {
    int score = 0;
    String name = "Computer";

    public int increaseScore() {
        score++;
        return score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void notifyMoves(Move playerMove, Move otherPlayerMove) {

    }
}
