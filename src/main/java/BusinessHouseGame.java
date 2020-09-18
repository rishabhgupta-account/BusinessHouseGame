import bank.Bank;
import gameboard.Board;
import gameboard.Square;
import location.Hotel;
import location.HotelType;
import location.ILocation;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BusinessHouseGame {

    private Board board;

    private List<Player> players;

    private Bank bank;

    private int[] hotelLocations;

    private Square square;


    private static Predicate<Hotel> hasEnoughMoney = (hotel) -> hotel.getOwner().getCurrentPrice() - hotel.getHotelType().next().getDelta() > 0;


    public BusinessHouseGame() {
        players = new ArrayList<>();
        this.board = new Board();
        hotelLocations = new int[]{1, 3, 6, 8};
        bank = new Bank();
    }


    String play(int inputDice[], int noOfPlayers) {


        initializePlayers(noOfPlayers);


        gamePlay(inputDice);


        return determineAndPrintResult();


    }

    private String determineAndPrintResult() {
        int count = 1;
        StringBuilder result = new StringBuilder();

        for (Player player : players) {

            int assetValue = 0;

            for (int location : hotelLocations) {

                Hotel hotel = (Hotel) board.getSquare(location).getLocation();

                if (hotel.getOwner() == player) {
                    assetValue += returnOnBasisOfHotelTypes(hotel, "PRICE");
                }
            }
            result.append("Player-").append(count).append(" has total money ").append(player.getCurrentPrice()).append(" and asset of amount: ").append(assetValue).append("\n");
            ;

            count++;
        }
        result.append("Balance at bank : ").append(bank.getCurrentPrice()).append("\n");

        return result.toString();
    }

    private void gamePlay(int[] inputDice) {
        int i = 0;
        while (i < inputDice.length) {
            for (Player player : players) {
                player.setCurrentSquareIndex(determineCurrentSquareIndex(player.getCurrentSquareIndex(), inputDice[i]));
                square = player.move(player.getCurrentSquareIndex(), board);
                //Checking if the square is Empty
                if (square != null) {
                    actionsBasedOnSquare(square, player, bank);
                }
                i++;
            }
        }
    }


    private int determineCurrentSquareIndex(int currentIndex, int diceMove) {

        int resultIndex = currentIndex + diceMove;


        if (resultIndex < 10) {
            return resultIndex;
        } else {
            while (resultIndex >= 10) {
                resultIndex = resultIndex - 10;
            }
        }


        return resultIndex;

    }


    private void initializePlayers(int noOfPlayers) {
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player());
        }
    }

    private void actionsBasedOnSquare(Square square, Player player, Bank bank) {

        ILocation currentLocation = square.getLocation();

        String locationName = currentLocation.getName();

        switch (locationName) {

            case "JailLocation":
                player.setCurrentPrice(player.getCurrentPrice() - currentLocation.getAssociatedMoney());
                bank.setCurrentPrice(bank.getCurrentPrice() + currentLocation.getAssociatedMoney());
                break;

            case "LotteryLocation":
                player.setCurrentPrice(player.getCurrentPrice() + currentLocation.getAssociatedMoney());
                bank.setCurrentPrice(bank.getCurrentPrice() - currentLocation.getAssociatedMoney());
                break;

            case "Hotel":
                hotelImplentation(player, bank, (Hotel) currentLocation);
                break;

            default:
                break;


        }

    }

    private void hotelImplentation(Player player, Bank bank, Hotel hotel) {

        //If Hotel is Bought
        if (hotel.isBought()) {


            //If HotelOwner is not the currentPlayer
            if (hotel.getOwner() != player) {
                hotel.getOwner().setCurrentPrice(hotel.getOwner().getCurrentPrice() +
                        returnOnBasisOfHotelTypes(hotel, "RENT")
                );
                player.setCurrentPrice(player.getCurrentPrice() - returnOnBasisOfHotelTypes(hotel, "RENT"));
            }

            //If HotelOwner is the currentPlayer and has enough money to upgrade property
            else if (hasEnoughMoney.test(hotel)) {
                hotel.setHotelType(hotel.getHotelType().next());
                hotel.getOwner().setCurrentPrice(hotel.getOwner().getCurrentPrice() - returnOnBasisOfHotelTypes(hotel, "DELTA"));
                bank.setCurrentPrice(bank.getCurrentPrice() + returnOnBasisOfHotelTypes(hotel, "DELTA"));
            }

        }

        //Else hotel is not bought, player need to bought the hotel

        else {

            hotel.setOwner(player);
            hotel.setHotelType(HotelType.SILVER);
            player.setCurrentPrice(player.getCurrentPrice() - returnOnBasisOfHotelTypes(hotel, "DELTA"));
            bank.setCurrentPrice(bank.getCurrentPrice() + returnOnBasisOfHotelTypes(hotel, "DELTA"));
        }
    }

    private long returnOnBasisOfHotelTypes(Hotel hotel, String type) {
        return type.equalsIgnoreCase("RENT") ? hotel.getHotelType().getRent() : type.equalsIgnoreCase("PRICE") ? hotel.getHotelType().getPrice() : hotel.getAssociatedMoney();
    }
}
