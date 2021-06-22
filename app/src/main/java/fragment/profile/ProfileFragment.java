package fragment.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sprm_project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ui.AddTravelActivity;


public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View currentView = inflater.inflate(R.layout.fragment_profile, container, false);

        // initialize floating action button
        FloatingActionButton fabAddTravel = currentView.findViewById(R.id.fab_add_travel);
        fabAddTravel.setOnClickListener(view ->
        {
            Intent intent = new Intent(currentView.getContext(), AddTravelActivity.class);
            // wait a result from the new activity
            startActivity(intent);
            //startActivityForResult(intent, NEW_BOOK_ACTIVITY_REQUEST_CODE);
        });

        return currentView;
    }
}