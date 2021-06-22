package ui;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sprm_project.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import data.api.LocationViewModel;
import models.Institution;

public class AddTravelActivity extends AppCompatActivity
{
    TextView textStartDate;
    TextView textEndDate;

    Date startDate;
    Date endDate;

    Spinner spinnerInstitution;
    data.api.LocationViewModel locationViewModel;
    String selectedCountry;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel);

        // initialize the country spinner
        initializeCountry();

        // initialize the institution spinner
        initializeInstitution();

        // initialize date fields
        textStartDate = findViewById(R.id.text_input_add_travel_start_date);
        textEndDate = findViewById(R.id.text_input_add_travel_end_date);
        initializeDatesInput(textStartDate);
        initializeDatesInput(textEndDate);

        // initialize the spinner with the duration type
        Spinner spinnerDurationType = findViewById(R.id.spinner_add_travel_duration_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.travel_duration_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDurationType.setAdapter(adapter);

        // initialize the next page button
        findViewById(R.id.button_add_travel_next).setOnClickListener(v ->
        {
            nextPage();
        });

    }

    private void initializeCountry()
    {
        // country
        ArrayList<String> listCountry = new ArrayList<String>();
        Spinner spinnerCountry = findViewById(R.id.spinner_add_travel_country);
        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCountry);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapterCountry);
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCountry = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // view model
        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel.class);
        locationViewModel.getCountry().observe(this, new Observer<List<Institution>>()
        {
            @Override
            public void onChanged(@Nullable List<Institution> listCountryParam)
            {
                for (Institution countryAPI : listCountryParam)
                {
                    alreadyInTheSpinner(listCountry, countryAPI.getCountry());
                }
                adapterCountry.notifyDataSetChanged();
            }
        });
    }

    private void alreadyInTheSpinner(ArrayList<String> listToUpdate, String apiData)
    {
        boolean alreadyInTheSpinner = false;

        for(String country : listToUpdate)
        {
            if(apiData.compareTo(country) == 0)
            {
                alreadyInTheSpinner = true;
            }
        }

        if(!alreadyInTheSpinner)
        {
            listToUpdate.add(apiData);
        }

        Collections.sort(listToUpdate);
    }

    private void initializeInstitution()
    {
        ArrayList<String> listInstitution = new ArrayList<String>();
        spinnerInstitution = findViewById(R.id.spinner_add_travel_institution);
        ArrayAdapter<String> adapterInstitution = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listInstitution);
        adapterInstitution.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInstitution.setAdapter(adapterInstitution);

        locationViewModel.getInstitutionsByCountry(selectedCountry).observe(this, new Observer<List<Institution>>()
        {
            @Override
            public void onChanged(List<Institution> institutions)
            {
                listInstitution.clear();
                for(Institution institutionAPI : institutions)
                {
                    listInstitution.add(institutionAPI.getName());
                }
                Collections.sort(listInstitution);
                adapterInstitution.notifyDataSetChanged();
            }
        });
    }

    private void initializeDatesInput(TextView textDate)
    {
        textDate.setOnClickListener(v ->
        {
            DatePickerDialog.OnDateSetListener setDate = new DatePickerDialog.OnDateSetListener()
            {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                {
                    textDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);

                    // update date values
                    startDate = stringToDate(textStartDate);
                    endDate = stringToDate(textEndDate);

                    // update status and duration
                    initializeStatus();
                    initializeDuration();
                }
            };

            // create and show the date picker
            new DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar, setDate,
                    Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
                    .show();
        });
    }

    private void initializeStatus()
    {
        TextView textStatus = findViewById(R.id.text_input_status);
        Log.i("Debug", "initialize status begin");
        if(!textStartDate.getText().toString().isEmpty() && !textEndDate.getText().toString().isEmpty())
        {
            Date currentDate = new Date();
            int comparisonStart = currentDate.compareTo(startDate);
            int comparisonEnd = currentDate.compareTo(endDate);

            if ( comparisonStart == 0)
            {
                Log.e("Debug", "comparisonStart == 0");
                textStatus.setText(getResources().getString(R.string.travel_status_in_progress));
            }
            else if(comparisonStart < 0)
            {
                Log.e("Debug", "comparisonStart < 0");
                textStatus.setText(getResources().getString(R.string.travel_status_in_preparation));
            }
            else if(comparisonStart > 0 && comparisonEnd <= 0)
            {
                Log.e("Debug", "comparisonStart > 0 && comparisonEnd <= 0");
                textStatus.setText(getResources().getString(R.string.travel_status_in_progress));
            }
            else if (comparisonEnd > 0)
            {
                Log.e("Debug", "comparisonEnd > 0");
                textStatus.setText(getResources().getString(R.string.travel_status_over));
            }
            else
            {
                textStatus.setText("error");
            }
        }
        else
        {
            textStatus.setText("");
        }
    }

    private void initializeDuration()
    {
        if(!textStartDate.getText().toString().isEmpty() && !textEndDate.getText().toString().isEmpty())
        {
            if(startDate != null && endDate !=null)
            {
                int intStartDate = startDate.getYear() * 12 + startDate.getMonth();
                int intEndDate = endDate.getYear() * 12 + endDate.getMonth();

                switch (intEndDate - intStartDate + 1)
                {
                    default:
                        break;
                }

            }
        }
    }

    private Date stringToDate(TextView textDate)
    {
        try
        {
            String stringDate = (textDate.getText().toString());
            return dateFormat.parse(stringDate);
        }
        catch (ParseException e)
        {
            return null;
        }

    }

    private void nextPage() {

    }