package com.example.projetoandroid.Activitys;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.projetoandroid.R;

public class MainActivity extends AppCompatActivity {

    private Button btn_cadastrar;
    private Button btn_listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapeiaCadastrar();
        mapeiaListar();



    }


    public void chamar(){
        Intent i4 = new Intent(this, Cadastropersonagem.class);
        startActivity(i4);
    }
    public void mapeiaCadastrar() {
        btn_cadastrar = (Button)findViewById(R.id.btn_cadastrar);
        btn_cadastrar.setOnClickListener(this::onClickCa);
    }

    public void mapeiaListar(){
        btn_listar = (Button)findViewById(R.id.btn_listar);
        btn_listar.setOnClickListener(this::onClickList);
    }

    public void onClickCa(View v){
        Intent intent = new Intent(MainActivity.this, Cadastropersonagem.class);
        startActivity(intent);
    }

    public void onClickList(View v){
        Intent intent1 = new Intent(MainActivity.this, Viewpersonagem.class);
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
        Toast.makeText(getApplicationContext(), "onPause metodo chamado", Toast.LENGTH_SHORT).show();
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
