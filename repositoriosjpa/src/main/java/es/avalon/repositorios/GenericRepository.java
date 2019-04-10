package es.avalon.repositorios;

public interface GenericRepository<T,K> {
	
	void insertar(T t);
	
	void borrar(T t);
	
	T buscarUno(K k);
	
	T salvar(T t);
	
	Iterable <T> buscarTodos(); 

}
