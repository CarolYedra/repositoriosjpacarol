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

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.LibroRepositorio;

@Repository
public class LibroRepositorioJPA implements LibroRepositorio {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Libro> buscarTodos(){
		TypedQuery<Libro> consulta=em.createQuery("select l from Libro l",Libro.class);
		return consulta.getResultList();
	}	
	
	public void insertar(Libro libro) {
		em.persist(libro);
		
	}
	
	public void borrar(Libro libro) {
		Libro libroGestionado = em.merge(libro);
		em.remove(libroGestionado);
		
	}
	
	public Libro buscarUno(String titulo) {
		Libro libro = em.find(Libro.class, titulo);
		return libro;

	}
	
	public void salvar(Libro milibro) {
		em.merge(milibro);
		
	}
	
	public List<Libro> buscarTodosOrdenados(String columna){
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
