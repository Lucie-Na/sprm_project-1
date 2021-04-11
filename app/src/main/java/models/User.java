package models;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private String noUser;
    private String lastName;
    private String firstName;
    private String gender;
    private Date birthday;
    private String country;
    private int zip;
    private String city;
    private String address;
    private String email;
    private String phoneNumber;
    private String password;

    public User(String noUser, String lastName, String firstName, String gender, Date birthday, String country, int zip, String city, String address, String email, String phoneNumber, String password) {
        this.setNoUser(noUser);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setGender(gender);
        this.setBirthday(birthday);
        this.setCountry(country);
        this.setZip(zip);
        this.setCity(city);
        this.setAddress(address);
        this.setEmail(email);
        this.setPhoneNumber(phoneNumber);
        this.setPassword(password);
    }

    public String getNoUser() {
        return noUser;
    }

    public void setNoUser(String noUser) {
        this.noUser = noUser;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName.trim();
        if(lastName.equals("")){throw new IllegalArgumentException("Last Name is empty");}
        else {this.lastName = lastName;}
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName.trim();
        if(firstName.equals("")){throw new IllegalArgumentException("First Name is empty");}
        else {this.firstName = firstName; }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country.trim();
        if(country.equals("")){throw new IllegalArgumentException("Country is empty");}
        else {this.country = country;}
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        city = city.trim();
        if(city.equals("")){throw new IllegalArgumentException("City is empty");}
        else {this.city = city;}
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address.trim();
        if(address.equals("")){throw new IllegalArgumentException("Address is empty");}
        else {this.address = address;}
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.trim();
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(email.equals("")){throw new IllegalArgumentException("Email is empty");}
        else if(matcher.matches()){this.email = email;}
        else { throw new IllegalArgumentException("Email is invalid"); }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.trim();
        String regex = "^\\\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if(phoneNumber.equals("")){throw new IllegalArgumentException("Phone Number is empty");}
        else if(matcher.matches()){this.phoneNumber = phoneNumber;}
        else { throw new IllegalArgumentException("Phone Number is invalid"); }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password.trim();
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if(password.equals("")){throw new IllegalArgumentException("Password Number is empty");}
        else if(matcher.matches()){this.password = phoneNumber;}
        else { throw new IllegalArgumentException("Password is invalid, must contain : At least 8 chars\n" +
                "\n" +
                "Contains at least one digit\n" +
                "\n" +
                "Contains at least one lower alpha char and one upper alpha char\n" +
                "\n" +
                "Contains at least one char within a set of special chars (@,#,%,$,^, etc.)\n" +
                "\n" +
                "Does not contain space, tab, etc."); }
    }
}
