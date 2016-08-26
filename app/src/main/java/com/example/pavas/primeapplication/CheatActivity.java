package com.example.pavas.primeapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    TextView answer;
    String message;
    private static final String TAG = "CheatActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        answer = (TextView) findViewById(R.id.cheattext);
        if (message == "True") {

            answer.setText("Correct");
        } else
            answer.setText("Incorrect");


    }


    public void onBackPressed() {
        String message2= "Cheated";
        Intent intent=new Intent();
        intent.putExtra(MainActivity.EXTRA_MESSAGE, message2);
        setResult(RESULT_OK, intent);
        finish();
    }
    @Override
    public void onSaveInstanceState (Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("Message", message);
        Log.i(TAG, "Inside CheatActivity onSaveInstance");
    }
    @Override
    public void onRestoreInstanceState (Bundle restoreInstanceState){
        super.onRestoreInstanceState(restoreInstanceState);
        message= restoreInstanceState.getString("Message");
        if (message == "True") {

            answer.setText("Correct");
        } else
            answer.setText("Incorrect");


        Log.i(TAG, "Inside CheatActivity onRestoreInstance");
    }
}