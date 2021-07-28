package br.com.zupacademy.transacao.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zupacademy.transacao.dto.TransacaoResponse;

@Component
public class ListenerDeTransacao {

	private final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void ouvir(TransacaoResponse eventoDeTransacao) {
		logger.info(eventoDeTransacao.toString());
	}
}
