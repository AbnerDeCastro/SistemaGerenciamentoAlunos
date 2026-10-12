import java.util.ArrayList;
import java.util.Scanner;

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

            int idade = 0;
            boolean idadeValida = false;

            while (!idadeValida) {

                    System.out.print("Digite o seu Idade: ");
                    idade = scanner.nextInt();

                    if (idade >= 0 ) {
                        idadeValida = true;
                    }
                    else {
                        System.out.println("Idade inválida! Digite novamente!");
                    }
            }

            // Primeira nota
            boolean notaValida = false;
            double nota1 = 0;

            while (!notaValida) {
                System.out.print("Digite a priemira nota: ");
                nota1 = scanner.nextDouble();

                if (nota1 >= 0 && nota1 <= 10) {
                    notaValida = true;
                }
                else {
                    System.out.println("Nota Inválida! Digite novamente!");
                }
            }

            // Segunda Nota
            boolean nota2Valida = false;
            double nota2 = 0;
            while (!nota2Valida) {
                System.out.print("Digite a segunda nota: ");
                nota2 = scanner.nextDouble();

                if (nota2 >= 0 && nota2 <= 10) {
                    nota2Valida = true;
                }
                else {
                    System.out.println("Nota Inválida! Digite novamente!");
                }
            }


            // Terceira nota

            boolean nota3Valida = false;
            double nota3 = 0;
            while (!nota3Valida) {
                System.out.print("Digite a terceira nota: ");
                nota3 = scanner.nextDouble();
                if (nota3 >= 0 && nota3 <= 10) {
                    nota3Valida = true;
                }
                else {
                    System.out.println("Nota Inválida! Digite novamente!");
                }
            }

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

                // ifs de escolha

                if  (escolha.equals("1")) {
                    System.out.println("Digite o nome para alterar: ");
                    String nomeNovo = scanner.nextLine();
                    aluno.setNome(nomeNovo);
                }
                else if (escolha.equals("2")) {
                    System.out.println("Digite a idade para alterar: ");
                    int idadeNovo = scanner.nextInt();
                    aluno.setIdade(idadeNovo);
                    scanner.nextLine();
                }

                else if (escolha.equals("3")) {
                    System.out.println("Digite qual nota deseja alterar: ");
                    System.out.println("1 - Nota 1");
                    System.out.println("2 - Nota 2");
                    System.out.println("3 - Nota 3");

                    String escolhaNota = scanner.nextLine();

                    if (escolhaNota.equals("1")){
                        System.out.println("Digite a nota para alterar: ");
                        double notaNova = scanner.nextDouble();
                        aluno.setNota1(notaNova);

                    } else if (escolhaNota.equals("2")) {
                        System.out.println("Digite a nota para alterar: ");
                        double notaNova = scanner.nextDouble();
                        aluno.setNota2(notaNova);
                    } else if (escolhaNota.equals("3")) {

                        System.out.println("Digite a nota para alterar: ");
                        double notaNova = scanner.nextDouble();
                        aluno.setNota3(notaNova);

                    }
                }
                System.out.println("Aluno alterado com sucesso!");
                return;
            }
        }
        System.out.println("Aluno não encontrado!");
    }
}
