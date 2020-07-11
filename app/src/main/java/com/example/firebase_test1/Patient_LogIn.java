package com.example.firebase_test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Patient_LogIn extends AppCompatActivity {

    EditText etPID, etPName;
    Button btnPLogIn;
    DatabaseReference DBPLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__log_in);
        etPID = findViewById(R.id.etPID);
        etPName = findViewById(R.id.etPName);
        btnPLogIn = findViewById(R.id.btnPLogIn);
        DBPLogin = FirebaseDatabase.getInstance().getReference("patients");
        btnPLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String pname, pid;
                pname = etPName.getText().toString().trim();
                pid = etPID.getText().toString().trim();
                DBPLogin.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //patients.clear();
                        for (DataSnapshot PatientSS : dataSnapshot.getChildren()) {
                            if (pname.equals(PatientSS.getValue(Patient.class).getName()) && pid.equals((String) PatientSS.getValue(Patient.class).getId())) {
                                Intent i = new Intent(Patient_LogIn.this, Patient_Dashboard.class);
                                i.putExtra("name",pname);
                                i.putExtra("pid",pid);
                                startActivity(i);
                                finish();
                                Toast.makeText(Patient_LogIn.this,"LogIn Successful",Toast.LENGTH_SHORT).show();
                            }
                        }

                        //Toast.makeText(Patient_LogIn.this, "No such Patient exists! Please retry", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(Patient_LogIn.this, "ERROR!", Toast.LENGTH_SHORT).show();
                    }
                });


            }
    });
}
}