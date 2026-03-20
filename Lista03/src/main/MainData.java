package main;

import questoes.Data;

public class MainData {
    public static void main(String[] args) {

        Data d1 = null, d2 = null;

        try {
            d1 = new Data(28, 2, 2024);
            d2 = new Data(31, 12, 2023);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar data: " + e.getMessage());
            return;
        }

        System.out.println("Data 1: " + d1);
        System.out.println("Data 2: " + d2);
        System.out.println();

        if (d1.eMaisAntiga(d2)) {
            System.out.println(d1 + " é mais antiga que " + d2);
        } else if (d2.eMaisAntiga(d1)) {
            System.out.println(d2 + " é mais antiga que " + d1);
        } else {
            System.out.println("As datas são iguais.");
        }
        System.out.println();

        d1.avancar();
        d2.avancar();

        System.out.println("Após avançar 1 dia:");
        System.out.println("Data 1: " + d1);
        System.out.println("Data 2: " + d2);

        System.out.println("\n--- Teste de validação ---");
        try {
            Data invalida = new Data(31, 4, 2024);
        } catch (IllegalArgumentException e) {
            System.out.println("Capturado: " + e.getMessage());
        }

        try {
            Data invalida2 = new Data(29, 2, 2023);
        } catch (IllegalArgumentException e) {
            System.out.println("Capturado: " + e.getMessage());
        }
    }
}