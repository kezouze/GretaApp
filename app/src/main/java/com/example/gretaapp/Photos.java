package com.example.gretaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Photos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photos);


        Button btnRedirectToInscription = findViewById(R.id.btnRedirectToInscription);
        btnRedirectToInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Photos.this, Inscription.class);
                startActivity(intent);
            }
        });

    }


}
