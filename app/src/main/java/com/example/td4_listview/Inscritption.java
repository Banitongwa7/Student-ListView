package com.example.td4_listview;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Inscritption extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private EditText email;
    private EditText password;
    private EditText confirm;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscritption);

        save = (Button) findViewById(R.id.enregistrer);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nom = (EditText) findViewById(R.id.NomInscription);
                prenom = (EditText) findViewById(R.id.PrenomInscription);
                email = (EditText) findViewById(R.id.emailInscription);
                password = (EditText) findViewById(R.id.passInscription);
                confirm = (EditText) findViewById(R.id.confirmInscription);

                if(nom.getText().toString().isEmpty() || prenom.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty() || confirm.getText().toString().isEmpty()){
                    Toast.makeText(Inscritption.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                }else {
                    if (password.getText().toString().equals(confirm.getText().toString())) {
                        EtudiantDAO dao = new EtudiantDAO(Inscritption.this);
                        Etudiant e = new Etudiant(nom.getText().toString(), prenom.getText().toString(), email.getText().toString(), password.getText().toString());
                        dao.insertEtudiant(e);
                        Toast.makeText(Inscritption.this, "Nouvel utilisateur ajouté !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Inscritption.this, "Les deux mot de passe ne sont pas identiques", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}