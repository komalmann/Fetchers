package com.example.fetcherss;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class Otp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Toast.makeText(Otp.this,"A confirmation code has been sent to your email",Toast.LENGTH_LONG).show();
        setSupportActionBar(toolbar);


    }

    public void onotpsubmit(View view)
    {
        Toast.makeText(Otp.this,"Welcome! You've successfully registered with us!",Toast.LENGTH_LONG).show();
    }

}
