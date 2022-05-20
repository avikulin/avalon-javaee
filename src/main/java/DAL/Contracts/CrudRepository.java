package DAL.Contracts;

import DAL.Utils.Filter.Contracts.FilterExpression;

import java.util.List;

public interface CrudRepository<T, K> {
    T getById(K id);
    void create(T value);
    void delete(K key);
    void flush();
}
