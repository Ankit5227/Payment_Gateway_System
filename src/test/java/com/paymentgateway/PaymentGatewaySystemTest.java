package com.paymentgateway;


import org.junit.jupiter.api.Test;
import org.paymentgateway.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentGatewaySystemTest {

    @Test
    public void testCreditCardPaymentSuccess() {
        PaymentDetails details = new PaymentDetails();
        details.setCardNumber("1234-5678-9012-3456");
        details.setCvv("123");
        PaymentStrategy paymentStrategy = new CreditCardPayment();

        PaymentProcessor processor = new PaymentProcessor(paymentStrategy, "LAI-12345");
        assertDoesNotThrow(() -> processor.process(1000, details, "Credit Card"));
    }

    @Test
    public void testDebitCardPaymentFailure() {
        PaymentDetails details = new PaymentDetails();
        details.setCardNumber("1234-5678-9012-3456");
        details.setOtp("0000"); // Incorrect OTP
        PaymentStrategy paymentStrategy = new DebitCardPayment();

        PaymentProcessor processor = new PaymentProcessor(paymentStrategy, "LAI-12345");
        processor.process(500, details, "Debit Card");

    }

    @Test
    public void testUPIPaymentWithDiscount() {
        PaymentDetails details = new PaymentDetails();
        details.setUpiId("upi123");
        details.setUpiPin("pin123");
        PaymentStrategy paymentStrategy = new UpiPayment();

        PaymentProcessor processor = new PaymentProcessor(paymentStrategy, "LAI-12345");
        processor.process(1000, details, "UPI");


        double expectedAmount = 1000 * 0.95; // 5% discount
        assertEquals(expectedAmount, paymentStrategy.calculateFinalAmount(1000));
    }

    @Test
    public void testNetBankingFlatFee() {
        PaymentDetails details = new PaymentDetails();
        details.setBankCredentials("bank123");
        PaymentStrategy paymentStrategy = new NetBankingPayment();

        PaymentProcessor processor = new PaymentProcessor(paymentStrategy, "LAI-12345");
        processor.process(2000, details, "Net Banking");


        double expectedAmount = 2000 + 10;
        assertEquals(expectedAmount, paymentStrategy.calculateFinalAmount(2000));
    }
}