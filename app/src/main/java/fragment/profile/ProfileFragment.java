package fragment.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.sprm_project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import fragment.UserBadge;
import fragment.UserPost;
import fragment.UserTravel;
import profileController.EditProfile;
import ui.AddTravelActivity;


public class ProfileFragment extends Fragment
{
    //Initialize variable
    TabLayout tabLayout;
    ViewPager viewPager;
    profileController.Profile.TabProfileAdapter tabAdapter;
    View currentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        currentView = inflater.inflate(R.layout.fragment_profile, container, false);

        tabLayout = currentView.findViewById(R.id.tab_profile);
        viewPager = currentView.findViewById(R.id.viewPagerProfile);

        tabAdapter = new profileController.Profile.TabProfileAdapter(getFragmentManager());

        tabAdapter.AddFragment(new UserPost(),"Post");
        tabAdapter.AddFragment(new UserTravel(),"Travel");
        tabAdapter.AddFragment(new UserBadge(),"Badge");

        viewPager.setAdapter(tabAdapter);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);

        // Initialize the add travel floating action button
        FloatingActionButton fabAddTravel = currentView.findViewById(R.id.fab_add_travel);
        fabAddTravel.setOnClickListener(view ->
        {
            Intent intent = new Intent(currentView.getContext(), AddTravelActivity.class);
            // wait a result from the new activity
            startActivity(intent);
            //startActivityForResult(intent, NEW_TRAVEL_ACTIVITY_REQUEST_CODE);
        });

        // Initialize the edit profile button
        Button editButton = currentView.findViewById(R.id.btn_edit_profile);
        editButton.setOnClickListener(view ->
                {
                    Intent intent = new Intent(currentView.getContext(), EditProfile.class);
                    startActivity(intent);
                });

        return currentView;
    }

    private class TabProfileAdapter extends FragmentPagerAdapter
    {
        //Initialize ArrayList
        ArrayList<Fragment> fragmentsArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        //Constructor
        public void AddFragment(Fragment f, String s){
            fragmentsArrayList.add(f);
            stringArrayList.add(s);
        }

        public TabProfileAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentsArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentsArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return  stringArrayList.get(position);
        }
    }
}
