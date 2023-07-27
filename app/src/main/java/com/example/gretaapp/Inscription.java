package com.example.gretaapp;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Inscription extends AppCompatActivity {

    private EditText editTextNom;
    private EditText editTextPrenom;
    private EditText editTextVille;
    private EditText editTextTelephone;
    private EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        editTextNom = findViewById(R.id.editTextNom);
        editTextPrenom = findViewById(R.id.editTextPrenom);
        editTextVille = findViewById(R.id.editTextVille);
        editTextTelephone = findViewById(R.id.editTextTelephone);
        editTextEmail = findViewById(R.id.editTextEmail);
        Button btnInscrire = findViewById(R.id.btnInscrire);

        btnInscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = editTextNom.getText().toString();
                String prenom = editTextPrenom.getText().toString();
                String ville = editTextVille.getText().toString();
                String telephone = editTextTelephone.getText().toString();
                String email = editTextEmail.getText().toString();

                if (nom.isEmpty() || prenom.isEmpty() || ville.isEmpty() || telephone.isEmpty() || email.isEmpty()) {
                    Toast.makeText(Inscription.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!Pattern.matches("\\d{10}", telephone)) {
                    Toast.makeText(Inscription.this, "Le numéro de téléphone doit comporter 10 chiffres", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(Inscription.this, "Veuillez entrer une adresse email valide", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(Inscription.this, "Inscription réussie pour : " + prenom + " " + nom, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
