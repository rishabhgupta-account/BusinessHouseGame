package player;

import gameboard.Board;
import gameboard.Square;

public class Player {


    private long currentPrice;

    private int currentSquareIndex;

    public Player() {
        this.currentPrice = 1000;
        this.currentSquareIndex = -1;
    }


    public Square move(int dice, Board board) {

        return board.getSquare(dice);

    }

    public void setCurrentPrice(long currentPrice) {
        this.currentPrice = currentPrice;
    }


    public long getCurrentPrice() {
        return currentPrice;
    }

    public int getCurrentSquareIndex() {
        return currentSquareIndex;
    }

    public void setCurrentSquareIndex(int currentSquareIndex) {
        this.currentSquareIndex = currentSquareIndex;
    }
}
