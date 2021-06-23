package profileController;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sprm_project.R;

public class EditEmail extends AppCompatActivity {

    TextView password, email;

    //FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();

    String oldM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);
        password = findViewById(R.id.passwordEditEmail);
        email = findViewById(R.id.emailEdit);

        oldM = email.getText().toString().trim();

        email.setText("test");
        //profilePicture.setImageURI(fUser.getPhotoUrl());

    }

    public void SaveEdit(View v){

        String newMail = email.getText().toString().trim();

        if(newMail.isEmpty()){email.setText(oldM);}

        /*if(!newMail.equals(oldN)) {
            fUser.updateEmail(newMail).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(EditInformation.this, "Successful", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditInformation.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        if(!newName.equals(oldM)) {
            UserProfileChangeRequest nameUpdates = new UserProfileChangeRequest.Builder().setDisplayName(newName).build();
            fUser.updateProfile(nameUpdates).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(EditInformation.this, "Successful", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditInformation.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }*/
        finish();
        startActivity(new Intent(getApplicationContext(), Profile.class));
    }
}