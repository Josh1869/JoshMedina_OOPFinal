public class EmailNotificationService implements NotificationService {
    public void sendNotification(String message) {
        System.out.println("Email: " + message);
    }
}
