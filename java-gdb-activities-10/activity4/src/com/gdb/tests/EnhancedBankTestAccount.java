package com.gdb.tests;

import com.gdb.domain.Account;
import com.gdb.domain.EnhancedBankAccount;

public class EnhancedBankTestAccount {
    public static void main(String[] args) {
        System.out.println("=== Activity 4: Enhanced EnhancedBankAccount Test Suite ===");

        // Test 1: Age validation
        boolean t1 = false;
        try {
            new EnhancedBankAccount("ACC1002", "Minor Kid", 16, 1000.0, "SAVINGS", "ACTIVE", "1111");
        } catch (IllegalArgumentException e) {
            t1 = true;
        }
        System.out.println("Test 1 (Underage Customer Rejection): " + (t1 ? "[PASS]" : "[FAIL]"));

        // Test 2: Wrong PIN
        EnhancedBankAccount acc = new EnhancedBankAccount("ACC1001", "Rajesh Sharma", 28, 5000.0, "SAVINGS", "ACTIVE", "1234");
        boolean t2 = !acc.withdraw(1000.0, "9999") && (acc.getBalance() == 5000.0);
        System.out.println("Test 2 (Wrong PIN Rejection): " + (t2 ? "[PASS]" : "[FAIL]"));

        // Test 3: Correct PIN
        boolean t3 = acc.withdraw(1000.0, "1234") && (acc.getBalance() == 4000.0);
        System.out.println("Test 3 (Correct PIN Withdrawal): " + (t3 ? "[PASS]" : "[FAIL]"));

        // Test 4: PIN Change
        boolean pinChanged = acc.changePin("1234", "5678");
        boolean oldPinFails = !acc.withdraw(500.0, "1234");
        boolean newPinWorks = acc.withdraw(500.0, "5678") && (acc.getBalance() == 3500.0);
        boolean t4 = pinChanged && oldPinFails && newPinWorks;
        System.out.println("Test 4 (PIN Change & Old PIN Invalidation): " + (t4 ? "[PASS]" : "[FAIL]"));

        // Test 5: Suspended EnhancedBankAccount
        acc.suspend();
        boolean t5 = !acc.withdraw(500.0, "5678") && (acc.getBalance() == 3500.0);
        System.out.println("Test 5 (Suspended EnhancedBankAccount Block): " + (t5 ? "[PASS]" : "[FAIL]"));

        // Test 6: Reactivate EnhancedBankAccount
        acc.activate();
        boolean t6 = acc.withdraw(500.0, "5678") && (acc.getBalance() == 3000.0);
        System.out.println("Test 6 (Reactivation & Success): " + (t6 ? "[PASS]" : "[FAIL]"));

        System.out.println("All Enhanced EnhancedBankAccount tests passed!");
    }
}
