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
import es.avalon.repositorios.GenericRepository;
import es.avalon.repositorios.LibroRepositorio;
import es.avalon.repositorios.jpa.generic.GenericRepositoryJPA;

@Repository
public class LibroRepositorioJPA extends GenericRepositoryJPA <Libro, String> implements LibroRepositorio{
	
	public LibroRepositorioJPA() {
		super(Libro.class);
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
