package com.example.tnua_hadasha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Order_Activity extends AppCompatActivity {
    TextView orderTitle;
    EditText tziudText;
    EditText amountT;
    EditText dateT;
    FirebaseFirestore firebaseFirestore;
    FirebaseFirestore firebaseUsers;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_);

        tziudText = findViewById(R.id.tziudText);
        amountT = findViewById(R.id.amountId);
        dateT = findViewById(R.id.dateId);
        orderTitle = findViewById(R.id.orderTitle);
        orderBtn = findViewById(R.id.OrderBtn);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseUsers = FirebaseFirestore.getInstance();


        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cUid = firebaseUser.getUid();
                DocumentReference documentReference = firebaseFirestore.collection("Users").document(cUid);
                documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful())
                        {
                            DocumentSnapshot documentSnapshot = task.getResult();
                            String nameU=(String) documentSnapshot.get("fname")+"-"+(String) documentSnapshot.get("lname");



                            String amount = amountT.getText().toString();
                            if (amount.isEmpty())
                            {
                                amountT.setError("נא להזין את כמות הציוד");
                                amountT.requestFocus();
                            }
                            String date = dateT .getText().toString();
                            if (date.isEmpty())
                            {
                                dateT.setError("לא להזין את תאריך הפעולה");
                                dateT.requestFocus();
                            }

                            String ob = tziudText.getText().toString();
                            if (ob.isEmpty())
                            {
                                tziudText.setError("נא להזין ציוד להזמנה");
                                tziudText.requestFocus();
                            }
                            String Forder = amount + "," +ob + "," + date + "," + nameU;


                            //  DocumentReference documentReference = firebaseFirestore.collection("Orders").document();
                            Map<String, String> fsO = new HashMap<>();
                            fsO.put("hazmana", Forder);
                            firebaseFirestore.collection("Orders").add(fsO).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Intent j = new Intent(Order_Activity.this, home_mashatzim.class);
                                    startActivity(j);

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






        });
    }
}