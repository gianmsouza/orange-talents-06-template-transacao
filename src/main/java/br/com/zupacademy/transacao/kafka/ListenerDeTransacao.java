package br.com.zupacademy.transacao.kafka;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.transacao.model.Cartao;
import br.com.zupacademy.transacao.model.Estabelecimento;
import br.com.zupacademy.transacao.model.Transacao;

@Component
public class ListenerDeTransacao {

	@PersistenceContext
	private EntityManager manager;
	
	private final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	@Transactional
	public void ouvir(TransacaoConsumer eventoDeTransacao) {
		logger.info(eventoDeTransacao.toString());
		
		Cartao cartao = eventoDeTransacao.toCartao();
		Estabelecimento estabelecimento = eventoDeTransacao.toEstabelecimento(); 
		Transacao transacao = eventoDeTransacao.toTransacao(estabelecimento, cartao);
		
		Cartao buscaCartao = manager.find(Cartao.class, cartao.getId());
		
		if (buscaCartao == null) {
			manager.persist(cartao);
		}
		
		if (!verificaEstabelecimentoJaExistente(estabelecimento)) {
			manager.persist(estabelecimento);
		}		
		
		manager.persist(transacao);		
	}
	
	private boolean verificaEstabelecimentoJaExistente(Estabelecimento estabelecimento) {
		String jpql = "SELECT e FROM Estabelecimento e where "
				+ "e.nome=:pnome and e.cidade=:pcidade and e.endereco=:pendereco";
		
		TypedQuery<Estabelecimento> query = manager.createQuery(jpql,
				Estabelecimento.class);
		query.setParameter("pnome", estabelecimento.getNome());
		query.setParameter("pcidade", estabelecimento.getCidade());
		query.setParameter("pendereco", estabelecimento.getEndereco());
		
		List<Estabelecimento> estabelecimentoExistente = query.getResultList();
		
		if (estabelecimentoExistente.isEmpty()) {
			return false;
		}		
		return true;
	}
}
