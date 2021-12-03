package com.projetofinalp3;

public class Dados {

    private static Dados instance =null;
    private static String cpf;



    private Dados(String cpf) {
        this.cpf = cpf;

    }

    public static Dados getInstance(String cpf) {
        if(instance == null){
            instance = new Dados(cpf);
        }
            return instance;
    }

    public static void setCpf(String cpf) {
        Dados.cpf = cpf;
    }

    public static String getCPF() {
        return cpf;
    }
}