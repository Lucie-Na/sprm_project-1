package profileController;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sprm_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EditPassword extends AppCompatActivity {

    FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    EditText actualPassword,newPassword, ReTypeNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);

        actualPassword = findViewById(R.id.actualPassword);
        newPassword = findViewById(R.id.newPassword);
        ReTypeNewPassword = findViewById(R.id.reTypeNewPassword);
        findViewById(R.id.edit_profile_back).setOnClickListener(view ->
        {
            finish();
        });
    }

    public void SaveNewPassword(View v){

       /* if((!actualPassword.getText().toString().trim().isEmpty())&&(!newPassword.getText().toString().trim().isEmpty())&&(!ReTypeNewPassword.getText().toString().trim().isEmpty())){
            if(newPassword.getText().toString().trim().equals(ReTypeNewPassword.getText().toString().trim())){
                AuthCredential credential = EmailAuthProvider.getCredential(fUser.getEmail(),actualPassword.getText().toString().trim());
                fAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        fUser.updatePassword(newPassword.getText().toString().trim()).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                finish();
                                startActivity(new Intent(getApplicationContext(), Profile.class));
                                Toast.makeText(EditPassword.this, "Password Changed", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(EditPassword.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EditPassword.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                Toast.makeText(this, "New Password doesn't match", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();
        }*/
    }
}