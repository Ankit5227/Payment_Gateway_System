package org.paymentgateway;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount, PaymentDetails details) {
        // Validate CVV
        if (!"123".equals(details.getCvv())) {
            System.out.println("Credit Card Payment Failed: Invalid CVV.");
            return false;
        }
        System.out.println("Credit Card Payment Successful.");
        return true;
    }

    @Override
    public double calculateFinalAmount(double amount) {
        return amount + (amount * 0.02); // 2% fee
    }
}