package com.example.eniacacademy.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
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
import com.example.eniacacademy.model.Usuario;
import com.google.android.material.navigation.NavigationView;

public class nutricao extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageButton ibPerfil;
    Button btNutricionista, btDieta;
    View headerView;
    TextView txtNomeUsuario, txtEmailUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nutricao);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainDrawer_layoutNutricao), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        drawerLayout = findViewById(R.id.mainDrawer_layoutNutricao);
        navigationView = findViewById(R.id.nav_view);
        ibPerfil = findViewById(R.id.ibPerfil);
        btNutricionista = findViewById(R.id.btNutricionista);
        btDieta = findViewById(R.id.btDieta);

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

                if (id == R.id.nav_horarios) {
                    intent = new Intent(nutricao.this, mainActivity.class);
                    startActivity(intent);
                } else if (id == R.id.nav_treinamento) {
                    intent = new Intent(nutricao.this, treinamento.class);
                    startActivity(intent);
                } else if (id == R.id.nav_nutricao) {
                    intent = new Intent(nutricao.this, nutricao.class);
                    startActivity(intent);
                } else if (id == R.id.nav_perfil) {
                    intent = new Intent(nutricao.this, perfil.class);
                    startActivity(intent);
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        btNutricionista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nutricao.this, nutricaowhats.class);
                startActivity(intent);
            }
        });

        btDieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nutricao.this, nutricaodieta.class);
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