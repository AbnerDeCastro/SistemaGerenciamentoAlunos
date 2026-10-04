import java.util.Scanner;

class Aluno {
    String nome;
    int idade;
    double nota1;
    double nota2;
    double nota3;

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
        Scanner scanner = new Scanner(System.in);

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

        System.out.println("\n--- Dados do Aluno Criado ---");
        System.out.println("Nome: " + meuAluno.nome);
        System.out.println("Idade: " + meuAluno.idade);
        System.out.println("Notas: " + meuAluno.nota1 + " | " + meuAluno.nota2 + " | " + meuAluno.nota3);

        scanner.close();
    }
}