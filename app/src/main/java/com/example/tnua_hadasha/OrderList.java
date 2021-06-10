package com.example.tnua_hadasha;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class OrderList extends AppCompatActivity {
    AlertDialog.Builder alert;
    public ArrayList<Order> listItem;
    ArrayAdapter<Order> adapter;
 ListView listOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        listItem= new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listItem);

        listOrders = (ListView)findViewById(R.id.listOrders);
        listOrders.setAdapter(adapter);
        registerForContextMenu(listOrders);
        listItem.add(new Order(""));
        updateListView();







            // textView2 = findViewById(R.id.tziudText);

            //String tziud = getIntent().getStringExtra("keyname");

            //textView2.setText(tziud);




    }
    public void updateListView() {
        Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        if (bundle != null) {
            Order a = new Order(intent.getStringExtra("TheOrder"));
            adapter.add(a);
            adapter.notifyDataSetChanged();
        }
    }
}