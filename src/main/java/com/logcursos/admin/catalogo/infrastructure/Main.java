package com.logcursos.admin.catalogo.infrastructure;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcao = 0;
        double valor = 0;
        String moeda = "";
        double valorConvertido = 0;
        double valorMoeda = 0;

        Scanner scanner = new Scanner(System.in);

        while (opcao != 7) {
            System.out.println("*".repeat(55) +
                    "\nSeja bem-vindo/a ao Conversor de Moedas =]" +
                    "\n1) Dólar =>> Peso Argentino" +
                    "\n2) Peso argentino =>> Dolar" +
                    "\n3) Dólar =>> Real Brasileiro" +
                    "\n4) Real Brasileiro =>> Dólar" +
                    "\n5) Dolar =>> Peso Colombiano" +
                    "\n6) Peso Colombiano =>> Dolar" +
                    "\n7) Sair" +
                    "\nDigite a opção válida: " +
                    "\n" + "*".repeat(55));
            opcao = scanner.nextInt();

            moeda = BuscaIdMoeda.buscaIdMoeda(opcao);

            System.out.println("Digite o valor que deseja converter: ");
            valor = scanner.nextDouble();

            RequisicaoAPI requisicaoAPI = new RequisicaoAPI();
            String requisicao = requisicaoAPI.conexaoCliente("USD");

            ConverteDjson converteDjson = new ConverteDjson();
            valorMoeda = converteDjson.getDadosMoedas(requisicao, moeda);

            valorConvertido = CalculaConversao.calcula(valor, valorMoeda);

            System.out.println("O valor convertido é: " + valorConvertido + " " + moeda);

        }
    }
}