package modules.principal;

import modules.funcionario.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Principal {
    private List<Funcionario> funcionarios = new ArrayList<>();
    private final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionarioPorNome(String nome) {
        funcionarios.removeIf(func -> func.getNome().equals(nome));
    }

    public void listarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    // 3.4 - Os funcionários receberam 10% de aumento de salário
    public void aumentoSalarial() {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(new BigDecimal("0.10"));
            funcionario.setSalario(funcionario.getSalario().add(aumento));
        }
    }

    //    3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
    public void agruparPorFuncao() {
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            funcionariosPorFuncao
                    .computeIfAbsent(funcionario.getFuncao(), k -> new ArrayList<>())
                    .add(funcionario);
        }
        imprimirFuncionariosAgrupadosPorFuncao(funcionariosPorFuncao);
    }

//    3.6 – Imprimir os funcionários, agrupados por função.

    private void imprimirFuncionariosAgrupadosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Funcionario funcionario : entry.getValue()) {
                System.out.println("  " + funcionario);
            }
        }
    }

    //   3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
    public void listaFuncionariosAniversario(int... meses) {
        for (Funcionario funcionario : funcionarios) {
            int mesNascimento = funcionario.getDataNascimento().getMonthValue();
            for (int mes : meses) {
                if (mesNascimento == mes) {
                    System.out.println(funcionario);
                }
            }
        }
    }

    //3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
    public void imprimirFuncionarioMaisVelho() {
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .max(Comparator.comparing(Funcionario::getIdade))
                .orElse(null);

        System.out.println("Nome: " + funcionarioMaisVelho.getNome());
        System.out.println("Idade: " + funcionarioMaisVelho.getIdade() + " anos");
    }

    //    3.10 – Imprimir a lista de funcionários por ordem alfabética.
    public void imprimirFuncionariosEmOrdemAlfabetica() {
        List<Funcionario> ordenados = new ArrayList<>(funcionarios);
        ordenados.sort(Comparator.comparing(Funcionario::getNome));

        ordenados.forEach(System.out::println);
    }

    //3.11 – Imprimir o total dos salários dos funcionários.
    public void imprimirTotalSalarios() {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\nTotal dos salários dos funcionários: " + totalSalarios);
    }

    //    3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
    public void imprimirSalariosMinimos() {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(SALARIO_MINIMO, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(funcionario.getNome() + " ganha " + salariosMinimos + " salários mínimos.");
        }
    }

    public void executar() {
        // 3.1 - Inserir todos os funcionários
        // conferir valores inseridos
        adicionarFuncionario(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        adicionarFuncionario(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        adicionarFuncionario(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        adicionarFuncionario(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        adicionarFuncionario(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        adicionarFuncionario(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        adicionarFuncionario(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        adicionarFuncionario(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        adicionarFuncionario(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        adicionarFuncionario(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 - Remover o funcionário “João” da lista
        removerFuncionarioPorNome("João");

        // Listar todos os funcionários
        System.out.println("Funcionários antes do aumento salarial: ");
        listarFuncionarios();

        // 3.4 - Aplicar aumento salarial de 10%
        aumentoSalarial();

        // Listar todos os funcionários após o aumento salarial
        System.out.println("\nFuncionários após aumento salarial de 10%:");
        listarFuncionarios();

//        3.6 – Imprimir os funcionários, agrupados por função.
        System.out.println("\nFuncionários agrupados por função:");
        agruparPorFuncao();

//        3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("\nFuncionários que fazem aniversário no mês 10 e 12:");
        listaFuncionariosAniversario(10, 12);

//        3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println("\nFuncionário com a maior idade:");
        imprimirFuncionarioMaisVelho();

//        3.10 – Imprimir a lista de funcionários por ordem alfabética.
        System.out.println("\nfuncionários por ordem alfabética.");
        imprimirFuncionariosEmOrdemAlfabetica();

//        3.11 – Imprimir o total dos salários dos funcionários.
        imprimirTotalSalarios();

//        3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        System.out.println("\nTotal de salarios minimos recebidos por funcionários");
        imprimirSalariosMinimos();

    }

}
