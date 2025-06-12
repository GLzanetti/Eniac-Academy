package com.example.eniacacademy.controller;

import android.content.Intent;
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


public class cadastro1 extends AppCompatActivity {

    EditText txtNome, txtCpf, txtIdade;
    Button btCadastro1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btCadastro1 = findViewById(R.id.btCadastro1);
        txtCpf = findViewById(R.id.txtCpf);
        txtIdade = findViewById(R.id.txtIdade);
        txtNome = findViewById(R.id.txtNome);

        btCadastro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCadastro1()) {
                    startActivity(passarDadosCadastro1());
                }
            }
        });
    }

    private boolean validarCadastro1() {
        String nome = txtNome.getText().toString();
        String idade = txtIdade.getText().toString();
        String cpf = txtCpf.getText().toString();
        String msg = "";
        boolean retorno = true;

        if (nome.isEmpty() || nome.length() < 3 ) {
            msg = "Preencha o nome corretamente";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }else if(!nome.matches("[a-zA-ZáâãéêíóôõçÇ]+")){
            msg = "Nome só pode conter letras";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }else if (cpf.isEmpty() || cpf.length() < 11) {
            msg = "Preencha a cpf corretamente";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            retorno = false;
        } else if (idade.length() != 2) {
            msg = "Preencha o idade corretamente";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }

        return retorno;
    }

    private Intent passarDadosCadastro1() {
        String nome = txtNome.getText().toString();
        String idade = txtIdade.getText().toString();
        String cpf = txtCpf.getText().toString();

        Intent intent = new Intent(cadastro1.this, cadastro2.class);
        intent.putExtra("nome", nome);
        intent.putExtra("idade", idade);
        intent.putExtra("cpf", cpf);

        return intent;
    }
}