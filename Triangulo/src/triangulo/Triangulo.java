package triangulo;

import java.util.Scanner;


public class Triangulo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Operacao op = new Operacao();

        System.out.print("Digite o cateto 1: ");
        op.setC1(sc.nextDouble());

        System.out.print("Digite o cateto 2: ");
        op.setC2(sc.nextDouble());

        System.out.println("Hipotenusa: " + op.calculaHipotenusa());
        System.out.println("area: " + op.calculaArea());

        sc.close();
    }
}

class Operacao {

    private double h;
    private double c1;
    private double c2;

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getC1() {
        return c1;
    }

    public void setC1(double c1) {
        this.c1 = c1;
    }

    public double getC2() {
        return c2;
    }

    public void setC2(double c2) {
        this.c2 = c2;
    }

    public double calculaHipotenusa() {
        h = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
        return h;
    }

    public double calculaArea() {
        return (c1 * c2) / 2;
    }
}