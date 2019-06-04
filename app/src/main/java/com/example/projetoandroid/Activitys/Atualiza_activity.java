package com.example.projetoandroid.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.projetoandroid.Model.Personagem;
import com.example.projetoandroid.R;

public class Atualiza_activity extends AppCompatActivity {

    private Personagem personagem;
    private EditText nome;
    private EditText funcao;
    private EditText descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualiza_activity);

        verificaParametro();
    }

    private  void verificaParametro(){
        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.containsKey("PERSONAGEM")){
            personagem = (Personagem)bundle.getSerializable("PERSONAGEM");
            nome.setText(personagem.nome);
            funcao.setText(personagem.funcao);
            descricao.setText(personagem.descricao);
        }
    }
}
