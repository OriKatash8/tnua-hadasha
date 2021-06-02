package com.example.tnua_hadasha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 Button Regbut;
 Button Logbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Regbut = findViewById(R.id.RegBut);
        Regbut.setOnClickListener(this);

        Logbut = findViewById(R.id.LogBut);
        Logbut.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == Regbut)
        {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        }
        else if(v == Logbut)
        {
            Intent intent = new Intent(this,Login.class);
            startActivity(intent);
        }
    }


}