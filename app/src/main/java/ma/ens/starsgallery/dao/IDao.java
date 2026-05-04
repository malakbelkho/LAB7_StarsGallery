package ma.ens.starsgallery.dao;

import java.util.List;

public interface IDao<T> {

    boolean create(T item);

    boolean update(T item);

    boolean delete(T item);

    T findById(int id);

    List<T> findAll();
}
