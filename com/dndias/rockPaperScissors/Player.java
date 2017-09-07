package com.dndias.rockPaperScissors;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * A class that models a player for the Rock, Paper, Scissors game.
 * Each player has a move and a score.
 *
 * @author Daniel Dias
 * @version 1.0
 */
public class Player {

    public Rps move;
    private IntegerProperty score = new SimpleIntegerProperty(this, "score");

    /**
     * Retrieves the score of this player
     *
     * @return the player's score
     */
    public int getScore() {
        return score.get();
    }

    /**
     * Attempts to place a valid specified score to this player. The score
     * needs to be equal or higher than zero, otherwise an exception is throw.
     *
     * @param score the specified score
     */
    public void setScore(int score) {
        if (score >= 0) {
            this.score.set(score);
        } else {
            throw new IllegalArgumentException("Error: Score can't be less than 0");
        }
    }

    /**
     * Increments this player's current score.
     */
    public void incrementScore() {
        setScore(this.score.intValue()+1);
    }

    /**
     * Retrieves the score Property of this player
     *
     * @return the IntegerProperty score of this player
     */
    public IntegerProperty scoreProperty() {
        return score;
    }

    /**
     * Receives the movement name and place in the corresponding enum value
     *
     * @param move the player's movement
     */
    public void makeMove(String move) {
        this.move = Rps.getRps(move);
    }

    /**
     * Generates a random move for the computer and place in the
     * corresponding enum value
     *
     * @return the enum corresponding to the random movement generated
     */
    public Rps makeRandomMove() {
        int random = (int) ( Math.random() * 3 + 1);
        String move;
        if (random == 1) {
            move = "rock";
        } else if (random == 2) {
            move = "paper";
        } else {
            move = "scissors";
        }
        Rps randomMove = Rps.getRps(move);
        return randomMove;
    }

    /**
     * Creates a string representation of this player movement.
     *
     * @return the player's movement name
     */
    @Override
    public String toString() {
        return move.getName();
    }
}
