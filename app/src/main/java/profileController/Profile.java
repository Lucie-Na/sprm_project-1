package profileController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sprm_project.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import fragment.UserBadge;
import fragment.UserPost;
import fragment.UserTravel;

public class Profile extends AppCompatActivity {

    //Initialize variable
    TabLayout tabLayout;
    ViewPager viewPager;
    TabProfileAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);
        //getSupportActionBar().hide();

        tabLayout = findViewById(R.id.tab_profile);
        viewPager = findViewById(R.id.viewPagerProfile);

        tabAdapter = new TabProfileAdapter(getSupportFragmentManager());

        tabAdapter.AddFragment(new UserPost(),"Post");
        tabAdapter.AddFragment(new UserTravel(),"Travel");
        tabAdapter.AddFragment(new UserBadge(),"Badge");

        viewPager.setAdapter(tabAdapter);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void editProfile(View v){
        startActivity(new Intent(getApplicationContext(), EditProfile.class));
    }


    public static class TabProfileAdapter extends FragmentPagerAdapter {
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