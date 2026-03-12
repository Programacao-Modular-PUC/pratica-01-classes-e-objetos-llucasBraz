
import java.util.Scanner;

class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;
    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void calculaIMC() {
        imc = peso / (altura * altura);
    }

    public String informaObesidade() {

        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc <= 24.9) {
            return "Peso normal";
        } else if (imc <= 29.9) {
            return "Sobrepeso";
        } else if (imc <= 34.9) {
            return "Obesidade grau 1";
        } else if (imc <= 39.9) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3";
        }

    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pessoa p = new Pessoa();

        System.out.println("Digite o nome:");
        p.setNome(sc.nextLine());

        System.out.println("Digite o sobrenome:");
        p.setSobrenome(sc.nextLine());

        System.out.println("Digite a idade:");
        p.setIdade(sc.nextInt());

        System.out.println("Digite a altura:");
        p.setAltura(sc.nextDouble());

        System.out.println("Digite o peso:");
        p.setPeso(sc.nextDouble());

        p.calculaIMC();

        System.out.println("Nome: " + p.getNome() + " " + p.getSobrenome());
        System.out.println("IMC: " + p.getImc());
        System.out.println("Classificaçao: " + p.informaObesidade());

    }

}

