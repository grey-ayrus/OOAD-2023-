package containers;

public class HeavyContainer extends Container {
    protected int weight;

    public HeavyContainer(int id, int weight) {
        super(id);
        this.weight = weight;
        this.setTotalWeight(this.getTotalWeight() + weight);
        System.out.println("Heavy");
    }
}
