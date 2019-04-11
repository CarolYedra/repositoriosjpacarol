package es.avalon.repositorios.jpa.generic;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.springframework.stereotype.Repository;

import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.GenericRepository;
@Repository
public abstract class GenericRepositoryJPA<T, K> implements GenericRepository<T, K>{
	@PersistenceContext
	    protected EntityManager em;
	    private Class<T> type;
	    
	    public GenericRepositoryJPA(Class<T> type) {
	       this.type = type;
	    }
	 
	    public void insertar(T t) {
	        em.persist(t);
	    }
	    public void borrar(T t) {
	    	em.remove(em.merge(t));    	
	    }	   
	    public T buscarUno(K clave) {
	    	return em.find(type,clave);
	    }
	    public T salvar(T t) {
	    	return em.merge(t);
	    }
	    public Iterable<T> buscarTodos() {
	    	CriteriaBuilder cb = this.em.getCriteriaBuilder();
	        CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
	        Root<T> root = criteriaQuery.from(type);
	        criteriaQuery.select(root);
	        TypedQuery<T> query = em.createQuery(criteriaQuery);
	        return query.getResultList();
	    }
	    
	    
	    
	}