package com.example.tnua_hadasha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Order_Activity extends AppCompatActivity {
    TextView orderTitle;
    EditText tziudText;
    Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_);

        tziudText = findViewById(R.id.tziudText);
        orderTitle = findViewById(R.id.orderTitle);
        orderBtn = findViewById(R.id.OrderBtn);

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tziudmuzman = tziudText.getText().toString();
                Intent intent = new Intent(Order_Activity.this,OrderList.class);
                intent.putExtra("tziud",tziudmuzman);
            }
        });
    }
}