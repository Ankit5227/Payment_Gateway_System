package org.paymentgateway;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;
    private AuditLog auditLog = new AuditLog(); // Added audit log instance
    private String loanNumber; // Track the user loan number

    public PaymentProcessor(PaymentStrategy paymentStrategy, String loanNumber) {
        this.paymentStrategy = paymentStrategy;
        this.loanNumber = loanNumber;
    }

    public void process(double amount, PaymentDetails details, String paymentMethod) {
        double finalAmount = paymentStrategy.calculateFinalAmount(amount);
        boolean paymentSuccess = paymentStrategy.processPayment(amount, details);

        String status = paymentSuccess ? "Successful" : "Failed";

        // Log the transaction
        auditLog.logTransaction(loanNumber, paymentMethod, finalAmount, status);

        if (paymentSuccess) {
            System.out.println("Final Amount Charged: ₹" + finalAmount);
        }
    }
}