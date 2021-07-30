package br.com.zupacademy.transacao.cartao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.transacao.model.Cartao;
import br.com.zupacademy.transacao.model.Transacao;
import br.com.zupacademy.transacao.response.TransacaoResponse;

@RestController
@RequestMapping
public class CartaoController {
	
	@PersistenceContext
	private EntityManager manager;

	@GetMapping("/cartoes/{id}/compras")
	@Transactional
	public ResponseEntity<?> listarCompras(@PathVariable (required = true) String id) {
		
		Cartao cartao = manager.find(Cartao.class, id);
		
		if (cartao == null) {
			return ResponseEntity.notFound().build();
		}
		
		String jpql = "SELECT t FROM Transacao t where "
				+ "t.cartao.id=:pid ORDER BY t.efetivadaEm DESC";

		TypedQuery<Transacao> query = manager.createQuery(jpql,
				Transacao.class);
		query.setParameter("pid", id);
		query.setMaxResults(10);
		
		List<Transacao> listaTransacoes = query.getResultList();
		
		return ResponseEntity.ok(TransacaoResponse.toResponse(listaTransacoes));
	}
}
