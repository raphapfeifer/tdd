package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class BonusService {

    public BigDecimal calcularBonus(Funcionario funcionario) {
        BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
        if (valor.compareTo(new BigDecimal("1000")) > 0) {
            //valor = BigDecimal.ZERO;
            throw new IllegalArgumentException("Funcionario com salário maior do que R$1.000,0 não pode receber bônus");
        }
        return valor;
    }

}
