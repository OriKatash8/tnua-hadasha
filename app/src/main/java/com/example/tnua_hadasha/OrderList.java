package com.example.tnua_hadasha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_1;
import static android.widget.Toast.LENGTH_SHORT;

public class OrderList extends AppCompatActivity {
    AlertDialog.Builder alert;
    public ArrayList<String> list;
    ArrayAdapter adapter;

    FirebaseFirestore firebaseFirestore;


 ListView listOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

//        firebaseFirestore = FirebaseFirestore.getInstance();
//        listOrders = (ListView)findViewById(R.id.listOrders);
//        registerForContextMenu(listOrders);
//        firebaseFirestore.collection("Orders").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful())
//                {
//                    adapter = new ArrayAdapter(this, simple_list_item_1,list)
//                    List<String> list = new ArrayList<>();
//                    for (DocumentSnapshot documentSnapshot : task.getResult())
//                    {
//                        list.add(documentSnapshot.getId()+documentSnapshot.getData());
//
//                    }
//                }
//
//            }
//        });
        list= new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        listOrders = (ListView)findViewById(R.id.listOrders);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Orders").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful())
                {
                    for (QueryDocumentSnapshot documentSnapshot:task.getResult())
                    {
                        list.add(documentSnapshot.getData().toString());
                        listOrders.setAdapter(adapter);
                        registerForContextMenu(listOrders);
                    }
                }
            }
        });
        listOrders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
        listOrders.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(OrderList.this);
                alert.setTitle("מחק מהרשימה");
                alert.setMessage("בטוח שאתה רוצה למחוק?");
                alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alert.show();
                return true;
            }
        });
    }
    {

    }







            // textView2 = findViewById(R.id.tziudText);

            //String tziud = getIntent().getStringExtra("keyname");

            //textView2.setText(tziud);






}