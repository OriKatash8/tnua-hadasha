package com.example.tnua_hadasha;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderList extends AppCompatActivity {
    AlertDialog.Builder alert;
    public ArrayList<String> listItem;
    ArrayAdapter adapter;
 ListView listOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        listItem= new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listItem);
        listOrders = (ListView)findViewById(R.id.listOrders);
        listOrders.setAdapter(adapter);
        registerForContextMenu(listOrders);
        listItem.add(new String(""));



       // textView2 = findViewById(R.id.tziudText);

        //String tziud = getIntent().getStringExtra("keyname");

        //textView2.setText(tziud);
    }
}