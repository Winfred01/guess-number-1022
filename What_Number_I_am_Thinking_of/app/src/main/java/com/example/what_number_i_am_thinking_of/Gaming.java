package com.example.what_number_i_am_thinking_of;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Gaming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);
        GuessingNumber guess = new GuessingNumber();
        TextView interval = (TextView) findViewById(R.id.interval);
        if (guess.getDifficulty().equals("Easy")){
            guess.GenerateNumber("Easy");
            interval.setText("0 to 30");
        }
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