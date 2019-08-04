package br.com.projetoweb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class ViaCEPBase {

    List<CEP> CEPs;
    int index;
    String currentCEP;
    ViaCEPEvents Events;

    ViaCEPBase() {
        CEPs = new ArrayList<>();
        index = -1;
        currentCEP = "00000-000";
        this.Events = null;
    }

    public abstract void buscar(String cep) throws ViaCEPException;
    public abstract void buscarCEP(CEP cep) throws ViaCEPException;

    public void buscarCEP(String Uf, String Localidade, String Logradouro) throws ViaCEPException {
        buscarCEP(new CEP(Logradouro, Localidade, Uf));
    }

    public String getCep() {
        return CEPs.get(index).CEP;
    }

    String getLogradouro() {
        return CEPs.get(index).Logradouro;
    }

    String getBairro() {
        return CEPs.get(index).Bairro;
    }

    String getLocalidade() {
        return CEPs.get(index).Localidade;
    }

    String getUf() {
        return CEPs.get(index).Uf;
    }

    final String getHttpGET(String urlToRead) throws ViaCEPException {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            
        } catch (IOException ex) {
            if (Events != null) {
                Events.onCEPError(currentCEP);
            }
            throw new ViaCEPException(ex.getMessage());
        }

        return result.toString();
    }
}
