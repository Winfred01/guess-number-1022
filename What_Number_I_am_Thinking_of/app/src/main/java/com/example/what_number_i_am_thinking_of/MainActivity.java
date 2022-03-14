package com.example.what_number_i_am_thinking_of;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toGamingPage(View v){
        //switch to Gaming Page
        Intent intent = new Intent(MainActivity.this, Gaming.class);
        startActivity(intent);
    }
    public void toHistoryPage(View v){
        //switch to Match History
        Intent intent = new Intent(MainActivity.this, History.class);
        startActivity(intent);
    }
}
