package fragment.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.sprm_project.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import fragment.UserBadge;
import fragment.UserPost;
import fragment.UserTravel;
import profileController.EditProfile;


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
        //View currentView = inflater.inflate(R.layout.fragment_profile, container, false);
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

        return currentView;
    }

    public void editProfile(View v)
    {
        startActivity(new Intent(currentView.getContext(), EditProfile.class));
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
