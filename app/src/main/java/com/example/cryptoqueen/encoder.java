package com.example.cryptoqueen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class encoder extends AppCompatActivity {

    EditText etenc;
    TextView enctv;
    ClipboardManager cpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encoder);

        etenc = findViewById(R.id.etenc);
        enctv = findViewById(R.id.enctv);
        cpb = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
    }

    //first function to pass the value into encode
    //second function to copy the text from clipboard
    public void enc(View view)
    {
        String temp = etenc.getText().toString();   //making string and storing to temp
        String rv = encode.enc(temp); //passing it to encode algo
        enctv.setText(rv);    //setting text which we got from result in rv
    }

    public void cp2(View view)
    {
        String data = enctv.getText().toString().trim();
        if(!data.isEmpty())
        {
            ClipData temp = ClipData.newPlainText("text",data);
            cpb.setPrimaryClip(temp);
            Toast.makeText(this, "Copied", Toast.LENGTH_LONG).show();
        }
    }
}