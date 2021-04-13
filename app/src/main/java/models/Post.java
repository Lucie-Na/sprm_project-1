package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Post {
    private String noUser;
    private String country;
    private String city;
    private String institution;
    private String content;
    private HashMap<Post,User> comment;
    private ArrayList<User> like;

    public Post(String noUser, String country, String city, String institution, String content) {
        this.setNoUser(noUser);
        this.setCountry(country);
        this.setCity(city);
        this.setInstitution(institution);
        this.setContent(content);
    }

    public String getNoUser() {
        return noUser;
    }

    public void setNoUser(String noUser) {
        this.noUser = noUser;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        content = content.trim();
        if(content.equals("")){throw new IllegalArgumentException("Content is empty");}
        else {this.content = content;}
    }

}
