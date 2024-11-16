import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// Abstract Class for Recycling Material
abstract class RecyclingMaterial {
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

// Subclass for custom recycling material (with dynamic impact factor)
class CustomMaterial extends RecyclingMaterial {
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

// Class to manage all materials
class RecyclingCenter {
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

// Main Program Class with Menu System
public class RecyclingManagementSystem {

    private static Scanner scanner = new Scanner(System.in);
    private static RecyclingCenter center = new RecyclingCenter();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addMaterial();
                    break;
                case 2:
                    removeMaterial();
                    break;
                case 3:
                    editMaterial();
                    break;
                case 4:
                    center.generateImpactReport();
                    break;
                case 5:
                    center.listMaterials();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Display menu to the user
    private static void showMenu() {
        System.out.println("\nRecycling Management System");
        System.out.println("1. Add a new material");
        System.out.println("2. Remove a material");
        System.out.println("3. Edit a material");
        System.out.println("4. Generate impact report");
        System.out.println("5. List all materials");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // Add a new material
    private static void addMaterial() {
        System.out.print("Enter the material type (e.g., Plastic, Glass, Paper, etc.): ");
        String materialType = scanner.nextLine();

        System.out.print("Enter the weight of the material in kilograms: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter the environmental impact factor (e.g., 1.2 for Plastic): ");
        double impactFactor = scanner.nextDouble();

        // Create a new material object and add it to the center
        RecyclingMaterial newMaterial = new CustomMaterial(materialType, weight, impactFactor);
        center.addMaterial(newMaterial);

        System.out.println("Material added successfully!");
    }

    // Remove a material
    private static void removeMaterial() {
        center.listMaterials();
        System.out.print("Enter the index of the material to remove: ");
        int index = scanner.nextInt();

        center.removeMaterial(index);
        System.out.println("Material removed successfully.");
    }

    // Edit a material
    private static void editMaterial() {
        center.listMaterials();
        System.out.print("Enter the index of the material to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the new material type: ");
        String newMaterialType = scanner.nextLine();

        System.out.print("Enter the new weight: ");
        double newWeight = scanner.nextDouble();

        center.editMaterial(index, newMaterialType, newWeight);
        System.out.println("Material edited successfully.");
    }
}
