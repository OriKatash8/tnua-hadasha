package com.example.tnua_hadasha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
TextView madTitle;
TextView madInfo;
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    public  boolean onOptionsItemSelected(MenuItem item)
    {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id==R.id.action_peula)
        {
            Toast.makeText(this,"בחרת בפעולה",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HomeActivity.this,Peula.class);
            startActivity(intent);
        }
            return  true;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lederman);
        madTitle =findViewById(R.id.titleMad);
        madInfo = findViewById(R.id.infoMad);
    }


}