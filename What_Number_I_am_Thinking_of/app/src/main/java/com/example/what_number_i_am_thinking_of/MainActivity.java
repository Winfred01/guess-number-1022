package com.example.what_number_i_am_thinking_of;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toGamingPage(View v){
        //switch to Gaming Page
        final int[] checkedItem = {-1};
        AlertDialog.Builder enterName = new AlertDialog.Builder(this);
        enterName.setTitle("Please enter your name:");
        final View customLayout = getLayoutInflater().inflate(R.layout.pop_up, null);
        enterName.setView(customLayout);
        enterName.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                AlertDialog.Builder selectDifficulty = new AlertDialog.Builder(MainActivity.this);
                selectDifficulty.setTitle("Please select difficulty: ");
                final String[] difficulty = new String[]{"Easy", "Normal", "Hard"};
                selectDifficulty.setSingleChoiceItems(difficulty, checkedItem[0], new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        checkedItem[0] = i;
                        Intent intent = new Intent(MainActivity.this, Gaming.class);
                        startActivity(intent);
                    }
                });
                AlertDialog diffDialog = selectDifficulty.create();
                diffDialog.show();
            }
        });
        AlertDialog dialog = enterName.create();
        dialog.show();
    }
    public void toHistoryPage(View v){
        //switch to Match History
        Intent intent = new Intent(MainActivity.this, History.class);
        startActivity(intent);
    }
}
