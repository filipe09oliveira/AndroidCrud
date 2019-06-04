package com.example.projetoandroid.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.projetoandroid.Model.Personagem;
import com.example.projetoandroid.persistence.PersonagemDB;

import java.util.ArrayList;

public class PersonagemDAO {

    private SQLiteDatabase db;
    private PersonagemDB banco;

    public PersonagemDAO(Context context){
        banco = new PersonagemDB(context);
        db = banco.getWritableDatabase();
    }

    public long inserir(Personagem personagem){
        ContentValues values = new ContentValues();
        values.put("nome", personagem.getNome());
        values.put("funcao", personagem.getFuncao());
        values.put("descricao", personagem.getDescricao());
        return db.insert("personagem", null, values);
    }

    public ArrayList<Personagem> list() {
        Cursor cursor;
        String[] campos = {"nome", "funcao", "descricao"};
        db = banco.getReadableDatabase();
        cursor = db.query("personagem", campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        ArrayList<Personagem> users = new ArrayList<Personagem>();
        for (int i = 0; i < cursor.getCount(); i++) {
            Personagem personagem = new Personagem();
            personagem.nome = cursor.getString(cursor.getColumnIndex("nome"));
            personagem.funcao = cursor.getString(cursor.getColumnIndex("funcao"));
            personagem.descricao = cursor.getString(cursor.getColumnIndex("descricao"));

            users.add(personagem);
            cursor.moveToNext();
        }
        return users;
    }
}
