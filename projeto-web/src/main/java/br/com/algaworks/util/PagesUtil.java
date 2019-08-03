package br.com.algaworks.util;

import org.primefaces.context.RequestContext;

import javax.faces.context.FacesContext;
import java.io.IOException;

public class PagesUtil {
    public static void redirectPage(String page) throws IOException {
        FacesContext context  = FacesContext.getCurrentInstance();
        String url = context.getExternalContext().getRequestContextPath();
        context.getExternalContext().redirect(url+"/pages/"+page+".xhtml");
    }

    public static void redirectPageLogin() throws IOException {
        FacesContext context  = FacesContext.getCurrentInstance();
        String url = context.getExternalContext().getRequestContextPath();
        context.getExternalContext().redirect(url+"/login.xhtml");
    }

    public static void atualizarComponente(String componente) {
        RequestContext.getCurrentInstance().update(componente);
    }
}
