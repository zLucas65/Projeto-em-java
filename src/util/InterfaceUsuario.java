package util;

import java.util.Scanner;



public class InterfaceUsuario {

    Scanner sc = new Scanner(System.in);

    public double pedirValorImovel() {

        while (true) {
            try {
                System.out.print("Digite o valor do ímovel: ");
                int valor = sc.nextInt();
                if (valor <= 0) {
                    throw new IllegalArgumentException("O prazo deve ser maior que zero.");
                }
                return valor;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: Por favor, digite um número válido.");
                sc.nextLine();
            }

        }
    }


    public int pedirPrazoFinanciamento() {
        while (true) {
            try {
                System.out.print("Digite o prazo do financiamento: ");
                int prazo = sc.nextInt();
                if (prazo <= 0) {
                    throw new IllegalArgumentException("O prazo deve ser maior que zero.");
                }
                return prazo;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: Por favor, digite um número válido.");
                sc.nextLine();
            }
        }
    }


    public double pedirTaxaDeJuros() {
        while (true) {
            try {
                System.out.print("Digite a taxa de juros: ");
                double juros = sc.nextDouble();
                if (juros < 0 || juros >= 70) {
                    throw new IllegalArgumentException("Taxa de juros deve estar entre 0 (inclusivo) e 70 (exclusivo).");
                }
                return juros;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: Por favor, digite um número válido.");
                sc.nextLine();
            }
        }
    }

}