package com.projetofinalp3;

public class Dados1 {

    private static Dados1 instance = null;
    private static String cpf, nome,senha;
    private static Double saldo,agencia;


    private Dados1(String cpf, String nome, String senha, Double saldo, Double agencia) {
        this.cpf = cpf;
        this.nome=nome;
        this.senha = senha;
        this.saldo=saldo;
        this.agencia = agencia;

    }

    public static Dados1 getInstance(String cpf, String nome, String senha, Double saldo, Double agencia) {
        return instance = new Dados1(cpf,nome,senha,saldo,agencia);

    }

    public static void setCpf(String cpf) {
        Dados1.cpf = cpf;
    }

    public static void setNome(String nome) {
        Dados1.nome = nome;
    }

    public static void setSenha(String senha) {
        Dados1.senha = senha;
    }

    public static void setSaldo(Double saldo) {
        Dados1.saldo = saldo;
    }

    public static void setAgencia(Double agencia) {
        Dados1.agencia = agencia;
    }

    public static String getCPF() {
        return cpf;
    }

    public static String getNome() {
        return nome;
    }

    public static String getSenha() {
        return senha;
    }

    public static Double getSaldo() {
        return saldo;
    }

    public static Double getAgencia() {
        return agencia;
    }

}