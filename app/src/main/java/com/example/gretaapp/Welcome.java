package com.example.gretaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Button btnRedirectToMain = findViewById(R.id.btnRedirectToMain);
        btnRedirectToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnRedirectToPhotos = findViewById(R.id.btnRedirectToPhotos);
        btnRedirectToPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome.this, Photos.class);
                startActivity(intent);
            }
        });

        Button btnRedirectToInscription = findViewById(R.id.btnRedirectToInscription);
        btnRedirectToInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome.this, Inscription.class);
                startActivity(intent);
            }
        });
    }
    public void openLink2(View view) {
        String url = "https://www.groupedelasalle-reims.com/centre-de-formation";
        openBrowser(url);
    }
    public void openLink3(View view) {
        String url = "https://www.academiereims.fr/reseau/greta-cfa-marne/";
        openBrowser(url);
    }
    private void openBrowser(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void openMentionsLegales(View view) {
        Intent intent = new Intent(Welcome.this, MentionsLegales.class);
        startActivity(intent);
    }
}
