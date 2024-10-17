package org.paymentgateway;

public class UserAuthentication {
    public boolean login(String loanNumber, String password) {
        // Login, return true if successful
        return "LAI-12345".equals(loanNumber) && "TEST@123".equals(password);
    }
}