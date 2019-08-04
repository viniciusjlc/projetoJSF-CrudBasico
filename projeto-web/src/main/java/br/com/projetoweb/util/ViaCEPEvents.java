package br.com.projetoweb.util;


public interface ViaCEPEvents {
    public void onCEPSuccess(ViaCEP cep);

    public void onCEPError(String cep);
}
