package br.com.projetoweb.enums;

public enum ModeloGenero {
	Masculino("M"),
	Feminino("F");

	private String sigla;

	ModeloGenero(String sigla){
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}
}
