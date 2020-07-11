package com.example.firebase_test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class Register_Activity extends AppCompatActivity {


     EditText etEmail, etPassword;
     Button btnRegister;
     FirebaseAuth auth;
    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);



        auth = FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 email = etEmail.getText().toString();
                 password = etPassword.getText().toString();

                if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password)) {
                    Toast.makeText(Register_Activity.this,"Please enter the credentials", LENGTH_SHORT).show();
                }
                else if(password.length()<6) {
                    Toast.makeText(Register_Activity.this,"Password must have minimum 7 characters", LENGTH_SHORT).show();
                }
                
                else
                {registerUser(email,password);
                //setContentView(R.layout.username);


            }
        }});

    }

    private void registerUser(String email, String password) {

    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(Register_Activity.this, "New user registered!", LENGTH_SHORT).show();
                        startActivity(new Intent(Register_Activity.this, Dashboard.class));
                        finish();
                    }
                else
                        Toast.makeText(Register_Activity.this,"Registration failed", LENGTH_SHORT).show();
            }}
    );
    }
    }
