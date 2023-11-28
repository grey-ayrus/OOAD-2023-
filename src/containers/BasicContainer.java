package containers;

public class BasicContainer extends Container {
    protected int weight;

    public BasicContainer(int id, int weight) {
        super(id);
        this.weight = weight;
        this.setTotalWeight(this.getTotalWeight() + weight);
        System.out.println("Basic");
    }
}
