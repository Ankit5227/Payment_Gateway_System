package org.paymentgateway;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AuditLog {

    public void logTransaction(String loanNumber, String paymentMethod, double amount, String status) {
        String logEntry = "[" + LocalDateTime.now() + "] Loan: " + loanNumber + ", Payment Method: "
                + paymentMethod + ", Amount: ₹" + amount + ", Status: " + status;

        // File Log
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("audit_log.txt", true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Optionally print to console as well
        System.out.println(logEntry);
    }
}