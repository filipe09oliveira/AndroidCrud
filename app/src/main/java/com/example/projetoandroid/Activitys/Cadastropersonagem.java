package com.example.projetoandroid.Activitys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetoandroid.Adapter.Adapterpersonagem;
import com.example.projetoandroid.DAO.PersonagemDAO;
import com.example.projetoandroid.Model.Personagem;
import com.example.projetoandroid.R;

public class Cadastropersonagem extends AppCompatActivity {

    public static  final int LOGIN_REQUEST = 5;

      private EditText nome;
      private EditText funcao;
      private EditText descricao;
      private PersonagemDAO dao;
      private Personagem personagem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastropersonagem);

         nome = findViewById(R.id.nomeText);
         funcao = findViewById(R.id.funcaoText);
         descricao = findViewById(R.id.descricaoText);
         dao = new PersonagemDAO(this);
         verificaParametro();
        Button btnCriar = findViewById(R.id.btn_cadastrar);

      /*  btnCriar.setOnClickListener(v -> {
            new android.support.v7.app.AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog)
                    .setTitle("Deseja realmente Cadastrar?")
                    .setMessage("Você deseja confirmar o cadastro com Campeão?")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Personagem personagem = new Personagem();
                            personagem.nome = nome.getText().toString();
                            personagem.funcao = funcao.getText().toString();
                            personagem.descricao = descricao.getText().toString();

                            PersonagemDAO personagemDAO = new PersonagemDAO(v.getContext());
                            String result = personagemDAO.insereDado(personagem);
                            Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();

                            Intent i = new Intent(v.getContext(), Viewpersonagem.class);
                            i.putExtra("personagem", personagem);
                            startActivityForResult(i, LOGIN_REQUEST);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getBaseContext(), "Você cancelou o cadastro", Toast.LENGTH_LONG).show();
                        }
                    })
                    .show();

        });*/

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

    public void salvar(View view){
        Personagem p = new Personagem();
        p.setNome(nome.getText().toString());
        p.setFuncao(funcao.getText().toString());
        p.setDescricao(funcao.getText().toString());
        long id = dao.inserir(p);
        Intent intent1 = new Intent(this, Viewpersonagem.class);
        startActivity(intent1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart metodo chamado", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart metodo chamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume metodo chamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPouse metodo chamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop metodo chamado", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy metodo chamado", Toast.LENGTH_SHORT).show();
    }
}
