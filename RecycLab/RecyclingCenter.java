import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecyclingCenter {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/recycling_db";
    private static final String DB_USER = "root";  // Your DB username
    private static final String DB_PASSWORD = "password";  // Your DB password

    // Add a material to the database
    public void addMaterial(RecyclingMaterial material) {
        String sql = "INSERT INTO materials (materialType, weight, impactFactor) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, material.getMaterialType());
            stmt.setDouble(2, material.getWeight());
            stmt.setDouble(3, ((CustomMaterial) material).calculateEnvironmentalImpact() / material.getWeight());
            stmt.executeUpdate();
            System.out.println("Material added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove a material by ID from the database
    public void removeMaterial(int id) {
        String sql = "DELETE FROM materials WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Material removed successfully.");
            } else {
                System.out.println("No material found with that ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Edit a material in the database
    public void editMaterial(int id, String newMaterialType, double newWeight, double newImpactFactor) {
        String sql = "UPDATE materials SET materialType = ?, weight = ?, impactFactor = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newMaterialType);
            stmt.setDouble(2, newWeight);
            stmt.setDouble(3, newImpactFactor);
            stmt.setInt(4, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Material updated successfully.");
            } else {
                System.out.println("No material found with that ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // List all materials from the database
    public void listMaterials() {
        String sql = "SELECT * FROM materials";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean hasMaterials = false;
            while (rs.next()) {
                hasMaterials = true;
                int id = rs.getInt("id");
                String materialType = rs.getString("materialType");
                double weight = rs.getDouble("weight");
                double impactFactor = rs.getDouble("impactFactor");
                System.out.println(id + ". " + materialType + " (" + weight + " kg), Impact Factor: " + impactFactor);
            }

            if (!hasMaterials) {
                System.out.println("No materials in the system.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
