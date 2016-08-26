package com.example.pavas.primeapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.content.Intent;

public class HintActivity extends AppCompatActivity {
    TextView hinttxt;
    int hnumber;
    private static final String TAG = "HintActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            hnumber = bundle.getInt(MainActivity.EXTRA_MESSAGE);
        }
        hinttxt=(TextView)findViewById(R.id.hinttext);
        hinttxt.setText("Try To Perform Factors Of " + hnumber );


    }
    @Override
    public void onSaveInstanceState (Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("Number", hnumber);
        Log.i(TAG, "Inside HintActivity onSaveInstance");
    }
    @Override
    public void onRestoreInstanceState (Bundle restoreInstanceState){
        super.onRestoreInstanceState(restoreInstanceState);
        hnumber = restoreInstanceState.getInt("Number");
        hinttxt.setText("Try To Perform Factors Of " + hnumber );

        Log.i(TAG, "Inside HintActivity onRestoreInstance");
    }
}
