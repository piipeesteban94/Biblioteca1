package com.example.biblioteca_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Libro.Libro;

public class Github_act extends AppCompatActivity {

    private Spinner spin;
    private TextView text;

    @Override //ciclo de trabajo
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spin = (Spinner) findViewById(R.id.spinlibros);
        text = (TextView) findViewById(R.id.tv1);
        final Libro libro = new Libro();

        String[] libros = {"Farenheit", "Revival", "El Alquimista"};

        spin.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, libros));

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spin.getSelectedItem().toString().equals("El Alquimista")){
                    text.setText("El precio del libro " + spin.getSelectedItem().toString() + " es " + libro.getAlquimista());
                }
                if (spin.getSelectedItem().toString().equals("Revival")){
                    text.setText("El precio del libro " + spin.getSelectedItem().toString() + " es " + libro.getRevival() + "");
                }
                if (spin.getSelectedItem().toString().equals("Farenheit")){
                    text.setText("El precio del libro " + spin.getSelectedItem().toString() + " es " + libro.getFarenheit() + "");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

}