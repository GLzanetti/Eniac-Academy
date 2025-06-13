package com.example.eniacacademy.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.eniacacademy.R;
import com.example.eniacacademy.model.Usuario;

public class login extends AppCompatActivity {

    EditText txtEmail, txtSenha;
    Button btEntrar, btCadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btEntrar = findViewById(R.id.btnEntrar);
        btCadastro = findViewById(R.id.btCadastro);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validaLogin()){
                    String email = txtEmail.getText().toString();

                    Intent intent = new Intent(login.this, mainActivity.class);
                    intent.putExtra("Email", email);
                    startActivity(intent);
                }
            }
        });

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, cadastro1.class);
                startActivity(intent);
            }
        });
    }

    public boolean validaLogin(){
        String email = txtEmail.getText().toString();
        String senha = txtSenha.getText().toString();
        String msg = "";

        boolean retorno = true;

        Usuario usuario = null;

        String prefs_name = "usuario_prefs";
        SharedPreferences preferences = getSharedPreferences(prefs_name, MODE_PRIVATE);

        if(email.isEmpty()){
            retorno = false;
            msg = "Preencha o campo email corretamente";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        } else if (senha.isEmpty()) {
            retorno = false;
            msg = "Preencha o campo senha corretamente";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            txtSenha.setText("");
        }

        usuariosController bd = new usuariosController(getBaseContext());

        Cursor allDados = bd.getData(email);

        if(allDados.moveToFirst()){
            usuario = new Usuario(allDados.getString(1), allDados.getString(3), allDados.getString(4));

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("usuario_nome", usuario.getNome());
            editor.putString("usuario_idade", usuario.getIdade());
            editor.putString("usuario_email", usuario.getEmail());

            editor.apply();
        }

        Cursor dados = bd.getDataLogin(email, senha);

        if(dados.moveToFirst()){
            retorno = true;
        } else {
            msg = "Usuário não registrado no banco de dados";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            limpar();
            retorno = false;
        }

        return retorno;
    }

    public void limpar(){
        txtEmail.setText("");
        txtSenha.setText("");
    }
}