package com.example.what_number_i_am_thinking_of;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;

public class History extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        TextView history = (TextView) findViewById(R.id.MatchHistoryView);
        Intent getName = getIntent();

        String name = getName.getStringExtra("getName");
        String diff = getName.getStringExtra("getDiff");
        String answer = getName.getStringExtra("getAnswer");
        //display the history
        if(getName.getStringArrayListExtra("getNumbers") != null){
            ArrayList<String> List = getName.getStringArrayListExtra("getNumbers");
            history.append("Name: " + name + "\n");
            history.append("Difficulty: " + diff + "\n");
            history.append("The correct number is: " + answer + "\n");
            for(int i = 0; i < List.size(); i++){
                if(i == 0){
                    history.append("Your 1st number is: " + List.get(i) + "\n");
                }
                else if (i == 1){
                    history.append("Your 2nd number is: " + List.get(i) + "\n");
                }
                else if (i == 2){
                    history.append("Your 3rd number is: " + List.get(i) + "\n");
                }
                else {
                    history.append("Your " + (i + 1) + "th number is: " + List.get(i) + "\n");
                }
            }
        }
        else{
            history.setText("No history available yet, play a game to see history");
        }

    }

    public void toMainPage(View v){
        //switch to main page
        Intent intent = new Intent(History.this, MainActivity.class);
        startActivity(intent);
    }
}