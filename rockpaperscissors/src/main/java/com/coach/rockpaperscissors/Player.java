package com.coach.rockpaperscissors;

/**
 * Created by sebastien on 14/11/2016.
 */
public interface Player {
    Move getMove();

    int increaseScore();

    int getScore();

    String getName();

    void notifyMoves(Move playerMove, Move otherPlayerMove);
}
