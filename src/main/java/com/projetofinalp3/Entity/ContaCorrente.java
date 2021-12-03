package com.projetofinalp3.Entity;

import com.projetofinalp3.Dados;
import com.projetofinalp3.Repository.ContaRepository;
import com.projetofinalp3.infra.ConexaoBDD;

public class ContaCorrente extends Conta {
    private final double taxa=3.80;


    public ContaCorrente(String nome, String cpf) {
        super(nome,cpf);
    }
    public ContaCorrente() {
        super();
    }

    @Override
    public void sacar(double valor) {
        if(super.getSaldo() >= (valor+taxa)){
            super.setSaldo(getSaldo()-(valor-taxa));
            ConexaoBDD.sacar(getCpf(),this.getSaldo());
            System.out.println("saque realizado");
        }else{
            System.out.println("não foi possivel");
        }
    }

    @Override
    public void depositar(double valor) {
        if((super.getSaldo()-taxa)+valor >= 0){
            super.setSaldo(getSaldo()+(valor-taxa));
            ConexaoBDD.depositar(getCpf(),this.getSaldo());
            System.out.println("deposito feito");
        }else{
            System.out.println("deposito não efetuado");
        }
    }
    public void pegarSaldoCC(){
        setSaldo(ConexaoBDD.resgatarSaldo(getCpf()));
    }
    public void encontrarCPF(String cpf){
        setCpf(ConexaoBDD.findById(cpf));
    }



//    public void mostrarDadosDaContaCorrente(){
//    String dados="Numero da conta: " + super.getNumero()+"\n"+
//            "Saldo atual: " + super.getSaldo()+"\n"+
//            "Taxa de operação: " + this.taxa + "\n";
//    }

}

