package es.avalon.repositorios;

import java.util.List;

import es.avalon.jpa.negocio.Libro;

public interface LibroRepositorio {

	List<Libro> buscarTodos();

	void insertar(Libro libro);

	void borrar(Libro libro);

	Libro buscarUno(String titulo);

	void salvar(Libro milibro);

	List<Libro> buscarTodosOrdenados(String columna);

}