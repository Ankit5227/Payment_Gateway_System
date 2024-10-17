package org.paymentgateway;

public class UpiPayment implements PaymentStrategy {
    @Override
    public boolean processPayment(double amount, PaymentDetails details) {

        // Validate UPI ID and PIN
        if (!"upi123".equals(details.getUpiId()) || !"pin123".equals(details.getUpiPin())) {
            System.out.println("UPI Payment Failed: Invalid UPI ID or PIN.");
            return false;
        }
        System.out.println("UPI Payment Successful.");
        return true;
    }

    @Override
    public double calculateFinalAmount(double amount) {
        return amount * 0.95; // 5% discount
    }
}