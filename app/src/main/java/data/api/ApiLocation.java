package data.api;

import java.util.List;

import models.Institution;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiLocation
{
    String BASE_URL = "http:/universities.hipolabs.com";

    @GET("search")
    Call<List<Institution>> getCountries();

    @GET("search?country=")
    Call<List<Institution>> getInstitution(@Query("name") String countryName) ;
}
