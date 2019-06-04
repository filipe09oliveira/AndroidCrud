package com.example.projetoandroid.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetoandroid.Activitys.Atualiza_activity;
import com.example.projetoandroid.Model.Personagem;
import com.example.projetoandroid.R;
import java.util.List;

public class Adapterpersonagem extends RecyclerView.Adapter<Adapterpersonagem.ViewHolder> {
    public List<Personagem> dadosPersonagem;


    public Adapterpersonagem(List<Personagem> dataUser) {
        this.dadosPersonagem = dataUser;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapterpersonagem, parent, false);
        return new ViewHolder(v, parent.getContext());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(dadosPersonagem.get(position));
    }

    @Override
    public int getItemCount() {
        return dadosPersonagem.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView nome;
        private final TextView funcao;
        private final TextView descricao;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.textView_nome);
            funcao = (TextView) itemView.findViewById(R.id.textView_funcao);
            descricao = (TextView) itemView.findViewById(R.id.textView_descricao);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dadosPersonagem.size() > 0){
                        Personagem personagem = dadosPersonagem.get(getLayoutPosition());

                        Intent it = new Intent(context, Atualiza_activity.class);
                        it.putExtra("PERSONAGEM", personagem);

                        ((AppCompatActivity)context).startActivityForResult(it,0);
                    }
                }
            });

        }

        public void bind(final Personagem personagem) {
            nome.setText(personagem.nome);
            funcao.setText(personagem.funcao);
            descricao.setText(personagem.descricao);
            nome.setOnClickListener(v ->{
                Toast.makeText(v.getContext(),personagem.nome,Toast.LENGTH_LONG).show();
            });
        }
    }

}
