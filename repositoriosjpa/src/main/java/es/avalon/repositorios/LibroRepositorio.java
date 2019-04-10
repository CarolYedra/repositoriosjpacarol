package es.avalon.repositorios;

import java.util.List;

import es.avalon.jpa.negocio.Libro;

public interface LibroRepositorio extends GenericRepository<Libro, String> {

	

	List<Libro> buscarTodosOrdenados(String columna);

}