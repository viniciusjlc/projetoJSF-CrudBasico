package br.com.projetoweb.util;

public class VerificadorUtil {

    public static boolean estaNulo(Object objeto) {
        return objeto == null;
    }

    public static boolean naoEstaNulo(Object value) {
        return !estaNulo(value);
    }

    public static boolean estaNuloOuVazio(Object valor) {
        return estaNulo(valor) || estaVazio(valor);
    }

    public static boolean estaVazio(Object valor) {
        return new StringUtil().isEmpty(valor.toString());
    }


    public static boolean naoEstaNuloOuVazio(Object valor) {
        return !estaNuloOuVazio(valor);
    }
}
