package es.avalon.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



import es.avalon.jpa.negocio.Libro;

public class LibroRepositorioJPA {
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("UnidadLibros");
	
	public List<Libro> buscarTodos(){

		EntityManager em=emf.createEntityManager();
		TypedQuery<Libro> consulta=em.createQuery("select l from Libro l",Libro.class);
		return consulta.getResultList();
	}	
	public void insertar(Libro libro) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction t=em.getTransaction();
		t.begin();
		em.persist(libro);
		t.commit();
		em.close();
	}
	public void borrar(Libro libro) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction t=em.getTransaction();
		t.begin();
		Libro libroGestionado = em.merge(libro);
		em.remove(libroGestionado);
		t.commit();
		em.close();
	}
	public Libro buscarUno(String titulo) {
		EntityManager em=emf.createEntityManager();
		Libro libro = em.find(Libro.class, titulo);
		em.close();
		return libro;

	}
	public void salvar(Libro milibro) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction t=em.getTransaction();
		t.begin();
		em.merge(milibro);
		t.commit();
		em.close();
	}
	public List<Libro> buscarTodosOrdenados(String columna){
//		EntityManager em=emf.createEntityManager();
//		TypedQuery<Libro> consulta=em.createQuery("select l from Libro l order by l."+columna,Libro.class);
//		return consulta.getResultList();
		
		EntityManager em=emf.createEntityManager();
		TypedQuery<Libro> consulta = null;
		if (columna.equals("titulo")){
		 consulta=em.createQuery("select l from Libro l order by titulo",Libro.class);
		}else if (columna.equals("autor")){
		consulta=em.createQuery("select l from Libro l order by autor",Libro.class);
		}else if (columna.equals("paginas")){
		consulta=em.createQuery("select l from Libro l order by pagina",Libro.class);	
		
		}
		return consulta.getResultList();
	}
}
