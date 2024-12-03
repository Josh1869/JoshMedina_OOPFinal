import java.util.Scanner;

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
                    center.listMaterials();
                    break;
                case 5:
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
        System.out.println("4. List all materials");
        System.out.println("5. Exit");
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
    }

    // Remove a material
    private static void removeMaterial() {
        center.listMaterials();
        System.out.print("Enter the ID of the material to remove: ");
        int id = scanner.nextInt();

        center.removeMaterial(id);
    }

    // Edit a material
    private static void editMaterial() {
        center.listMaterials();
        System.out.print("Enter the ID of the material to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the new material type: ");
        String newMaterialType = scanner.nextLine();

        System.out.print("Enter the new weight: ");
        double newWeight = scanner.nextDouble();

        System.out.print("Enter the new environmental impact factor: ");
        double newImpactFactor = scanner.nextDouble();

        center.editMaterial(id, newMaterialType, newWeight, newImpactFactor);
    }
}
