package model.dao;

import java.util.List;

public interface GenericDAO<T> extends AutoCloseable{

	void create(T entity);

	T readById(int id);

	List<T> readAll();

	void update(T entity);

	void delete(T entity);

	void close();

}
