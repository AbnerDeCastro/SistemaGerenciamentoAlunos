public class Aluno {
    private String nome;
    private int idade;
    private double nota1;
    private double nota2;
    private double nota3;

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
        setIdade(idade);
        setNota1(nota1);
        setNota2(nota2);
        setNota3(nota3);
    }
    // Getter
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public double getNota1() {
        return nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public double getNota3() {
        return nota3;
    }

    // Setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        }
        else {
            throw  new IllegalArgumentException("Idade Inserida Invalida");
        }
    }
    public void setNota1(double nota1) {
        if (nota1 >= 0 &&  nota1 <= 10) {
            this.nota1 = nota1;
        }
        else  {
            throw  new IllegalArgumentException("Nota invalida!");
        }
    }

    public void setNota2(double nota2) {
        if (nota2 >= 0 && nota2 <= 10) {
            this.nota2 = nota2;
        }
        else   {
            throw  new IllegalArgumentException("Nota invalida!");
        }
    }

    public void setNota3(double nota3) {
        if (nota3 >= 0 && nota3 <= 10) {
            this.nota3 = nota3;
        }
        else   {
            throw  new IllegalArgumentException("Nota invalida!");
        }
    }
}