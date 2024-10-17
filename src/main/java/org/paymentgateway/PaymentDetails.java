package org.paymentgateway;



public class PaymentDetails {
    String cardNumber;
    String cvv;
    String otp;
    String upiId;
    String upiPin;
    String bankCredentials;


    public PaymentDetails() {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.otp = otp;
        this.upiId = upiId;
        this.upiPin = upiPin;
        this.bankCredentials = bankCredentials;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getUpiPin() {
        return upiPin;
    }

    public void setUpiPin(String upiPin) {
        this.upiPin = upiPin;
    }

    public String getBankCredentials() {
        return bankCredentials;
    }

    public void setBankCredentials(String bankCredentials) {
        this.bankCredentials = bankCredentials;
    }
}
