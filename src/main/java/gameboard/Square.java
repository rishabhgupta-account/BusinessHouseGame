package gameboard;

import location.ILocation;

public class Square {

    private ILocation name;

    public Square(ILocation name) {
        this.name = name;
    }

    public ILocation getLocation() {
        return name;
    }


}
