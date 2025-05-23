package org.example.therapycenter.dao;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO {

    boolean save(T entity);

    List<T> getAll();

    boolean update(T entity);

    boolean delete(String id);

    List<T> search(String searchText);
}
