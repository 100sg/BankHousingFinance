package skbaek.homework.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skbaek.homework.demo.entity.BankCode;

public interface BankRepository extends JpaRepository<BankCode, Long> {
}
