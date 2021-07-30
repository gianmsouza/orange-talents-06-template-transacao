package br.com.zupacademy.transacao.kafka;

public class EstabelecimentoConsumer {
	
	private String nome;	
	private String cidade;	
	private String endereco;
	
	public EstabelecimentoConsumer() {}
	
	public EstabelecimentoConsumer(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;	
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