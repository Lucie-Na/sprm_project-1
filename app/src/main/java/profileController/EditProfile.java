package profileController;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

import com.example.sprm_project.R;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    public void editInformation(View v){
        startActivity(new Intent(getApplicationContext(), EditInformation.class));
    }

    public void editEmail(View v){
        startActivity(new Intent(getApplicationContext(), EditEmail.class));
    }

    public void resetPassword(View v){
        startActivity(new Intent(getApplicationContext(), EditPassword.class));
    }

    public void logoutFromProfile(View v){
        logout(this);
    }
    private void logout(Activity a) {
        AlertDialog.Builder builder = new AlertDialog.Builder(a);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseAuth.getInstance().signOut();
                //startActivity(new Intent(getApplicationContext(), Login.class));
                Toast.makeText(a, "Sign Out Successful", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void closeActivity(View v){
        finish();
    }
}