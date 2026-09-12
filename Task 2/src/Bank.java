public class Bank {

    private NotificationService notificationService;

    public Bank(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void processAccount() {
        notificationService.send("Account processed successfully");
    }
}