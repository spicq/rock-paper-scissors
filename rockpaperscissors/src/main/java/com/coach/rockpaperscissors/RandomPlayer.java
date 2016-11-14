package com.coach.rockpaperscissors;

import java.util.Random;

/**
 * Created by sebastien on 14/11/2016.
 */
public class RandomPlayer extends AbstractPlayer {
    private Random random = new Random();

    public RandomPlayer(String name) {
        super();
        this.name=name;
    }
    public RandomPlayer(){}

    public Move getMove() {
        return Move.fromOrder(random.nextInt(Move.getNumMoves()) + 1);
    }
}
