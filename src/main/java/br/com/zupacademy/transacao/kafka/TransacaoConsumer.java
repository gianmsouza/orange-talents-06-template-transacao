package br.com.zupacademy.transacao.kafka;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.transacao.model.Cartao;
import br.com.zupacademy.transacao.model.Estabelecimento;
import br.com.zupacademy.transacao.model.Transacao;

public class TransacaoConsumer {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoConsumer estabelecimento;
	private CartaoConsumer cartao;
	private LocalDateTime efetivadaEm;

	public TransacaoConsumer() {}

	public TransacaoConsumer(String id, BigDecimal valor, EstabelecimentoConsumer estabelecimento,
			CartaoConsumer cartao, LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}
	
	public Cartao toCartao() {
		return new Cartao(cartao.getId(), cartao.getEmail());
	}

	public Estabelecimento toEstabelecimento() {
		return new Estabelecimento(estabelecimento.getNome(), estabelecimento.getCidade(),
				estabelecimento.getEndereco());
	}

	public Transacao toTransacao(Estabelecimento estabelecimento, Cartao cartao) {
		return new Transacao(this.id, this.valor, estabelecimento, cartao, this.efetivadaEm);
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoConsumer getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoConsumer getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	@Override
	public String toString() {
		return "TransacaoConsumer [id=" + id + ", valor=" + valor + ", estabelecimento=" + estabelecimento.getNome()
				+ ", cartao=" + cartao.getEmail() + ", efetivadaEm=" + efetivadaEm + "]";
	}
}
