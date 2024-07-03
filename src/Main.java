<<<<<<< HEAD
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
=======
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Nome: ");

    }


    class Pessoa {
        private String nome;
        private LocalDate dataNascimento;

        public Pessoa(String nome, LocalDate dataNascimento) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
        }

        public String getNome() {
            return nome;
        }

        public LocalDate getDataNascimento() {
            return dataNascimento;
        }

        public int getIdade() {
            return Period.between(dataNascimento, LocalDate.now()).getYears();
>>>>>>> be9f004aed1b702d31a6152a6d6aa2dd2dc0c53a
        }
    }
}