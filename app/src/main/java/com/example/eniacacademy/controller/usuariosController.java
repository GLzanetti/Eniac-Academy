package com.example.eniacacademy.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.eniacacademy.model.CriaBanco;

public class usuariosController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public usuariosController(Context context){
        banco = new CriaBanco(context);
    }

    public String insertData(String nome, String cpf, int idade, String email, String senha){
        ContentValues values;
        long result;
        db = banco.getWritableDatabase();

        values = new ContentValues();
        values.put("nome", nome);
        values.put("cpf", cpf);
        values.put("idade", idade);
        values.put("email", email);
        values.put("senha", senha);

        result = db.insert("usuario", null, values);
        db.close();

        if(result == -1){
            return "Erro ao inserir dados";
        } else {
            return "Dados salvos com sucesso";
        }
    }

    public Cursor getData(String email, String senha){
        Cursor cursor;
        String[] campos = {"email","senha"};
        String where = "email='" + email + "' AND senha='" + senha + "'";
        db = banco.getWritableDatabase();
        cursor = db.query("usuarios", campos, where, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }


}
