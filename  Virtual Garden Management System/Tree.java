public class Tree extends Plant {
    public Tree(String name, double waterRequirement) {
        super(name, waterRequirement);
    }

    @Override
    public void displayInfo() {
        System.out.println("Tree Name: " + getName());
        System.out.println("Water Requirement: " + getWaterRequirement() + " liters");
    }
}
