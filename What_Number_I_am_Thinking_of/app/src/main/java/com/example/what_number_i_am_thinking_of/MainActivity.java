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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {
    private TextView displayHistory;
    private String difficulty;
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
                /*if (!displayHistory.getText().toString().equals("")){
                    EditText getName = findViewById(R.id.Name);
                    String name = getName.getText().toString();
                    try {
                        writeMatchHistory("Name: " + name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }*/
                AlertDialog.Builder selectDifficulty = new AlertDialog.Builder(MainActivity.this);
                selectDifficulty.setTitle("Please select difficulty: ");
                final String[] difficulty = new String[]{"Easy", "Normal", "Hard"};
                selectDifficulty.setSingleChoiceItems(difficulty, checkedItem[0], new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        checkedItem[0] = i;
                        //GuessingNumber g = new GuessingNumber();
                        GuessingNumber guess = new GuessingNumber();
                        /*guess.setDifficulty(difficulty[i]);
                        guess.GenerateNumber(guess.getDifficulty());*/
                        Intent setDiff = new Intent(getApplicationContext(), Gaming.class);
                        setDiff.putExtra("message_key", difficulty[i]);
                        startActivity(setDiff);
                        /*try {
                            writeMatchHistory("Difficulty: " + difficulty[i]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Intent intent = new Intent(MainActivity.this, Gaming.class);
                        startActivity(intent);*/
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
        Intent intent = new Intent(MainActivity.this, History.class);
        startActivity(intent);
        //displayHistory = findViewById(R.id.MatchHistoryView);
        /*try {
            if(readFromFile() != null)
            {
                displayHistory.setText(readFromFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public void writeMatchHistory(String message) throws IOException {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("History.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(message);
            outputStreamWriter.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    /*public String readFromFile() throws IOException {
        String result = "";
        InputStream is = openFileInput("History.txt");
        if(is != null)
        {
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String temp = "";
            StringBuilder stringBuilder = new StringBuilder();

            while((temp = br.readLine()) != null)
            {
                stringBuilder.append(temp);
                stringBuilder.append("\n");
            }

            is.close();
            result = stringBuilder.toString();
        }
        return result;
    }*/
}
