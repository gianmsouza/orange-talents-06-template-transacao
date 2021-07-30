package br.com.zupacademy.transacao.kafka;

public class CartaoConsumer {
	
	private String id;
	private String email;

	public CartaoConsumer() {}
	
	public CartaoConsumer(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
}
