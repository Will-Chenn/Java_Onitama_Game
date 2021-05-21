package main;
/**
 * A class represents the Player in the game
 */

// TODO: Add Javadoc comments for this class and all its methods. (Task 6.1)
public class Player {

    protected final char player;

    /**
     * Constructs a player by the char player
     * @param player
     */
    public Player(char player) {
        this.player = player;
    }

    /**
     * This method is made for the method getTurn in PlayerHuman and PlayerRandom
     * This is used to implement in subclasses
     * @return null for now
     */
    public Turn getTurn() {
        return null;
    }

    /**
     * This method will return the player as the char token in the game
     * @return player,which is a char, representing a token
     */
    public char getPlayer() {
        return player;
    }
}