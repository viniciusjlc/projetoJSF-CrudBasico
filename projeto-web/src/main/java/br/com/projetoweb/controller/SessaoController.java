package br.com.projetoweb.controller;

import br.com.projetoweb.dao.SessaoDAO;
import br.com.projetoweb.model.Usuario;
import br.com.projetoweb.util.MensagemUtil;
import br.com.projetoweb.util.PagesUtil;
import br.com.projetoweb.util.VerificadorUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean (name = "sessaoMB")
public class SessaoController implements Serializable {
    private Usuario usuarioAcesso;
    private SessaoDAO sessionDAO;

    public SessaoController() {
        usuarioAcesso = new Usuario();
        sessionDAO = new SessaoDAO();
    }

    public void validarAcesso() throws IOException {
        if(VerificadorUtil.estaNulo(usuarioAcesso.getEmail()) || VerificadorUtil.estaNulo(usuarioAcesso.getSenha())){
            MensagemUtil.erro("Senha e/ou Email não preenchidos!");
        }else if (sessionDAO.verificaSenha(usuarioAcesso)) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user_session", usuarioAcesso);
            redirecionarPrincipal();
        } else {
            MensagemUtil.erro("Senha e Email Incorretos!");
        }
    }

    public void controlarSessao() throws IOException {
        if(VerificadorUtil.estaNulo(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user_session"))){
            PagesUtil.redirectPage("login");
        }
    }

    public void redirecionarLogin() throws IOException {
        PagesUtil.redirectPage("login");
    }

    public void redirecionarPrincipal() throws IOException {
        PagesUtil.redirectPage("principal");
    }

    public Usuario getUsuarioAcesso() {
        return usuarioAcesso;
    }

    public void setUsuarioAcesso(Usuario usuarioAcesso) {
        this.usuarioAcesso = usuarioAcesso;
    }
}
