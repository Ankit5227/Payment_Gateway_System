package org.paymentgateway;

public class DigitalWalletPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount, PaymentDetails details) {
        // Validate wallet ID and password
        if (!"wallet123".equals(details.getCardNumber()) || !"pass123".equals(details.getCvv())) {
            System.out.println("Digital Wallet Payment Failed: Invalid wallet ID or password.");
            return false;
        }
        System.out.println("Digital Wallet Payment Successful.");
        return true;
    }

    @Override
    public double calculateFinalAmount(double amount) {
        return amount + 5; // Flat ₹5 fee
    }
}