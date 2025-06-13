package com.example.eniacacademy.model;

public class Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String idade;
    private String email;
    private String senha;

    public Usuario(int id, String nome, String cpf, String idade, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String idade, String email) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
