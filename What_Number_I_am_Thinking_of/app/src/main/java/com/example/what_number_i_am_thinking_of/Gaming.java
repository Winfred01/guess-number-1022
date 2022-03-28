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
    int answer;
    int count = 10;
    //测试1

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);
        Intent getDiff = getIntent();
        String diff = getDiff.getStringExtra("message_key");
        GuessingNumber guess = new GuessingNumber();
        TextView interval = (TextView) findViewById(R.id.interval);
        TextView attempt = (TextView) findViewById(R.id.attempts);
        guess.setDifficulty(diff);
        answer = guess.GenerateNumber(guess.getDifficulty());
        System.out.println(answer);
        //interval.setText(diff);
        if (diff.equals("Easy")){
            interval.setText("0 to 30");
        }
        else if (diff.equals("Normal")){
            interval.setText("0 to 60");
        }
        else if (diff.equals("Hard")){
            interval.setText("0 to 100");
        }
        attempt.setText("You have " + count + " attempt(s) left");
    }

    @SuppressLint("SetTextI18n")
    public void submitNumber(View v){
        EditText getNumber = (EditText) findViewById(R.id.getNumber);
        TextView attempt = (TextView) findViewById(R.id.attempts);
        String gN = getNumber.getText().toString();
        int number = Integer.parseInt(gN);
        GuessingNumber guess = new GuessingNumber();
        String s = guess.CompareNumber(number, answer);
        System.out.println(number);
        count--;
        /*Wrong number pop op*/
        AlertDialog.Builder prompt = new AlertDialog.Builder(Gaming.this);
        prompt.setTitle("Oops, wrong number");
        prompt.setCancelable(false);//remain show
        prompt.setPositiveButton("Try again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //do nothing
            }
        });
        /*Right number pop up*/
        AlertDialog.Builder winLose = new AlertDialog.Builder(Gaming.this);
        winLose.setCancelable(false);
        winLose.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Gaming.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //-----------------------------------------------------------------------
        if(s.equals("You are close, the difference is within 10") || s.equals("You can try a smaller number") || s.equals("You can try a bigger number")){
            if(count < 1){
                winLose.setTitle("GG, you lose");
                winLose.setMessage("Unlucky, you lost all attempts");
                AlertDialog winLosePopup = winLose.create();
                winLosePopup.show();
            }
            else{
                prompt.setMessage(s);
                AlertDialog wrongNumber = prompt.create();
                wrongNumber.show();
                attempt.setText("You have " + count + " attempt(s) left");
            }
        }
        else if(s.equals("YOU WIN")){
            winLose.setTitle("Congratulations!");
            winLose.setMessage("You guessed the right number, you win");
            AlertDialog rightNumber = winLose.create();
            rightNumber.show();
        }
        getNumber.setText(null);
    }
    public void toMainPage(View v){
        //switch to main page
        Intent intent = new Intent(Gaming.this, MainActivity.class);
        startActivity(intent);
    }
}