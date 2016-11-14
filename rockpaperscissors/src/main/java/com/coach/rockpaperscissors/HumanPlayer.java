package com.coach.rockpaperscissors;

/**
 * Created by sebastien on 14/11/2016.
 */
public class HumanPlayer extends AbstractPlayer {
    Reader reader = new Reader();

    public HumanPlayer(Reader reader) {
        this();
        this.reader = reader;
    }

    public HumanPlayer() {
        super();
        this.name = "Player";
    }

    public Move getMove() {
        int moveOrder = reader.readInt("Please enter a Move " + Move.displayMoves() + " :", 1, Move.getNumMoves());
        return Move.fromOrder(moveOrder);
    }
}
