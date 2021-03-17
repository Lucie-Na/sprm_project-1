package pojo;

import java.time.LocalDate;
import java.util.Arrays;

public class User {

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String[] country;
    private String zip;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;

    public User(String firstName, String lastName, String gender, LocalDate dateOfBirth,
                String[] country, String zip, String city, String address, String phoneNumber,
                String email, String password) throws Exception {
        
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setCountry(country);
        this.setZip(zip);
        this.setCity(city);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
        this.setEmail(email);
        this.setPassword(password);
    }

    /* Setters */
    public void setFirstName(String firstName) throws Exception {
        if(firstName.isEmpty()) {
            throw new Exception("Warning! First name is empty!");
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) throws Exception {
        if(lastName.isEmpty()) {
            throw new Exception("Warning! Last name is empty!");
        } else {
            this.lastName = lastName;
        }
    }

    public void setGender(String gender) throws Exception {
        if(gender.isEmpty()){
            throw new Exception("Warning! Gender is empty!");
        } else {
            this.gender = gender;
        }
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCountry(String[] country) throws Exception {
        if(Arrays.equals(country, new String[0])){
            throw new Exception("Warning! Country is empty!");
        } else {
            this.country = country;
        }
    }

    public void setZip(String zip) throws Exception {
        if(zip.isEmpty()){
            throw new Exception("Warning! Zip is empty!");
        } else {
            this.zip = zip;
        }
    }

    public void setCity(String city) throws Exception {
        if(city.isEmpty()){
            throw new Exception("Warning! City is empty!");
        } else {
            this.city = city;
        }
    }

    public void setAddress(String address) throws Exception {
        if(address.isEmpty()){
            throw new Exception("Warning! Address is empty!");
        } else {
            this.address = address;
        }
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        if(phoneNumber.isEmpty()){
            throw new Exception("Warning! Phone number is empty!");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    public void setEmail(String email) throws Exception {
        if(email.isEmpty()){
            throw new Exception("Warning! Email address is empty!");
        } else {
            this.email = email;
        }
    }

    public void setPassword(String password) throws Exception {
        if(password.isEmpty()){
            throw new Exception("Warning! Password is empty!");
        } else {
            this.password = password;
        }
    }

    /* Getters */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String[] getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
