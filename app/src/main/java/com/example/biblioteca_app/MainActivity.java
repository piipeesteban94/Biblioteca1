package com.example.biblioteca_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private Button btn;
    private ImageButton ib;


    // aqui mi ciclo de trabajo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.progressBar);
        btn = (Button) findViewById(R.id.button);
        ib = (ImageButton) findViewById(R.id.imageButton);

        ib.setVisibility(View.INVISIBLE);
        pb.setVisibility(View.INVISIBLE);


        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });

    }

    public void goToGit(View view){
        Intent intent = new Intent(this, Github_act.class);
        startActivity(intent);
    }



    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute(){
            pb.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(String... strings) {

            for (int i = 1; i<10; i++){
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s){
            pb.setVisibility(View.INVISIBLE);
            ib.setVisibility(View.VISIBLE);
        }

    }
}