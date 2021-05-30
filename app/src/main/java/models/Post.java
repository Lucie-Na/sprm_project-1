package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Post {
    private User user;
    private String country;
    private String city;
    private String institution;
    private String content;
    private String date;
    private ArrayList<Post> comment;
    private ArrayList<User> like;
    private ArrayList<User> repost;

    public Post(User user, String country, String city, String institution, String content, String date) {
        this.user = user;
        this.setCountry(country);
        this.setCity(city);
        this.setInstitution(institution);
        this.setDate(date);
        this.setContent(content);
    }

    public void addToLike(User user){
        like.add(user);
    }
    public void removeFromLike(User user){
        like.remove(user);
    }

    public void addToRepost(User user){
        repost.add(user);
    }

    public void removeFromRepost(User user){
        repost.remove(user);
    }

    public void addToComment(Post post){
        comment.add(post);
    }


    public int nbComment(){
        return comment.size();
    }

    public int nbRepost(){
        return repost.size();
    }

    public int nbFav(){
        return like.size();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        date = date.trim();
        if(date.equals("")){throw new IllegalArgumentException("Date is empty");}
        else {this.date = date;}
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
