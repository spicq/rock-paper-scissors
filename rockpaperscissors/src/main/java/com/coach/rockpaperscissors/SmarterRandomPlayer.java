package com.coach.rockpaperscissors;

/**
 * Created by sebastien on 14/11/2016.
 */
public class SmarterRandomPlayer extends RandomPlayer {

    public SmarterRandomPlayer(String name) {
        super(name);
    }
    public SmarterRandomPlayer(){
        super("Smarter Computer");
    }

    public Move getMove() {
        if (nextMove==null) {
            return super.getMove();
        } else {
            return nextMove;
        }
    }

    @Override
    public int increaseScore() {
        return super.increaseScore();
    }

    private Move nextMove=null;
    public void notifyMoves(Move playerMove, Move otherPlayerMove) {
        /*
         cf http://arstechnica.com/science/2014/05/win-at-rock-paper-scissors-by-knowing-thy-opponent/
         if you lose the first round, switch to the thing that beats the thing your opponent just played.
         If you win, don't keep playing the same thing, but instead switch to the thing that would beat the thing that you just played.
         In other words, play the hand your losing opponent just played
         */
        if (playerMove.isWinningAgainst(otherPlayerMove)) {
            nextMove = playerMove.getWiningMove();
        } else if (otherPlayerMove.isWinningAgainst(playerMove)){
            nextMove = otherPlayerMove.getWiningMove();
        } else {
            nextMove = null;    // tie
        }
    }
}
