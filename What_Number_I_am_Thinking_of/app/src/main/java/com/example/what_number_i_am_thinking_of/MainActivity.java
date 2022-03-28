package com.example.what_number_i_am_thinking_of;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    String getName;
    String getDiff;

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

                EditText name = customLayout.findViewById(R.id.Name);
                getName = name.getText().toString();

                AlertDialog.Builder selectDifficulty = new AlertDialog.Builder(MainActivity.this);
                selectDifficulty.setTitle("Please select difficulty: ");
                final String[] difficulty = new String[]{"Easy", "Normal", "Hard"};
                selectDifficulty.setSingleChoiceItems(difficulty, checkedItem[0], new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        checkedItem[0] = i;
                        getDiff = difficulty[i];
                        Intent setDiff = new Intent(getApplicationContext(), Gaming.class);
                        setDiff.putExtra("message_key", difficulty[i]);
                        setDiff.putExtra("name_key", getName);
                        startActivity(setDiff);
                    }
                });
                selectDifficulty.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();;
                    }
                });

                AlertDialog diffDialog = selectDifficulty.create();
                diffDialog.show();
            }
        });
        enterName.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog dialog = enterName.create();
        dialog.show();
    }

    public void toHistoryPage(View v){
        //switch to Match History
        Intent getDiff = getIntent();

        String diff = getDiff.getStringExtra("diff");
        String name = getDiff.getStringExtra("name");
        String answer = getDiff.getStringExtra("answer");


        Intent intent = new Intent(getApplicationContext(), History.class);
        intent.putExtra("getName", name);
        intent.putExtra("getDiff", diff);
        intent.putExtra("getAnswer", answer);
        if(getDiff.getStringArrayListExtra("number") != null){
            ArrayList<String> numbersList = getDiff.getStringArrayListExtra("number");
            intent.putExtra("getNumbers", numbersList);
        }
        startActivity(intent);
    }
}
