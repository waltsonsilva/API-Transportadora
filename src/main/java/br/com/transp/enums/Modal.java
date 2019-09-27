package br.com.transp.enums;

public enum Modal {

	RODOVIARIO("Rodoviario"), AEREO("Aéreo"), FERROVIARIO("Ferroviário"), AQUAVIARIO("Aquaviário"),
	DUTOVIARIO("Dutoviário");

	private String descricao;

	private Modal(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String toString() {
		return this.descricao;
	}
}
