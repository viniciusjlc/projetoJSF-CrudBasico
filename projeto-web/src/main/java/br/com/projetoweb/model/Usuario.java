package br.com.projetoweb.model;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private String email;
    private String senha;
    private String celular;
    private String genero;
    private String rgNumero;
    private String rgEstado;
    private Date rgDataEmissao;
    private Endereco endereco;
    private Byte foto;
    private Boolean administrador;

    public Usuario() {
        this.endereco = new Endereco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRgNumero() {
        return rgNumero;
    }

    public void setRgNumero(String rgNumero) {
        this.rgNumero = rgNumero;
    }

    public String getRgEstado() {
        return rgEstado;
    }

    public void setRgEstado(String rgEstado) {
        this.rgEstado = rgEstado;
    }

    public Date getRgDataEmissao() {
        return rgDataEmissao;
    }

    public void setRgDataEmissao(Date rgDataEmissao) {
        this.rgDataEmissao = rgDataEmissao;
    }

    public void setFoto(Byte foto) {
        this.foto = foto;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Byte getFoto() {
        return foto;
    }
}
