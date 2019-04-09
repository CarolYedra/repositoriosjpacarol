package es.avalon.repositorios;

import java.util.List;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;

public interface CapitulosRepositorio {

	List<Capitulo> buscarTodos();

	List<Capitulo> buscarTodosConLibros();

	List<Capitulo> buscarTodosParaUnLibro(Libro l);

	void insertar(Capitulo c);

	void borrar(Capitulo capitulos);

	Capitulo buscarUno(String titulo);

	void salvar(Capitulo micapitulo);

	List<Capitulo> buscarTodosOrdenados(String columna);

}