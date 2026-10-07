public class Aluno {
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