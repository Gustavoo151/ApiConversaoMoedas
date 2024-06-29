package com.logcursos.admin.catalogo.infrastructure;

public class BuscaIdMoeda {

    public static String buscaIdMoeda(int opcao){
        return switch (opcao) {
            case 1 -> "ARS"; // Peso Argentino
            case 2 | 4 | 6 -> "USD";  // Dolar
            case 3 -> "BRL"; // Real Brasileiro
            case 5 -> "COP"; // Peso colombiano
            default ->
                    "Valor Inválido!";
        };
    }
}
