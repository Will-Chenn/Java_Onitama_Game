package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: Add Javadoc comments for this class and all its methods. (Task 6.1)

/**
 * An main.PlayerHuman class consisting of the string for the invalid style and number.
 * It is also extends the Player class. This class represents the palyerHuman in the
 * onitama game.
 */
public class PlayerHuman extends Player{

    private static final String INVALID_MOVE_INPUT_MESSAGE = "Invalid number, please enter 0-4";
    private static final String INVALID_STYLE_INPUT_MESSAGE = "Invalid style, please enter one of this player's styles " +
            "(Dragon, Crab, Horse, Mantis, Rooster)";
    private static final BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    /**
     * This method imply the action of extending the Player class by using super()
     * @param player, which is a char token of the player
     */
    public PlayerHuman(char player) {
        super(player);
    }

    /**
     * This method overwrites the getTurn method in Player. It asks the style name from player and
     * it uses a helper function getMove to get the coordinates by asking player to get them
     * @return Turn, which contains the data from player's input.
     */
    @Override
    public Turn getTurn() {
        String style_name = "";
        try {
            System.out.print("Choose your style:");
            style_name = PlayerHuman.stdin.readLine();
        } catch (IOException e) {
            System.out.println(INVALID_STYLE_INPUT_MESSAGE);
        }
        int row_o = getMove("row origin: ");
        int col_o = getMove("col origin: ");
        int row_d = getMove("row destination: ");
        int col_d = getMove("col destination: ");
        return new Turn(row_o, col_o, row_d, col_d, style_name, this.player);
    }

    /**
     * This method determines the correct input number, if the input number is invalid it will
     * also print the String corresponds to the invalid content.
     * @param message, which will be used to ask player to get the integer of the move
     * @return the valid number, and return -1 if invalid
     */
    private int getMove(String message) {
        int move, lower = 0, upper = 4;
        while (true) {
            try {
                System.out.print(message);
                String line = PlayerHuman.stdin.readLine();
                move = Integer.parseInt(line);
                if (lower <= move && move <= upper) {
                    return move;
                } else {
                    System.out.println(INVALID_MOVE_INPUT_MESSAGE);
                }
            } catch (IOException e) {
                System.out.println(INVALID_MOVE_INPUT_MESSAGE);
                break;
            } catch (NumberFormatException e) {
                System.out.println(INVALID_MOVE_INPUT_MESSAGE);
            }
        }
        return -1;
    }
}