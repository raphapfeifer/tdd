package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    private ReajusteService service;

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){
        BonusService service = new BonusService();
        //assertThrows(IllegalArgumentException.class,
         //       () -> service.calcularBonus(new Funcionario("Raphael", LocalDate.now(),new BigDecimal("25000"))));

        // segunda maneira
        try{
            service.calcularBonus(new Funcionario("Raphael", LocalDate.now(),new BigDecimal("25000")));
            fail("Não deu a exception");
        }catch(Exception e){
            assertEquals("Funcionario com salário maior do que R$1.000,0 não pode receber bônus", e.getMessage());
        }

    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Raphael", LocalDate.now(),new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.0"),bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Raphael", LocalDate.now(),new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"),bonus);
    }

}
