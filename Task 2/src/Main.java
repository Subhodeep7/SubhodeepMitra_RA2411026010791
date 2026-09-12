public class Main {

    public static void main(String[] args) {

        NotificationService notificationService =
                new NotificationService();

        Bank bank = new Bank(notificationService);

        bank.processAccount();
    }
}