package br.com.projetoweb.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class ViaCEP extends ViaCEPBase {

    ViaCEP() {
        super();
    }

    @Override
    public final void buscar(String cep) throws ViaCEPException {
        currentCEP = cep;
        String url = "http://viacep.com.br/ws/" + cep + "/json/";
        JSONObject obj = new JSONObject(getHttpGET(url));
        if (!obj.has("erro")) {
            mapeamentoCEP(obj);
        } else {
            if (Events != null) {
                Events.onCEPError(currentCEP);
            }
            throw new ViaCEPException("Não foi possível encontrar o CEP");
        }
    }

    final Boolean validarCEP(String cep) throws ViaCEPException {
        boolean retorno = false;
        currentCEP = cep;
        String url = "http://viacep.com.br/ws/" + cep + "/json/";
        JSONObject obj = new JSONObject(getHttpGET(url));
        if (!obj.has("erro")) {
            retorno = true;
        }
        return retorno;
    }

    private void mapeamentoCEP(JSONObject obj) {
        CEP novoCEP = new CEP(obj.getString("cep"),
                obj.getString("logradouro"),
                obj.getString("bairro"),
                obj.getString("localidade"),
                obj.getString("uf"));
        CEPs.add(novoCEP);
        index = CEPs.size() - 1;
        if (Events != null) {
            Events.onCEPSuccess(this);
        }
    }

    @Override
    public void buscarCEP(CEP cep) throws ViaCEPException {
        buscarCEP(cep.Uf, cep.Localidade, cep.Logradouro);
    }

    @Override
    public void buscarCEP(String Uf, String Localidade, String Logradouro) throws ViaCEPException {
        currentCEP = "?????-???";
        String url = "http://viacep.com.br/ws/" + Uf.toUpperCase() + "/" + Localidade + "/" + Logradouro + "/json/";
        JSONArray ceps = new JSONArray(getHttpGET(url));
        if (ceps.length() > 0) {
            for (int i = 0; i < ceps.length(); i++) {
                JSONObject obj = ceps.getJSONObject(i);
                if (!obj.has("erro")) {
                    mapeamentoCEP(obj);
                } else {
                    if (Events != null) {
                        Events.onCEPError(currentCEP);
                    }
                    throw new ViaCEPException("Não foi possível validar o CEP");
                }
            }
        } else {
            throw new ViaCEPException("Nenhum CEP encontrado");
        }
    }
}
