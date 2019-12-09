package skbaek.homework.demo.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import skbaek.homework.demo.entity.BankHousingFinance;
import skbaek.homework.demo.repository.BankHousingFinanceRepository;
import skbaek.homework.demo.service.CRUDService;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class GenericCRUDService<T> implements CRUDService<T> {

    private JpaRepository<T, Long> repository;

    public GenericCRUDService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List findAll() throws Exception {
        return this.repository.findAll();
    }

    @Override
    public T save(T data) throws Exception {
        return this.repository.save(data);
    }

    @Override
    public T detail(long id) throws Exception {
        Optional<T> find = this.repository.findById(id);

        if(find.isPresent()){
            return find.get();
        } else {
            throw new NoResultException("The requested id(" + id + ") is no data");
        }
    }

    @Override
    public void del(long id) throws Exception {
        Optional<T> find = this.repository.findById(id);
        if(find.isPresent()){
            this.repository.deleteById(id);
        } else {
            throw new NoResultException("The request id(" + id + ") is no data");
        }
    }
}
