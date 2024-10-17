package org.paymentgateway;

public class CryptocurrencyPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount, PaymentDetails details) {
        // Simulate cryptocurrency transaction validation (wallet ID)
        if (!"btc-wallet-123".equals(details.getCardNumber())) {
            System.out.println("Cryptocurrency Payment Failed: Invalid wallet.");
            return false;
        }
        System.out.println("Cryptocurrency Payment Successful.");
        return true;
    }

    @Override
    public double calculateFinalAmount(double amount) {
        return amount; // No additional fee
    }
}
