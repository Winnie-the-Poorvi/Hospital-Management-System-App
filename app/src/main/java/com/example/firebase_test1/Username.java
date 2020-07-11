package com.example.firebase_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
//CHECK THIS ISSUES!

public class Username extends AppCompatActivity {

    EditText etUsername;
    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.username);

        etUsername = findViewById(R.id.etUsername);
        btnSubmit = findViewById(R.id.btnAddPatient);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String mName = etUsername.getText().toString();
                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                        .setDisplayName(mName).build();

                if(user.updateProfile(profileUpdates).isSuccessful())
                {
                    startActivity(new Intent(Username.this, AcceptData.class));
                }

            }
        });

    }
}
