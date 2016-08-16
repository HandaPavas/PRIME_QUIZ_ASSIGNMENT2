package com.example.pavas.primeapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    TextView question,score;
    int number;
    static int result,total;
    Random r = new Random();
    private static final String TAG = "PrimeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        result=0;
        total=1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // calculate_score();
        random_number();
       // onclickbutton();
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


    }
   /* public void calculate_score(){

        score=(TextView)findViewById(R.id.textView);
        score.setText("SCORE " + result + "/"+total);
*/
    public void random_number() {

        number = r.nextInt(1000 - 1) + 1;
        question = (TextView) findViewById(R.id.textView2);
        question.setText("Is " + number + " a prime number ?");
    }
    public boolean check_prime_number(int num){

        //double len=Math.sqrt(num);
        for(int start=2;start<num;start++)
        {
            if(num%start==0)
                return false;
        }
        return true;
    }


    public void yesbuttonclick(View view) {
        boolean check=true;


        if(check==check_prime_number(number))
        {

            Toast.makeText(getApplicationContext(),"Correct Answer" , Toast.LENGTH_LONG).show();
            //result++;
           // calculate_score();
        }

        else
            Toast.makeText(getApplicationContext(),"Incorrect Answer" , Toast.LENGTH_LONG).show();
    }

    public void nobuttonClick(View view) {
        boolean check=false;

        if(check==check_prime_number(number))
        {

            Toast.makeText(getApplicationContext(),"Correct Answer" , Toast.LENGTH_LONG).show();
         //   result++;
            //calculate_score();

        }

        else
            Toast.makeText(getApplicationContext(),"Incorrect Answer" , Toast.LENGTH_LONG).show();
    }


    public void nextbuttonClick(View view) {
       // total++;
       // score=(TextView)findViewById(R.id.textView);
       // score.setText("SCORE " + result + "/"+total);
        random_number();
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("Number",number);
        Log.i(TAG, "Inside onSaveInstance");
    }
    @Override
    public void onRestoreInstanceState(Bundle restoreInstanceState){
        super.onRestoreInstanceState(restoreInstanceState);
        number= restoreInstanceState.getInt("Number");

        question.setText("Is " + number + " a prime number ?");
        Log.i(TAG, "Inside onRestoreInstance");
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }



}
