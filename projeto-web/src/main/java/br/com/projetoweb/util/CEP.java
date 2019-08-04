/*
 * PARG Desenvolvimento de Sistemas
 * Pablo Alexander - pablo@parg.com.br
 * 
 * Obtem um CEP no ViaCEP
 */
package br.com.projetoweb.util;

public class CEP {
    // pripriedades do CEP
    public String CEP;
    public String Logradouro;
    public String Complemento;
    public String Bairro;
    public String Localidade;
    public String Uf;
    public String Ibge;
    public String Gia;

    public CEP() {
        this.Logradouro = null;
        this.Complemento = null;
        this.Bairro = null;
        this.Localidade = null;
        this.Uf = null;
        this.Ibge = null;
        this.Gia = null;
    }

    public CEP(String CEP, String Logradouro, String Complemento, String Bairro, String Localidade, String Uf, String Ibge, String Gia) {
        this.CEP = CEP;
        this.Logradouro = Logradouro;
        this.Complemento = Complemento;
        this.Bairro = Bairro;
        this.Localidade = Localidade;
        this.Uf = Uf;
        this.Ibge = Ibge;
        this.Gia = Gia;
    }

    public CEP(String Logradouro, String Localidade, String Uf) {
        this.Logradouro = Logradouro;
        this.Localidade = Localidade;
        this.Uf = Uf;
    }
}
