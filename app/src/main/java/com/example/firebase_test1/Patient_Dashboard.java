package com.example.firebase_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Patient_Dashboard extends AppCompatActivity {

    TextView tvPGreet;
    Button btnApt, btnPPrescription, btnComments, btnPtLogOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__dashboard);
        final String pname = getIntent().getStringExtra("name");
        final String pid = getIntent().getStringExtra("pid");
        tvPGreet = findViewById(R.id.tvPGreet);
        btnPPrescription = findViewById(R.id.btnPPrescription);
        btnComments = findViewById(R.id.btnComments);
        btnApt = findViewById(R.id.btnApt);
        btnPtLogOut = findViewById(R.id.btnPtLogOut);
        tvPGreet.setText("Welcome "+pname+ "!");

        btnComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Patient_Dashboard.this, AllComments.class);
                i.putExtra("ID",pid);
                startActivity(i);
            }
        });

        btnApt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Patient_Dashboard.this, AllSlots.class);
                i.putExtra("pid",pid);
                i.putExtra("pname",pname);
                startActivity(i);
            }
        });

        btnPPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Patient_Dashboard.this, My_Prescriptions.class);
                i.putExtra("pid",pid);
                i.putExtra("pname",pname);
                startActivity(i);
            }
        });

        btnPtLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Patient_Dashboard.this, "Log Out Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Patient_Dashboard.this, MainActivity.class));
                finish();
            }
        });

    }
}
