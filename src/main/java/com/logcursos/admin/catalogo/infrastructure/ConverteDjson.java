package com.logcursos.admin.catalogo.infrastructure;

import org.json.JSONObject;

public class ConverteDjson {

    public double getDadosMoedas(String response, String moedaDesejada){
        JSONObject jsonObject = new JSONObject(response);
        JSONObject conversionRates = jsonObject.getJSONObject("conversion_rates");

        return conversionRates.getDouble(moedaDesejada);
    }
}
