package es.avalon.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.avalon.jpa.negocio.Libro;

public interface LibroRepositorio extends JpaRepository<Libro, String> {

	

	//List<Libro> buscarTodosOrdenados(String columna);
	List<Libro> findAllByOrderByTituloAsc();
	List<Libro> findAllByOrderByAutorAsc();

}