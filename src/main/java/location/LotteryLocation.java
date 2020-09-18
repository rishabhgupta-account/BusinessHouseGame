package location;

public class LotteryLocation implements ILocation {

    private  final String name="LotteryLocation";

    @Override
    public  String getName() {
        return name;
    }

    @Override
    public long getAssociatedMoney() {
        return 200;
    }
}
