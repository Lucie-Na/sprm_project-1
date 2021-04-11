package models;

import java.sql.Date;

public class Documentation {

    private String noDoc;
    private String country;
    private String information;
    private Date date;
    private String link;

    public Documentation(String noDoc, String country, String information, Date date, String link) {
        this.setNoDoc(noDoc);
        this.setCountry(country);
        this.setInformation(information);
        this.setDate(date);
        this.setLink(link);
    }

    public String getNoDoc() {
        return noDoc;
    }

    public void setNoDoc(String noDoc) {
        this.noDoc = noDoc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country.trim();
        if(country.equals("")){throw new IllegalArgumentException("Country is empty");}
        else {this.country = country;}
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        information = information.trim();
        if(information.equals("")){throw new IllegalArgumentException("Information is empty");}
        else {this.information = information;}
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
