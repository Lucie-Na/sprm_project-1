package models;

public class Travel {
    private int flag;
    private String noUser;
    private String noTravel;
    private String country;
    private String city;
    private String institution;
    private String program;
    private String duration;
    private String noDoc;


    public Travel(int flag, String noUser, String noTravel, String country, String city, String institution,String program, String duration, String noDoc) {
        this.flag = flag;
        this.setNoUser(noUser);
        this.setNoTravel(noTravel);
        this.setCountry(country);
        this.setCity(city);
        this.setInstitution(institution);
        this.setProgram(program);
        this.setDuration(duration);
        this.setNoDoc(noDoc);
    }

    public String getNoUser() {
        return noUser;
    }

    public void setNoUser(String noUser) {
        this.noUser = noUser;
    }

    public String getNoTravel() {
        return noTravel;
    }

    public void setNoTravel(String noTravel) {
        this.noTravel = noTravel;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        country = country.trim();
        if(country.equals("")){throw new IllegalArgumentException("Country is empty");}
        else {this.country = country;}
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        city = city.trim();
        if(city.equals("")){throw new IllegalArgumentException("City is empty");}
        else {this.city = city;}
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        institution = institution.trim();
        if(institution.equals("")){throw new IllegalArgumentException("Institution is empty");}
        else {this.institution = institution;}
    }

    public String getProgram() {
        return program;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        duration = duration.trim();
        if(duration.equals("")){throw new IllegalArgumentException("Duration is empty");}
        else {this.duration = duration;}
    }

    public void setProgram(String program) {
        program = program.trim();
        if(program.equals("")){throw new IllegalArgumentException("Program is empty");}
        else {this.program = program;}
    }

    public String getNoDoc() {
        return noDoc;
    }

    public void setNoDoc(String noDoc) {
        this.noDoc = noDoc;
    }
}
