package com.example.tnua_hadasha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tnua_hadasha.user.UserDetail;
import com.example.tnua_hadasha.util.CustomToast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText firstName,lastName,password,email;
    Spinner tafkid;
    TextView tvTafkid;
    Button MRegbtn;
    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        MRegbtn = findViewById(R.id.RegBtn);
        tvTafkid =findViewById(R.id.textViewTafkid);
        tafkid = findViewById(R.id.Tafkid);




        mFirebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        MRegbtn.setOnClickListener(view -> {
            final String fName = firstName.getText().toString();
            final String lName = lastName.getText().toString();
            final String Email = email.getText().toString();
            final String Password =password.getText().toString();
       //     Spinner tafkid = (Spinner)findViewById(R.id.Tafkid);
          // final String TafkidText = tafkid.getSelectedItem().toString();
            final String TafkidText = tafkid.getSelectedItem().toString();

            if(Email.isEmpty())
            {
                email.setError("נא להזין כתובת מייל");
                email.requestFocus();
            }
            else if (fName.isEmpty())
            {
                firstName.setError("נא להזין שם פרטי");
                firstName.requestFocus();
            }
            else if (lName.isEmpty())
            {
                lastName.setError("נא להזין שם משפחה");
                lastName.requestFocus();
            }
            else if (Password.isEmpty())
            {
                password.setError("נא להזין סיסמה");
                password.requestFocus();
            }
            else if (TafkidText.equals("לא בחר"))
            {
                tvTafkid.setError("נא לבחור את התפקיד בתנועה");
                tvTafkid.requestFocus();
            }
            else if (!(Email.isEmpty()&&Password.isEmpty())){
                mFirebaseAuth.createUserWithEmailAndPassword(Email,Password)
                        .addOnCompleteListener(Register.this, task -> {
                            if (!task.isSuccessful())
                            {
                                CustomToast.createToast(Register.this,"הרשמה נכשלה, נסה שוב!"+ task.getException().getMessage(),true);
                            }
                            else {
                                UserDetail userDetail = new UserDetail(fName,lName,Password,Email,TafkidText);
                                String uid = task.getResult().getUser().getUid();
                                firebaseDatabase.getReference(uid).setValue(userDetail)
                                        .addOnSuccessListener(aVoid -> {
                                            Intent intent=new Intent(this,Login.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);


                                        });
                            }

                        });

            } else
            {
                CustomToast.createToast(Register.this,"שגיאה !",true);
            }
        });




        Spinner tafkid =(Spinner) findViewById(R.id.Tafkid);

        tafkid.setOnItemSelectedListener(this);

        List<String> tafkidim = new ArrayList<String>();
        tafkidim.add("לא בחר");
        tafkidim.add("מדריך ט");
        tafkidim.add("מדריך ח");
        tafkidim.add("מדריך ז");
        tafkidim.add("מדריך ו");
        tafkidim.add("מדריך ה");
        tafkidim.add("מדריך ד בנים");
        tafkidim.add("מדריך ד בנות");
        tafkidim.add("מדריך ג");
        tafkidim.add("צוות לדרמן");
        tafkidim.add("משץ ט");
        tafkidim.add("משץ ח");
        tafkidim.add("משץ ז");
        tafkidim.add("משץ ו");
        tafkidim.add("משץ ה");
        tafkidim.add("משץ ד בנות");
        tafkidim.add("משץ ד בנים");
        tafkidim.add("משץ ג");




        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tafkidim);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        tafkid.setAdapter(dataAdapter);


        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),"Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}