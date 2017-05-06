package by.db.repository;

/**
 * Created by AMakas on 07.03.2017.
 */
public interface IRepository {

    <T> boolean set(T entity);
}
