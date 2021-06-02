package com.example.tnua_hadasha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class activity_home_lederman extends AppCompatActivity {

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
            }
            else if (id==R.id.action_orders)
            {
                Toast.makeText(this,"בחרת בהזמנות",Toast.LENGTH_SHORT).show();
            }
            return true;
        }

}