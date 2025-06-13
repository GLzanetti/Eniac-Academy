package com.example.eniacacademy.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String nomeBanco = "EniacAcademyuBD";
    private static final int versao = 1;

    public CriaBanco(Context context) {
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

//        sql = "CREATE TABLE treinamentos(" +
//                "id integer PRIMARY KEY AUTOINCREMENT," +
//                "nome text NOT NULL," +
//                "exercicio1 text," +
//                "exercicio2 text," +
//                "exercicio3 text," +
//                "exercicio4 text," +
//                "exercicio5 text," +
//                "exercicio6 text)";
//        db.execSQL(sql);

//        sql = "CREATE TABLE medidasUsuarios(" +
//                "Id int PRIMARY KEY AUTOINCREMENT, " +
//                "Peso double, " +
//                "Altura double, " +
//                "Torax double, " +
//                "Quadril double, " +
//                "Abdomen double, " +
//                "Cintura double, " +
//                "Escapular double, " +
//                "Braco_E double, " +
//                "Braco_D double, " +
//                "Coxa_E double, " +
//                "Coxa_D double, " +
//                "Panturrilha_E double, " +
//                "Panturrilha_D double)";
//        db.execSQL(sql);

//        sql = "CREATE TABLE medidasUsuariosPassadas(" +
//                "Id int PRIMARY KEY AUTOINCREMENT, " +
//                "PesoPassada double, " +
//                "AlturaPassada double, " +
//                "ToraxPassada double, " +
//                "QuadrilPassada double, " +
//                "AbdomenPassada double, " +
//                "CinturaPassada double, " +
//                "EscapularPassada double, " +
//                "Braco_EPassada double, " +
//                "Braco_DPassada double, " +
//                "Coxa_EPassada double, " +
//                "Coxa_DPassada double, " +
//                "Panturrilha_EPassada double, " +
//                "Panturrilha_DPassada double)";
//
//        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
