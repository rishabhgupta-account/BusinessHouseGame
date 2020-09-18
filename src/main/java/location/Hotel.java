package location;

import player.Player;

public class Hotel implements ILocation {

    private final String name = "Hotel";

    private int id;

    private Player owner;


    private HotelType hotelType;


    public Hotel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBought() {
        return this.getOwner() != null;
    }


    public Player getOwner() {
        return owner;
    }


    public void setOwner(Player owner) {
        this.owner = owner;
    }


    public HotelType getHotelType() {
        return hotelType;
    }


    public void setHotelType(HotelType hotelType) {
        this.hotelType = hotelType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getAssociatedMoney() {
        return this.getHotelType().getDelta();
    }
}
