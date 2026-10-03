package com.gdb.domain;

// TODO: Step 4.1 - Make SalaryAccount extend EnhancedBankAccount.
public class SalaryAccount extends Account{
    // TODO: Step 4.2 - Declare private fields employerName (String) and inactiveMonths (int, default 0).
    private String employerName;
    private int inactiveMonths=0;

    public SalaryAccount(String accountNumber, String name, int age, double balance, String status, String pin) {
        // TODO: Step 4.3 - Call super(...) as the FIRST statement, passing "SALARY" as the account type.
        super(accountNumber,name,age,balance,"SALARY",status,pin);
    }

    public SalaryAccount(String accountNumber, String name, int age, double balance, String status, String pin, String employerName) {
        // TODO: Step 4.3 - Call super(...) with "SALARY", then store employerName and set inactiveMonths to 0.
        super(accountNumber,name,age,balance,"SALARY",status,pin);
        this.employerName = employerName;
        this.inactiveMonths = 0;
    }

    // TODO: Accessors for the new fields (getEmployerName is used by the test program;
    //   the inactiveMonths helpers are used in later activities).

    public String getEmployerName() {

        return employerName;
    }

    public int getInactiveMonths() {

        return inactiveMonths;
    }

    public void setInactiveMonths(int inactiveMonths) {
        this.inactiveMonths = inactiveMonths;
    }

    public void incrementInactiveMonths() {
        inactiveMonths++;
    }
}
