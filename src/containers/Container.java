package containers;

import java.util.*;

public abstract class Container {
    protected int id;
    public static int totalWeight;

    public Container(int id) {
        super();
        this.id = id;
    }

    public static int getTotalWeight() {
        return totalWeight;
    }

    public static void setTotalWeight(int totalWeight) {
        Container.totalWeight = totalWeight;
    }
}
