package com.projetofinalp3.Repository;



import com.projetofinalp3.Entity.Cliente;
import com.projetofinalp3.Entity.Conta;

import java.util.List;

public interface iConta {
    Conta criarConta(Conta contaCorrente);
    Conta depositar (String cpf, double valor);
    Conta sacar(String cpf, double valor);
    String findById(String cpf);
    double resgatarSaldo(String cpf);
}