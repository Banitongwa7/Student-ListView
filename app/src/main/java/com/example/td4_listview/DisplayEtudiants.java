package com.example.td4_listview;

import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class DisplayEtudiants extends AppCompatActivity {

    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_etudiants);

        ListView allEtudiant = (ListView) findViewById(R.id.listView);
        EtudiantDAO dao = new EtudiantDAO(DisplayEtudiants.this);
        List<Etudiant> etudiants = dao.getAll();
        MyAdapter adapter = new MyAdapter(etudiants);
        allEtudiant.setAdapter(adapter);

    }
}