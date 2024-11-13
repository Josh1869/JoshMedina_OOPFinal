public class GardenManagementSystem {
    public static void main(String[] args) {
        // Create plants
        Plant rose = new Flower("Rose", 1.5); 
        Plant oakTree = new Tree("Oak Tree", 5.0); 
        Plant boxwood = new Shrub("Boxwood", 2.0); 

        // Create watering schedules for plants
        WateringSchedule roseSchedule = new WateringSchedule(rose);
        WateringSchedule oakTreeSchedule = new WateringSchedule(oakTree);
        WateringSchedule boxwoodSchedule = new WateringSchedule(boxwood);

        // Create notification system
        NotificationService notificationService = new EmailNotificationService();

        // Simulate passing days and updating watering schedules
        for (int day = 1; day <= 5; day++) {
            System.out.println("\nDay " + day + ":");

            // Update watering schedule for each plant
            roseSchedule.updateWateringSchedule();
            oakTreeSchedule.updateWateringSchedule();
            boxwoodSchedule.updateWateringSchedule();

            // Send notifications and water plants if needed
            sendDailyNotifications(notificationService, rose, roseSchedule);
            sendDailyNotifications(notificationService, oakTree, oakTreeSchedule);
            sendDailyNotifications(notificationService, boxwood, boxwoodSchedule);
        }
    }

    // Method to handle daily notifications and watering logic
    private static void sendDailyNotifications(NotificationService notificationService, Plant plant, WateringSchedule schedule) {
        if (schedule.isTimeToWater()) {
            notificationService.sendNotification("It's time to water the " + plant.getName());
            plant.waterPlant(); // Water the plant
            schedule.resetWateringSchedule(); // Reset the watering schedule after watering
        } else {
            notificationService.sendNotification("Checking the watering schedule for the " + plant.getName() + ": No need to water today.");
        }

        // Display plant info daily
        plant.displayInfo();
    }
}
