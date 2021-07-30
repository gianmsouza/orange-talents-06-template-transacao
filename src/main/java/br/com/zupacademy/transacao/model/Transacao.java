package br.com.zupacademy.transacao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transacao {

	@Id
	private String id;
	private BigDecimal valor;
	
	@ManyToOne
	private Estabelecimento estabelecimento;
	
	@ManyToOne
	private Cartao cartao;
	private LocalDateTime efetivadaEm;

	@Deprecated
	public Transacao() {
	}

	public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento,
			Cartao cartao, LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
}
