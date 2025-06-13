package com.example.eniacacademy.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.eniacacademy.R;
import com.google.android.material.navigation.NavigationView;

public class treinamento extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageButton ibPerfil;
    View headerView;
    TextView txtNomeUsuario, txtEmailUsuario;
    Button btTreinoA, btTreinoB, btTreinoC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_treinamento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainDrawer_layoutTreinamento), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btTreinoA = findViewById(R.id.treinoA);
        btTreinoB = findViewById(R.id.treinoB);
        btTreinoC = findViewById(R.id.treinoC);

        drawerLayout = findViewById(R.id.mainDrawer_layoutTreinamento);
        navigationView = findViewById(R.id.nav_view);
        ibPerfil = findViewById(R.id.ibPerfil);

        headerView = navigationView.getHeaderView(0);

        txtNomeUsuario = headerView.findViewById(R.id.txtNomeUsuario);
        txtEmailUsuario = headerView.findViewById(R.id.txtEmailUsuario);
        carregarDadosUsuario();

        ibPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent intent = null;

                if(id == R.id.nav_horarios){
                    intent = new Intent(treinamento.this, mainActivity.class);
                    startActivity(intent);
                } else if(id == R.id.nav_treinamento){
                    intent = new Intent(treinamento.this, treinamento.class);
                    startActivity(intent);
                } else if(id == R.id.nav_nutricao){
                    intent = new Intent(treinamento.this, nutricao.class);
                    startActivity(intent);
                } else if(id == R.id.nav_perfil){
                    intent = new Intent(treinamento.this, perfil.class);
                    startActivity(intent);
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        btTreinoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String treino = "Treino A";
                Intent intent = new Intent(treinamento.this, treinamento2.class);
                intent.putExtra("treino", treino);
                startActivity(intent);
            }
        });

        btTreinoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String treino = "Treino B";
                Intent intent = new Intent(treinamento.this, treinamento2.class);
                intent.putExtra("treino", treino);
                startActivity(intent);
            }
        });

        btTreinoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String treino = "Treino C";
                Intent intent = new Intent(treinamento.this, treinamento2.class);
                intent.putExtra("treino", treino);
                startActivity(intent);
            }
        });
    }

    private void carregarDadosUsuario() {
        String prefs_name = "usuario_prefs";
        SharedPreferences preferences = getSharedPreferences(prefs_name, MODE_PRIVATE);

        String nomeUsuario = preferences.getString("usuario_nome","Visitante");
        String emailUsuario = preferences.getString("usuario_email","faca_login@app.com");

        txtNomeUsuario.setText(nomeUsuario);
        txtEmailUsuario.setText(emailUsuario);
    }
}