package es.avalon.repositorios.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.CapitulosRepositorio;

@Repository
public class CapitulosRepositorioJPA implements CapitulosRepositorio {
	
	@PersistenceContext
	EntityManager em;

	
	public List<Capitulo> buscarTodos() {
		TypedQuery<Capitulo> consulta = em.createQuery("select c from Capitulo c", Capitulo.class);
		return consulta.getResultList();
	}
	
	public List<Capitulo> buscarTodosConLibros() {
		TypedQuery<Capitulo> consulta = em.createQuery("select distinct c from Capitulo c join fetch c.libro",
				Capitulo.class);
		return consulta.getResultList();
	}
	
	public List<Capitulo> buscarTodosParaUnLibro(Libro l) {
		TypedQuery<Capitulo> consulta = em.createQuery("select  c from Capitulo c where c.libro.titulo=:titulo",
				Capitulo.class);
		consulta.setParameter("titulo", l.getTitulo());
		return consulta.getResultList();
	}
	
	public void insertar(Capitulo c) {
		em.persist(c);
	}
	
	public void borrar(Capitulo capitulos) {
		em.remove(em.merge(capitulos));
	}
	
	public Capitulo buscarUno(String titulo) {
		return em.find(Capitulo.class, titulo);
	}
	
	public void salvar(Capitulo micapitulo) {
		em.merge(micapitulo);
	}

	public List<Capitulo> buscarTodosOrdenados(String columna) {
		TypedQuery<Capitulo> consulta = null;
		if (columna.equals("titulo")) {
			consulta = em.createQuery("select c from Capitulo c order by titulo", Capitulo.class);
		} else if (columna.equals("paginas")) {
			consulta = em.createQuery("select c from Capitulo c order by paginas", Capitulo.class);
		}
		return consulta.getResultList();
	}
}
