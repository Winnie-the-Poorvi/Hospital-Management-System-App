package com.example.firebase_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AcceptData extends AppCompatActivity {

    EditText etName, etAge, etWeight, etHeight;
    Button btnSubmit;
    Spinner spGender;
    DatabaseReference DBPatients, DBdoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_data);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        btnSubmit = findViewById(R.id.btnAddPatient);
        spGender = findViewById(R.id.spGender);
        //spType = findViewById(R.id.spType);
        etWeight = findViewById(R.id.etWeight);
        //btnViewPatients = findViewById(R.id.btnViewPatients);
        etHeight = findViewById(R.id.etHeight);
        DBPatients = FirebaseDatabase.getInstance().getReference("patients");
        //DBdoctor = FirebaseDatabase.getInstance().getReference("");// ADD DR USER NAME
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPatient();
            }
        });
    }

    private void addPatient() {

        String name = etName.getText().toString().trim();
        float age = Float.parseFloat(etAge.getText().toString());
        String gender = spGender.getSelectedItem().toString();
        //String height = spType.getSelectedItem().toString();
        float height = Float.parseFloat( etHeight.getText().toString());
        float weight = Float.parseFloat( etWeight.getText().toString());


       /* var user = firebase.auth().currentUser;
        var name, email, photoUrl, uid, emailVerified;

        if (user != null) {
            name = user.displayName;
            email = user.email;
            photoUrl = user.photoURL;
            emailVerified = user.emailVerified;
            uid = user.uid;  // The user's ID, unique to the Firebase project. Do NOT use
            // this value to authenticate with your backend server, if
            // you have one. Use User.getToken() instead.
        }

*/
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(etAge.getText().toString()) || TextUtils.isEmpty(gender) || TextUtils.isEmpty(etHeight.getText().toString())||TextUtils.isEmpty(etWeight.getText().toString())) {
            Toast.makeText(AcceptData.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String id = DBPatients.push().getKey();
            Patient p = new Patient(name, id,gender,age, height,weight, "Dr Saroyan"); //PASS DR NAME
            if(DBPatients.child(id).setValue(p).isSuccessful())
            Toast.makeText(AcceptData.this,"Patient Added Successfully",Toast.LENGTH_SHORT);
            else
            Toast.makeText(AcceptData.this,"Patient Addition Failed",Toast.LENGTH_SHORT);
        }
    }
}