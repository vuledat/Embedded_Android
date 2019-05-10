package com.datvl.nhung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    Switch aSwitch1, aSwitch2, aSwitch3;

    private DatabaseReference mDatabase;
    DatabaseReference myRef1, myRef2, myRef3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);

        aSwitch1 = findViewById(R.id.switch1);
        aSwitch2 = findViewById(R.id.switch2);
        aSwitch3 = findViewById(R.id.switch3);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        myRef1 = FirebaseDatabase.getInstance().getReference("tb1");
        myRef2 = FirebaseDatabase.getInstance().getReference("tb2");
        myRef3 = FirebaseDatabase.getInstance().getReference("tb3");

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);

                if (value.equals("0")){
                    aSwitch1.setChecked(true);
                }
                else {
                    aSwitch1.setChecked(false);
                }
                Log.d("datvl", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("datvl", "Failed to read value.", error.toException());
            }
        });

        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if (value.equals("0")){
                    aSwitch2.setChecked(true);
                }
                else {
                    aSwitch2.setChecked(false);
                }
                Log.d("datvl", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("datvl", "Failed to read value.", error.toException());
            }
        });

        myRef3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if (value.equals("0")){
                    aSwitch3.setChecked(true);
                }
                else {
                    aSwitch3.setChecked(false);
                }
                Log.d("datvl", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("datvl", "Failed to read value.", error.toException());
            }
        });

        aSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myRef1.setValue("0");
                }
                else {
                    myRef1.setValue("1");
                }
            }
        });

        aSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myRef2.setValue("0");
                }
                else {
                    myRef2.setValue("1");
                }
            }
        });

        aSwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myRef3.setValue("0");
                }
                else {
                    myRef3.setValue("1");
                }
            }
        });
    }
}
