package com.example.fetcherss;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void onordersubmit(View view)
    {
        Intent intent = new Intent(Order.this,Thanks.class);
        startActivity(intent);
    }
    public void onlocationclick(View view)
    {
        Intent intent = new Intent(Order.this,locationMaps.class);
        startActivity(intent);
    }

}
