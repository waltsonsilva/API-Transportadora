package br.com.transp.service;

import java.util.List;

public interface IService<T> {

	T inserir(T entity);

	T atualizar(T entity);

	T buscarPorId(Long id) throws IllegalAccessException;

	void deletarPorID(Long id);

	List<T> buscarPorTodos();

}
