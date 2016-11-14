package com.coach.rockpaperscissors;

import org.junit.Test;

import java.io.StringReader;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


/**
 * Created by Sebastien Picq on 10/11/2016.
 */
public class RockPaperScissorsTest {

    @Test
    public void testReader() {
        Reader reader = new Reader(new Scanner(new StringReader("-5\nzab\n1\n2\n15\n10")));
        int num = reader.readInt("Test message", 2, 10);
        assertEquals(num, 2);
        num = reader.readInt("Test message", 2, 10);
        assertEquals(num, 10);
    }

    @Test
    public void testMove() {
        assertTrue("Paper must win against Rock", Move.Paper.isWinningAgainst(Move.Rock));
        assertFalse("Paper mustn't win against Scissors", Move.Paper.isWinningAgainst(Move.Scissors));
        assertFalse("Paper mustn't win against Paper", Move.Paper.isWinningAgainst(Move.Paper));
        assertTrue("Rock must win against Scissors", Move.Rock.isWinningAgainst(Move.Scissors));
        assertTrue("Scissors must win against Paper", Move.Scissors.isWinningAgainst(Move.Paper));
    }

    @Test
    public void testPlayer() {
        Player player1 = new RandomPlayer(), player2 = new HumanPlayer(new Reader(new Scanner(new StringReader("-5\nzab\n2\n1\n3")))), player3 = new SmarterRandomPlayer();
        assertNotNull(player1.getMove());
        Move player3Move = player3.getMove();
        assertNotNull(player3Move);
        assertEquals(player2.getMove(), Move.Paper);
        player3.notifyMoves(player3Move, Move.Paper);
        assertEquals(player2.getMove(), Move.Rock);
        assertNotNull(player3Move);
        assertEquals(player2.getMove(), Move.Scissors);
    }

    @Test
    public void testGame() {
        Game game = new Game(GameType.CompVsComp, 10);
        GameResult gameResult = game.play();
        assertNotNull(gameResult);
        assertNotNull(gameResult.player1);
        assertNotNull(gameResult.player2);
        assertTrue(gameResult.player1.getScore() >= 0 && gameResult.player1.getScore() <= 10);
        assertTrue(gameResult.player2.getScore() >= 0 && gameResult.player2.getScore() <= 10);
        assertTrue(gameResult.player1.getScore() + gameResult.player2.getScore() <= 10);
    }
}
