package com.example.td4_listview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class InterfaceAccueil extends AppCompatActivity {

    private TextView user;
    private Button lister;

    @SuppressLint("SetTextI18n")
    @Override
    @Deprecated
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_accueil);

        Intent intent = getIntent();
        Etudiant e = (Etudiant) intent.getSerializableExtra("etudiant");

        user = (TextView) findViewById(R.id.user);
        user.setText("Bonjour " + e.getNom() + " " + e.getPrenom());

        lister = (Button) findViewById(R.id.ListerEtudiants);
        lister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InterfaceAccueil.this, DisplayEtudiants.class);
                startActivity(intent);
            }
        });


    }
}