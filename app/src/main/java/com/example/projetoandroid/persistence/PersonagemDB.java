package com.example.projetoandroid.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonagemDB extends SQLiteOpenHelper {
    private static final String name = "banco.db";
    private static final int version = 1;

    public PersonagemDB(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table personagem(id_personagem integer primary key autoincrement, " +
                "nome varchar(50), funcao varchar(50), descricao varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
