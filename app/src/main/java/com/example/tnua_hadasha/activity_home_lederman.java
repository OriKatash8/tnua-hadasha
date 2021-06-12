package com.example.tnua_hadasha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class activity_home_lederman extends AppCompatActivity {
TextView title;
TextView subTitle;
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_lederman,menu);
        return true;

    }

    public  boolean onOptionsItemSelected(MenuItem item)
        {
            super.onOptionsItemSelected(item);
            int id = item.getItemId();
            if (id==R.id.action_table)
            {
                Toast.makeText(this,"בחרת בטבלת מלאי",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity_home_lederman.this,LedermanActivity.class);
                startActivity(intent);
            }
            else if (id==R.id.action_orders)
            {
                Toast.makeText(this,"בחרת בהזמנות",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity_home_lederman.this,OrderList.class);
                startActivity(intent);
            }
            return true;
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lederman);

        title = findViewById(R.id.TitlePageLederman);
        subTitle = findViewById(R.id.infoLederman);
    }

}