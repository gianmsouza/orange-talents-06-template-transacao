package br.com.zupacademy.transacao.response;

import br.com.zupacademy.transacao.model.Estabelecimento;

public class EstabelecimentoResponse {
	
	private String nome;	
	private String cidade;	
	private String endereco;

	public EstabelecimentoResponse(Estabelecimento estabelecimento) {
		this.nome = estabelecimento.getNome();
		this.cidade = estabelecimento.getCidade();
		this.endereco = estabelecimento.getEndereco();	
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}
}