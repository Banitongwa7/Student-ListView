package com.example.td4_listview;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {
    private SQLiteDatabase db;
    private DataBaseHandler dbHandler;


    public EtudiantDAO(Context c) {
        this.dbHandler = new DataBaseHandler(c);
    }

    public long insertEtudiant(Etudiant etudiant) {
        db = dbHandler.getWritableDatabase();
        ContentValues cont = new ContentValues();
        cont.put("nom", etudiant.getNom());
        cont.put("prenom", etudiant.getPrenom());
        cont.put("email", etudiant.getEmail());
        cont.put("password", etudiant.getPassword());
        long res = db.insert("etudiant", null, cont);
        db.close();
        return res;
    }



    public int deleteEtudiant(Etudiant etudiant) {
        db = dbHandler.getWritableDatabase();
        int res = db.delete("etudiant", "matricule=" + etudiant.getMatricule(), null);
        db.close();
        return res;
    }

    public List<Etudiant> getAll() {
        db = dbHandler.getReadableDatabase();
        Cursor c = db.query("etudiant", null, null, null, null, null, null);
        List<Etudiant> list = new ArrayList<>();
        while(c.moveToNext())
        {
            Etudiant e = new Etudiant();
            setEtudiantData(c, e);
            list.add(e);
        }
        c.close();
        db.close();
        return list;
    }

    @SuppressLint("Range")
    public Etudiant getEtudiantWithLogin(String email, String password) {
        db = dbHandler.getReadableDatabase();
        String query = "SELECT * FROM etudiant WHERE email = '" + email + "' AND password = '" + password + "';";
        Cursor cursor = db.rawQuery(query, null);
        Etudiant etudiant = new Etudiant();
        if (cursor.moveToFirst()) {
            setEtudiantData(cursor, etudiant);
        }
        cursor.close();
        db.close();
        return etudiant;
    }

    @SuppressLint("Range")
    private void setEtudiantData(Cursor c, Etudiant e) {
        e.setMatricule(c.getInt(c.getColumnIndex("matricule")));
        e.setNom(c.getString(c.getColumnIndex("nom")));
        e.setPrenom(c.getString(c.getColumnIndex("prenom")));
        e.setEmail(c.getString(c.getColumnIndex("email")));
        e.setPassword(c.getString(c.getColumnIndex("password")));
    }

}
