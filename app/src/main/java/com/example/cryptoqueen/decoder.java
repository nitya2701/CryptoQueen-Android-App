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

public class decoder extends AppCompatActivity {

    EditText etdec;
    TextView dectv;
    ClipboardManager cplboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoder);

        etdec = findViewById(R.id.etdec);
        dectv = findViewById(R.id.dectv);
        cplboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
    }

    //first function to pass the value into encode
    //second function to copy the text from clipboard
    public void dec(View view)
    {
        String temp = etdec.getText().toString();   //making string and storing to temp
        String rv = decode.dec(temp); //passing it to encode algo
        dectv.setText(rv);    //setting text which we got from result in rv
    }

    public void cp1(View view)
    {
        String data = dectv.getText().toString().trim();
        if(!data.isEmpty())
        {
            ClipData temp = ClipData.newPlainText("text",data);
            cplboard.setPrimaryClip(temp);
            Toast.makeText(this, "Copied", Toast.LENGTH_LONG).show();
        }
    }
}