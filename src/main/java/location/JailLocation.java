package location;

public class JailLocation implements ILocation {

    private  final String name="JailLocation";

    @Override
    public  String getName() {
        return name;
    }


    @Override
    public long getAssociatedMoney() {
        return 150;
    }
}
