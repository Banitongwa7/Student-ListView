package com.example.td4_listview;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText login;
    private EditText password;
    private Button connexion;
    private Button inscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connexion = (Button) findViewById(R.id.connexion);
        inscription = (Button) findViewById(R.id.inscription);

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EtudiantDAO dao = new EtudiantDAO(MainActivity.this);
                login = (EditText) findViewById(R.id.editTextTextPersonName);
                password = (EditText) findViewById(R.id.editTextTextPassword);
                Etudiant e = new Etudiant();
                e = dao.getEtudiantWithLogin(login.getText().toString(), password.getText().toString());
                if (login.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    if (e != null) {
                        Intent intent = new Intent(MainActivity.this, InterfaceAccueil.class);
                        intent.putExtra("etudiant", e);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Login ou Mot de passe incorrect !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Inscritption.class);
                startActivity(intent);
            }
        });

    }
}