package com.example.tnua_hadasha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import  com.example.tnua_hadasha.user.UserDetail;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tnua_hadasha.util.CustomToast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    EditText emailLog, password;
    Button btnSignIn;
    TextView tvSignIn;
    FirebaseUser mFirebaseUser;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth FirebaseUserT=FirebaseAuth.getInstance();
    FirebaseAuth.AuthStateListener mAuthStateListener;
     Object ValueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLog = findViewById(R.id.emailId);
        password = findViewById(R.id.passwordLogin);
        btnSignIn = findViewById(R.id.LoginBtn);
        tvSignIn = findViewById(R.id.LoginText);

        firebaseDatabase = FirebaseDatabase.getInstance();

btnSignIn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        moveToMenuActivity(mFirebaseUser);
        //firebaseDatabase.getReference().child(FirebaseUserT.getUid()).addValueEventListener(new )
    }
});
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = firebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    moveToMenuActivity(mFirebaseUser);
                } else {
                    CustomToast.createToast(Login.this, "בבקשה התחבר למשתמש", false);

                }
            }



                };
            }
    public void moveToMenuActivity(FirebaseUser mFirebaseUser) {
         ValueEventListener   = firebaseDatabase.getReference().child(mFirebaseUser.getUid()).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserDetail userDetail = snapshot.getValue(UserDetail.class);
             //   String name = userDetail.getFirstName() + "" + userDetail.getLastName();
               String Borer = userDetail.getTafkid().toString();
                switch (Borer) {
                    case "מדריך ט":
                    case "מדריך ח":
                    case "מדריך ז":
                    case "מדריך ו":
                    case "מדריך ה":
                    case "מדריך ד בנים":
                    case "מדריך ד בנות":
                    case "מדריך ג":
                        Intent i = new Intent(Login.this, HomeActivity.class);
                        CustomToast.createToast(getApplicationContext(), "התחברת בהצלחה!", false);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                      //  i.putExtra("מה קורה", name);
                        startActivity(i);
                        break;
                    case "משץ ט":
                    case "משץ ח":
                    case "משץ ז":
                    case "משץ ו":
                    case "משץ ה":
                    case "משץ ד בנים":
                    case "משץ ד בנות":
                    case "משץ ג":
                        Intent j = new Intent(Login.this, home_mashatzim.class);
                        CustomToast.createToast(getApplicationContext(), "התחברת בהצלחה!", false);
                        j.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                      //  j.putExtra("מה קורה", name);
                        startActivity(j);
                        break;
                    case "צוות לדרמן":
                        Intent k = new Intent(Login.this, LedermanActivity.class);//getApplicationContext()
                        CustomToast.createToast(getApplicationContext(), "התחברת בהצלחה!", false);
                        k.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       // k.putExtra("מה קורה", name);
                        startActivity(k);
                        break;
                }


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
    };















