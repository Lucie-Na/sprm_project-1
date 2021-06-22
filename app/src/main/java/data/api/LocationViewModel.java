package data.api;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import models.Institution;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The type Location view model.
 */
public class LocationViewModel extends ViewModel
{
    private MutableLiveData<List<Institution>> listAll;
    private MutableLiveData<List<Institution>> listInstitutionsByCountry;
    private ApiLocation api;

    /**
     * Gets country.
     *
     * @return the country
     */
    public LiveData<List<Institution>> getCountry()
    {
        if(listAll == null)
        {
            initializeInstance();
            loadAll();
        }
        return listAll;
    }

    /**
     * Gets institutions by country.
     *
     * @param country the country
     * @return the institutions by country
     */
    public LiveData<List<Institution>> getInstitutionsByCountry(String country)
    {
        if(listInstitutionsByCountry == null)
        {
            initializeInstance();
        }
        loadInstitutionsByCountry(country == null ? "" : country);

        return listInstitutionsByCountry;
    }

    /**
     * Initializes a new api connection
     */
    private void initializeInstance()
    {
        listAll = new MutableLiveData<List<Institution>>();
        listInstitutionsByCountry = new MutableLiveData<List<Institution>>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiLocation.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiLocation.class);
    }

    /**
     *
     *
     * @param country the country
     */
    private void loadInstitutionsByCountry(String country)
    {
        Call<List<Institution>> call = api.getInstitution(country);

        call.enqueue(new Callback<List<Institution>>()
        {
            @Override
            public void onResponse(Call<List<Institution>> call, Response<List<Institution>> response)
            {
                listInstitutionsByCountry.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Institution>> call, Throwable t)
            {
                Log.e("Debug API View Model", t.getMessage());
            }
        });
    }

    /**
     *
     */
    private void loadAll()
    {
        Call<List<Institution>> call = api.getCountries();

        call.enqueue(new Callback<List<Institution>>()
        {
            @Override
            public void onResponse(Call<List<Institution>> call, Response<List<Institution>> response)
            {
                listAll.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Institution>> call, Throwable t)
            {

                Log.e("Debug API View Model", t.getMessage());
            }
        });
    }
}
