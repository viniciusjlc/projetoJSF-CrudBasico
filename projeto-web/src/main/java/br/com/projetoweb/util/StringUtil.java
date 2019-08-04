package br.com.projetoweb.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtil extends org.apache.commons.lang3.StringUtils{

    public static String putMask(String valorSemMascara, String mask) {
        StringBuilder valorComMascara = new StringBuilder();
        int j = 0;
        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == '#') {
                valorComMascara.append(valorSemMascara.charAt(j));
                j++;
            } else {
                valorComMascara.append(mask.charAt(i));
            }
        }
        return valorComMascara.toString();
    }

    public static String retirarMascara(String valorComMascara) {
        return valorComMascara.replaceAll("\\D*", "");
    }

    public static String retirarAcento(String str){
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}
