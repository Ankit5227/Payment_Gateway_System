package org.paymentgateway;


public interface PaymentStrategy {
    boolean processPayment(double amount, PaymentDetails details);
    double calculateFinalAmount(double amount);
    default double applyDiscount(double amount, double discountPercentage) {
        return amount - (amount * discountPercentage / 100);
    }
}