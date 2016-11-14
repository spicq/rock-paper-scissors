package com.coach.rockpaperscissors;


import java.util.Random;

/**
 * Created by sebastien on 14/11/2016.
 */
public class Game {
    private int numRounds;
    private Player player1, player2;

    public Game(GameType gameType, int numRounds) {
        this.player1 = gameType == GameType.PlayerVsComp ? new HumanPlayer() : getComputerPlayer(" A", null);
        this.player2 = gameType == GameType.PlayerVsComp ? getComputerPlayer("", null) : getComputerPlayer(" B", player1);
        this.numRounds = numRounds;
    }

    private Random random = new Random();
    private Player getComputerPlayer(String suffix, Player otherComputerPlayer) {
        boolean smarterComputer = otherComputerPlayer==null?random.nextBoolean():(player1 instanceof RandomPlayer);
        return smarterComputer ? new SmarterRandomPlayer("Smarter Computer" + suffix) : new RandomPlayer("Computer" + suffix);
    }

    public GameResult play() {
        for (int i = 0; i < numRounds; i++) {
            Move player1Move = player1.getMove(), player2Move = player2.getMove();
            System.out.print("round" + (i + 1) + ", " + player1Move + " vs " + player2Move + ": ");
            if (player1Move != player2Move) {
                if (player1Move.isWinningAgainst(player2Move)) {
                    System.out.println(player1.getName() + " has won this round");
                    player1.increaseScore();
                } else {
                    System.out.println(player2.getName() + " has won this round");
                    player2.increaseScore();
                }
            } else {
                System.out.println("This round was tied");
            }
            player1.notifyMoves(player1Move, player2Move);
            player2.notifyMoves(player2Move, player1Move);
        }
        return new GameResult(player1, player2);
    }

    public int getNumRounds() {
        return numRounds;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
