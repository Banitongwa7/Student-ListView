package com.example.td4_listview;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Etudiant> liste;
    public MyAdapter(List<Etudiant> e) {
        this.liste = e;
    }
    @Override
    public int getCount() {
        return liste.size();
    }
    @Override
    public Object getItem(int i) {
        return liste.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder")
        View v = View.inflate(viewGroup.getContext(), R.layout.item_etudiant, null);
        Etudiant e = liste.get(i);
        ((TextView) v.findViewById(R.id.nomItem)).setText(e.getNom() + " " + e.getPrenom());
        ((TextView) v.findViewById(R.id.emailItem)).setText(e.getEmail());
        ((Button) v.findViewById(R.id.deleteEtudiantButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EtudiantDAO dao = new EtudiantDAO(viewGroup.getContext());
                dao.deleteEtudiant(e);
                liste.remove(i);
                notifyDataSetChanged();
            }
        });

        return v;
    }
}
