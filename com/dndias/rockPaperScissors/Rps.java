package com.dndias.rockPaperScissors;

import java.util.HashMap;

/**
 * Creates an Enum for thee possible movements in a Rock,
 * Paper, Scissors game.
 *
 * @author Daniel Dias
 * @version 1.0
 */
public enum Rps {
    ROCK ("rock", "scissors"),
    PAPER ("paper", "rock"),
    SCISSORS("scissors", "paper");

    private String name;
    private String winsOver;
    private static HashMap<String, Rps> lookUpByName = null;

    /**
     * Construct a Rps Enum object.
     *
     * @param name the movement name. Can be rock, paper or scissor
     * @param winsOver the movement which each movement wins over.
     */
    Rps(String name, String winsOver) {
        this.name = name;
        this.winsOver = winsOver;
    }

    /**
     * Retrieves the name of the movement
     *
     * @return the name of the movement
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the movement which this movement wins over
     *
     * @return the movement which this movement wins over
     */
    public String getWinsOver() {
        return winsOver;
    }


    /**
     * Retrieves the movement enum passing the movement name
     *
     * @param name the name of the movement
     * @return the movement enum
     */
    public static Rps getRps(String name) {

        if (lookUpByName == null) {
            initNameLookUp();
        }

        Rps rps = lookUpByName.get(name);

        if (rps == null) {
            throw new IllegalArgumentException("Invalid Movement");
        }

        return rps;
    }

    /**
     * Creates the HashMap that will be used by the getRPS() function
     */
    private static void initNameLookUp() {

        lookUpByName = new HashMap<>();

        for (Rps rps : values()) {
            lookUpByName.put(rps.name, rps);
        }
    }

    /**
     * Checks if the player's movement generates a tie by comparing
     * with the computer random generated movement
     *
     * @param other the computer random generated movement
     * @return true if it is a tie, false if it isn't
     */
    public boolean tie(Rps other) {
        if (this.equals(other)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the player's movement wins over the computer random
     * generated movement
     *
     * @param other the computer random generated movement
     * @return true if the player wins, false if don't
     */
    public boolean win(Rps other) {
        if (this.getWinsOver().equals(other.getName())) {
            return true;
        } else {
            return false;
        }
    }

}
