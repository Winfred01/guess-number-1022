package com.example.what_number_i_am_thinking_of;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
        TextView interval = (TextView) findViewById(R.id.interval);
        //interval.setText(diff);
        if (diff.equals("Easy")){
            //guess.GenerateNumber("Easy");
            interval.setText("0 to 30");
        }
        else if (diff.equals("Normal")){
            //guess.GenerateNumber("Normal");
            interval.setText("0 to 60");
        }
        else if (diff.equals("Hard")){
            //guess.GenerateNumber("Hard");
            interval.setText("0 to 100");
        }
    }

    public void submitNumber(View v){
        EditText getNumber = (EditText) findViewById(R.id.getNumber);
        String gN = getNumber.getText().toString();
        int number = (int) Double.parseDouble(gN);
        GuessingNumber guess = new GuessingNumber();
        String s = guess.CompareNumber(number);

        //pop up, 先写出来后面用---------------------------------------------------------
        /*Wrong number pop op*/
        AlertDialog.Builder prompt = new AlertDialog.Builder(Gaming.this);
        prompt.setTitle("Oops, wrong number");
        prompt.setMessage("message from the result");//fill it out
        prompt.setCancelable(false);//remain show
        prompt.setPositiveButton("Try again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //do nothing
            }
        });
        AlertDialog wrongNumber = prompt.create();
        //wrongNumber.show();
        /*Right number pop up*/
        AlertDialog.Builder right = new AlertDialog.Builder(Gaming.this);
        right.setTitle("Congratulations");
        right.setMessage("You guess the right number");
        right.setCancelable(false);
        right.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Gaming.this, MainActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog rightNumber = right.create();
        //rightNumber.show();
        //-----------------------------------------------------------------------
        //下面这行用来找地方输出s，上面几行不用动
        //((TextView)findViewById(R.id.textView7)).setText(s);
    }
    public void toMainPage(View v){
        //switch to main page
        Intent intent = new Intent(Gaming.this, MainActivity.class);
        startActivity(intent);
    }
}