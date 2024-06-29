package com.logcursos.admin.catalogo.infrastructure;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisicaoAPI {
    private String moeda;

    public String conexaoCliente(String moeda) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/95a48e294439b4fbbeeb0c4d/latest/" + moeda;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
