package com.projetofinalp3.Repository;
import com.projetofinalp3.Entity.Conta;
import com.projetofinalp3.infra.ConexaoBDD;


public class ContaRepository implements iConta{

    @Override
    public Conta criarConta(Conta contaCorrente) {
        return ConexaoBDD.criarConta(contaCorrente);
    }

    @Override
    public Conta depositar(String cpf, double valor) {
        return ConexaoBDD.depositar(cpf,valor);
    }

    @Override
    public Conta sacar(String cpf, double valor) {
        return ConexaoBDD.sacar(cpf,valor);
    }

    @Override
    public String findById(String cpf) {
        return ConexaoBDD.findById(cpf);
    }

    public double resgatarSaldo(String cpf) {
        return ConexaoBDD.resgatarSaldo(cpf);
    }
}
