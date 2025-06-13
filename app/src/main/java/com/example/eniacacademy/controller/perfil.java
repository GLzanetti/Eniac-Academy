package com.example.eniacacademy.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.eniacacademy.R;
import com.example.eniacacademy.model.Usuario;

public class perfil extends AppCompatActivity {

    ImageButton ibVoltar;
    Button btSair;
    TextView txtNome, txtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ibVoltar = findViewById(R.id.ibGoBack);
        btSair = findViewById(R.id.btSair);

        txtNome = findViewById(R.id.txtNome);
        txtIdade = findViewById(R.id.txtIdade);
        carregarDadosUsuario();

        ibVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(perfil.this, mainActivity.class);
                startActivity(intent);
            }
        });

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }

    private void carregarDadosUsuario() {
        String prefs_name = "usuario_prefs";
        SharedPreferences preferences = getSharedPreferences(prefs_name, MODE_PRIVATE);

        String nomeUsuario = preferences.getString("usuario_nome","Visitante");
        String idadeUsuario = preferences.getString("usuario_idade","00");

        txtNome.setText(nomeUsuario);
        txtIdade.setText(idadeUsuario);
    }
}