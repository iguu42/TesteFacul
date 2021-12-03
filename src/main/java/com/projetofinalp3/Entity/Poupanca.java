package com.projetofinalp3.Entity;

public class Poupanca extends Conta{
    private final double limite = 0;

    public Poupanca(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public void sacar(double valor) {
        if(super.getSaldo() >= (valor)){
            super.setSaldo(valor);
            System.out.println("saque realizado");
        }else{
            System.out.println("não foi possivel");
        }
    }

    @Override
    public void depositar(double valor) {
        super.setSaldo(valor);
    }

//    public void mostrarDadosDaContaCorrente(){
//        String dados="Numero da conta: " + super.getNumero()+"\n"+
//                "Saldo atual: " + super.getSaldo()+"\n";
//    }
}
