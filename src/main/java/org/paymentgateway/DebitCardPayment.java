package org.paymentgateway;

public class DebitCardPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount, PaymentDetails details) {
        // Validate OTP
        if (!"4567".equals(details.getOtp())) {
            System.out.println("Debit Card Payment Failed: Invalid OTP.");
            return false;
        }
        System.out.println("Debit Card Payment Successful.");
        return true;
    }

    @Override
    public double calculateFinalAmount(double amount) {
        // Add a 1% fee, but apply a 2% discount
        double finalAmount = amount + (amount * 0.01); // 1% fee
        return applyDiscount(finalAmount, 2); // 2% discount
    }
}