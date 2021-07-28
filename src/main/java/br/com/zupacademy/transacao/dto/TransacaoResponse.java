package br.com.zupacademy.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoResponse estabelecimento;
	private CartaoResponse cartao;
	private LocalDateTime efetivadaEm;

	public TransacaoResponse() {
	}

	public TransacaoResponse(String id, BigDecimal valor, EstabelecimentoResponse estabelecimento,
			CartaoResponse cartao, LocalDateTime efetivadaEm) {
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

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoResponse getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	@Override
	public String toString() {
		return "TransacaoResponse [id=" + id + ", valor=" + valor + ", estabelecimento=" + estabelecimento.getNome()
				+ ", cartao=" + cartao.getEmail() + ", efetivadaEm=" + efetivadaEm + "]";
	}
}
