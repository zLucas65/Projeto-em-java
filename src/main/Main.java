package main;

import modelo.Financiamento;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Financiamento> listaDeFinanciamento = new ArrayList<>();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.pedirTaxaDeJuros();

        Financiamento casa = new modelo.Casa(valorImovel, prazoFinanciamento, taxaJuros, 100, 200);
        listaDeFinanciamento.add(casa);
        Financiamento casa2 = new modelo.Casa(2500000, 30, 20, 300, 500);
        listaDeFinanciamento.add(casa2);

        Financiamento apartamento = new modelo.Apartamento(300000, 15, 10, 2, 4);
        listaDeFinanciamento.add(apartamento);
        Financiamento apartamento2 = new modelo.Apartamento(130000, 30, 18, 1, 2);
        listaDeFinanciamento.add(apartamento2);

        Financiamento terreno = new modelo.Terreno(100000, 18, 20, "Rural");
        listaDeFinanciamento.add(terreno);

        double somaValores = 0;
        for (Financiamento financiamento : listaDeFinanciamento) {
            somaValores += financiamento.getValorImovel();
        }


        System.out.printf("\nO total da soma dos imóveis é: R$%.2f%n", somaValores);


        String arquivo = "financiamentos.ser";


        try (FileOutputStream fileOut = new FileOutputStream(arquivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(listaDeFinanciamento);
            out.flush();
            System.out.println("\nSerialização concluída!");

        } catch (IOException e) {
            System.err.println("Erro durante a serialização: " + e.getMessage());
        }

        try (FileInputStream fileIn = new FileInputStream(arquivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            List<Financiamento> listaDeserializada = (List<Financiamento>) in.readObject();
            System.out.println("\nDeserialização concluída!");

            for (Financiamento financiamento : listaDeserializada) {
                System.out.println(financiamento);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro durante a deserialização: " + e.getMessage());
        }

    }


}

