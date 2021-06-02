package com.example.tnua_hadasha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Peula extends AppCompatActivity {
private EditText mEditTextto;
private EditText mEditTextName;
private EditText mEditTextcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peula);

        mEditTextto = findViewById(R.id.edit_text_to);
        mEditTextName= findViewById(R.id.peula_name);
        mEditTextcontext= findViewById(R.id.context_peula);

        Button buttonSend = findViewById(R.id.sendBtn);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }
    private void sendMail()
    {
        String recipientList = mEditTextto.getText().toString();
        String[]recipients = recipientList.split(",");
        //exemple@gmail.com,example2@gmail.com
        String subject = mEditTextName.getText().toString();
        String message=mEditTextcontext.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"תבחרו בGmail ותלחצו על שלח"));

    }
}