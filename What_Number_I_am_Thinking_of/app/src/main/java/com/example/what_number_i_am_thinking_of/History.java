package com.example.what_number_i_am_thinking_of;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }
    public void toMainPage(View v){
        //switch to main page
        Intent intent = new Intent(History.this, MainActivity.class);
        startActivity(intent);
    }
}