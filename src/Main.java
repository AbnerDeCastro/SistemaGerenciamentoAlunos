import java.util.Scanner;
import java.util.ArrayList;

class Aluno {
    String nome;
    int idade;
    double nota1;
    double nota2;
    double nota3;

    public double calcularMedia() {
     return ((nota1 + nota2 + nota3)/3 );
    }

    public String verificarAprovacao() {

        if (calcularMedia() >= 7 ) {
            return "Aprovado";
        }

        else if (calcularMedia() >= 5 ) {
            return "recuperação";
        }

        else {
            return "Reprovado";
            }
    }

    public Aluno(String nome, int idade, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.idade = idade;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
}

public class Main {
    public static void main(String[] args) {

        // Create List
        ArrayList<Aluno> alunos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

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

        for (Aluno aluno : alunos) {
            System.out.println("--- Aluno ---");
            System.out.println("Nome: " +aluno.nome);
            System.out.println("Idade: " +aluno.idade);
            System.out.println("Média: " +aluno.calcularMedia());
            System.out.println("Situação: " +aluno.verificarAprovacao());
        }

        scanner.close();
    }
}