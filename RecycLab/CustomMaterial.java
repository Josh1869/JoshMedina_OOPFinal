// Subclass for custom recycling material (with dynamic impact factor)
public class CustomMaterial extends RecyclingMaterial {
    private double impactFactor;

    public CustomMaterial(String materialType, double weight, double impactFactor) {
        super(materialType, weight);
        this.impactFactor = impactFactor;
    }

    // Overridden method to calculate the environmental impact for custom material
    @Override
    public double calculateEnvironmentalImpact() {
        return getWeight() * impactFactor;
    }
}
