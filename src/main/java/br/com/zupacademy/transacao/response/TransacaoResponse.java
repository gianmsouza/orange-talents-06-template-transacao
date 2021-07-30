package br.com.zupacademy.transacao.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.transacao.model.Transacao;

public class TransacaoResponse {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoResponse estabelecimento;
	private CartaoResponse cartao;
	private LocalDateTime efetivadaEm;

	public TransacaoResponse(Transacao transacao) {
		this.id = transacao.getId();
		this.valor = transacao.getValor();
		this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
		this.cartao = new CartaoResponse(transacao.getCartao());
		this.efetivadaEm = transacao.getEfetivadaEm();
	}

	public static List<TransacaoResponse> toResponse(List<Transacao> listaTransacoes) {
		return listaTransacoes.stream().
				map(transacao -> new TransacaoResponse(transacao)).collect(Collectors.toList());
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
}
