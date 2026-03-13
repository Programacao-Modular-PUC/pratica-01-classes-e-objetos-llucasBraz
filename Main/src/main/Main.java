package main;

import java.util.Scanner;
import java.time.LocalDate;

class Data {

    int dia;
    int mes;
    int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

}

class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private double altura;
    private double peso;
    private double imc;
    private Data dataNascimento;

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

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void calculaIMC() {
        imc = peso / (altura * altura);
    }

    public void calculaIdade() {

        LocalDate hoje = LocalDate.now();

        idade = hoje.getYear() - dataNascimento.ano;

        if (hoje.getMonthValue() < dataNascimento.mes ||
           (hoje.getMonthValue() == dataNascimento.mes && hoje.getDayOfMonth() < dataNascimento.dia)) {
            idade--;
        }
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

        Pessoa[] pessoas = new Pessoa[10];

        int i;

        for (i = 0; i < 10; i++) {

            pessoas[i] = new Pessoa();

            System.out.println("\nCadastro " + (i + 1));

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Sobrenome: ");
            String sobrenome = sc.nextLine();

            if (i > 0) {
                if (nome.equalsIgnoreCase(pessoas[i - 1].getNome()) &&
                    sobrenome.equalsIgnoreCase(pessoas[i - 1].getSobrenome())) {
                    break;
                }
            }

            pessoas[i].setNome(nome);
            pessoas[i].setSobrenome(sobrenome);

            System.out.print("Data de nascimento (dd/mm/aaaa): ");
            String data = sc.nextLine();

            String[] partes = data.split("/");

            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);

            Data nascimento = new Data(dia, mes, ano);

            pessoas[i].setDataNascimento(nascimento);

            pessoas[i].calculaIdade();

            System.out.print("Altura: ");
            pessoas[i].setAltura(sc.nextDouble());

            System.out.print("Peso: ");
            pessoas[i].setPeso(sc.nextDouble());

            sc.nextLine();

            pessoas[i].calculaIMC();
        }

        System.out.println("\n===== DADOS CADASTRADOS =====");

        for (int j = 0; j < i; j++) {

            System.out.println("\nCadastro " + (j + 1));
            System.out.println("Nome completo: " + pessoas[j].getNome() + " " + pessoas[j].getSobrenome());
            System.out.println("Nome de referência: " + pessoas[j].getSobrenome().toUpperCase() + ", " + pessoas[j].getNome().toUpperCase());
            System.out.println("Idade: " + pessoas[j].getIdade());
            System.out.println("Peso: " + pessoas[j].getPeso());
            System.out.println("Altura: " + pessoas[j].getAltura());
            System.out.println("IMC: " + pessoas[j].getImc());
            System.out.println("Classificação: " + pessoas[j].informaObesidade());
        }

        sc.close();
    }
}