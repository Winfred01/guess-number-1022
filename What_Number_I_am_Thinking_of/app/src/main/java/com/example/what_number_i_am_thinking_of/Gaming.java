package com.example.what_number_i_am_thinking_of;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Gaming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);

    }

    public void submitNumber(View v){
        EditText getNumber = (EditText) findViewById(R.id.getNumber);
    }
    public void toMainPage(View v){
        //switch to main page
        Intent intent = new Intent(Gaming.this, MainActivity.class);
        startActivity(intent);
    }
}