package br.com.projetoweb.util;

import java.util.Calendar;
import java.util.Date;

public class DataUtil {
    public static Date getDataMaxima() {
        Calendar dataAtual = Calendar.getInstance();
        return dataAtual.getTime();
    }
}
