public class Shrub extends Plant {
    public Shrub(String name, double waterRequirement) {
        super(name, waterRequirement);
    }

    @Override
    public void displayInfo() {
        System.out.println("Shrub Name: " + getName());
        System.out.println("Water Requirement: " + getWaterRequirement() + " liters");
    }
}
