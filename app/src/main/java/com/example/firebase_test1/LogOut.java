package com.example.firebase_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LogOut extends AppCompatActivity {

    Button btnLogOut;
    //FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);
        btnLogOut = findViewById(R.id.btnLogOut);
      //  auth = FirebaseAuth.getInstance();

    btnLogOut.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(LogOut.this, "Log Out Successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LogOut.this, MainActivity.class));
        }
    });

    }
}
