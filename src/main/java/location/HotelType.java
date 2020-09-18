package location;

public enum HotelType {

    SILVER(200,50, 200) {
        @Override
        public HotelType next() {
            return GOLD;
        }
    }, GOLD(300, 150,100) {
        @Override
        public HotelType next() {
            return PLATINUM;
        }
    }, PLATINUM(500, 300,200) {
        @Override
        public HotelType next() {
            return PLATINUM;
        }
    };

    private long price;

    private long rent;

    private long delta;

    public long getDelta() {
        return delta;
    }

    public abstract HotelType next();

    HotelType(long price, long rent,long delta) {
        this.price = price;
        this.rent=rent;
        this.delta=delta;
    }


    public long getPrice() {
        return price;
    }

    public long getRent() {
        return rent;
    }
}
