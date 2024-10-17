package org.paymentgateway;

import java.util.Scanner;

public class PaymentGatewaySystem {
    public static void main(String[] args) {
        UserAuthentication auth = new UserAuthentication();
        Scanner sc = new Scanner(System.in);

        // Simulate user login
        System.out.print("Enter Loan Number: ");
        String loanNumber = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (auth.login(loanNumber, password)) {
            System.out.println("User logged in successfully.");

            // Choose payment method
            System.out.print("Choose Payment Method (Credit Card, Debit Card, UPI, Net Banking, Digital Wallet): ");
            String paymentMethod = sc.nextLine();

            // Collect payment details
            PaymentDetails details = new PaymentDetails();
            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine(); // Consume newline

            PaymentStrategy paymentStrategy;

            // Payment strategy selection
            switch (paymentMethod) {
                case "Credit Card":
                    System.out.print("Enter Card Number: ");
                    details.setCardNumber(sc.nextLine());
                    System.out.print("Enter CVV: ");
                    details.setCvv(sc.nextLine());
                    paymentStrategy = new CreditCardPayment();
                    break;
                case "Debit Card":
                    System.out.print("Enter Card Number: ");
                    details.setCardNumber(sc.nextLine());
                    System.out.print("Enter OTP: ");
                    details.setOtp(sc.nextLine());
                    paymentStrategy = new DebitCardPayment();
                    break;
                case "UPI":
                    System.out.print("Enter UPI ID: ");
                    details.setUpiId(sc.nextLine());
                    System.out.print("Enter UPI PIN: ");
                    details.setUpiPin(sc.nextLine());
                    paymentStrategy = new UpiPayment();
                    break;
                case "Net Banking":
                    System.out.print("Enter Bank Credentials: ");
                    details.setBankCredentials(sc.nextLine());
                    paymentStrategy = new NetBankingPayment();
                    break;
                case "Digital Wallet":
                    System.out.print("Enter Wallet ID: ");
                    details.setCardNumber(sc.nextLine());
                    System.out.print("Enter Wallet Password: ");
                    details.setCvv(sc.nextLine()); // Using CVV as password in this context
                    paymentStrategy = new DigitalWalletPayment();
                    break;
                default:
                    System.out.println("Invalid Payment Method.");
                    return;
            }

            // Process payment
            PaymentProcessor processor = new PaymentProcessor(paymentStrategy, loanNumber);
            processor.process(amount, details, paymentMethod);

        } else {
            System.out.println("Login Failed.");
        }

        sc.close();
    }
}