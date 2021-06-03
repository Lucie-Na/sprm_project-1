package profileController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sprm_project.R;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    public void editInformation(View v){
        startActivity(new Intent(getApplicationContext(), EditProfile.class));
    }

    public void editEmail(View v){
        startActivity(new Intent(getApplicationContext(), EditProfile.class));
    }

    public void resetPassword(View v){
        startActivity(new Intent(getApplicationContext(), EditProfile.class));
    }

    public void logoutFromProfile(View v){
        startActivity(new Intent(getApplicationContext(), EditProfile.class));
    }

    public void closeActivity(View v){
        finish();
    }
}