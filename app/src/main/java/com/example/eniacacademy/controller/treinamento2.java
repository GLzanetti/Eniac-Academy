package com.example.eniacacademy.controller;

import android.content.Intent;
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

public class treinamento2 extends AppCompatActivity {

    ImageButton ibVoltar;
    TextView txtTreinamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_treinamento2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ibVoltar = findViewById(R.id.ibGoBack);

        txtTreinamento = findViewById(R.id.txtTreinamento);
        pegarDados();

        ibVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(treinamento2.this, treinamento.class);
                startActivity(intent);
            }
        });
    }

    private void pegarDados() {
        String treino = getIntent().getStringExtra("treino");
        txtTreinamento.setText(treino);
    }
}