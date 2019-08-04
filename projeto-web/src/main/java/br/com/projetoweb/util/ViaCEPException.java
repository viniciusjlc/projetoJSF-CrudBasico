package br.com.projetoweb.util;

public class ViaCEPException extends Exception {
    ViaCEPException(String message) {
        super(message);
        MensagemUtil.erro(message);
    }
}
