package main;

// TODO: Add Javadoc comments for all its methods. (Task 6.1)

/**
 * A class to represent a potential turn (piece selection and movement).
 */

public class Turn {
    private int rowO, colO, rowD, colD;
    private String styleName;
    private char player;


    /**
     * Constructs a move (piece placement) that knows its row, col
     * movement from origin to destination on the grid
     *
     * @param row_o	integer representing the origin row of the piece to move
     * @param col_o	integer representing the origin column of the piece to move
     * @param row_d	integer representing the destination row of the piece to move
     * @param col_d	integer representing the destination column of the piece to move
     * @param styleName string representing the style being used to move
     * @param player the character representing the player making this Turn
     */
    public Turn(int row_o, int col_o, int row_d, int col_d, String styleName, char player) {
        this.rowO = row_o;
        this.colO = col_o;
        this.rowD = row_d;
        this.colD = col_d;
        this.player = player;
        this.styleName = styleName;
    }

    /**
     * Return the initializer player
     * @return player the initializer of this turn
     */
    public char getPlayer() {
        return player;
    }

    /**
     * Return the initializer colD
     * @return the colD of this turn
     */
    public int getColD(){
        return colD;
    }

    /**
     * Return the initializer colO
     * @return the colO of this turn
     */
    public int getColO(){
        return colO;
    }

    /**
     * Return the initializer rowO
     * @return the rowO of this turn
     */
    public int getRowO(){
        return rowO;
    }

    /**
     * Return the initializer rowD
     * @return the rowD of this turn
     */
    public int getRowD(){
        return rowD;
    }

    /**
     * Return the initializer styleName
     * @return the styleName of this turn, which means the style in this turn
     */
    public String getStyle(){
        return styleName;
    }

    /**
     * Returns string representation of this Turn, containing rowO, rowD, colO, colD
     * @return Returns string representation of this Turn with the specific format
     */
    public String toString(){
        String name = String.valueOf(getPlayer());
        String style = getStyle();
        return name + ": (" + getRowO() + "," + getColO() + "," + style + ") -> (" + getRowD() +
                "," + getColD() + ")";
    }

    /**
     * Main function which creates and get the toString in main.Turn
     */
    public static void main(String[] args){
        // Create Turns
        Turn t1 = new Turn(0, 0, 1, 2, "dragon", 'X');
        Turn t2 = new Turn(3, 2, 2, 2, "crab", 'O');
        Turn t3 = new Turn(2, 2, 3, 1, "rooster", 'X');

        // Print Turns
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }


}
