package org.paymentgateway;

public class NetBankingPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount, PaymentDetails details) {
        // Validate bank credentials
        if (!"bank123".equals(details.getBankCredentials())) {
            System.out.println("Net Banking Payment Failed: Invalid bank credentials.");
            return false;
        }
        System.out.println("Net Banking Payment Successful.");
        return true;
    }

    @Override
    public double calculateFinalAmount(double amount) {
        return amount + 10; // Flat ₹10 fee
    }
}