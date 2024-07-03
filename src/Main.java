import modules.funcionario.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador"));

        for (Funcionario funcionario : funcionarios){
            System.out.println(funcionario);
        }
    }
}