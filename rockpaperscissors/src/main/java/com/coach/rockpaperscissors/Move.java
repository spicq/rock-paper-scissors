package com.coach.rockpaperscissors;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by sebastien on 14/11/2016.
 */
public enum Move {
    Rock(1), Paper(2), Scissors(3);    // other moves can be added incrementing move order, so that
    // If odd, it must win against all preceeding even moves and must lose against the other moves
    // If even, it must win against all preceeding odd moves and must lose against the other moves
    private int order, group;

    Move(int order) {
        this.order = order;
        this.group = order % 2;
    }

    public boolean isWinningAgainst(Move otherMove) {
        if (otherMove == this) return false;
        if (otherMove.group == group) {
            return order < otherMove.order;
        } else {
            return order > otherMove.order;
        }
    }

    /**
     *
     * @return the move that wins against this move
     */
    public Move getWiningMove() {
        for (Move move:EnumSet.complementOf(EnumSet.of(this))) {
            if (move.isWinningAgainst(this)) {
                return move;
            }
        }
        return null;
    }

    public static int getNumMoves() {
        return EnumSet.allOf(Move.class).size();
    }

    private static Map<Integer, Move> movesByOrder;

    public static Move fromOrder(int order) {
        if (movesByOrder == null) {
            movesByOrder = new HashMap<Integer, Move>();
            for (Move move : EnumSet.allOf(Move.class)) {
                movesByOrder.put(move.order, move);
            }
        }
        return movesByOrder.get(order);
    }

    public static String displayMoves() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (Move move : EnumSet.allOf(Move.class)) {
            if (!first) {
                stringBuilder.append(", ");
            } else {
                first = false;
            }
            stringBuilder.append(move.order).append('-').append(move);
        }
        return stringBuilder.toString();
    }
}
