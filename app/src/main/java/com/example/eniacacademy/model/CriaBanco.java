package com.example.eniacacademy.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String nomeBanco = "EniacAcademyuBD";
    private static final int versao = 1;

    public CriaBanco(Context context){
        super(context, nomeBanco, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE usuarios(" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "nome text NOT NULL," +
                "cpf text NOT NULL," +
                "idade text NOT NULL," +
                "email text NOT NULL," +
                "senha text NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
