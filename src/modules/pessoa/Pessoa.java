package modules.pessoa;

import java.time.LocalDate;
import java.time.Period;

//1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
public class Pessoa {
    private final String nome;
    private final LocalDate dataNascimento;

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
