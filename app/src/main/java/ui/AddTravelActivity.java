package ui;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

public class AddTravelActivity extends AppCompatActivity {
    TextView textStartDate;
    TextView textEndDate;

    Date startDate;
    Date endDate;

    Spinner spinnerInstitution;
    data.api.LocationViewModel locationViewModel;
    String selectedCountry;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel);

        // initialize the back button
        ImageButton buttonBack = findViewById(R.id.button_add_travel_back);
        buttonBack.setOnClickListener(v ->
        {
            finish();
        });

        // initialize the country spinner
        initializeCountry();

        // initialize date fields
        textStartDate = findViewById(R.id.text_input_add_travel_start_date);
        textEndDate = findViewById(R.id.text_input_add_travel_end_date);
        initializeDatesInput(textStartDate);
        initializeDatesInput(textEndDate);

        // initialize the spinner with the duration type
        /*Spinner spinnerDurationType = findViewById(R.id.spinner_add_travel_duration_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.travel_duration_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDurationType.setAdapter(adapter);*/

        // initialize the validation button
        findViewById(R.id.button_add_travel_validate).setOnClickListener(v ->
        {
            Toast.makeText(this, "Did you just filled the whole form for nothing ? Well... Yes. You should blame the developers for that !", Toast.LENGTH_LONG).show();
            finish();
        });

    }

    /**
     * Initializes the country Spinner with an API
     */
    private void initializeCountry()
    {
        ArrayList<String> listCountry = new ArrayList<String>();
        Spinner spinnerCountry = findViewById(R.id.spinner_add_travel_country);

        // set an adapter to set the api's data to the spinner
        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCountry);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapterCountry);

        // change the selected item when something the user click on it
        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCountry = parent.getItemAtPosition(position).toString();
                Log.e("Add travel", "New country selected");
                initializeInstitution();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // set a view model to fill the spinner with the wanted data
        locationViewModel = ViewModelProviders.of(this).get(LocationViewModel.class);
        locationViewModel.getCountry().observe(this, new Observer<List<Institution>>() {
            @Override
            public void onChanged(@Nullable List<Institution> listCountryParam)
            {
                Log.e("Add travel", "Api data for the country changed");
                for (Institution countryAPI : listCountryParam)
                {
                    alreadyInTheSpinner(listCountry, countryAPI.getCountry());
                }
                adapterCountry.notifyDataSetChanged();
            }
        });
    }

    /**
     * Add a new country to the list if it is a new one
     *
     * @param listToUpdate list to add the country
     * @param apiData
     */
    private void alreadyInTheSpinner(ArrayList<String> listToUpdate, String apiData)
    {
        boolean alreadyInTheSpinner = false;

        // check if the country isn't already in the spinner
        for (String country : listToUpdate) {
            if (apiData.compareTo(country) == 0) {
                alreadyInTheSpinner = true;
            }
        }

        // add the country to the spinner if it is not already in
        if (!alreadyInTheSpinner) {
            listToUpdate.add(apiData);
        }

        // sort the countries in the spinner by their alphabetical name
        Collections.sort(listToUpdate);
    }

    /**
     * Initializes the institution Spinner with an API
     */
    private void initializeInstitution()
    {
        ArrayList<String> listInstitution = new ArrayList<String>();
        spinnerInstitution = findViewById(R.id.spinner_add_travel_institution);

        // set an adapter to fill the spinner
        ArrayAdapter<String> adapterInstitution = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listInstitution);
        adapterInstitution.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerInstitution.setAdapter(adapterInstitution);

        locationViewModel.getInstitutionsByCountry(selectedCountry).observe(this, new Observer<List<Institution>>() {
            @Override
            public void onChanged(List<Institution> institutions) {
                listInstitution.clear();
                Log.e("Add travel", "Institution list has been reseated");
                for (Institution institutionAPI : institutions)
                {
                    if(selectedCountry == null || selectedCountry.isEmpty())
                    {
                        listInstitution.add("Please first select a country");
                    }
                    else
                    {
                        listInstitution.add(institutionAPI.getName());
                        Log.e("Add travel", "New institution added : " + institutionAPI.getCountry() + ", " + institutionAPI.getName());
                    }
                }
                Collections.sort(listInstitution);
                adapterInstitution.notifyDataSetChanged();
            }
        });
    }

    /**
     * Initializes a date input
     * @param textDate
     */
    private void initializeDatesInput(TextView textDate) {
        textDate.setOnClickListener(v ->
        {
            // open a date picker
            DatePickerDialog.OnDateSetListener setDate = new DatePickerDialog.OnDateSetListener()
            {
                // change the date text field according to the selected date from the date picker
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
                {
                    textDate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);

                    // update date values
                    startDate = stringToDate(textStartDate);
                    endDate = stringToDate(textEndDate);

                    Log.e("Add travel", "A new travel date has been picked !");

                    // update status and duration
                    initializeStatus();
                    //initializeDuration();
                }
            };

            // create and show the date picker
            new DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar, setDate,
                    Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
                    .show();
        });
    }

    /**
     * Automatically changes the travel status according to the start and end dates
     */
    private void initializeStatus()
    {
        TextView textStatus = findViewById(R.id.text_input_status);
        Log.e("Add travel", "Initialize status : begin");
        // check if the dates have been given
        if (!textStartDate.getText().toString().isEmpty() && !textEndDate.getText().toString().isEmpty())
        {
            Date currentDate = new Date();
            // relates the given dates according to the current date
            int comparisonStart = currentDate.compareTo(startDate);
            int comparisonEnd = currentDate.compareTo(endDate);

            // set the travel status according to the given travel dates
            if (comparisonStart == 0)
            {
                textStatus.setText(getResources().getString(R.string.travel_status_in_progress));
            }
            else if (comparisonStart < 0)
            {
                textStatus.setText(getResources().getString(R.string.travel_status_in_preparation));
            }
            else if (comparisonStart > 0 && comparisonEnd <= 0)
            {
                textStatus.setText(getResources().getString(R.string.travel_status_in_progress));
            }
            else if (comparisonEnd > 0)
            {
                textStatus.setText(getResources().getString(R.string.travel_status_over));
            }
            else {
                textStatus.setText("error");
            }
        }
        else
            {
            textStatus.setText("");
        }
        Log.e("Add travel", "Status has been changed");
    }

    /*private void initializeDuration() {
        if (!textStartDate.getText().toString().isEmpty() && !textEndDate.getText().toString().isEmpty()) {
            if (startDate != null && endDate != null) {
                int intStartDate = startDate.getYear() * 12 + startDate.getMonth();
                int intEndDate = endDate.getYear() * 12 + endDate.getMonth();

                switch (intEndDate - intStartDate + 1) {
                    default:
                        break;
                }

            }
        }
    }*/

    /**
     * Converts a TextView's content to a date type
     * @param textDate the textView's content to convert
     * @return
     */
    private Date stringToDate(TextView textDate) {
        try {
            String stringDate = (textDate.getText().toString());
            return dateFormat.parse(stringDate);
        } catch (ParseException e) {
            return null;
        }

    }
}
