package com.gdb.tests;

import com.gdb.domain.AccountActivity6;
import com.gdb.exceptions.*;

public class TestAccountExceptions6 {
    public static void main(String[] args) {
        System.out.println("=== Activity 6: Exception Handling Suite ===");

        // NOTE: If you completed Activity 5 successfully, paste your working EnhancedBankAccount.java into src/com/gdb/domain and your exception classes into src/com/gdb/exceptions (replacing the provided versions).

        AccountActivity6 acc = new AccountActivity6("ACC1001", "Rajesh Sharma", 28, 5000.0, "SAVINGS", "ACTIVE", "1234");

        System.out.println("=== Complete Activity 6 exception handling tests and verify output ===");
        // Test 1: Invalid PIN handling
        try {
            acc.withdraw(1000.0, "9999");
            System.out.println("[Test 1] [FAIL]");
        } catch (InvalidPinException e) {
            System.out.println("[Test 1] Caught Invalid PIN: " + e.getMessage() + " [PASS]");
        } catch (AccountException e) {
            System.out.println("[Test 1] [FAIL]");
        }

        // Test 2: Inactive EnhancedBankAccount handling
        acc.suspend();
        try {
            acc.withdraw(1000.0, "1234");
            System.out.println("[Test 2] [FAIL]");
        } catch (InactiveAccountException e) {
            System.out.println("[Test 2] Caught Inactive EnhancedBankAccount: " + e.getMessage() + " [PASS]");
        } catch (AccountException e) {
            System.out.println("[Test 2] [FAIL]");
        }

        // Test 3: Invalid Amount handling
        acc.activate();
        try {
            acc.deposit(-500.0);
            System.out.println("[Test 3] [FAIL]");
        } catch (InvalidAmountException e) {
            System.out.println("[Test 3] Caught Invalid Amount: " + e.getMessage() + " [PASS]");
        }

        // Test 4: Insufficient Funds handling
        try {
            acc.withdraw(10000.0, "1234");
            System.out.println("[Test 4] [FAIL]");
        } catch (InsufficientBalanceException e) {
            System.out.println("[Test 4] Caught Insufficient Funds: " + e.getMessage() + " [PASS]");
        } catch (AccountException e) {
            System.out.println("[Test 4] [FAIL]");
        }

        // Test 5: Polymorphic Catch with Base Class
        acc.close();
        try {
            acc.withdraw(500.0, "1234");
            System.out.println("[Test 5] [FAIL]");
        } catch (AccountException e) {
            System.out.println("[Test 5] Polymorphic Handler caught: " + e.getMessage() + " [PASS]");
        }

        System.out.println("All exception handling tests completed successfully!");


    }
}
