package main;

/**
 * A controller which is about Human VS Human.and keeping track of
 * which player's turn it currently is and some statistics about the game.
 * It updates every round for two random players.
 * It also print every round for this the board for random players in order to run this game
 */
public class OnitamaControllerRandomVSRandom {
    protected Onitama onitama;
    PlayerRandom player1;
    PlayerRandom player2;

    /**
     * Constructs the OnitamaControllerHumanVSHuman. Sets the G1 to palyer1 and
     * G2 to player2, also intializes a new onitama game.
     */
    public OnitamaControllerRandomVSRandom() {
        this.player1 = new PlayerRandom(OnitamaBoard.G1);
        this.player2 = new PlayerRandom(OnitamaBoard.G2);
        this.onitama = new Onitama(player1, player2);
        player2.setOnitama(onitama);
        player2.setBoard();
        player1.setOnitama(onitama);
        player1.setBoard();

    }

    /**
     * This method get whoseTurn of the current round, and it also gets this player's turn.
     * Using reportTurn to print the specific String for player and the getTurn method also get the
     * input Style name and rowO and rowD and colD and colO from player.
     * If there is the winner, the method will run the reportFinal which will show the
     * string about the winning.
     */
    public void play() {
        while (onitama.getWinner() == OnitamaBoard.EMPTY) {
            this.report();

            Turn turn;
            Player whosTurn = onitama.getWhoseTurn();
            turn = whosTurn.getTurn();

            this.reportTurn(whosTurn.getPlayer(), turn);
            onitama.move(turn.getRowO(), turn.getColO(), turn.getRowD(),
                    turn.getColD(), turn.getStyle());
        }
        this.reportFinal();
    }


    /**
     * this method will print the message when one player makes the move, and
     * this message is about this player itself and the description from turn
     */
    private void reportTurn(char whosTurn, Turn turn) {
        System.out.println(whosTurn + " makes move " + turn + "\n");
    }


    /**
     * The report method, it will print the current board and the style sample for G1, G2 and EMPTY
     */
    private void report() {

        String s = onitama.getBoardString() + onitama.getStylesString(OnitamaBoard.G1) +
                onitama.getStylesString(OnitamaBoard.G2) +
                onitama.getStylesString(OnitamaBoard.EMPTY)
                + "  " + onitama.getWhoseTurn().getPlayer() + " moves next";
        System.out.println(s);
    }

    /**
     * this method will print the message after there is one winner in this game, and
     * it will let people know who wins the game
     */
    private void reportFinal() {

        String s = onitama.getBoardString() + "  "
                + onitama.getWinner() + " won\n";
        System.out.println(s);
    }

    /**
     * the main function about this class. It will create an object of OnitamaControllerHumanVSHuman
     * named oc, and it will run the play method in OnitamaControllerHumanVSHuman
     * @param args
     */
    public static void main(String[] args) {

        OnitamaControllerRandomVSRandom oc = new OnitamaControllerRandomVSRandom();
        oc.play();
    }
}
