package es.avalon.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;

public class CapitulosRepositorioJPA {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadLibros");
	EntityManager em = emf.createEntityManager();

	public List<Capitulo> buscarTodos() {
		// genera un problema de n+1 queries, no lo hara si imprimimos la informacion
		// por capitulos
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
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(c);
		t.commit();
		em.close();
	}
	public void borrar(Capitulo capitulos) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.remove(em.merge(capitulos));
		t.commit();
		em.close();
	}
	
	
	public Capitulo buscarUno(String titulo) {
		EntityManager em = emf.createEntityManager();
		return em.find(Capitulo.class, titulo);
		

	}

	public void salvar(Capitulo micapitulo) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(micapitulo);
		t.commit();
		em.close();
	}

	public List<Capitulo> buscarTodosOrdenados(String columna) {

		EntityManager em = emf.createEntityManager();
		TypedQuery<Capitulo> consulta = null;
		if (columna.equals("titulo")) {
			consulta = em.createQuery("select c from Capitulo c order by titulo", Capitulo.class);
		} else if (columna.equals("paginas")) {
			consulta = em.createQuery("select c from Capitulo c order by paginas", Capitulo.class);

		}
		return consulta.getResultList();
	}
}
