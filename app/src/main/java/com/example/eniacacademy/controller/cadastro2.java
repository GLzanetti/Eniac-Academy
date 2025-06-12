package com.example.eniacacademy.controller;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
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

public class cadastro2 extends AppCompatActivity {

    EditText txtEmail, txtSenha, txtConfirmaSenha;
    Button btCadastro2, btVoltarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btCadastro2 = findViewById(R.id.btCadastro2);
        btVoltarCadastro = findViewById(R.id.btVoltarCadastro);
        txtConfirmaSenha = findViewById(R.id.txtConfirmasenha);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);

        btVoltarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cadastro2.this, cadastro1.class);
                startActivity(intent);
            }
        });

        btCadastro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCadastro2()){
                    Intent intent = new Intent(cadastro2.this, mainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean validarCadastro2(){
        String confirmaSenha = txtConfirmaSenha.getText().toString();
        String email = txtEmail.getText().toString();
        String senha = txtSenha.getText().toString();
        String msg = "";
        boolean retorno = true;

        if(email.isEmpty() || !email.contains("@gmail.com")) {
            msg = "Preencha o email corretamente";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            retorno = false;

        } else if(senha.isEmpty() || senha.length() < 6 ) {
            msg = "A senha deve conter 6 caracteres";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            retorno = false;
        } else if(confirmaSenha != senha){
            msg = "A senha deve ser igual ao campo de cima";
            Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }

        return retorno;
    }
}