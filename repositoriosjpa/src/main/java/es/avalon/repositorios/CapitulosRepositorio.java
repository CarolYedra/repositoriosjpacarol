package es.avalon.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.avalon.jpa.negocio.Capitulo;
import es.avalon.jpa.negocio.Libro;

public interface CapitulosRepositorio extends JpaRepository<Capitulo, String>{

	

}