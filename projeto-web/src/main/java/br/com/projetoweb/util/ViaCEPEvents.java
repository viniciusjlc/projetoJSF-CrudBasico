package br.com.projetoweb.util;


public interface ViaCEPEvents {
    void onCEPSuccess(ViaCEP cep);

    void onCEPError(String cep);
}
