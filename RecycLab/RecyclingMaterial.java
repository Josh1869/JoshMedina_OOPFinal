// Abstract Class for Recycling Material
public abstract class RecyclingMaterial {
    private String materialType;
    private double weight;

    public RecyclingMaterial(String materialType, double weight) {
        this.materialType = materialType;
        this.weight = weight;
    }

    // Getter and Setter methods (Encapsulation)
    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Abstract method to calculate environmental impact
    public abstract double calculateEnvironmentalImpact();

    // Method to display material information
    public void displayMaterialInfo() {
        System.out.println("Material Type: " + materialType);
        System.out.println("Weight: " + weight + " kg");
    }
}
