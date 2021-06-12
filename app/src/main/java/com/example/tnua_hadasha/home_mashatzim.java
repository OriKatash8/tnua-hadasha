package com.example.tnua_hadasha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class home_mashatzim extends AppCompatActivity {
TextView TitleMashazim;
TextView infoMashazim;
         @Override
     public boolean onCreateOptionsMenu(Menu menu){
     getMenuInflater().inflate(R.menu.menu_mashztzim,menu);
     return true;
}

    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int ida = item.getItemId();
        if (ida == R.id.action_check) {
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
            if (intent != null) {
                startActivity(intent);
            }


        } else if (ida == R.id.action_toOrder) {
            Intent intent = new Intent(home_mashatzim.this, Order_Activity.class);
            startActivity(intent);
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_mashatzim);

        TitleMashazim = findViewById(R.id.mashazim_title);
        infoMashazim = findViewById(R.id.infoMashazim);

    }

}




