package gameboard;

import location.Hotel;
import location.JailLocation;
import location.LotteryLocation;

public class Board {


    public static final int NUM_SQUARES = 10;


    private final Square[] squares = new Square[NUM_SQUARES];


    public Board() {
        squares[0] = new Square(new JailLocation());
        squares[1] = new Square(new Hotel(1));
        squares[2] = new Square(new LotteryLocation());
        squares[3] = new Square(new Hotel(2));
        squares[4] = null; //EMPTY SQUARE
        squares[5] = new Square(new LotteryLocation());
        squares[6] = new Square(new Hotel(3));
        squares[7] = new Square(new LotteryLocation());
        squares[8] = new Square(new Hotel(4));
        squares[9] = new Square(new JailLocation());


    }


    public Square getSquare(int index) {
        return squares[index];
    }


}
