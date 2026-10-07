import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Create List
        ArrayList<Aluno> alunos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        AlunoService alunoService = new AlunoService();

        int escolha = 0;
        while (escolha != 6) {

            System.out.println("===== SISTEMA DE GERENCIAMENTO DE ALUNOS =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar aluno");
            System.out.println("4 - Excluir aluno");
            System.out.println("5 - Para alterar dados do Aluno");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 1) {
                alunoService.cadastrarAluno(alunos, scanner);
            } else if (escolha == 2) {
                alunoService.listarAlunos(alunos);
            } else if (escolha == 3) {
            alunoService.buscarAluno(alunos, scanner);}
            else if (escolha == 4) {
                alunoService.deletarAluno(alunos, scanner);
            }
            else if (escolha == 5) {
                alunoService.alterarAluno(alunos, scanner);
            }

        }
        scanner.close();
    }
}