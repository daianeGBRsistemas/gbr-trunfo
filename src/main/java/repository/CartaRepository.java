package repository;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Carta;

@Stateless
public class CartaRepository {
	
	@PersistenceContext
    protected EntityManager manager;
	
	public Integer inserir(Carta carta) {
		this.manager.persist(carta);
		return carta.getId();
	}
	
	public void atualizar(Carta carta) {
		this.manager.merge(carta);
	}
	
	public Carta consultar(int id) {
		return this.manager.find(Carta.class, id);
	}
	
	public List<Carta> pesquisarTodos() {
		return this.manager.createQuery("select c from Carta c order by id desc").getResultList();
	}
	
	public void remover(int id) throws Exception {
		Carta carta = this.consultar(id);
		if(carta != null) {
			this.manager.remove(carta);
		} else
			throw new Exception("Carta não encontrada");
	}

}
