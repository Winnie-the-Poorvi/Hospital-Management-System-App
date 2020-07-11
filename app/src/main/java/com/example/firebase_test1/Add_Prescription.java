package com.example.firebase_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Prescription extends AppCompatActivity {

    EditText etMedName, etPerDay, etDays;
    Button btnAddPrescription;
    DatabaseReference DBPres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__prescription);
        final String pid = getIntent().getStringExtra("pid");
        etMedName = findViewById(R.id.etMedName);
        etPerDay = findViewById(R.id.etPerDay);
        etDays = findViewById(R.id.etDays);
        btnAddPrescription = findViewById(R.id.btnAddPrescription);
        DBPres = FirebaseDatabase.getInstance().getReference("prescriptions");

        btnAddPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String medname = etMedName.getText().toString().trim();
                int days = Integer.parseInt(etDays.getText().toString().trim());
                int perday = Integer.parseInt(etPerDay.getText().toString().trim());

                String id = DBPres.push().getKey();
                Prescription p = new Prescription(medname,perday,days,pid,id,"false","N/A","N/A");
                DBPres.child(id).setValue(p);
                Toast.makeText(Add_Prescription.this,"Prescription added successfully",Toast.LENGTH_SHORT).show();


            }
        });

    }
}
