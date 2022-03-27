package com.example.what_number_i_am_thinking_of;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Gaming extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);
        Intent getDiff = getIntent();
        String diff = getDiff.getStringExtra("message_key");
        GuessingNumber guess = new GuessingNumber();
        TextView interval = (TextView)findViewById(R.id.interval);
        interval.setText(diff);
        /*if (diff.equals("Easy")){
            guess.GenerateNumber("Easy");
            interval.setText("0 to 30");
        }
        else if (diff.equals("Normal")){
            guess.GenerateNumber("Normal");
            interval.setText("0 to 60");
        }
        else if (diff.equals("Hard")){
            guess.GenerateNumber("Hard");
            interval.setText("0 to 100");
        }*/
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