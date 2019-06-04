package com.example.projetoandroid.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.projetoandroid.Adapter.Adapterpersonagem;
import com.example.projetoandroid.DAO.PersonagemDAO;
import com.example.projetoandroid.Model.Personagem;
import com.example.projetoandroid.R;


public class Viewpersonagem extends AppCompatActivity {

    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
    public RecyclerView recyPersonagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_viewpersonagem);


            recyPersonagem = findViewById(R.id.rec_user_list);
            PersonagemDAO personagemDAO = new PersonagemDAO(this);
            Adapterpersonagem adapterpersonagem = new Adapterpersonagem(personagemDAO.list());
            recyPersonagem.setAdapter(adapterpersonagem);

            recyPersonagem.setLayoutManager(this.mLayoutManager);


            ImageButton next =  findViewById(R.id.next_button);


            Personagem personagem = (Personagem) getIntent().getSerializableExtra("Personagem");


            next.setOnClickListener(v->{
                Intent resultIntent = new Intent();
                resultIntent.putExtra("personagem", personagem);
                setResult(RESULT_OK,resultIntent);
                finish();
            });



        }
}
