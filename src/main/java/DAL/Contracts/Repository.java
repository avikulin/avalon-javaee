package DAL.Contracts;

import DAL.Utils.Filter.Contracts.FilterExpression;

import java.util.List;

public interface Repository<T, K> {
    T getById(K id);
    List<T> getAll(FilterExpression filterExpression);
    void create(T value);
    void delete(K key);
    void flush();
}
