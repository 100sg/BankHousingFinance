package skbaek.homework.demo.service;

import java.util.List;

public interface CRUDService<T> {

    List<T> findAll() throws Exception;
    T save(T data) throws Exception;
    T detail(long id) throws Exception;
    void del(long id) throws Exception;

}
