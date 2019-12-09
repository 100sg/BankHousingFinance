package skbaek.homework.demo.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import skbaek.homework.demo.entity.BankCode;

@Service
public class BankService extends GenericCRUDService<BankCode> {

    public BankService(JpaRepository<BankCode, Long> repository) {
        super(repository);
    }

}