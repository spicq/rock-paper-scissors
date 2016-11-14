package com.coach.rockpaperscissors;

/**
 * Created by Sebastien Picq on 10/11/2016.
 */
public class RockPaperScissors {

    public static void main(String args[]) {
        System.out.println("Welcome to the game Rock/Paper/Scissors");
        Reader reader = new Reader();
        int numGame = 1;
        while (true) {   // game loop
            System.out.println("=============== Game n°" + numGame++);
            int numRounds = reader.readInt("Please enter the number of rounds between 0(quit) and 10: ", 0, 10);
            if (numRounds == 0) {
                break;
            }
            boolean playerPlaying = reader.readInt("Please enter the type of game: 0 for Player vs Computer, 1 for Computer vs Computer: ", 0, 1) == 0;
            GameType gameType = playerPlaying ? GameType.PlayerVsComp : GameType.CompVsComp;
            Game game = new Game(gameType, numRounds);
            System.out.println("We are going to play " + numRounds + " rounds, " + game.getPlayer1().getName() + " vs " + game.getPlayer2().getName());

            GameResult gameResult = game.play();
            System.out.println("=============== End of game. Results:");
            if (gameResult.isTieResult()) {
                System.out.println("This game was tied " + gameResult.player1.getScore() + " vs " + gameResult.player2.getScore());
            } else if (gameResult.hasFirstPlayerWon()) {
                System.out.println(gameResult.player1.getName() + " has won this game, scoring " + gameResult.player1.getScore() + " vs " + gameResult.player2.getScore());
            } else {
                System.out.println(gameResult.player2.getName() + " has won this game, scoring " + gameResult.player2.getScore() + " vs " + gameResult.player1.getScore());
            }
            System.out.println("===============");
            System.out.println("");
        }
        System.out.println("Thanks for playing with us, bye");
    }

}
