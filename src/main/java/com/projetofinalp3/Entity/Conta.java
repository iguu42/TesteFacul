package com.projetofinalp3.Entity;

public abstract class Conta extends Cliente {
    private double saldo;
    private Cliente cliente;

    public Conta(String nome, String cpf) {
        this.cliente.setNome(nome);
        this.cliente.setCpf(cpf);
    }

    public Conta() {

    }

    public abstract void depositar(double valor);

    public abstract void sacar(double valor);

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


//    public void trasnferir(double valor, Conta conta){
//        if(this instanceof ContaCorrente){
//
//        }
//    }
}