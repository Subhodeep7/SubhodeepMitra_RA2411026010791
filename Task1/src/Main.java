public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.deposit(1000);
        account.withdraw(200);
        account.deposit(500);

        AccountRepository repository = new AccountRepository();
        repository.save(account);

        NotificationService notificationService =
                new NotificationService();

        notificationService.send("Account updated successfully");

        StatementGenerator statementGenerator =
                new StatementGenerator();

        String statement = statementGenerator.generate(account);

        System.out.println(statement);
    }
}