package com.example.projetoandroid.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetoandroid.R;

public class SegundaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        TextView nomeT = findViewById(R.id.nomeText);
        TextView funcaoT = findViewById(R.id.funcaoText);
        TextView vidaT = findViewById(R.id.descricaoText);
        TextView armaduraT = findViewById(R.id.armaduraText);
        TextView danoT = findViewById(R.id.danoText);
        TextView resistenciaT = findViewById(R.id.resistenciaText);
        TextView velocidadeAtaqueT = findViewById(R.id.velocidadeAtaqueText);
        TextView velocidadeMovimentoT = findViewById(R.id.velocidadeMovimentoText);
        TextView compartilhar = findViewById(R.id.textView_compartilhar);


        nomeT.setText(bundle.getString("nome"));
        funcaoT.setText(bundle.getString("funcao"));
        vidaT.setText(bundle.getString("vida"));
        armaduraT.setText(bundle.getString("armadura"));
        danoT.setText(bundle.getString("dano_ataque"));
        resistenciaT.setText(bundle.getString("resitencia_magica"));
        velocidadeAtaqueT.setText(bundle.getString("velocidade_ataque"));
        velocidadeMovimentoT.setText(bundle.getString("velocidade_movimento"));


        compartilhar.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Campeão Cadastrado com Sucesso !");
            sendIntent.setType("text/plain");
            v.getContext().startActivity(sendIntent);

        });

        Button next = findViewById(R.id.next_button);

        next.setOnClickListener(v->{
            Intent resultIntent = new Intent();
            setResult(RESULT_OK,resultIntent);
            finish();
        });

    }
}
