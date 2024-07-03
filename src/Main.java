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
        }
    }
}