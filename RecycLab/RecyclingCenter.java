import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecyclingCenter {
    private static final String FILE_PATH = "materials.txt";

    // Add a material to the text file
    public void addMaterial(RecyclingMaterial material) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            // Get the next ID based on existing records
            int nextId = getNextId();
            // Write the new material to the file
            writer.write(nextId + "," + material.getMaterialType() + "," + material.getWeight() + "," + ((CustomMaterial) material).calculateEnvironmentalImpact() / material.getWeight());
            writer.newLine();
            System.out.println("Material added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Remove a material by ID from the text file
    public void removeMaterial(int id) {
        List<String> lines = readAllMaterials();
        boolean found = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : lines) {
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[0]) != id) {
                    writer.write(line);
                    writer.newLine();
                } else {
                    found = true;
                }
            }
            if (found) {
                System.out.println("Material removed successfully.");
            } else {
                System.out.println("No material found with that ID.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Edit a material in the text file
    public void editMaterial(int id, String newMaterialType, double newWeight, double newImpactFactor) {
        List<String> lines = readAllMaterials();
        boolean found = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : lines) {
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[0]) == id) {
                    writer.write(id + "," + newMaterialType + "," + newWeight + "," + newImpactFactor);
                    writer.newLine();
                    found = true;
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }
            if (found) {
                System.out.println("Material updated successfully.");
            } else {
                System.out.println("No material found with that ID.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // List all materials from the text file
    public void listMaterials() {
        List<String> lines = readAllMaterials();
        if (lines.isEmpty()) {
            System.out.println("No materials in the system.");
            return;
        }
        for (String line : lines) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String materialType = parts[1];
            double weight = Double.parseDouble(parts[2]);
            double impactFactor = Double.parseDouble(parts[3]);
            System.out.println(id + ". " + materialType + " (" + weight + " kg), Impact Factor: " + impactFactor);
        }
    }

    // Helper method to read all materials from the file
    private List<String> readAllMaterials() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    // Helper method to get the next ID for a new material
    private int getNextId() {
        List<String> lines = readAllMaterials();
        if (lines.isEmpty()) {
            return 1;  // Start from ID 1 if no materials exist
        }
        String lastLine = lines.get(lines.size() - 1);
        String[] parts = lastLine.split(",");
        return Integer.parseInt(parts[0]) + 1;  // Increment the last ID by 1
    }
}
