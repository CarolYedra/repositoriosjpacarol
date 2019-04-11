package es.avalon.repositorios.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import es.avalon.jpa.negocio.Categoria;
import es.avalon.jpa.negocio.Libro;
import es.avalon.repositorios.CategoriaRepositorio;
import es.avalon.repositorios.GenericRepository;
import es.avalon.repositorios.LibroRepositorio;
import es.avalon.repositorios.jpa.generic.GenericRepositoryJPA;

@Repository
public class CategoriaRepositorioJPA extends GenericRepositoryJPA <Categoria, Integer> implements CategoriaRepositorio {


	public CategoriaRepositorioJPA() {
		super(Categoria.class);


	}


}