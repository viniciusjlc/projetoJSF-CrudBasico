package br.com.algaworks.util;

import org.apache.commons.lang3.StringUtils;

public class TratamentoDadosDaoUtil {
    public static String retornaTratamentoParametroStringOuNuloOuVazio(String value) {
        return value == null || StringUtils.isEmpty(value.trim()) ? null : value.trim();
    }

    public static Integer retornaTratamentoParametroIntegerOuNulo(Integer value) {
        return value == null ? null : value;
    }
}
