package es.avalon.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.avalon.jpa.negocio.Categoria;
import es.avalon.jpa.negocio.Libro;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

	//Iterable<Libro> buscarLibrosPorCategoria(Categoria c);


	

}