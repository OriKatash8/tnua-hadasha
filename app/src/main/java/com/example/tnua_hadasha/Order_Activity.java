package com.example.tnua_hadasha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Order_Activity extends AppCompatActivity {
    TextView orderTitle;
    EditText tziudText;
    FirebaseFirestore firebaseFirestore;
    Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_);

        tziudText = findViewById(R.id.tziudText);
        orderTitle = findViewById(R.id.orderTitle);
        orderBtn = findViewById(R.id.OrderBtn);
        firebaseFirestore = FirebaseFirestore.getInstance();


        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ob = tziudText.getText().toString();
                if (ob.isEmpty())
                {
                    tziudText.setError("נא להזין ציוד להזמנה");
                    tziudText.requestFocus();
                }
                else {
                 //  DocumentReference documentReference = firebaseFirestore.collection("Orders").document();
                    Map<String, String> fsO = new HashMap<>();
                    fsO.put("hazmana", ob);
                    firebaseFirestore.collection("Orders").add(fsO).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
            }

        });
    }
}