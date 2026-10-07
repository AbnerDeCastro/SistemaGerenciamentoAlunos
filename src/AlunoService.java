import java.util.ArrayList;
import java.util.Scanner;

public class AlunoService {
    public void listarAlunos(ArrayList<Aluno> alunos) {
        if (alunos.isEmpty()) {
            System.out.println("Não existe Alunos cadastrdos!");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println("--- Aluno ---");
                System.out.println("Nome: " + aluno.nome);
                System.out.println("Idade: " + aluno.idade);
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

            System.out.print("Informe a sua idade: ");
            int idade = scanner.nextInt();

            System.out.print("Informe sua primeira nota: ");
            double nota1 = scanner.nextDouble();

            System.out.print("Informe sua segunda nota: ");
            double nota2 = scanner.nextDouble();

            System.out.print("Informe sua terceira nota: ");
            double nota3 = scanner.nextDouble();

            Aluno meuAluno = new Aluno(nome, idade, nota1, nota2, nota3);
            alunos.add(meuAluno);
            System.out.println("Alunos cadastrados com sucesso!");
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
            if (busca.equals(aluno.nome)) {
                System.out.println("Alunos encontrados com sucesso!");
                System.out.println("Nome: " + aluno.nome);
                System.out.println("Idade: " + aluno.idade);
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
            if (busca.equals(aluno.nome)) {
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

            if (busca.equals(aluno.nome)) {

                System.out.println("O que deseja alterar?");
                System.out.println("1 - Nome");
                System.out.println("2 - Idade");
                System.out.println("3 - Notas");

                String escolha = scanner.nextLine();

                // AGORA entram os ifs de escolha

                if  (escolha.equals("1")) {
                    System.out.println("Digite o nome para alterar: ");
                    String nomeNovo = scanner.nextLine();
                    aluno.nome = nomeNovo;
                }
                else if (escolha.equals("2")) {
                    System.out.println("Digite a idade para alterar: ");
                    int idadeNovo = scanner.nextInt();
                    aluno.idade = idadeNovo;
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
                        aluno.nota1 = notaNova;

                    } else if (escolhaNota.equals("2")) {
                        System.out.println("Digite a nota para alterar: ");
                        double notaNova = scanner.nextDouble();
                        aluno.nota2 = notaNova;
                    } else if (escolhaNota.equals("3")) {

                        System.out.println("Digite a nota para alterar: ");
                        double notaNova = scanner.nextDouble();
                        aluno.nota3 = notaNova;

                    }
                }
                System.out.println("Aluno alterado com sucesso!");
                return;
            }
        }
        System.out.println("Aluno não encontrado!");
    }
}
