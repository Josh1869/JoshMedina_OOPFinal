import java.util.ArrayList;
import java.util.List;

public class RecyclingCenter {
    private List<RecyclingMaterial> materials = new ArrayList<>();

    // Add a material to the list
    public void addMaterial(RecyclingMaterial material) {
        materials.add(material);
    }

    // Remove a material by index
    public void removeMaterial(int index) {
        if (index >= 0 && index < materials.size()) {
            materials.remove(index);
        } else {
            System.out.println("Invalid index, unable to remove material.");
        }
    }

    // Edit a material's details by index
    public void editMaterial(int index, String newMaterialType, double newWeight) {
        if (index >= 0 && index < materials.size()) {
            RecyclingMaterial material = materials.get(index);
            material.setMaterialType(newMaterialType);
            material.setWeight(newWeight);
        } else {
            System.out.println("Invalid index, unable to edit material.");
        }
    }

    // Generate impact report
    public void generateImpactReport() {
        if (materials.isEmpty()) {
            System.out.println("No materials to report on.");
            return;
        }

        double totalImpact = 0;
        for (RecyclingMaterial material : materials) {
            material.displayMaterialInfo();
            double impact = material.calculateEnvironmentalImpact();
            System.out.println("Environmental Impact: " + impact + " kg CO2");
            totalImpact += impact;
        }
        System.out.println("\nTotal Environmental Impact: " + totalImpact + " kg CO2");
    }

    // List all materials
    public void listMaterials() {
        if (materials.isEmpty()) {
            System.out.println("No materials in the system.");
            return;
        }
        for (int i = 0; i < materials.size(); i++) {
            System.out.println(i + ". " + materials.get(i).getMaterialType() + " (" + materials.get(i).getWeight() + " kg)");
        }
    }
}
