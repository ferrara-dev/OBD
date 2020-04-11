package util;

/**
 * Utility class representing general contact information to a business or person
 */

public class ContactInformation {
    private String email;
    private String phoneNumber;
    private String mailAdress;

    public ContactInformation(String email, String phoneNumber, String mailAdress){
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.mailAdress = mailAdress;
    }

    public String getEmail() {
        return email;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
