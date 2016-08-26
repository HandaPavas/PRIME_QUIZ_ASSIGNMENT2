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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import java.util.Random;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    TextView question, score;
    int number;
    private Button yes, no, next, hint, cheat;
    public static int result, total;
    Random r = new Random();
    private static final String TAG = "PrimeActivity";
    public final static String EXTRA_MESSAGE = "com.example.pavas.PRIME_APPLICATION.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        result = 0;
        total = 1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random_number();
        onclickbutton();
    }

    public void random_number() {

        number = r.nextInt(1000 - 1) + 1;
        question = (TextView) findViewById(R.id.question);
        question.setText("Is " + number + " a prime number ?");
    }

    public boolean check_prime_number(int num) {

        //double len=Math.sqrt(num);
        for (int start = 2; start < num; start++) {
            if (num % start == 0)
                return false;
        }
        return true;
    }


    public void onclickbutton() {


        yes = (Button) findViewById(R.id.yesbutton);
        no = (Button) findViewById(R.id.nobutton);
        next = (Button) findViewById(R.id.nextbutton);
        hint = (Button) findViewById(R.id.hintbutton);
        cheat = (Button) findViewById(R.id.cheatbutton);
        question = (TextView) findViewById(R.id.question);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = true;


                if (check == check_prime_number(number)) {

                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_LONG).show();
                    //result++;
                    // calculate_score();
                } else
                    Toast.makeText(getApplicationContext(), "Incorrect Answer", Toast.LENGTH_LONG).show();

            }
        });

   /*   public void yesbuttonclick(View view) {
            boolean check=true;


            if(check==check_prime_number(number))
            {

              Toast.makeText(getApplicationContext(),"Correct Answer" , Toast.LENGTH_LONG).show();
             //result++;
            // calculate_score();
            }

             else
            Toast.makeText(getApplicationContext(),"Incorrect Answer" , Toast.LENGTH_LONG).show();
    }*/
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean check = false;

                if (check == check_prime_number(number)) {

                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_LONG).show();
                    //   result++;
                    //calculate_score();

                } else
                    Toast.makeText(getApplicationContext(), "Incorrect Answer", Toast.LENGTH_LONG).show();
            }
        });
   /* public void nobuttonClick(View view) {
        boolean check=false;

        if(check==check_prime_number(number))
        {

            Toast.makeText(getApplicationContext(),"Correct Answer" , Toast.LENGTH_LONG).show();
         //   result++;
            //calculate_score();

        }

        else
            Toast.makeText(getApplicationContext(),"Incorrect Answer" , Toast.LENGTH_LONG).show();
    }*/


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                random_number();
            }
        });
  /* public void nextbuttonClick(View view) {
       // total++;
       // score=(TextView)findViewById(R.id.textView);
       // score.setText("SCORE " + result + "/"+total);
        random_number();
    }
*/
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), HintActivity.class);
                intent.putExtra(EXTRA_MESSAGE, number);
                startActivity(intent);
            }
        });
        cheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(), CheatActivity.class);
                boolean val=check_prime_number( number);
                String vals;
                if(val==true)
                {
                    vals="True";
                }
                else
                vals="False";
                intent.putExtra(EXTRA_MESSAGE,vals);
                //startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String result=data.getStringExtra(EXTRA_MESSAGE);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
        public void onSaveInstanceState (Bundle savedInstanceState){
            super.onSaveInstanceState(savedInstanceState);
            savedInstanceState.putInt("Number", number);
            Log.i(TAG, "Inside onSaveInstance");
        }
        @Override
        public void onRestoreInstanceState (Bundle restoreInstanceState){
            super.onRestoreInstanceState(restoreInstanceState);
            number = restoreInstanceState.getInt("Number");

            question.setText("Is " + number + " a prime number ?");
            Log.i(TAG, "Inside onRestoreInstance");
        }
        @Override
        public void onStart ()
        {
            super.onStart();
            Log.d(TAG, "Inside OnStart");
        }

        @Override
        public void onPause ()
        {
            super.onPause();
            Log.d(TAG, "Inside OnPause");
        }

        @Override
        public void onResume () {
            super.onResume();
            Log.d(TAG, "Inside OnREsume");

        }

        @Override
        public void onStop () {
            super.onStop();
            Log.d(TAG, "Inside OnSTop");
        }

        @Override
        public void onDestroy () {
            super.onDestroy();
            Log.d(TAG, "Inside OnDestroy");
        }


    }
