import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class AlunoService {
    public void listarAlunos(ArrayList<Aluno> alunos) {
        if (alunos.isEmpty()) {
            System.out.println("Não existe Alunos cadastrdos!");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println("--- Aluno ---");
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Idade: " + aluno.getIdade());
                System.out.println("Média: " + aluno.calcularMedia());
                System.out.println("Situação: " + aluno.verificarAprovacao());
            }

        }
    }

    public void cadastrarAluno(ArrayList<Aluno> alunos, Scanner scanner) {
        System.out.print("Deseja adiconar alunos (s/n): ");
        String opcao = scanner.nextLine();
        while (opcao.equals("s")) {
            System.out.print("Digite o seu nome: ");
            String nome = scanner.nextLine();

            int idade = lerIdade(scanner);
            double nota1 = lerNota(scanner);
            double nota2 = lerNota(scanner);
            double nota3 = lerNota(scanner);

            try {
                Aluno meuAluno = new Aluno(nome, idade, nota1, nota2, nota3);
                alunos.add(meuAluno);
                System.out.println("Alunos cadastrados com sucesso!");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            scanner.nextLine();

            System.out.println("Deseja cadastrar outro Aluno? (s/n)");
            opcao = scanner.nextLine();
        }
    }
    public int lerIdade(Scanner scanner){
        int idade = -1;
        boolean idadeValida = false;
        while (!idadeValida){
            try {
                System.out.println("Digite o idade: ");
                idade = scanner.nextInt();

                if (idade >= 0) {
                    idadeValida = true;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Entrada Inválida! Digite uma idade usando números inteiros.");
                scanner.nextLine();
            }
        }

        return idade;
    }

    public double lerNota(Scanner scanner) {
        boolean notaValida = false;
        double nota = 0;
        while (!notaValida) {
            try {
                System.out.println("Digite o nota: ");
                nota = scanner.nextDouble();
                if (nota >= 0 && nota <= 10) {
                    notaValida = true;
                }
                else {
                    System.out.println("Digite uma nota de 0 a 10.");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Nota inválida! Digite novamente.");
                scanner.nextLine();
            }

        }
        return nota;

    }

    public void buscarAluno(ArrayList<Aluno> alunos, Scanner scanner) {
        System.out.print("Digite o nome do aluno: ");
        String busca = scanner.nextLine();
        boolean existe = false;

        for (Aluno aluno : alunos) {
            if (busca.equals(aluno.getNome())) {
                System.out.println("Alunos encontrados com sucesso!");
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Idade: " + aluno.getIdade());
                System.out.print("Status: "+ aluno.verificarAprovacao());
                existe = true;

            }
        }
        if (!existe) {
            System.out.println("Aluno não encontrado!");
        }
    }

    public void deletarAluno(ArrayList<Aluno> alunos, Scanner scanner) {
        System.out.print("Digite o nome do aluno que deseja deletar: ");
        String busca = scanner.nextLine();

        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);
            if (busca.equals(aluno.getNome())) {
                alunos.remove(i);
                System.out.println("Aluno deletado com sucesso!");
                return;
            }
        }
        System.out.println("Aluno não encontrado!");
    }

    public void alterarAluno(ArrayList<Aluno> alunos, Scanner scanner) {

        System.out.print("Digite o nome do aluno que deseja alterar: ");
        String busca = scanner.nextLine();

        for (int i = 0; i < alunos.size(); i++) {

            Aluno aluno = alunos.get(i);

            if (busca.equals(aluno.getNome())) {

                System.out.println("O que deseja alterar?");
                System.out.println("1 - Nome");
                System.out.println("2 - Idade");
                System.out.println("3 - Notas");

                String escolha = scanner.nextLine();

                if (escolha.equals("1") || escolha.equals("2") || escolha.equals("3")) {
                    System.out.println("Opção válida!");
                }
                else {
                    System.out.println("Digite uma opção válida de 1 a 3!");
                }

                // ifs de escolha

                if  (escolha.equals("1")) {
                    System.out.println("Digite o nome para alterar: ");
                    String nomeNovo = scanner.nextLine();
                    aluno.setNome(nomeNovo);
                }
                else if (escolha.equals("2")) {
                    int idadeNovo = lerIdade(scanner);
                    aluno.setIdade(idadeNovo);
                    System.out.println("Nome do Aluno alterado com sucesso! ");

                }

                else if (escolha.equals("3")) {
                    System.out.println("Digite qual nota deseja alterar: ");
                    System.out.println("1 - Nota 1");
                    System.out.println("2 - Nota 2");
                    System.out.println("3 - Nota 3");

                    String escolhaNota = scanner.nextLine();

                    if (escolhaNota.equals("1")){
                        double notaNova = lerNota(scanner);
                        aluno.setNota1(notaNova);
                        System.out.println("Nota 1 alterado com sucesso!");

                    } else if (escolhaNota.equals("2")) {
                        double notaNova = lerNota(scanner);
                        aluno.setNota2(notaNova);
                        System.out.println("Nota 2 alterado com sucesso! ");

                    } else if (escolhaNota.equals("3")) {
                        double notaNova = lerNota(scanner);
                        aluno.setNota3(notaNova);
                        System.out.println("Nota 3 alterado com sucesso!");

                    }
                    else {
                        System.out.println("Opção inválida! ");
                    }
                }

                return;
            }
        }
        System.out.println("Aluno não encontrado!");
    }
}
