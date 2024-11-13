abstract class Plant {
    private String name;
    private double waterRequirement; 
    private boolean needsWater;

    public Plant(String name, double waterRequirement) {
        this.name = name;
        this.waterRequirement = waterRequirement;
        this.needsWater = false;
    }

    public String getName() {
        return name;
    }

    public double getWaterRequirement() {
        return waterRequirement;
    }

    public boolean needsWater() {
        return needsWater;
    }

    public void setNeedsWater(boolean needsWater) {
        this.needsWater = needsWater;
    }

    public abstract void displayInfo();

    public void waterPlant() {
        System.out.println(name + " has been watered.");
        this.needsWater = false;
    }
}
