package com.gdb.domain;

// TODO: Step 3.1 - Make FixedDepositAccount extend EnhancedBankAccount.
public class FixedDepositAccount extends  Account{
    // TODO: Step 3.2 - Declare private fields tenureMonths (int, default 12) and interestRate (double, default 6.5).
    private int tenureMonths = 12;
    private double interestRate = 6.5;

    public FixedDepositAccount(String accountNumber, String name, int age, double balance, String status, String pin) {
        // TODO: Step 3.3 - Call super(...) as the FIRST statement, passing "FIXED_DEPOSIT" as the account type.
        super(accountNumber,name,age,balance,"FIXED_DEPOSIT",status,pin);
    }

    public FixedDepositAccount(String accountNumber, String name, int age, double balance, String status, String pin, int tenureMonths, double interestRate) {
        // TODO: Step 3.3 - Call super(...) with "FIXED_DEPOSIT", then store tenureMonths and interestRate in the fields.
        super(accountNumber,name,age,balance,"FIXED_DEPOSIT",status,pin);
        this.tenureMonths = tenureMonths;
        this.interestRate = interestRate;

    }

    public double calculateMaturityAmount() {
        // TODO: Step 3.4 - Return the maturity amount using monthly compound interest:
        //   balance * (1 + monthlyRate) ^ tenureMonths, where monthlyRate = (interestRate / 100.0) / 12
        //   Hint: Math.pow(base, exponent).
        double monthlyRate = (interestRate/100)/12;
        return balance*(Math.pow(1+monthlyRate,tenureMonths));
    }

    // TODO: Return the fields (the test program prints them).
    public int getTenureMonths() {

        return tenureMonths;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
