package profileController;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sprm_project.R;

public class EditInformation extends AppCompatActivity {

    ImageView profilePicture;

    TextView name, email;

    //FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();

    String oldN;
    String oldM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_information);

        profilePicture = findViewById(R.id.profileImageEdit);
        name = findViewById(R.id.nameEdit);
        email = findViewById(R.id.otherEdit);

        oldN = name.getText().toString().trim();
        oldM = email.getText().toString().trim();

        name.setText("test"/*fUser.getDisplayName()*/);
        email.setText("test");
        //profilePicture.setImageURI(fUser.getPhotoUrl());

        findViewById(R.id.edit_infromation_back).setOnClickListener(view ->
        {
            finish();
        });
    }

    public void SaveEdit(View v){

        String newName = name.getText().toString().trim();
        String newMail = email.getText().toString().trim();

        if(newName.isEmpty()){name.setText(oldN);}
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