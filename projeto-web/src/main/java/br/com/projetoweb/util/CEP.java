/*
 * PARG Desenvolvimento de Sistemas
 * Pablo Alexander - pablo@parg.com.br
 * 
 * Obtem um CEP no ViaCEP
 */
package br.com.projetoweb.util;

public class CEP {
    String CEP;
    String Logradouro;
    String Bairro;
    String Localidade;
    String Uf;

    public CEP() {
        this.Logradouro = null;
        this.Bairro = null;
        this.Localidade = null;
        this.Uf = null;
    }

    public CEP(String CEP, String Logradouro, String Bairro, String Localidade, String Uf) {
        this.CEP = CEP;
        this.Logradouro = Logradouro;
        this.Bairro = Bairro;
        this.Localidade = Localidade;
        this.Uf = Uf;
    }

    public CEP(String Logradouro, String Localidade, String Uf) {
        this.Logradouro = Logradouro;
        this.Localidade = Localidade;
        this.Uf = Uf;
    }
}
