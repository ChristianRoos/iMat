
package dokagg.project;

public class User {
    
    private String firstName = "";
    private String lastName = "";
    private String address = "";
    private int postNbr = 0;
    private String city = "";
    private int phoneNumber = 0;
    private int mobileNumber = 0;
    private String email = "";
    private String password = "";

//    public User(String firstName, String lastName, String address, int postNbr, 
//            String city, int phoneNumber, int mobileNumber, 
//            String email, String password) {
//        
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.address = address;
//        this.postNbr = postNbr;
//        this.city = city;
//        this.phoneNumber = phoneNumber;
//        this.mobileNumber = mobileNumber;
//        this.email = email;
//        this.password = password;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostNbr() {
        return postNbr;
    }

    public void setPostNbr(int postNbr) {
        this.postNbr = postNbr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
