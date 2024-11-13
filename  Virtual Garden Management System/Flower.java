public class Flower extends Plant {
    public Flower(String name, double waterRequirement) {
        super(name, waterRequirement);
    }

    @Override
    public void displayInfo() {
        System.out.println("Flower Name: " + getName());
        System.out.println("Water Requirement: " + getWaterRequirement() + " liters");
    }
}
