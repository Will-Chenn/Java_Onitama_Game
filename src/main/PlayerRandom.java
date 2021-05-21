package main;

import java.util.*;

/**
 * The main.PlayerRandom class extends the Player class and this class represents the palyerRandom in the
 * onitama game. We simulate a Random player to play the onitama game. This randomPlayer will choose a style
 * randomly and will get the valid rowO, colO, rowD and colD by random choose
 */
public class PlayerRandom extends Player {
    private Onitama onitama;
    private char[][] board;

    /**
     * this method initializes the instance board in the class
     */
    public void setBoard(){
        this.board = onitama.getBoard();
    }

    /**
     * this method initializes the instance onitama in the class
     */
    public void setOnitama(Onitama onitama){
        this.onitama = onitama;
    }

    /**
     * This method imply the action of extending the Player class by using super()
     * @param player, which is a char token of the player
     */
    public PlayerRandom(char player) {
        super(player);
    }

    /**
     * This method overwrites the getTurn method in Player. It uses many helper function,
     * It gets the style name and the coordinates of the valid move randomly.
     * @return Turn, which contains the coordinates and the stylename and player
     */
    @Override
    public Turn getTurn() {
        Style style = chooseStyle();
        int[] start = startMove();
        int rowO = start[0];
        int colO = start[1];
        int[] end = endMove(style, rowO, colO);
        assert end != null;
        int rowD = end[0];
        int colD = end[1];
        return new Turn(rowO, colO, rowD, colD, style.getName(), this.player);
    }

    /**
     * the method chooses the correct style randomly
     * @return the correct style corresponds to the player
     */
    private Style chooseStyle(){
        Style[] styleP1 = new Style[0];
        for(Style s: onitama.getStyles()){
            if (s.getOwner() == player){
                styleP1 = addElement(styleP1, s);
            }
        }
        int chooseNumber = new Random().nextInt(styleP1.length);
        return styleP1[chooseNumber];
    }

    /**
     * A helper function which add the int[] item into the int[][] arr
     * @param arr is the int[][] array itself
     * @param item is the item needed to be added into int[][] arr
     * @return the int[][] arr containing the item which is just added
     */
    public int[][] addX(int[][] arr, int[] item){
        int[][] newArr = new int[arr.length + 1][arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[newArr.length - 1] = item;
        return newArr;
    }

    /**
     * A helper function which add the new style into the Style[] arr
     * @param arr is the Style[] array itself
     * @param style needs to be added into Style[] arr
     * @return the Style[] arr which has been already added the style inside
     */
    public Style[] addElement(Style[] arr, Style style){
        Style[] newArray = new Style[arr.length + 1];
        System.arraycopy(arr, 0, newArray, 0, arr.length);
        newArray[newArray.length - 1] = style;
        return newArray;
    }

    /**
     * Determine the correct move of the rowO, colO, rowD, colD
     * @param rowO which is generated randomly
     * @param colO which is generated randomly
     * @param rowD which is generated randomly
     * @param colD which is generated randomly
     * @return true or false if it is a legal move
     */
    private boolean isLegalMove(int rowO, int colO, int rowD, int colD) {
        if(rowO < 0 || rowO >= Onitama.DIMENSION ||
                colO < 0 || colO >= Onitama.DIMENSION ||
                rowD < 0 || rowD >= Onitama.DIMENSION ||
                colD < 0 || colD >= Onitama.DIMENSION){
            return false;
        }
        return true;
    }

    /**
     * This method uses style.getMoves and rowO and colO to get the valid rowD and colD
     * @param style is the style we will use to get the moves
     * @param rowO is generated randomly
     * @param colO is generated randomly
     * @return the valid end move from int[] properMoves
     */
    private int[] endMove(Style style, int rowO, int colO){
        int[][] properMoves = new int[0][0];
        if(board[rowO][colO] == OnitamaBoard.G2 ||
                board[rowO][colO] == OnitamaBoard.M2){
            for(Move move: style.getMoves()){
                if(isLegalMove(rowO, colO, rowO + move.getRow(), colO + move.getCol())){
                    int[] end =  {rowO + move.getRow(), colO + move.getCol()};
                    properMoves = addX(properMoves, end);
                }
            }
        }
        if(board[rowO][colO] == OnitamaBoard.M1 ||
                board[rowO][colO] == OnitamaBoard.G1){
            for(Move move: onitama.flipStyle(style).getMoves()){
                if(isLegalMove(rowO, colO, rowO + move.getRow(), colO + move.getCol())){
                    int[] end =  {rowO + move.getRow(), colO + move.getCol()};
                    properMoves = addX(properMoves, end);
                }
            }
        }
        if(properMoves.length != 0){
            int chooseNumber = new Random().nextInt(properMoves.length);
            return properMoves[chooseNumber];
        }
        return null;
    }

    /**
     * This method loops through the board and gets coordinates of the
     * original move of each players. It also the get the rowO and colO randomly from int[][]
     * startMovesP1(meaning the valid start move
     * from player1) and int[][] startMovesP2(meaning the valid start move from player2)
     * @return the int[] startMove which contains rowO and ColO
     */
    private int[] startMove(){
        int size = Onitama.DIMENSION;
        int[][] startMovesP1 = new int[0][0];
        int[][] startMovesP2= new int[0][0];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == OnitamaBoard.M1 || board[i][j] == OnitamaBoard.G1){
                    int[] move = {i, j};
                    startMovesP1 = addX(startMovesP1, move);
                }
                if(board[i][j] == OnitamaBoard.M2 || board[i][j] == OnitamaBoard.G2){
                    int[] move = {i, j};
                    startMovesP2 = addX(startMovesP2, move);
                }
            }
        }
        int chooseNumber = new Random().nextInt(size);
        if(this.player == OnitamaBoard.M1 || this.player == OnitamaBoard.G1){
            return startMovesP1[chooseNumber];
        }
        return startMovesP2[chooseNumber];
    }

}
