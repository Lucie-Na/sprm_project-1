package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Institution
{
    @Expose
    private String name;
    @Expose
    private String country;
    @SerializedName("state-province")
    @Expose
    private String city;

    public Institution(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
